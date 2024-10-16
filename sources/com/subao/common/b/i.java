package com.subao.common.b;

import android.os.Build;
import android.util.JsonWriter;

/* loaded from: classes2.dex */
public class i implements com.subao.common.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f5926a;
    public final int b;
    private final String c;
    private final String d;
    private final String e = Build.MODEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, int i) {
        this.f5926a = str;
        this.b = i;
        boolean b = com.subao.a.a.b();
        this.c = b ? com.subao.a.a.a() : null;
        this.d = b ? "MTK" : null;
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        com.subao.common.n.g.a(jsonWriter, "productId", this.f5926a);
        jsonWriter.name("num").value(this.b);
        com.subao.common.n.g.a(jsonWriter, "deviceId", this.c);
        com.subao.common.n.g.a(jsonWriter, "chipType", this.d);
        com.subao.common.n.g.a(jsonWriter, "phoneModel", this.e);
        jsonWriter.endObject();
    }
}
