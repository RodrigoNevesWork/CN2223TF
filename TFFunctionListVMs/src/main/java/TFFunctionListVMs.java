import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TFFunctionListVMs implements HttpFunction {
    private static final String  PROJECT = "cn2223-t3-g05";
    private static final String  ZONE = "europe-west1-b";
    private static final String GROUP_NAME = "instance-group-tf-server";

    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        try {
            List<String> vmList = listVMInstances();
            String responseJson = new Gson().toJson(vmList);
            response.getWriter().write(responseJson);
        } catch (IOException e) {
            response.setStatusCode(500);
            response.getWriter().write("Error occurred: " + e.getMessage());
        }
    }

    static List<String> listVMInstances() throws IOException {
        List<String> vmList = new ArrayList<>();
        try (InstancesClient client = InstancesClient.create()) {
            for (Instance instance : client.list(PROJECT, ZONE).iterateAll()) {
                if (instance.getName().contains(GROUP_NAME) && instance.getStatus().equals("RUNNING")) {
                    vmList.add(instance.getNetworkInterfaces(0).getAccessConfigs(0).getNatIP());
                }
            }
        }
        return vmList;
    }
}