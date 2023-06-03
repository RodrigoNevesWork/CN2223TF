package utils;

public class AboveCertaintyResult {
    private String blobID;
    private String localName;

    public AboveCertaintyResult(String blobID, String localName) {
        this.blobID = blobID;
        this.localName = localName;
    }

    public AboveCertaintyResult(){}

    public String getBlobID() {
        return blobID;
    }

    public void setBlobID(String blobID) {
        this.blobID = blobID;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @Override
    public String toString() {
        return "utils.AboveCertaintyResult{" +
                "blobID='" + blobID + '\'' +
                ", localName='" + localName + '\'' +
                '}';
    }
}
