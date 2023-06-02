import java.io.Serializable;
import java.util.List;

public class FireStoreDocument implements Serializable {
    List<AnaliseResult> ar;
    String blobName;

    public FireStoreDocument(List<AnaliseResult> ar, String blobName)  {
        this.ar = ar;
        this.blobName = blobName;
    }
    public FireStoreDocument(){ //To deserialize object

    }

    public List<AnaliseResult> getAr() {
        return ar;
    }

    public void setAr(List<AnaliseResult> ar) {
        this.ar = ar;
    }

    public String getBlobName() {
        return blobName;
    }

    public void setBlobName(String blobName) {
        this.blobName = blobName;
    }

    @Override
    public String toString() {
        return "FireStoreDocument{" +
                "ar=" + ar +
                ", blobName='" + blobName + '\'' +
                '}';
    }
}
