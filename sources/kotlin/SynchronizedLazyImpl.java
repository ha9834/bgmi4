package kotlin;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SynchronizedLazyImpl<T> implements Serializable, c<T> {
    private volatile Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(kotlin.jvm.a.a<? extends T> aVar, Object obj) {
        kotlin.jvm.internal.h.b(aVar, "initializer");
        this.initializer = aVar;
        this._value = j.f6965a;
        this.lock = obj == null ? this : obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(kotlin.jvm.a.a aVar, Object obj, int i, kotlin.jvm.internal.f fVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }

    @Override // kotlin.c
    public T a() {
        T t;
        T t2 = (T) this._value;
        if (t2 != j.f6965a) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == j.f6965a) {
                kotlin.jvm.a.a<? extends T> aVar = this.initializer;
                kotlin.jvm.internal.h.a(aVar);
                t = aVar.b();
                this._value = t;
                this.initializer = (kotlin.jvm.a.a) null;
            }
        }
        return t;
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
