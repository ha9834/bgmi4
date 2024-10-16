package com.shieldtunnel.svpn.common.h;

import android.os.Build;
import android.util.JsonWriter;
import com.intlgame.webview.WebViewManager;
import com.shieldtunnel.svpn.common.f.f;
import com.shieldtunnel.svpn.common.k.e;

/* loaded from: classes2.dex */
public class d implements com.shieldtunnel.svpn.common.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f5837a;
    public final String b;
    public final String c;
    public final String d;

    public d(String str, String str2, String str3, String str4) {
        this.f5837a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return com.shieldtunnel.svpn.common.c.a(this.f5837a, dVar.f5837a) && com.shieldtunnel.svpn.common.c.a(this.b, dVar.b) && com.shieldtunnel.svpn.common.c.a(this.c, dVar.c) && com.shieldtunnel.svpn.common.c.a(this.d, dVar.d);
    }

    public int hashCode() {
        return ((this.f5837a.hashCode() ^ this.b.hashCode()) ^ this.c.hashCode()) ^ this.d.hashCode();
    }

    @Override // com.shieldtunnel.svpn.common.a
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("number").value(this.f5837a);
        jsonWriter.name(WebViewManager.KEY_JS_CHANNEL).value(this.b);
        jsonWriter.name("osVersion").value(this.c);
        jsonWriter.name("androidVersion").value(this.d);
        jsonWriter.endObject();
    }

    public d(String str, String str2) {
        this(str, str2, e.b(Build.FINGERPRINT), String.format(f.b, "%d", Integer.valueOf(Build.VERSION.SDK_INT)));
    }
}
