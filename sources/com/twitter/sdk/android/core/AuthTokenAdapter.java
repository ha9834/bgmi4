package com.twitter.sdk.android.core;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AuthTokenAdapter implements JsonDeserializer<AuthToken>, JsonSerializer<AuthToken> {
    private static final String AUTH_TOKEN = "auth_token";
    private static final String AUTH_TYPE = "auth_type";
    static final Map<String, Class<? extends AuthToken>> authTypeRegistry = new HashMap();
    private final Gson gson = new Gson();

    static {
        authTypeRegistry.put("oauth1a", TwitterAuthToken.class);
        authTypeRegistry.put("oauth2", OAuth2Token.class);
        authTypeRegistry.put("guest", GuestAuthToken.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(AuthToken authToken, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("auth_type", getAuthTypeString(authToken.getClass()));
        jsonObject.add("auth_token", this.gson.toJsonTree(authToken));
        return jsonObject;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AuthToken deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String asString = asJsonObject.getAsJsonPrimitive("auth_type").getAsString();
        return (AuthToken) this.gson.fromJson(asJsonObject.get("auth_token"), (Class) authTypeRegistry.get(asString));
    }

    static String getAuthTypeString(Class<? extends AuthToken> cls) {
        for (Map.Entry<String, Class<? extends AuthToken>> entry : authTypeRegistry.entrySet()) {
            if (entry.getValue().equals(cls)) {
                return entry.getKey();
            }
        }
        return "";
    }
}
