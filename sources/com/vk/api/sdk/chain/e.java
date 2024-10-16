package com.vk.api.sdk.chain;

import com.vk.api.sdk.exceptions.VKApiExecutionException;

/* loaded from: classes3.dex */
public final class e<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f6871a;
    private final int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(com.vk.api.sdk.h hVar, c<? extends T> cVar, int i) {
        super(hVar);
        kotlin.jvm.internal.h.b(hVar, "manager");
        kotlin.jvm.internal.h.b(cVar, "chain");
        this.f6871a = cVar;
        this.b = i;
    }

    @Override // com.vk.api.sdk.chain.c
    public T a(b bVar) throws Exception {
        kotlin.jvm.internal.h.b(bVar, "args");
        return a(bVar, 0);
    }

    private final T a(b bVar, int i) {
        try {
            return this.f6871a.a(bVar);
        } catch (VKApiExecutionException e) {
            if (e.e()) {
                int i2 = this.b;
                if (i2 > 0 && i < i2) {
                    String o = e.o();
                    String c = a().d().c();
                    String e2 = a().d().e();
                    boolean z = !kotlin.jvm.internal.h.a((Object) o, (Object) c);
                    boolean z2 = e2 != null && kotlin.jvm.internal.h.a((Object) o, (Object) e2);
                    if (o != null && (z || z2)) {
                        return a(bVar, i + 1);
                    }
                }
                if (e.a() == 3610) {
                    com.vk.api.sdk.g e3 = a().e();
                    if (e3 != null) {
                        e3.a(e.b());
                    }
                } else {
                    com.vk.api.sdk.g e4 = a().e();
                    if (e4 != null) {
                        e4.a(e.b(), e.n());
                    }
                }
            }
            throw e;
        }
    }
}
