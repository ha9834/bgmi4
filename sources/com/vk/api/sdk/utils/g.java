package com.vk.api.sdk.utils;

import com.vk.api.sdk.utils.f;

/* loaded from: classes3.dex */
public final class g<T> implements f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.jvm.a.a<T> f6923a;
    private final ThreadLocal<T> b;

    /* loaded from: classes3.dex */
    public static final class a extends ThreadLocal<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<T> f6924a;

        a(g<T> gVar) {
            this.f6924a = gVar;
        }

        @Override // java.lang.ThreadLocal
        protected T initialValue() {
            return this.f6924a.b().b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(kotlin.jvm.a.a<? extends T> aVar) {
        kotlin.jvm.internal.h.b(aVar, "factory");
        this.f6923a = aVar;
        this.b = new a(this);
    }

    @Override // com.vk.api.sdk.utils.f
    public T a(Object obj, kotlin.e.e<?> eVar) {
        return (T) f.a.a(this, obj, eVar);
    }

    public final kotlin.jvm.a.a<T> b() {
        return this.f6923a;
    }

    @Override // com.vk.api.sdk.utils.f
    public T a() {
        T t = this.b.get();
        kotlin.jvm.internal.h.a(t);
        return t;
    }
}
