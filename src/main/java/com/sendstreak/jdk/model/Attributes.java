package com.sendstreak.jdk.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a collection of attributes that can be used for emails and contacts.
 */
public class Attributes {
    /**
     * The attributes in this object.
     */
    private final Map<String, Object> attributes = new HashMap<>();

    /**
     * Constructs a new attributes object.
     */
    Attributes() {
    }

    /**
     * Adds all attributes from the given parameter to this attributes object.
     *
     * @param attributes the attributes to add
     */
    public void putAll(Attributes attributes) {
        this.attributes.putAll(attributes.attributes);
    }

    /**
     * Adds a new {@code String} attribute to this attributes object.
     *
     * @param key the key of the attribute
     * @param value the value of the attribute
     */
    public void putString(String key, String value) {
        attributes.put(key, value);
    }

    /**
     * Adds a new {@code Date} attribute to this attributes object.
     *
     * @param key the key of the attribute
     * @param value the value of the attribute
     */
    public void putDate(String key, Date value) {
        attributes.put(key, value);
    }

    /**
     * Adds a new {@code Number} attribute to this attributes object.
     *
     * @param key the key of the attribute
     * @param value the value of the attribute
     */
    public void putNumber(String key, Number value) {
        attributes.put(key, value);
    }

    /**
     * Adds a new {@code Boolean} attribute to this attributes object.
     *
     * @param key the key of the attribute
     * @param value the value of the attribute
     */
    public void putBoolean(String key, Boolean value) {
        attributes.put(key, value);
    }

    /**
     * Returns a copy of the attributes in this object.
     *
     * @return a copy of the attributes in this object
     */
    public Map<String, Object> getAttributes() {
        return new HashMap<>(attributes);
    }
}
