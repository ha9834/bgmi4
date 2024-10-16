package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c<T> implements Collection<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T[] f6944a;
    private final boolean b;

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.jvm.internal.e.a(this, tArr);
    }

    public c(T[] tArr, boolean z) {
        kotlin.jvm.internal.h.b(tArr, "values");
        this.f6944a = tArr;
        this.b = z;
    }

    @Override // java.util.Collection
    public final int size() {
        return a();
    }

    public int a() {
        return this.f6944a.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f6944a.length == 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return d.a(this.f6944a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        kotlin.jvm.internal.h.b(collection, MessengerShareContentUtility.ELEMENTS);
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.b.a(this.f6944a);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return j.a(this.f6944a, this.b);
    }
}
