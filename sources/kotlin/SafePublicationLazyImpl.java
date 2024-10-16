package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SafePublicationLazyImpl<T> implements Serializable, c<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6936a = new a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> b = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final, reason: not valid java name */
    private final Object f1final;
    private volatile kotlin.jvm.a.a<? extends T> initializer;

    public SafePublicationLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        kotlin.jvm.internal.h.b(aVar, "initializer");
        this.initializer = aVar;
        this._value = j.f6965a;
        this.f1final = j.f6965a;
    }

    @Override // kotlin.c
    public T a() {
        T t = (T) this._value;
        if (t != j.f6965a) {
            return t;
        }
        kotlin.jvm.a.a<? extends T> aVar = this.initializer;
        if (aVar != null) {
            T b2 = aVar.b();
            if (b.compareAndSet(this, j.f6965a, b2)) {
                this.initializer = (kotlin.jvm.a.a) null;
                return b2;
            }
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

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }
}
