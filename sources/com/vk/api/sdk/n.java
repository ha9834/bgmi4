package com.vk.api.sdk;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6889a = new b(null);
    private final String b;
    private final String c;
    private final String d;
    private final Map<String, String> e;
    private final int f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int[] k;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f6890a;
        private String b = "";
        private String c = "";
        private Map<String, String> d = new LinkedHashMap();
        private int e = 4;
        private boolean f;
        private boolean g;
        private int[] h;
        private boolean i;
        private boolean j;

        public final String a() {
            return this.f6890a;
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

        public final int e() {
            return this.e;
        }

        public final boolean f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        public final int[] h() {
            return this.h;
        }

        public final boolean i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }

        public a a(String str) {
            kotlin.jvm.internal.h.b(str, FirebaseAnalytics.Param.METHOD);
            a aVar = this;
            aVar.b = str;
            return aVar;
        }

        public a b(String str) {
            kotlin.jvm.internal.h.b(str, "version");
            a aVar = this;
            aVar.c = str;
            return aVar;
        }

        public a a(Map<String, String> map) {
            kotlin.jvm.internal.h.b(map, "args");
            a aVar = this;
            aVar.d().putAll(map);
            return aVar;
        }

        public a a(boolean z) {
            a aVar = this;
            aVar.i = z;
            return aVar;
        }

        public a b(boolean z) {
            a aVar = this;
            aVar.j = z;
            return aVar;
        }

        public n k() {
            return new n(this);
        }
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final Map<String, String> d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.i;
    }

    protected n(a aVar) {
        kotlin.jvm.internal.h.b(aVar, "b");
        if (kotlin.text.l.a((CharSequence) aVar.b())) {
            throw new IllegalArgumentException("method is null or empty");
        }
        if (kotlin.text.l.a((CharSequence) aVar.c())) {
            throw new IllegalArgumentException("version is null or empty");
        }
        this.b = aVar.a();
        this.c = aVar.b();
        this.d = aVar.c();
        this.e = aVar.d();
        this.f = aVar.e();
        this.g = aVar.f();
        this.h = aVar.g();
        this.k = aVar.h();
        this.i = aVar.i();
        this.j = aVar.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.h.a(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            n nVar = (n) obj;
            return kotlin.jvm.internal.h.a((Object) this.c, (Object) nVar.c) && kotlin.jvm.internal.h.a(this.e, nVar.e);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.vk.api.sdk.VKMethodCall");
    }

    public int hashCode() {
        return (this.c.hashCode() * 31) + this.e.hashCode();
    }

    public String toString() {
        return "VKMethodCall(method='" + this.c + "', args=" + this.e + ')';
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }

        private b() {
        }
    }
}
