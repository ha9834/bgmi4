package com.vk.api.sdk.okhttp;

import com.vk.api.sdk.utils.log.Logger;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import kotlin.collections.j;
import kotlin.collections.w;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.i;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.u;
import okhttp3.z;

/* loaded from: classes3.dex */
public final class b implements u {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6898a;
    static final /* synthetic */ kotlin.e.e<Object>[] b;
    private static final Map<Logger.LogLevel, HttpLoggingInterceptor.Level> k;
    private final boolean c;
    private final Collection<String> d;
    private final Logger e;
    private final kotlin.c f;
    private final kotlin.c g;
    private final kotlin.c h;
    private final kotlin.c i;
    private final com.vk.api.sdk.utils.f j;

    public b(boolean z, Collection<String> collection, Logger logger) {
        h.b(collection, "keysToFilter");
        h.b(logger, "logger");
        this.c = z;
        this.d = collection;
        this.e = logger;
        this.f = kotlin.d.a(new kotlin.jvm.a.a<Regex>() { // from class: com.vk.api.sdk.okhttp.LoggingInterceptor$sensitiveKeysRequestRegex$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Regex b() {
                Collection collection2;
                StringBuilder sb = new StringBuilder();
                b bVar = b.this;
                sb.append("(");
                collection2 = bVar.d;
                sb.append(j.a(collection2, "|", null, null, 0, null, null, 62, null));
                sb.append(")=[a-z0-9]+");
                String sb2 = sb.toString();
                h.a((Object) sb2, "StringBuilder().apply {\n            append(\"(\")\n            append(keysToFilter.joinToString(\"|\"))\n            append(\")=[a-z0-9]+\")\n        }.toString()");
                return new Regex(sb2, RegexOption.f6979a);
            }
        });
        this.g = kotlin.d.a(new kotlin.jvm.a.a<kotlin.jvm.a.b<? super i, ? extends String>>() { // from class: com.vk.api.sdk.okhttp.LoggingInterceptor$sensitiveKeyRequestTransformer$2
            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.jvm.a.b<i, String> b() {
                return new kotlin.jvm.a.b<i, String>() { // from class: com.vk.api.sdk.okhttp.LoggingInterceptor$sensitiveKeyRequestTransformer$2.1
                    @Override // kotlin.jvm.a.b
                    public final String a(i iVar) {
                        h.b(iVar, "match");
                        return h.a(iVar.b().get(1), (Object) "=<HIDE>");
                    }
                };
            }
        });
        this.h = kotlin.d.a(new kotlin.jvm.a.a<Regex>() { // from class: com.vk.api.sdk.okhttp.LoggingInterceptor$sensitiveKeysResponseRegex$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Regex b() {
                Collection collection2;
                StringBuilder sb = new StringBuilder();
                b bVar = b.this;
                sb.append("\"(");
                collection2 = bVar.d;
                sb.append(j.a(collection2, "|", null, null, 0, null, null, 62, null));
                sb.append(")\":\"[a-z0-9]+\"");
                String sb2 = sb.toString();
                h.a((Object) sb2, "StringBuilder().apply {\n            append(\"\\\"(\")\n            append(keysToFilter.joinToString(\"|\"))\n            append(\")\\\":\\\"[a-z0-9]+\\\"\")\n        }.toString()");
                return new Regex(sb2, RegexOption.f6979a);
            }
        });
        this.i = kotlin.d.a(new kotlin.jvm.a.a<kotlin.jvm.a.b<? super i, ? extends String>>() { // from class: com.vk.api.sdk.okhttp.LoggingInterceptor$sensitiveKeysResponseTransformer$2
            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.jvm.a.b<i, String> b() {
                return new kotlin.jvm.a.b<i, String>() { // from class: com.vk.api.sdk.okhttp.LoggingInterceptor$sensitiveKeysResponseTransformer$2.1
                    @Override // kotlin.jvm.a.b
                    public final String a(i iVar) {
                        h.b(iVar, "match");
                        return '\"' + iVar.b().get(1) + "\":<HIDE>";
                    }
                };
            }
        });
        this.j = com.vk.api.sdk.utils.h.a(new kotlin.jvm.a.a<HttpLoggingInterceptor>() { // from class: com.vk.api.sdk.okhttp.LoggingInterceptor$delegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final HttpLoggingInterceptor b() {
                final b bVar = b.this;
                return new HttpLoggingInterceptor(new HttpLoggingInterceptor.a() { // from class: com.vk.api.sdk.okhttp.LoggingInterceptor$delegate$2.1
                    @Override // okhttp3.logging.HttpLoggingInterceptor.a
                    public void a(String str) {
                        boolean z2;
                        Logger logger2;
                        Logger logger3;
                        h.b(str, "message");
                        z2 = b.this.c;
                        if (z2) {
                            str = b(str);
                        }
                        String str2 = str;
                        logger2 = b.this.e;
                        logger3 = b.this.e;
                        Logger.a.a(logger2, logger3.a().a(), str2, null, 4, null);
                    }

                    private final String b(String str) {
                        String a2;
                        a2 = b.this.a(str);
                        return a2;
                    }
                });
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(boolean z, Logger logger) {
        this(z, j.b("access_token", "key", "client_secret"), logger);
        h.b(logger, "logger");
    }

    private final Regex a() {
        return (Regex) this.f.a();
    }

    private final kotlin.jvm.a.b<i, CharSequence> b() {
        return (kotlin.jvm.a.b) this.g.a();
    }

    private final Regex c() {
        return (Regex) this.h.a();
    }

    private final kotlin.jvm.a.b<i, CharSequence> d() {
        return (kotlin.jvm.a.b) this.i.a();
    }

    static {
        kotlin.e.e<Object>[] eVarArr = new kotlin.e.e[5];
        eVarArr[4] = kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.b(b.class), "delegate", "getDelegate()Lokhttp3/logging/HttpLoggingInterceptor;"));
        b = eVarArr;
        f6898a = new a(null);
        k = w.a(kotlin.i.a(Logger.LogLevel.NONE, HttpLoggingInterceptor.Level.NONE), kotlin.i.a(Logger.LogLevel.ERROR, HttpLoggingInterceptor.Level.NONE), kotlin.i.a(Logger.LogLevel.WARNING, HttpLoggingInterceptor.Level.BASIC), kotlin.i.a(Logger.LogLevel.DEBUG, HttpLoggingInterceptor.Level.HEADERS), kotlin.i.a(Logger.LogLevel.VERBOSE, HttpLoggingInterceptor.Level.BODY), kotlin.i.a(Logger.LogLevel.NONE, HttpLoggingInterceptor.Level.NONE));
    }

    private final HttpLoggingInterceptor e() {
        return (HttpLoggingInterceptor) this.j.a(this, b[4]);
    }

    @Override // okhttp3.u
    public ab intercept(u.a aVar) {
        HttpLoggingInterceptor.Level level;
        h.b(aVar, "chain");
        z a2 = aVar.a();
        aa d = a2.d();
        long c = d == null ? 0L : d.c();
        com.vk.api.sdk.okhttp.a aVar2 = (com.vk.api.sdk.okhttp.a) a2.a(com.vk.api.sdk.okhttp.a.class);
        Logger.LogLevel a3 = aVar2 == null ? null : aVar2.a();
        if (a3 == null) {
            a3 = this.e.a().a();
        }
        HttpLoggingInterceptor e = e();
        if (c > 64 || c <= 0) {
            level = k.get(Collections.min(j.b(a3, Logger.LogLevel.WARNING)));
        } else {
            level = k.get(a3);
        }
        h.a(level);
        e.level(level);
        return e().intercept(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str) {
        return c().a(a().a(str, b()), d());
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
