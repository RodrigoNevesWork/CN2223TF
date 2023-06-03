package utils;

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.storage.*;
import org.threeten.bp.Duration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GoogleCloudStorageUtils {


    private static final Integer maxAttemps = 5;

    private static final Double retryDelayMultiplier = 3.0;

    private static final Duration totalTimeOut = Duration.ofMinutes(3);

    private static final String projectId = "cn2223-t3-g05";

    private static final RetrySettings retryStorageOptions = StorageOptions
            .getDefaultRetrySettings()
            .toBuilder()
            .setMaxAttempts(maxAttemps)
            .setRetryDelayMultiplier(retryDelayMultiplier)
            .setTotalTimeout(totalTimeOut)
            .build();

    private static final StorageOptions storageOptions = StorageOptions
            .newBuilder()
            .setRetrySettings(retryStorageOptions)
            .setProjectId(projectId)
            .build();

    private static final Storage storage = storageOptions.getService();

    public GoogleCloudStorageUtils() throws IOException {
    }

    public static void uploadBlobToBucket(String bucketName, String blobName,  byte [] bytes) {

        BlobId blobId = BlobId.of(bucketName,blobName);

        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();

        Blob blob = storage.create(blobInfo,bytes);

        System.out.println(blob);

    }


    public static byte[] downloadFromBucket(String bucketName, String fileName) throws IOException {

        Blob blob = storage.get(bucketName,fileName);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        blob.downloadTo(outputStream);
        outputStream.close();

        return outputStream.toByteArray();

    }


}
