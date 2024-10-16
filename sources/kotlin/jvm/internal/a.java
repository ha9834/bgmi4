package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class a<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    private int f6968a;
    private final T[] b;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public a(T[] tArr) {
        h.b(tArr, "array");
        this.b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6968a < this.b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.b;
            int i = this.f6968a;
            this.f6968a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f6968a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
