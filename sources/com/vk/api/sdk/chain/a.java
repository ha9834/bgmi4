package com.vk.api.sdk.chain;

import com.vk.api.sdk.n;

/* loaded from: classes3.dex */
public final class a<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f6867a;
    private final n b;
    private final com.vk.api.sdk.utils.b c;
    private final kotlin.c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(com.vk.api.sdk.h hVar, c<? extends T> cVar, n nVar, com.vk.api.sdk.utils.b bVar) {
        super(hVar);
        kotlin.jvm.internal.h.b(hVar, "manager");
        kotlin.jvm.internal.h.b(cVar, "chain");
        kotlin.jvm.internal.h.b(nVar, "call");
        kotlin.jvm.internal.h.b(bVar, "priorityBackoff");
        this.f6867a = cVar;
        this.b = nVar;
        this.c = bVar;
        this.d = kotlin.d.a(new kotlin.jvm.a.a<Integer>(this) { // from class: com.vk.api.sdk.chain.ApiMethodPriorityChainCall$chainId$2
            final /* synthetic */ a<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.a.a
            public /* synthetic */ Integer b() {
                return Integer.valueOf(a());
            }

            public final int a() {
                com.vk.api.sdk.utils.b bVar2;
                bVar2 = ((a) this.this$0).c;
                return bVar2.b();
            }
        });
    }

    private final int b() {
        return ((Number) this.d.a()).intValue();
    }

    @Override // com.vk.api.sdk.chain.c
    public T a(b bVar) {
        kotlin.jvm.internal.h.b(bVar, "args");
        if (!this.c.a()) {
            return this.f6867a.a(bVar);
        }
        String b = this.b.b();
        while (this.c.a(b)) {
            if (Thread.interrupted()) {
                throw new InterruptedException("request interrupted");
            }
            this.c.a(b(), b);
        }
        return this.f6867a.a(bVar);
    }
}
