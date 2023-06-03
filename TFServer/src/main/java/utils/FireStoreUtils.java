package utils;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.util.ArrayList;
import java.util.List;


public class FireStoreUtils{


        static Firestore db;
        static CollectionReference currentCollection;

        private static void init(String collectionName) {

            FirestoreOptions options = FirestoreOptions.newBuilder().build();

            db = options.getService();
            currentCollection = db.collection(collectionName);
        }

        private static void close() throws Exception {
            db.close();
        }



        public static FireStoreDocument useGetDoc(String collectionName, String docID) throws Exception {
            init(collectionName);
            FireStoreDocument doc = getDocumentByID(docID);
            close();
            return doc;
        }

        public static List<AboveCertaintyResult> useGetAboveCertaintyResult(String collectionName,double certainty) throws Exception {
            init(collectionName);

            List<AboveCertaintyResult> results = new ArrayList<>();

            Iterable<DocumentReference> allDocs = currentCollection.listDocuments();

            for (DocumentReference docref : allDocs) {
                ApiFuture<DocumentSnapshot> docfut = docref.get();

                DocumentSnapshot doc = docfut.get();

                FireStoreDocument fsd = doc.toObject(FireStoreDocument.class);

                if(fsd == null) throw new Exception("This document is null");
                for(AnaliseResult analise : fsd.ar){
                    if(analise.getCertainty() >= certainty) results.add(new AboveCertaintyResult(fsd.getBlobName(),analise.getDescription()));
                }
            }
            close();
            return results;
        }


        private static FireStoreDocument getDocumentByID(String docID) throws Exception{
            DocumentReference docRef = currentCollection.document(docID);

            ApiFuture<DocumentSnapshot> future = docRef.get();

            DocumentSnapshot document = future.get();

            if (document.exists()) {
                return document.toObject(FireStoreDocument.class);
            } else  throw new Exception("This Document does not exists");
        }









}
