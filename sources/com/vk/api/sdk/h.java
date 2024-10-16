package com.vk.api.sdk;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.okhttp.e;
import com.vk.api.sdk.utils.e;
import java.io.IOException;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final e f6880a;
    private final kotlin.c b;
    private final k c;
    private final kotlin.c d;
    private volatile g e;

    public h(e eVar) {
        kotlin.jvm.internal.h.b(eVar, ConfigDBHelper.TABLE_NAME_CONFIG);
        this.f6880a = eVar;
        this.b = kotlin.d.a(new kotlin.jvm.a.a<com.vk.api.sdk.utils.e>() { // from class: com.vk.api.sdk.VKApiManager$rateLimitBackoff$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.vk.api.sdk.utils.e b() {
                return new com.vk.api.sdk.utils.e(new e.a(h.this.a().a()), h.this.a().n(), 0L, 0.0f, null, 28, null);
            }
        });
        this.c = this.f6880a.c();
        this.d = kotlin.d.a(new kotlin.jvm.a.a<com.vk.api.sdk.okhttp.c>() { // from class: com.vk.api.sdk.VKApiManager$executor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.vk.api.sdk.okhttp.c b() {
                return new com.vk.api.sdk.okhttp.c(new com.vk.api.sdk.okhttp.d(h.this.a()));
            }
        });
    }

    public final e a() {
        return this.f6880a;
    }

    protected final com.vk.api.sdk.utils.e b() {
        return (com.vk.api.sdk.utils.e) this.b.a();
    }

    public final k c() {
        return this.c;
    }

    public com.vk.api.sdk.okhttp.c d() {
        return (com.vk.api.sdk.okhttp.c) this.d.a();
    }

    public final g e() {
        return this.e;
    }

    public final void a(String str, String str2) {
        kotlin.jvm.internal.h.b(str, SDKConstants.PARAM_ACCESS_TOKEN);
        d().a(str, str2);
    }

    public final void a(kotlin.c<f> cVar) {
        kotlin.jvm.internal.h.b(cVar, "credentialsProvider");
        d().a(cVar);
    }

    public final <T> T a(n nVar, i<T> iVar) throws InterruptedException, IOException, VKApiException {
        kotlin.jvm.internal.h.b(nVar, "call");
        return (T) a(a(nVar, b(nVar, iVar)));
    }

    protected <T> com.vk.api.sdk.chain.c<T> a(n nVar, com.vk.api.sdk.chain.c<? extends T> cVar) {
        kotlin.jvm.internal.h.b(nVar, "call");
        kotlin.jvm.internal.h.b(cVar, "chainCall");
        if (!nVar.f()) {
            cVar = a(nVar.e(), cVar);
        }
        com.vk.api.sdk.chain.g gVar = new com.vk.api.sdk.chain.g(this, nVar.b(), b(), b(nVar, new com.vk.api.sdk.chain.e(this, new com.vk.api.sdk.chain.a(this, cVar, nVar, this.f6880a.o()), 1)));
        return nVar.e() > 0 ? new com.vk.api.sdk.chain.d(this, nVar.e(), gVar) : gVar;
    }

    protected <T> com.vk.api.sdk.chain.j<T> a(int i, com.vk.api.sdk.chain.c<? extends T> cVar) {
        kotlin.jvm.internal.h.b(cVar, "chainCall");
        return new com.vk.api.sdk.chain.j<>(this, i, cVar);
    }

    protected <T> T a(com.vk.api.sdk.chain.c<? extends T> cVar) throws InterruptedException, IOException, VKApiException {
        kotlin.jvm.internal.h.b(cVar, "cc");
        T a2 = cVar.a(new com.vk.api.sdk.chain.b());
        kotlin.jvm.internal.h.a(a2);
        return a2;
    }

    protected <T> com.vk.api.sdk.chain.c<T> b(n nVar, i<T> iVar) {
        kotlin.jvm.internal.h.b(nVar, "call");
        return new com.vk.api.sdk.chain.f(this, d(), new e.a().a(nVar), this.f6880a.d().a(), this.f6880a.r(), iVar);
    }

    protected <T> com.vk.api.sdk.chain.i<T> b(n nVar, com.vk.api.sdk.chain.c<? extends T> cVar) {
        kotlin.jvm.internal.h.b(nVar, "call");
        kotlin.jvm.internal.h.b(cVar, "chainCall");
        return new com.vk.api.sdk.chain.i<>(this, nVar.e(), com.vk.api.sdk.utils.a.a.f6916a, cVar);
    }
}
