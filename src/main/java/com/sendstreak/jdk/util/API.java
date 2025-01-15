package com.sendstreak.jdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sendstreak.jdk.model.Attributes;
import com.sendstreak.jdk.model.Contact;
import com.sendstreak.jdk.model.Email;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public abstract class API {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Attributes.class, new AttributesSerializer())
            .registerTypeAdapter(Contact.class, new ContactSerializer())
            .registerTypeAdapter(Email.class, new EmailSerializer())
            .create();

    public static void invokeAPI(String endpoint, String method, Object body, Map<String, String> config, String apiKey) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(config.get("server") + endpoint));
        //        .uri(URI.create(this.config.get("server")));
        builder.header("Authorization", "Bearer " + apiKey);

        switch (method) {
            case "GET":
                builder.GET();
                break;
            case "POST":
                builder.header("Content-Type", "application/json");
                builder.POST(HttpRequest.BodyPublishers.ofString(gson.toJson(body)));
                break;
            case "DELETE":
                builder.DELETE();
                break;
            default:
                throw new IllegalArgumentException("Invalid method");
        }

        HttpRequest request = builder.build();

        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
