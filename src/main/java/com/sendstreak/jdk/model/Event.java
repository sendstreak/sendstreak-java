package com.sendstreak.jdk.model;

import com.google.gson.annotations.SerializedName;
import com.sendstreak.jdk.util.Constants;

/**
 * Represents an event.
 */
public class Event {
    /**
     * The email address of the contact that triggered the event.
     */
    @SerializedName("email")
    private final String email;

    /**
     * The slug (short string identifier) of the event.
     */
    @SerializedName("slug")
    private final String eventSlug;

    /**
     * Constructs a new event object.
     *
     * @param email the email address of the contact that triggered the event
     * @param eventSlug the slug of the event
     */
    public Event(String email, String eventSlug) {
        if (!email.matches(Constants.EMAIL_REGEXP)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        if (eventSlug == null || eventSlug.isEmpty()) {
            throw new IllegalArgumentException("Invalid event slug");
        }

        this.email = email;
        this.eventSlug = eventSlug;
    }

    /**
     * Constructs a new event object.
     *
     * @param contact the contact that triggered the event
     * @param eventSlug the slug of the event
     */
    public Event(Contact contact, String eventSlug) {
        this.email = contact.getEmail();
        this.eventSlug = eventSlug;
    }
}
