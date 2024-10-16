package kotlin.collections;

import com.tencent.imsdk.android.IR;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public abstract class b<E> extends kotlin.collections.a<E> implements List<E> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6942a = new a(null);

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public abstract E get(int i);

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new C0227b();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new c(i);
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new d(this, i, i2);
    }

    /* loaded from: classes3.dex */
    private static final class d<E> extends b<E> implements RandomAccess {
        private int b;
        private final b<E> c;
        private final int d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(b<? extends E> bVar, int i, int i2) {
            kotlin.jvm.internal.h.b(bVar, "list");
            this.c = bVar;
            this.d = i;
            b.f6942a.a(this.d, i2, this.c.size());
            this.b = i2 - this.d;
        }

        @Override // kotlin.collections.b, java.util.List
        public E get(int i) {
            b.f6942a.a(i, this.b);
            return this.c.get(this.d + i);
        }

        @Override // kotlin.collections.a
        public int a() {
            return this.b;
        }
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f6942a.a(this, (Collection<?>) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f6942a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kotlin.collections.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0227b implements Iterator<E> {
        private int b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public C0227b() {
        }

        protected final int a() {
            return this.b;
        }

        protected final void a(int i) {
            this.b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b bVar = b.this;
            int i = this.b;
            this.b = i + 1;
            return (E) bVar.get(i);
        }
    }

    /* loaded from: classes3.dex */
    private class c extends b<E>.C0227b implements ListIterator<E> {
        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public c(int i) {
            super();
            b.f6942a.b(i, b.this.size());
            a(i);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            b bVar = b.this;
            a(a() - 1);
            return (E) bVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void b(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void a(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            }
            if (i <= i2) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }

        public final int a(Collection<?> collection) {
            kotlin.jvm.internal.h.b(collection, IR.path.DOCS_IMSDK_CHANNEL);
            Iterator<?> it = collection.iterator();
            int i = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i = (i * 31) + (next != null ? next.hashCode() : 0);
            }
            return i;
        }

        public final boolean a(Collection<?> collection, Collection<?> collection2) {
            kotlin.jvm.internal.h.b(collection, IR.path.DOCS_IMSDK_CHANNEL);
            kotlin.jvm.internal.h.b(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.h.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.h.a(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.h.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
