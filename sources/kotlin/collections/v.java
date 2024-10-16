package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class v implements Iterator<Integer> {
    public abstract int b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Integer next() {
        return Integer.valueOf(b());
    }
}
