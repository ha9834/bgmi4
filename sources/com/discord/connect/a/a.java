package com.discord.connect.a;

import com.discord.connect.a.b;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class a<E extends b> extends TypeAdapter<E> {
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, E e) throws IOException {
        jsonWriter.value(e.a());
    }
}
