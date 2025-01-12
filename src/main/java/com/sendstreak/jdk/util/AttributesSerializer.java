package com.sendstreak.jdk.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sendstreak.jdk.model.Attributes;

import java.lang.reflect.Type;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class AttributesSerializer implements JsonSerializer<Attributes> {
    @Override
    public JsonElement serialize(Attributes attributes, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        attributes.getAttributes().forEach((key, value) -> {
            if (value instanceof String) {
                jsonObject.addProperty(key, (String) value);
            } else if (value instanceof Number) {
                jsonObject.addProperty(key, (Number) value);
            } else if (value instanceof Boolean) {
                jsonObject.addProperty(key, (Boolean) value);
            } else if (value instanceof Date) {
                jsonObject.addProperty(key, ((Date) value).toInstant().atZone(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_INSTANT));
            } else {
                throw new IllegalArgumentException("Unsupported attribute type");
            }
        });

        return jsonObject;
    }
}
