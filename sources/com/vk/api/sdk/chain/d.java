package com.vk.api.sdk.chain;

import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.exceptions.VKApiIllegalResponseException;
import com.vk.api.sdk.exceptions.VKInternalServerErrorException;

/* loaded from: classes3.dex */
public final class d<T> extends h<T> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f6870a;
    private final com.vk.api.sdk.utils.d b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(com.vk.api.sdk.h hVar, int i, c<? extends T> cVar) {
        super(hVar, i);
        kotlin.jvm.internal.h.b(hVar, "manager");
        kotlin.jvm.internal.h.b(cVar, "chain");
        this.f6870a = cVar;
        this.b = new com.vk.api.sdk.utils.d(1000L, 60000L, 1.5f, 0.0f, 0.0f, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.vk.api.sdk.chain.c
    public T a(b bVar) throws Exception {
        kotlin.jvm.internal.h.b(bVar, "args");
        VKInternalServerErrorException vKInternalServerErrorException = null;
        while (true) {
            if (b() >= 0 && this.b.b() > b()) {
                if (vKInternalServerErrorException == null) {
                    throw new VKApiException("api-call failed due to retry limits, but no exception has tracked");
                }
                throw vKInternalServerErrorException;
            }
            if (this.b.c()) {
                Thread.sleep(this.b.a());
            }
            try {
                return this.f6870a.a(bVar);
            } catch (VKApiExecutionException e) {
                if (e.c()) {
                    b("", e);
                    vKInternalServerErrorException = e;
                    this.b.f();
                } else {
                    throw e;
                }
            } catch (VKApiIllegalResponseException e2) {
                b("", e2);
                vKInternalServerErrorException = e2;
                this.b.f();
            } catch (VKInternalServerErrorException e3) {
                b("", e3);
                vKInternalServerErrorException = e3;
                this.b.f();
            }
        }
    }
}
