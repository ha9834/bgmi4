package com.vk.api.sdk;

import java.util.concurrent.TimeUnit;
import okhttp3.x;

/* loaded from: classes3.dex */
public abstract class o {

    /* loaded from: classes3.dex */
    public interface a {
        x.a a(x.a aVar);
    }

    public abstract x a();

    public abstract void a(a aVar);

    /* loaded from: classes3.dex */
    public static final class b extends o {

        /* renamed from: a, reason: collision with root package name */
        private volatile x f6891a;

        @Override // com.vk.api.sdk.o
        public x a() {
            if (this.f6891a == null) {
                this.f6891a = new x.a().a(20L, TimeUnit.SECONDS).b(30L, TimeUnit.SECONDS).c(20L, TimeUnit.SECONDS).b(true).a(true).a(new com.vk.api.sdk.okhttp.g(com.vk.api.sdk.b.f6862a.f())).a();
            }
            x xVar = this.f6891a;
            kotlin.jvm.internal.h.a(xVar);
            return xVar;
        }

        @Override // com.vk.api.sdk.o
        public void a(a aVar) {
            kotlin.jvm.internal.h.b(aVar, "f");
            this.f6891a = aVar.a(a().A()).a();
        }
    }
}
