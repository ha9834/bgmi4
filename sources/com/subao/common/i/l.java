package com.subao.common.i;

import android.util.JsonWriter;

/* loaded from: classes2.dex */
public class l implements com.subao.common.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f6042a;
    public final String b;

    public l(String str, String str2) {
        this.f6042a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return com.subao.common.e.a(this.f6042a, lVar.f6042a) && com.subao.common.e.a(this.b, lVar.b);
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        com.subao.common.n.g.a(jsonWriter, "AppLabel", this.f6042a);
        com.subao.common.n.g.a(jsonWriter, "PkgName", this.b);
        jsonWriter.endObject();
    }
}
