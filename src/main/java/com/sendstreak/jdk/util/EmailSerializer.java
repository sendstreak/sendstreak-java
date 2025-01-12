package com.sendstreak.jdk.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sendstreak.jdk.model.Email;

import java.lang.reflect.Type;

class EmailSerializer implements JsonSerializer<Email> {
    @Override
    public JsonElement serialize(Email email, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("rcpt", email.getRcptAddress());
        jsonObject.addProperty("templateSlug", email.getTemplateSlug());

        JsonObject variables = context.serialize(email.getAttributes()).getAsJsonObject();
        jsonObject.add("variables", variables);

        return jsonObject;
    }
}
