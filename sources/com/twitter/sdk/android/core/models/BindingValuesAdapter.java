package com.twitter.sdk.android.core.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class BindingValuesAdapter implements JsonDeserializer<BindingValues>, JsonSerializer<BindingValues> {
    private static final String BOOLEAN_MEMBER = "boolean_value";
    private static final String BOOLEAN_TYPE = "BOOLEAN";
    private static final String IMAGE_TYPE = "IMAGE";
    private static final String IMAGE_VALUE_MEMBER = "image_value";
    private static final String STRING_TYPE = "STRING";
    private static final String TYPE_MEMBER = "type";
    private static final String TYPE_VALUE_MEMBER = "string_value";
    private static final String USER_TYPE = "USER";
    private static final String USER_VALUE_MEMBER = "user_value";

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(BindingValues bindingValues, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public BindingValues deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonElement.isJsonObject()) {
            return new BindingValues();
        }
        Set<Map.Entry<String, JsonElement>> entrySet = jsonElement.getAsJsonObject().entrySet();
        HashMap hashMap = new HashMap(32);
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            hashMap.put(entry.getKey(), getValue(entry.getValue().getAsJsonObject(), jsonDeserializationContext));
        }
        return new BindingValues(hashMap);
    }

    Object getValue(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        JsonElement jsonElement = jsonObject.get("type");
        if (jsonElement == null || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        String asString = jsonElement.getAsString();
        char c = 65535;
        int hashCode = asString.hashCode();
        if (hashCode != -1838656495) {
            if (hashCode != 2614219) {
                if (hashCode != 69775675) {
                    if (hashCode == 782694408 && asString.equals(BOOLEAN_TYPE)) {
                        c = 3;
                    }
                } else if (asString.equals("IMAGE")) {
                    c = 1;
                }
            } else if (asString.equals(USER_TYPE)) {
                c = 2;
            }
        } else if (asString.equals(STRING_TYPE)) {
            c = 0;
        }
        switch (c) {
            case 0:
                return jsonDeserializationContext.deserialize(jsonObject.get(TYPE_VALUE_MEMBER), String.class);
            case 1:
                return jsonDeserializationContext.deserialize(jsonObject.get(IMAGE_VALUE_MEMBER), ImageValue.class);
            case 2:
                return jsonDeserializationContext.deserialize(jsonObject.get(USER_VALUE_MEMBER), UserValue.class);
            case 3:
                return jsonDeserializationContext.deserialize(jsonObject.get(BOOLEAN_MEMBER), Boolean.class);
            default:
                return null;
        }
    }
}
