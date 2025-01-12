package com.sendstreak.jdk.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sendstreak.jdk.model.Contact;

import java.lang.reflect.Type;

class ContactSerializer implements JsonSerializer<Contact> {
    @Override
    public JsonElement serialize(Contact contact, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(contact.getAttributes()).getAsJsonObject();
        jsonObject.addProperty("email", contact.getEmail());

        return jsonObject;
    }
}
