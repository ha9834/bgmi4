package com.vk.api.sdk.chain;

import com.vk.api.sdk.utils.log.Logger;

/* loaded from: classes3.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.vk.api.sdk.h f6869a;

    public abstract T a(b bVar) throws Exception;

    public c(com.vk.api.sdk.h hVar) {
        kotlin.jvm.internal.h.b(hVar, "manager");
        this.f6869a = hVar;
    }

    public final com.vk.api.sdk.h a() {
        return this.f6869a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, Throwable th) {
        kotlin.jvm.internal.h.b(str, "msg");
        kotlin.jvm.internal.h.b(th, "t");
        this.f6869a.a().g().a(Logger.LogLevel.DEBUG, str, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(String str, Throwable th) {
        kotlin.jvm.internal.h.b(str, "msg");
        kotlin.jvm.internal.h.b(th, "t");
        this.f6869a.a().g().a(Logger.LogLevel.WARNING, str, th);
    }
}
