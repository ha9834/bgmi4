package com.twitter.sdk.android.core.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class SafeListAdapter implements TypeAdapterFactory {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> typeToken) {
        final TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, typeToken);
        return new TypeAdapter<T>() { // from class: com.twitter.sdk.android.core.models.SafeListAdapter.1
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                delegateAdapter.write(jsonWriter, t);
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T read2(JsonReader jsonReader) throws IOException {
                T t = (T) delegateAdapter.read2(jsonReader);
                if (!List.class.isAssignableFrom(typeToken.getRawType())) {
                    return t;
                }
                if (t == null) {
                    return (T) Collections.EMPTY_LIST;
                }
                return (T) Collections.unmodifiableList((List) t);
            }
        };
    }
}
