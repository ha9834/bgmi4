package com.vk.api.sdk.okhttp;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.api.sdk.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f6903a;
    private final String b;
    private final String c;
    private final Map<String, String> d;
    private final f e;
    private final boolean f;
    private final int g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f6904a;
        private f e;
        private boolean f;
        private String b = "";
        private String c = "";
        private Map<String, String> d = new HashMap();
        private int g = 4;

        public final String a() {
            return this.f6904a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        public final Map<String, String> d() {
            return this.d;
        }

        public final f e() {
            return this.e;
        }

        public final boolean f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }

        public a a(String str) {
            a aVar = this;
            aVar.f6904a = str;
            return aVar;
        }

        public a b(String str) {
            h.b(str, FirebaseAnalytics.Param.METHOD);
            a aVar = this;
            aVar.b = str;
            return aVar;
        }

        public a c(String str) {
            h.b(str, "version");
            a aVar = this;
            aVar.c = str;
            return aVar;
        }

        public a a(Map<String, String> map) {
            h.b(map, "args");
            a aVar = this;
            aVar.d().putAll(map);
            return aVar;
        }

        public a a(String str, String str2) {
            h.b(str, "key");
            h.b(str2, "value");
            a aVar = this;
            aVar.d().put(str, str2);
            return aVar;
        }

        public final String d(String str) {
            h.b(str, "key");
            return this.d.get(str);
        }

        public final a a(boolean z) {
            a aVar = this;
            aVar.f = z;
            return aVar;
        }

        public final a a(int i) {
            a aVar = this;
            aVar.g = i;
            return aVar;
        }

        public a a(n nVar) {
            h.b(nVar, "call");
            a aVar = this;
            aVar.b(nVar.b());
            aVar.c(nVar.c());
            aVar.a(nVar.d());
            aVar.a(nVar.g());
            aVar.a(nVar.e());
            aVar.a(nVar.a());
            return aVar;
        }

        public e h() {
            return new e(this);
        }
    }

    public final String a() {
        return this.f6903a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final Map<String, String> d() {
        return this.d;
    }

    public final f e() {
        return this.e;
    }

    protected e(a aVar) {
        h.b(aVar, "b");
        if (l.a((CharSequence) aVar.b())) {
            throw new IllegalArgumentException("method is null or empty");
        }
        if (l.a((CharSequence) aVar.c())) {
            throw new IllegalArgumentException("version is null or empty");
        }
        this.f6903a = aVar.a();
        this.b = aVar.b();
        this.c = aVar.c();
        this.d = aVar.d();
        this.e = aVar.e();
        this.f = aVar.f();
        this.g = aVar.g();
    }

    public final boolean f() {
        return h.a((Object) this.d.get("extended"), (Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || h.a((Object) this.d.get("extended"), (Object) "1");
    }
}
