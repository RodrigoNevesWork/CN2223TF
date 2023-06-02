import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.io.IOException;


public class FireStoreUtils{


    static Firestore db;
    static CollectionReference currentCollection;

    private static void init(String collectionName) throws IOException {

        FirestoreOptions options = FirestoreOptions.newBuilder().build();

        db = options.getService();
        currentCollection = db.collection(collectionName);
    }

    private static void close() throws Exception {
        db.close();
    }

    public static void useInsert(String collectionName, String docID, FireStoreDocument fbd) throws Exception{
        init(collectionName);
        insertDocuments(docID,fbd);
        close();
    }



    private static void insertDocuments(String docID, FireStoreDocument fbd) throws Exception {

        DocumentReference docRef = currentCollection.document(docID);

        ApiFuture<WriteResult> resultFut = docRef.set(fbd);

        WriteResult result = resultFut.get();

        System.out.println("Update time : " + result.getUpdateTime());

    }


}
