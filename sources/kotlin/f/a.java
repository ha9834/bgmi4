package kotlin.f;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class a<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<b<T>> f6960a;

    public a(b<? extends T> bVar) {
        kotlin.jvm.internal.h.b(bVar, "sequence");
        this.f6960a = new AtomicReference<>(bVar);
    }

    @Override // kotlin.f.b
    public Iterator<T> a() {
        b<T> andSet = this.f6960a.getAndSet(null);
        if (andSet == null) {
            throw new IllegalStateException("This sequence can be consumed only once.");
        }
        return andSet.a();
    }
}
