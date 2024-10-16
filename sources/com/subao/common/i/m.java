package com.subao.common.i;

import android.content.Context;
import android.os.Build;
import android.util.JsonWriter;
import com.subao.common.n.e;

/* loaded from: classes2.dex */
public class m implements com.subao.common.c {

    /* renamed from: a, reason: collision with root package name */
    private String f6043a;
    private int b;
    private int c;
    private int d;
    private String e;

    public String a() {
        return this.f6043a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public m(String str, int i, int i2, int i3, String str2) {
        this.f6043a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = str2;
    }

    public m(Context context) {
        this(Build.MODEL, (int) e.a.c(), e.a.b(), (int) (com.subao.common.n.e.a(context) / 1048576), Build.DISPLAY);
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        com.subao.common.n.g.a(jsonWriter, "model", this.f6043a);
        jsonWriter.name("cpuSpeed").value(this.b);
        jsonWriter.name("cpuCore").value(this.c);
        jsonWriter.name("memory").value(this.d);
        com.subao.common.n.g.a(jsonWriter, "rom", this.e);
        jsonWriter.endObject();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.b == mVar.b && this.c == mVar.c && this.d == mVar.d && com.subao.common.e.a(this.f6043a, mVar.f6043a) && com.subao.common.e.a(this.e, mVar.e);
    }
}
