package com.vk.api.sdk.chain;

import com.tencent.imsdk.android.IR;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.k;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.a.q;
import kotlin.k;

/* loaded from: classes3.dex */
public final class j<T> extends h<T> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f6876a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j(com.vk.api.sdk.h hVar, int i, c<? extends T> cVar) {
        super(hVar, i);
        kotlin.jvm.internal.h.b(hVar, "manager");
        kotlin.jvm.internal.h.b(cVar, "chain");
        this.f6876a = cVar;
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
                try {
                    return this.f6876a.a(bVar);
                } catch (VKApiExecutionException e) {
                    a(e, bVar);
                    if (i == b) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        throw new VKApiException("Can't confirm validation due to retry limit!");
    }

    private final void a(VKApiExecutionException vKApiExecutionException, b bVar) throws Exception {
        k kVar;
        if (vKApiExecutionException.h()) {
            c(vKApiExecutionException, bVar);
            return;
        }
        if (vKApiExecutionException.g()) {
            a(vKApiExecutionException);
            return;
        }
        if (vKApiExecutionException.f()) {
            b(vKApiExecutionException, bVar);
            return;
        }
        com.vk.api.sdk.k c = a().c();
        if (c == null) {
            kVar = null;
        } else {
            c.a(vKApiExecutionException, a());
            kVar = k.f6974a;
        }
        if (kVar == null) {
            throw vKApiExecutionException;
        }
    }

    private final void b(VKApiExecutionException vKApiExecutionException, b bVar) {
        Boolean bool = (Boolean) a(vKApiExecutionException.m(), a().c(), ValidationHandlerChainCall$handleUserConfirmation$confirmation$1.f6865a);
        if (bool == null) {
            throw vKApiExecutionException;
        }
        if (kotlin.jvm.internal.h.a((Object) bool, (Object) false)) {
            throw vKApiExecutionException;
        }
        bVar.a(bool.booleanValue());
    }

    private final void a(VKApiExecutionException vKApiExecutionException) {
        a((k.b) a(vKApiExecutionException.l(), a().c(), ValidationHandlerChainCall$handleValidation$credentials$1.f6866a), vKApiExecutionException);
    }

    protected final void a(k.b bVar, VKApiExecutionException vKApiExecutionException) {
        kotlin.jvm.internal.h.b(vKApiExecutionException, IR.path.DOCS_EXTRA_MSG);
        if (kotlin.jvm.internal.h.a(bVar, k.b.f6887a.a())) {
            return;
        }
        boolean z = false;
        if (bVar != null && bVar.c()) {
            z = true;
        }
        if (!z) {
            throw vKApiExecutionException;
        }
        com.vk.api.sdk.h a2 = a();
        String b = bVar.b();
        kotlin.jvm.internal.h.a((Object) b);
        a2.a(b, bVar.a());
    }

    private final void c(VKApiExecutionException vKApiExecutionException, b bVar) {
        String str = (String) a(vKApiExecutionException.k(), a().c(), ValidationHandlerChainCall$handleCaptcha$captcha$1.f6864a);
        if (str == null) {
            throw vKApiExecutionException;
        }
        bVar.a(vKApiExecutionException.j());
        bVar.b(str);
    }

    protected final <T, H> T a(String str, H h, q<? super H, ? super String, ? super k.a<T>, kotlin.k> qVar) {
        kotlin.jvm.internal.h.b(str, "extra");
        kotlin.jvm.internal.h.b(qVar, "handlerMethod");
        if (h == null) {
            return null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        k.a aVar = new k.a(countDownLatch);
        qVar.a(h, str, aVar);
        countDownLatch.await();
        return (T) aVar.a();
    }
}
