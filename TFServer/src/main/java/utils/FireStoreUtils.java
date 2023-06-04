package utils;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.cloud.firestore.Firestore;
import exceptions.FirestoreInvalidIdentifierException;
import exceptions.FirestoreNotProcessedException;

import java.util.ArrayList;
import java.util.List;

public class FireStoreUtils {

    private static Firestore db;
    private static CollectionReference currentCollection;

    private FireStoreUtils() {
    }

    public static void initialize(String collectionName) throws Exception {
        FirestoreOptions options = FirestoreOptions.newBuilder().build();
        db = options.getService();
        currentCollection = db.collection(collectionName);

        // Create a dummy document to ensure the collection exists
        createDummyDocument();
    }

    public static void close() throws Exception {
        db.close();
    }

    public static FireStoreDocument useGetDoc(String docID) throws Exception {
        FireStoreDocument doc = getDocumentByID(docID);
        return doc;
    }

    public static List<AboveCertaintyResult> useGetAboveCertaintyResult(Float certainty) throws Exception {
        List<AboveCertaintyResult> results = new ArrayList<>();

        Iterable<DocumentReference> allDocs = currentCollection.listDocuments();

        for (DocumentReference docRef : allDocs) {
            ApiFuture<DocumentSnapshot> docFuture = docRef.get();

            DocumentSnapshot doc = docFuture.get();

            FireStoreDocument fsd = doc.toObject(FireStoreDocument.class);
            if(fsd.ar!=null){
                for (AnaliseResult analise : fsd.getAr()) {
                    if (analise.getCertainty() >= certainty) {
                        results.add(new AboveCertaintyResult(fsd.getBlobName(), analise.getDescription()));
                    }
                }
            }
        }
        return results;
    }

    public static void addEmptyDocument(String docID) throws Exception {
        DocumentReference docRef = currentCollection.document(docID);
        docRef.set(new FireStoreDocument()); // Create an empty document
    }

    private static FireStoreDocument getDocumentByID(String docID) throws Exception {
        DocumentReference docRef = currentCollection.document(docID);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        if (document.exists()) {
            return document.toObject(FireStoreDocument.class);
        } else throw new FirestoreInvalidIdentifierException("Invalid identifier");
    }

    private static void createDummyDocument() throws Exception {
        DocumentReference dummyDocRef = currentCollection.document("dummy");
        dummyDocRef.set(new FireStoreDocument()); // Create a dummy document
    }
}
