import com.google.api.gax.retrying.RetrySettings;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.threeten.bp.Duration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Paths;

public class GoogleCloudStorageUtils {


    private final Integer maxAttemps = 5;

    private final Double retryDelayMultiplier = 3.0;

    private final Duration totalTimeOut = Duration.ofMinutes(3);

    private final String projectId = "cn2223-t3-g05";

    private final RetrySettings retryStorageOptions = StorageOptions
            .getDefaultRetrySettings()
            .toBuilder()
            .setMaxAttempts(maxAttemps)
            .setRetryDelayMultiplier(retryDelayMultiplier)
            .setTotalTimeout(totalTimeOut)
            .build();

    private final StorageOptions storageOptions = StorageOptions
            .newBuilder()
            .setRetrySettings(retryStorageOptions)
            .setProjectId(projectId)
            .build();

    private final Storage storage = storageOptions.getService();

    public GoogleCloudStorageUtils() throws IOException {
    }

    public void uploadBlobToBucket(String bucketName, String blobName,  byte [] bytes) {

        BlobId blobId = BlobId.of(bucketName,blobName);

        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();

        Blob blob = storage.create(blobInfo,bytes);

        System.out.println(blob);

    }




    private byte[] byteArrayFromPath(String path) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(path));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        return  bos.toByteArray();
    }

}
