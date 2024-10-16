package com.amazonaws.util.json;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class JsonUtils {
    private static volatile AwsJsonFactory factory = new GsonFactory();

    /* loaded from: classes.dex */
    public enum JsonEngine {
        Gson,
        Jackson
    }

    public static void setJsonEngine(JsonEngine jsonEngine) {
        switch (jsonEngine) {
            case Gson:
                factory = new GsonFactory();
                return;
            case Jackson:
                factory = new JacksonFactory();
                return;
            default:
                throw new RuntimeException("Unsupported json engine");
        }
    }

    static void setJsonEngine(AwsJsonFactory awsJsonFactory) {
        if (awsJsonFactory == null) {
            throw new IllegalArgumentException("factory can't be null");
        }
        factory = awsJsonFactory;
    }

    public static AwsJsonReader getJsonReader(Reader reader) {
        if (factory == null) {
            throw new IllegalStateException("Json engine is unavailable.");
        }
        return factory.getJsonReader(reader);
    }

    public static AwsJsonWriter getJsonWriter(Writer writer) {
        if (factory == null) {
            throw new IllegalStateException("Json engine is unavailable.");
        }
        return factory.getJsonWriter(writer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Map<String, String> jsonToMap(Reader reader) {
        AwsJsonReader jsonReader = getJsonReader(reader);
        try {
            if (jsonReader.peek() == null) {
                return Collections.EMPTY_MAP;
            }
            HashMap hashMap = new HashMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.isContainer()) {
                    jsonReader.skipValue();
                } else {
                    hashMap.put(nextName, jsonReader.nextString());
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            return Collections.unmodifiableMap(hashMap);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to parse JSON String.", e);
        }
    }

    public static Map<String, String> jsonToMap(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        return jsonToMap(new StringReader(str));
    }

    public static String mapToString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "{}";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jsonWriter.name(entry.getKey()).value(entry.getValue());
            }
            jsonWriter.endObject();
            jsonWriter.close();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AmazonClientException("Unable to serialize to JSON String.", e);
        }
    }

    private static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
