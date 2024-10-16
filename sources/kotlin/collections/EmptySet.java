package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final class EmptySet implements Serializable, Set {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptySet f6941a = new EmptySet();
    private static final long serialVersionUID = 3406603774387020532L;

    public int a() {
        return 0;
    }

    public boolean a(Void r2) {
        kotlin.jvm.internal.h.b(r2, "element");
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.e.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.jvm.internal.e.a(this, tArr);
    }

    public String toString() {
        return "[]";
    }

    private EmptySet() {
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return a();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        kotlin.jvm.internal.h.b(collection, MessengerShareContentUtility.ELEMENTS);
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return u.f6946a;
    }

    private final Object readResolve() {
        return f6941a;
    }
}
