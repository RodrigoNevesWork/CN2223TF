package utils;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.util.ArrayList;
import java.util.List;

public class FireStoreUtils implements AutoCloseable {

    private Firestore db;
    private CollectionReference currentCollection;

    public FireStoreUtils(String collectionName) {
        FirestoreOptions options = FirestoreOptions.newBuilder().build();
        db = options.getService();
        currentCollection = db.collection(collectionName);
    }

    @Override
    public void close() throws Exception {
        db.close();
    }

    public FireStoreDocument useGetDoc(String docID) throws Exception {
        FireStoreDocument doc = getDocumentByID(docID);
        return doc;
    }

    public List<AboveCertaintyResult> useGetAboveCertaintyResult(Float certainty) throws Exception {
        List<AboveCertaintyResult> results = new ArrayList<>();

        Iterable<DocumentReference> allDocs = currentCollection.listDocuments();

        for (DocumentReference docref : allDocs) {
            ApiFuture<DocumentSnapshot> docfut = docref.get();

            DocumentSnapshot doc = docfut.get();

            FireStoreDocument fsd = doc.toObject(FireStoreDocument.class);

            if (fsd == null) throw new Exception("This document is null");
            for (AnaliseResult analise : fsd.ar) {
                if (analise.getCertainty() >= certainty) results.add(new AboveCertaintyResult(fsd.getBlobName(), analise.getDescription()));
            }
        }
        return results;
    }

    private FireStoreDocument getDocumentByID(String docID) throws Exception {
        DocumentReference docRef = currentCollection.document(docID);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        if (document.exists()) {
            return document.toObject(FireStoreDocument.class);
        } else throw new Exception("This Document does not exist");
    }
}
