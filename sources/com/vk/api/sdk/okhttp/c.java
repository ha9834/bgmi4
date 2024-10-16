package com.vk.api.sdk.okhttp;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import com.vk.api.sdk.exceptions.IgnoredAccessTokenException;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.exceptions.VKInternalServerErrorException;
import com.vk.api.sdk.exceptions.VKLargeEntityException;
import com.vk.api.sdk.o;
import com.vk.api.sdk.utils.log.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.text.l;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.s;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6899a = new a(null);
    private final d b;
    private final Context c;
    private final Object d;
    private final kotlin.c e;
    private volatile kotlin.c<com.vk.api.sdk.f> f;
    private final String g;
    private volatile String h;

    protected void d(e eVar) {
        h.b(eVar, "call");
    }

    public c(d dVar) {
        h.b(dVar, ConfigDBHelper.TABLE_NAME_CONFIG);
        this.b = dVar;
        this.c = this.b.a();
        this.d = new Object();
        this.e = kotlin.d.a(new kotlin.jvm.a.a<o>() { // from class: com.vk.api.sdk.okhttp.OkHttpExecutor$okHttpProvider$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final o b() {
                if (h.a(Looper.getMainLooper(), Looper.myLooper())) {
                    throw new IllegalStateException("UI thread");
                }
                c cVar = c.this;
                cVar.a(cVar.a().f());
                return c.this.a().f();
            }
        });
        this.f = com.vk.api.sdk.f.f6879a.a(this.b.d(), this.b.e());
        this.g = this.b.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final d a() {
        return this.b;
    }

    private final o f() {
        return (o) this.e.a();
    }

    public final String b() {
        return this.b.c().b();
    }

    public final String c() {
        return this.f.a().a();
    }

    public final String d() {
        return this.f.a().b();
    }

    public final String e() {
        return this.h;
    }

    public final void a(String str, String str2) {
        h.b(str, SDKConstants.PARAM_ACCESS_TOKEN);
        this.f = com.vk.api.sdk.f.f6879a.a(str, str2);
    }

    public final void a(kotlin.c<com.vk.api.sdk.f> cVar) {
        h.b(cVar, "credentialsProvider");
        this.f = cVar;
    }

    public b a(e eVar) throws InterruptedException, IOException, VKApiException {
        h.b(eVar, "call");
        String b2 = b(eVar);
        b(eVar.b(), b2);
        String c = c(eVar);
        d(eVar);
        aa create = aa.Companion.create(a(eVar, com.vk.api.sdk.internal.c.f6883a.a(eVar.b(), eVar.d(), eVar.c(), b2, c, this.b.b())), v.Companion.parse("application/x-www-form-urlencoded; charset=utf-8"));
        String a2 = eVar.a();
        if (a2 == null) {
            a2 = b();
        }
        z.a a3 = new z.a().a(create).a(a(a2) + '/' + eVar.b()).a(okhttp3.d.f7054a);
        f e = eVar.e();
        z b3 = a3.a((Class<? super Class>) Map.class, (Class) (e == null ? null : e.a())).b();
        String c2 = c();
        ab a4 = a(b3);
        return new b(a(a4), a4.f(), c2);
    }

    protected final String a(e eVar, String str) throws VKApiException {
        h.b(eVar, "call");
        h.b(str, "paramsString");
        if (l.a(eVar.b(), "execute.", false, 2, (Object) null)) {
            Uri parse = Uri.parse(h.a("https://vk.com/?", (Object) str));
            if (parse.getQueryParameters(FirebaseAnalytics.Param.METHOD).contains("execute")) {
                List<String> queryParameters = parse.getQueryParameters("code");
                if (!(queryParameters == null || queryParameters.isEmpty())) {
                    throw new VKApiExecutionException(15, eVar.b(), false, "Hey dude don't execute your hacky code ;)", null, null, null, null, 0, 496, null);
                }
            }
        }
        return str;
    }

    protected final ab a(z zVar) throws InterruptedException, IOException {
        h.b(zVar, "request");
        return f().a().a(zVar).a();
    }

    protected final String a(ab abVar) {
        h.b(abVar, AnalyticsEventKey.RESPONSE);
        if (abVar.b() == 413) {
            throw new VKLargeEntityException(abVar.d());
        }
        ac g = abVar.g();
        String str = null;
        if (g != null) {
            ac acVar = g;
            Throwable th = (Throwable) null;
            try {
                String g2 = acVar.g();
                kotlin.c.a.a(acVar, th);
                str = g2;
            } catch (Throwable th2) {
                kotlin.c.a.a(acVar, th);
                throw th2;
            }
        }
        int b2 = abVar.b();
        boolean z = false;
        if (500 <= b2 && b2 <= 599) {
            z = true;
        }
        if (!z) {
            return str;
        }
        int b3 = abVar.b();
        if (str == null) {
            str = Constants.NULL_VERSION_ID;
        }
        throw new VKInternalServerErrorException(b3, str);
    }

    protected String b(e eVar) {
        h.b(eVar, "call");
        return c();
    }

    protected String c(e eVar) {
        h.b(eVar, "call");
        return d();
    }

    protected final void b(String str, String str2) throws IgnoredAccessTokenException {
        h.b(str, FirebaseAnalytics.Param.METHOD);
        if (this.h != null && str2 != null && h.a((Object) str2, (Object) this.h)) {
            throw new IgnoredAccessTokenException(str);
        }
    }

    private final String a(String str) {
        if (this.g.length() > 0) {
            return this.g;
        }
        return f6899a.a(str);
    }

    /* renamed from: com.vk.api.sdk.okhttp.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0222c implements o.a {
        C0222c() {
        }

        @Override // com.vk.api.sdk.o.a
        public x.a a(x.a aVar) {
            h.b(aVar, "builder");
            if (Logger.LogLevel.NONE != c.this.a().h().a().a()) {
                c cVar = c.this;
                aVar.a(cVar.a(cVar.a().g(), c.this.a().h()));
            }
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(o oVar) {
        oVar.a(new C0222c());
    }

    protected com.vk.api.sdk.okhttp.b a(boolean z, Logger logger) {
        h.b(logger, "logger");
        return new com.vk.api.sdk.okhttp.b(z, logger);
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f6900a;
        private final s b;
        private final String c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return h.a((Object) this.f6900a, (Object) bVar.f6900a) && h.a(this.b, bVar.b) && h.a((Object) this.c, (Object) bVar.c);
        }

        public int hashCode() {
            String str = this.f6900a;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode()) * 31;
            String str2 = this.c;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "MethodResponse(response=" + ((Object) this.f6900a) + ", headers=" + this.b + ", executorRequestAccessToken=" + ((Object) this.c) + ')';
        }

        public b(String str, s sVar, String str2) {
            h.b(sVar, "headers");
            this.f6900a = str;
            this.b = sVar;
            this.c = str2;
        }

        public final String a() {
            return this.f6900a;
        }

        public final s b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String a(String str) {
            return "https://" + str + "/method";
        }
    }
}
