package utils;

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class PubSubUtils {

    private static final String PROJECT_ID = "cn2223-t3-g05";
    private static final String TOPIC_ID = "tf-msg-topic";

    public static void publishMessage(String identifier, String bucketName, String blobName) throws IOException {
        TopicName topicName = TopicName.of(PROJECT_ID, TOPIC_ID);



        JsonObject payload = new JsonObject();
        payload.add("identifier", new JsonPrimitive(identifier));
        payload.add("bucketName", new JsonPrimitive(bucketName));
        payload.add("blobName", new JsonPrimitive(blobName));

        Gson gson = new Gson();
        byte[] avroData = gson.toJson(payload).getBytes(StandardCharsets.UTF_8);

        PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                .setData(ByteString.copyFrom(avroData))
                .build();
        Publisher publisher = null;
        try {
            publisher = Publisher.newBuilder(topicName).build();
            ApiFuture<String> future = publisher.publish(pubsubMessage);
            String msgID = future.get();
            System.out.println("Message Published with ID=" + msgID);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (publisher != null) {
                publisher.shutdown();
            }
        }
    }
}
