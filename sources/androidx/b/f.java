package androidx.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f<K, V> {
    f<K, V>.b b;
    f<K, V>.c c;
    f<K, V>.e d;

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    protected abstract void c();

    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f380a;
        int b;
        int c;
        boolean d = false;

        a(int i) {
            this.f380a = i;
            this.b = f.this.a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) f.this.a(this.c, this.f380a);
            this.c++;
            this.d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            this.c--;
            this.b--;
            this.d = false;
            f.this.a(this.c);
        }
    }

    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        int f383a;
        boolean c = false;
        int b = -1;

        d() {
            this.f383a = f.this.a() - 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.f383a;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.b++;
            this.c = true;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.c) {
                throw new IllegalStateException();
            }
            f.this.a(this.b);
            this.b--;
            this.f383a--;
            this.c = false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) f.this.a(this.b, 0);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) f.this.a(this.b, 1);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) f.this.a(this.b, (int) v);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return androidx.b.c.a(entry.getKey(), f.this.a(this.b, 0)) && androidx.b.c.a(entry.getValue(), f.this.a(this.b, 1));
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object a2 = f.this.a(this.b, 0);
            Object a3 = f.this.a(this.b, 1);
            return (a2 == null ? 0 : a2.hashCode()) ^ (a3 != null ? a3.hashCode() : 0);
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a2 = f.this.a();
            for (Map.Entry<K, V> entry : collection) {
                f.this.a((f) entry.getKey(), (K) entry.getValue());
            }
            return a2 != f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a2 = f.this.a(entry.getKey());
            if (a2 < 0) {
                return false;
            }
            return androidx.b.c.a(f.this.a(a2, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int a2 = f.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = f.this.a(a2, 0);
                Object a4 = f.this.a(a2, 1);
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a4 == null ? 0 : a4.hashCode());
            }
            return i;
        }
    }

    /* loaded from: classes.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return f.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return f.a((Map) f.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int a2 = f.this.a(obj);
            if (a2 < 0) {
                return false;
            }
            f.this.a(a2);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return f.b(f.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return f.c(f.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return f.this.b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.a(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int a2 = f.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = f.this.a(a2, 0);
                i += a3 == null ? 0 : a3.hashCode();
            }
            return i;
        }
    }

    /* loaded from: classes.dex */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            f.this.c();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return f.this.b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int b = f.this.b(obj);
            if (b < 0) {
                return false;
            }
            f.this.a(b);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int a2 = f.this.a();
            int i = 0;
            boolean z = false;
            while (i < a2) {
                if (collection.contains(f.this.a(i, 1))) {
                    f.this.a(i);
                    i--;
                    a2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int a2 = f.this.a();
            int i = 0;
            boolean z = false;
            while (i < a2) {
                if (!collection.contains(f.this.a(i, 1))) {
                    f.this.a(i);
                    i--;
                    a2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return f.this.a();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return f.this.b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] b(int i) {
        int a2 = a();
        Object[] objArr = new Object[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public <T> T[] a(T[] tArr, int i) {
        int a2 = a();
        if (tArr.length < a2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), a2));
        }
        for (int i2 = 0; i2 < a2; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > a2) {
            tArr[a2] = null;
        }
        return tArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
                if (set.containsAll(set2)) {
                    return true;
                }
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused2) {
            return false;
        }
    }

    public Set<Map.Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new b();
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new c();
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new e();
        }
        return this.d;
    }
}
