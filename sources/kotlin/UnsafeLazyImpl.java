package kotlin;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class UnsafeLazyImpl<T> implements Serializable, c<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        kotlin.jvm.internal.h.b(aVar, "initializer");
        this.initializer = aVar;
        this._value = j.f6965a;
    }

    @Override // kotlin.c
    public T a() {
        if (this._value == j.f6965a) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            kotlin.jvm.internal.h.a(aVar);
            this._value = aVar.b();
            this.initializer = (kotlin.jvm.a.a) null;
        }
        return (T) this._value;
    }

    public boolean b() {
        return this._value != j.f6965a;
    }

    public String toString() {
        return b() ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(a());
    }
}
