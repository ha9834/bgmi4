package com.discord.connect.a;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public class e extends TypeAdapter<Long> {
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Long l) throws IOException {
        jsonWriter.value(l.toString());
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long read2(JsonReader jsonReader) throws IOException {
        return Long.valueOf(Long.parseLong(jsonReader.nextString()));
    }
}
