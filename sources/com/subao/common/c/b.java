package com.subao.common.c;

import android.util.JsonWriter;

/* loaded from: classes2.dex */
public class b implements com.subao.common.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f5939a;
    public final int b;

    public b(String str, int i) {
        this.f5939a = str;
        this.b = i;
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("productId").value(this.f5939a);
        jsonWriter.name("num").value(this.b);
        jsonWriter.endObject();
    }
}
