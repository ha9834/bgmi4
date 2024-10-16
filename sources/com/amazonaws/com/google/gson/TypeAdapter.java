package com.amazonaws.com.google.gson;

import com.amazonaws.com.google.gson.internal.bind.JsonTreeReader;
import com.amazonaws.com.google.gson.internal.bind.JsonTreeWriter;
import com.amazonaws.com.google.gson.stream.JsonReader;
import com.amazonaws.com.google.gson.stream.JsonToken;
import com.amazonaws.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes.dex */
public abstract class TypeAdapter<T> {
    /* renamed from: read */
    public abstract T read2(JsonReader jsonReader) throws IOException;

    public abstract void write(JsonWriter jsonWriter, T t) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new JsonWriter(writer), t);
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.amazonaws.com.google.gson.TypeAdapter.1
            @Override // com.amazonaws.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (t == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, t);
                }
            }

            @Override // com.amazonaws.com.google.gson.TypeAdapter
            /* renamed from: read */
            public T read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return (T) TypeAdapter.this.read2(jsonReader);
            }
        };
    }

    public final String toJson(T t) throws IOException {
        StringWriter stringWriter = new StringWriter();
        toJson(stringWriter, t);
        return stringWriter.toString();
    }

    public final JsonElement toJsonTree(T t) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t);
            return jsonTreeWriter.get();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read2(new JsonReader(reader));
    }

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read2(new JsonTreeReader(jsonElement));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
