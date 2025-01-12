package com.sendstreak.jdk.model;

import com.sendstreak.jdk.util.Constants;

/**
 * Represents an email.
 */
public class Email {
    /**
     * The recipient address of the email.
     */
    private final String rcptAddress;

    /**
     * The slug (short string identifier) of the template to be used.
     */
    private final String templateSlug;

    /**
     * The attributes of the email.
     */
    private final Attributes attributes;

    /**
     * Constructs a new email object.
     *
     * @param rcptAddress the recipient address of the email
     * @param templateSlug the slug of the template to be used
     */
    public Email(String rcptAddress, String templateSlug) {
        if (!rcptAddress.matches(Constants.EMAIL_REGEXP)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        if (templateSlug == null || templateSlug.isEmpty()) {
            throw new IllegalArgumentException("Invalid template slug");
        }

        this.rcptAddress = rcptAddress;
        this.templateSlug = templateSlug;
        this.attributes = new Attributes();
    }

    /**
     * Constructs a new email object.
     *
     * @param rcptAddress the recipient address of the email
     * @param templateSlug the slug of the template to be used
     * @param attributes the attributes of the email
     */
    public Email(String rcptAddress, String templateSlug, Attributes attributes) {
        this(rcptAddress, templateSlug);

        this.attributes.putAll(attributes);
    }

    /**
     * Returns the recipient address of the email.
     *
     * @return the recipient address of the email
     */
    public String getRcptAddress() {
        return rcptAddress;
    }

    /**
     * Returns the slug of the template to be used.
     *
     * @return the slug of the template to be used
     */
    public String getTemplateSlug() {
        return templateSlug;
    }

    /**
     * Returns all the attributes of the email.
     *
     * @return the attributes of the email
     */
    public Attributes getAttributes() {
        return attributes;
    }
}
