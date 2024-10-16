package kotlin.f;

import java.util.Iterator;

/* loaded from: classes3.dex */
public final class i<T, R> implements b<R> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f6963a;
    private final kotlin.jvm.a.b<T, R> b;

    /* loaded from: classes3.dex */
    public static final class a implements Iterator<R> {
        private final Iterator<T> b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a() {
            this.b = i.this.f6963a.a();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) i.this.b.a(this.b.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(b<? extends T> bVar, kotlin.jvm.a.b<? super T, ? extends R> bVar2) {
        kotlin.jvm.internal.h.b(bVar, "sequence");
        kotlin.jvm.internal.h.b(bVar2, "transformer");
        this.f6963a = bVar;
        this.b = bVar2;
    }

    @Override // kotlin.f.b
    public Iterator<R> a() {
        return new a();
    }
}
