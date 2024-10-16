package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class a<E> implements Collection<E> {
    public abstract int a();

    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
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
    public final int size() {
        return a();
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

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        return j.a(this, ", ", "[", "]", 0, null, new kotlin.jvm.a.b<E, CharSequence>() { // from class: kotlin.collections.AbstractCollection$toString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CharSequence a(E e) {
                return e == a.this ? "(this Collection)" : String.valueOf(e);
            }
        }, 24, null);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.e.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "array");
        T[] tArr2 = (T[]) kotlin.jvm.internal.e.a(this, tArr);
        if (tArr2 != null) {
            return tArr2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if ((this instanceof Collection) && isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.h.a(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }
}
