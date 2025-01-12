package com.sendstreak.jdk;

import com.sendstreak.jdk.model.*;
import com.sendstreak.jdk.util.API;

import java.util.HashMap;
import java.util.Map;

/**
 * The SendStreak class represents a client that can interact with the SendStreak API to send events,
 * emails, and manage contacts.
 */
public class SendStreak {
    /**
     * The API key used to authenticate with SendStreak.
     */
    private final String apiKey;

    /**
     * The (optional) configuration values.
     */
    private final Map<String, String> config = new HashMap<>();

    /**
     * Creates a new SendStreak client
     *
     * @param apiKey Your SendStreak API key
     */
    public SendStreak(String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key cannot be null or empty");
        }

        this.apiKey = apiKey;

        this.config.put("server", "https://api.sendstreak.com");
    }

    /**
     * Sets a configuration value.
     *
     * <p>
     *     Note: This is for debugging purposes only. If you want to see what messages are being sent to the API, set the
     *     'server' variable to some other URL where you can monitor the requests.
     * </p>
     * <p>
     *     Example:
     * </p>
     * <pre>
     *     sendStreak.setConfig("server", "http://localhost:8080");
     * </pre>
     *
     * @param key The configuration key
     * @param value The configuration value
     */
    public void setConfig(String key, String value) {
        config.put(key, value);
    }

    /**
     * Deletes a contact from SendStreak.
     *
     * @param contact The contact to delete
     */
    public void deleteContact(Contact contact) {
        API.invokeAPI("/v1/contacts/" + contact.getEmail(), "DELETE", null, this.config, this.apiKey);
    }

    /**
     * Sends an event to SendStreak.
     *
     * @param event The event to send
     */
    public void sendEvent(Event event) {
        API.invokeAPI("/v1/events", "POST", event, this.config, this.apiKey);
    }

    /**
     * Sends a transactional email through SendStreak using an email template.
     *
     * @param email The email to send
     */
    public void sendMail(Email email) {
        API.invokeAPI("/v1/messages", "POST", email, this.config, this.apiKey);
    }

    /**
     * Creates or updates a contact in SendStreak.
     *
     * @param contact The contact to create or update
     */
    public void updateContact(Contact contact) {
        API.invokeAPI("/v1/contacts/", "POST", contact, this.config, this.apiKey);
    }

}
