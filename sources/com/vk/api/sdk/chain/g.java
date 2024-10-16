package com.vk.api.sdk.chain;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.api.sdk.exceptions.RateLimitReachedException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;

/* loaded from: classes3.dex */
public final class g<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6873a = new a(null);
    private final String b;
    private final com.vk.api.sdk.utils.e c;
    private final c<T> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(com.vk.api.sdk.h hVar, String str, com.vk.api.sdk.utils.e eVar, c<? extends T> cVar) {
        super(hVar);
        kotlin.jvm.internal.h.b(hVar, "manager");
        kotlin.jvm.internal.h.b(str, FirebaseAnalytics.Param.METHOD);
        kotlin.jvm.internal.h.b(eVar, "backoff");
        kotlin.jvm.internal.h.b(cVar, "chainCall");
        this.b = str;
        this.c = eVar;
        this.d = cVar;
    }

    @Override // com.vk.api.sdk.chain.c
    public T a(b bVar) {
        kotlin.jvm.internal.h.b(bVar, "args");
        if (this.c.a(this.b)) {
            throw new RateLimitReachedException(this.b, "Rate limit reached.");
        }
        this.c.c(this.b);
        try {
            return this.d.a(bVar);
        } catch (VKApiExecutionException e) {
            if (e.i()) {
                this.c.d(this.b);
                a("Rate limit reached.", e);
            }
            throw e;
        }
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
