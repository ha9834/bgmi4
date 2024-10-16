package com.subao.common.i;

import android.os.Build;
import android.util.JsonWriter;
import com.intlgame.webview.WebViewManager;

/* loaded from: classes2.dex */
public class r implements com.subao.common.c {

    /* renamed from: a, reason: collision with root package name */
    private String f6059a;
    private String b;
    private String c;
    private String d;

    public String a() {
        return this.f6059a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    r(String str, String str2, String str3, String str4) {
        this.f6059a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static r a(String str, String str2) {
        return new r(str, str2, Build.FINGERPRINT, Build.VERSION.RELEASE);
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        com.subao.common.n.g.a(jsonWriter, "number", this.f6059a);
        com.subao.common.n.g.a(jsonWriter, WebViewManager.KEY_JS_CHANNEL, this.b);
        com.subao.common.n.g.a(jsonWriter, "osVersion", this.c);
        com.subao.common.n.g.a(jsonWriter, "androidVersion", this.d);
        jsonWriter.endObject();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return com.subao.common.e.a(this.f6059a, rVar.f6059a) && com.subao.common.e.a(this.b, rVar.b) && com.subao.common.e.a(this.c, rVar.c) && com.subao.common.e.a(this.d, rVar.d);
    }

    public void e() {
        this.c = "";
        this.d = "";
    }
}
