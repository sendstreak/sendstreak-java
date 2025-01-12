package com.sendstreak.jdk.model;

import com.sendstreak.jdk.util.Constants;

/**
 * Represents a contact.
 */
public class Contact {
    /**
     * The email address of the contact.
     */
    private final String email;

    /**
     * The attributes of the contact.
     */
    private final Attributes attributes;

    /**
     * Constructs a new contact object.
     *
     * @param email the email address of the contact
     */
    public Contact(String email) {
        super();

        if (!email.matches(Constants.EMAIL_REGEXP)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        this.email = email;
        this.attributes = new Attributes();
    }

    /**
     * Constructs a new contact object.
     *
     * @param email the email address of the contact
     * @param attributes the attributes of the contact
     */
    public Contact(String email, Attributes attributes) {
        this(email);

        this.attributes.putAll(attributes);
    }

    /**
     * Returns the email address of the contact.
     *
     * @return the email address of the contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns all the attributes of the contact.
     *
     * @return the attributes of the contact
     */
    public Attributes getAttributes() {
        return attributes;
    }
}
