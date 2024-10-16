package com.vk.api.sdk.chain;

/* loaded from: classes3.dex */
public abstract class h<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f6874a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(com.vk.api.sdk.h hVar, int i) {
        super(hVar);
        kotlin.jvm.internal.h.b(hVar, "manager");
        this.f6874a = i;
        if (this.f6874a < 0) {
            throw new IllegalArgumentException("retryLimit must be >= 0");
        }
    }

    public final int b() {
        return this.f6874a;
    }
}
