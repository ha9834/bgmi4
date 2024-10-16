package com.vk.api.sdk;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.tencent.midas.http.midashttp.IAPMidasEncodeKeyType;
import com.vk.api.sdk.utils.log.Logger;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6877a = new a(null);
    private final Context b;
    private final int c;
    private final k d;
    private final c e;
    private final kotlin.c<String> f;
    private final String g;
    private final o h;
    private final Logger i;
    private final kotlin.c<String> j;
    private final kotlin.c<String> k;
    private final String l;
    private final boolean m;
    private final kotlin.c<Boolean> n;
    private final int o;
    private final kotlin.jvm.a.a<String> p;
    private final kotlin.jvm.a.a<String> q;
    private final m r;
    private final kotlin.c<String> s;
    private final long t;
    private final com.vk.api.sdk.utils.b u;
    private final kotlin.c<String> v;
    private final boolean w;
    private final j x;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.h.a(this.b, eVar.b) && this.c == eVar.c && kotlin.jvm.internal.h.a(this.d, eVar.d) && kotlin.jvm.internal.h.a(this.e, eVar.e) && kotlin.jvm.internal.h.a(this.f, eVar.f) && kotlin.jvm.internal.h.a((Object) this.g, (Object) eVar.g) && kotlin.jvm.internal.h.a(this.h, eVar.h) && kotlin.jvm.internal.h.a(this.i, eVar.i) && kotlin.jvm.internal.h.a(this.j, eVar.j) && kotlin.jvm.internal.h.a(this.k, eVar.k) && kotlin.jvm.internal.h.a((Object) this.l, (Object) eVar.l) && this.m == eVar.m && kotlin.jvm.internal.h.a(this.n, eVar.n) && this.o == eVar.o && kotlin.jvm.internal.h.a(this.p, eVar.p) && kotlin.jvm.internal.h.a(this.q, eVar.q) && kotlin.jvm.internal.h.a(this.r, eVar.r) && kotlin.jvm.internal.h.a(this.s, eVar.s) && this.t == eVar.t && kotlin.jvm.internal.h.a(this.u, eVar.u) && kotlin.jvm.internal.h.a(this.v, eVar.v) && this.w == eVar.w && kotlin.jvm.internal.h.a(this.x, eVar.x);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.b.hashCode() * 31) + Integer.hashCode(this.c)) * 31;
        k kVar = this.d;
        int hashCode2 = (hashCode + (kVar == null ? 0 : kVar.hashCode())) * 31;
        c cVar = this.e;
        int hashCode3 = (((((((((((((((hashCode2 + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        boolean z = this.m;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode4 = (((((((((((((((((((hashCode3 + i) * 31) + this.n.hashCode()) * 31) + Integer.hashCode(this.o)) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + Long.hashCode(this.t)) * 31) + this.u.hashCode()) * 31) + this.v.hashCode()) * 31;
        boolean z2 = this.w;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode4 + i2) * 31;
        j jVar = this.x;
        return i3 + (jVar != null ? jVar.hashCode() : 0);
    }

    public String toString() {
        return "VKApiConfig(context=" + this.b + ", appId=" + this.c + ", validationHandler=" + this.d + ", apiCallListener=" + this.e + ", deviceId=" + this.f + ", version=" + this.g + ", okHttpProvider=" + this.h + ", logger=" + this.i + ", accessToken=" + this.j + ", secret=" + this.k + ", clientSecret=" + this.l + ", logFilterCredentials=" + this.m + ", debugCycleCalls=" + this.n + ", callsPerSecondLimit=" + this.o + ", httpApiHostProvider=" + this.p + ", langProvider=" + this.q + ", keyValueStorage=" + this.r + ", customApiEndpoint=" + this.s + ", rateLimitBackoffTimeoutMs=" + this.t + ", apiMethodPriorityBackoff=" + this.u + ", externalDeviceId=" + this.v + ", enableAnonymousToken=" + this.w + ", responseValidator=" + this.x + ')';
    }

    public e(Context context, int i, k kVar, c cVar, kotlin.c<String> cVar2, String str, o oVar, Logger logger, kotlin.c<String> cVar3, kotlin.c<String> cVar4, String str2, boolean z, kotlin.c<Boolean> cVar5, int i2, kotlin.jvm.a.a<String> aVar, kotlin.jvm.a.a<String> aVar2, m mVar, kotlin.c<String> cVar6, long j, com.vk.api.sdk.utils.b bVar, kotlin.c<String> cVar7, boolean z2, j jVar) {
        kotlin.jvm.internal.h.b(context, "context");
        kotlin.jvm.internal.h.b(cVar2, "deviceId");
        kotlin.jvm.internal.h.b(str, "version");
        kotlin.jvm.internal.h.b(oVar, "okHttpProvider");
        kotlin.jvm.internal.h.b(logger, "logger");
        kotlin.jvm.internal.h.b(cVar3, SDKConstants.PARAM_ACCESS_TOKEN);
        kotlin.jvm.internal.h.b(cVar4, IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_SECRET);
        kotlin.jvm.internal.h.b(str2, "clientSecret");
        kotlin.jvm.internal.h.b(cVar5, "debugCycleCalls");
        kotlin.jvm.internal.h.b(aVar, "httpApiHostProvider");
        kotlin.jvm.internal.h.b(aVar2, "langProvider");
        kotlin.jvm.internal.h.b(mVar, "keyValueStorage");
        kotlin.jvm.internal.h.b(cVar6, "customApiEndpoint");
        kotlin.jvm.internal.h.b(bVar, "apiMethodPriorityBackoff");
        kotlin.jvm.internal.h.b(cVar7, "externalDeviceId");
        this.b = context;
        this.c = i;
        this.d = kVar;
        this.e = cVar;
        this.f = cVar2;
        this.g = str;
        this.h = oVar;
        this.i = logger;
        this.j = cVar3;
        this.k = cVar4;
        this.l = str2;
        this.m = z;
        this.n = cVar5;
        this.o = i2;
        this.p = aVar;
        this.q = aVar2;
        this.r = mVar;
        this.s = cVar6;
        this.t = j;
        this.u = bVar;
        this.v = cVar7;
        this.w = z2;
        this.x = jVar;
    }

    public final Context a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final k c() {
        return this.d;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ e(android.content.Context r25, int r26, com.vk.api.sdk.k r27, com.vk.api.sdk.c r28, kotlin.c r29, java.lang.String r30, com.vk.api.sdk.o r31, com.vk.api.sdk.utils.log.Logger r32, kotlin.c r33, kotlin.c r34, java.lang.String r35, boolean r36, kotlin.c r37, int r38, kotlin.jvm.a.a r39, kotlin.jvm.a.a r40, com.vk.api.sdk.m r41, kotlin.c r42, long r43, com.vk.api.sdk.utils.b r45, kotlin.c r46, boolean r47, com.vk.api.sdk.j r48, int r49, kotlin.jvm.internal.f r50) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vk.api.sdk.e.<init>(android.content.Context, int, com.vk.api.sdk.k, com.vk.api.sdk.c, kotlin.c, java.lang.String, com.vk.api.sdk.o, com.vk.api.sdk.utils.log.Logger, kotlin.c, kotlin.c, java.lang.String, boolean, kotlin.c, int, kotlin.jvm.a.a, kotlin.jvm.a.a, com.vk.api.sdk.m, kotlin.c, long, com.vk.api.sdk.utils.b, kotlin.c, boolean, com.vk.api.sdk.j, int, kotlin.jvm.internal.f):void");
    }

    public final kotlin.c<String> d() {
        return this.f;
    }

    public final String e() {
        return this.g;
    }

    public final o f() {
        return this.h;
    }

    public final Logger g() {
        return this.i;
    }

    public final kotlin.c<String> h() {
        return this.j;
    }

    public final kotlin.c<String> i() {
        return this.k;
    }

    public final boolean j() {
        return this.m;
    }

    public final kotlin.jvm.a.a<String> k() {
        return this.p;
    }

    public final m l() {
        return this.r;
    }

    public final kotlin.c<String> m() {
        return this.s;
    }

    public final long n() {
        return this.t;
    }

    public final com.vk.api.sdk.utils.b o() {
        return this.u;
    }

    public final kotlin.c<String> p() {
        return this.v;
    }

    public final j q() {
        return this.x;
    }

    public final String r() {
        return this.q.b();
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }
}
