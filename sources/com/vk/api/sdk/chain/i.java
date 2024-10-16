package com.vk.api.sdk.chain;

import com.subao.gamemaster.GameMaster;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;

/* loaded from: classes3.dex */
public final class i<T> extends h<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6875a = new a(null);
    private static final com.vk.api.sdk.utils.d d = new com.vk.api.sdk.utils.d(1000, GameMaster.DEFAULT_NODE_DETECT_TIMEOUT, 1.2f, 0.0f, 0.0f, 24, null);
    private final com.vk.api.sdk.utils.a.b b;
    private final c<T> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(com.vk.api.sdk.h hVar, int i, com.vk.api.sdk.utils.a.b bVar, c<? extends T> cVar) {
        super(hVar, i);
        kotlin.jvm.internal.h.b(hVar, "manager");
        kotlin.jvm.internal.h.b(bVar, "backoff");
        kotlin.jvm.internal.h.b(cVar, "chain");
        this.b = bVar;
        this.c = cVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.vk.api.sdk.chain.c
    public T a(b bVar) throws Exception {
        kotlin.jvm.internal.h.b(bVar, "args");
        int b = b();
        if (b >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                d.d();
                this.b.a(3, 1000L);
                try {
                    T a2 = this.c.a(bVar);
                    d.e();
                    return a2;
                } catch (VKApiExecutionException e) {
                    if (e.d()) {
                        a("Too many requests", e);
                        d.f();
                        if (i == b) {
                            break;
                        }
                        i = i2;
                    } else {
                        throw e;
                    }
                }
            }
        }
        throw new VKApiException("Can't handle too many requests due to retry limit! (retryLimit=" + b() + ')');
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
