package net.ecoporium.mc;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MCStatus {

    public static void main(String[] args) {
        String baseUrl = "https://api.mcsrvstat.us/2/{ip}";
        String ip = args[0];

        if (ip.equals("")) {
            System.out.println("Please enter a valid IP address.");
            return;
        }

        JsonObject object = null;

        try {
            URL url = new URL(baseUrl.replace("{ip}", ip));
            URLConnection connection = url.openConnection();
            connection.connect();

            JsonElement element = JsonParser.parseReader(new InputStreamReader((InputStream) connection.getContent()));
            object = element.getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (object == null) return;
        boolean status = object.get("online").getAsBoolean();

        if (!status) {
            System.out.println("Server status: false");
            return;
        }

        int online = object.get("players").getAsJsonObject().get("online").getAsInt();
        int max = object.get("players").getAsJsonObject().get("max").getAsInt();
        System.out.println("Server Status: true (" + online + "/" + max + ")");
    }

}
