package androidx.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    c<K, V> f107a;
    private c<K, V> b;
    private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap<>();
    private int d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a_(c<K, V> cVar);
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.f107a;
        while (cVar != null && !cVar.f108a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public V a(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.b;
        }
        b(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.d++;
        c<K, V> cVar2 = this.b;
        if (cVar2 == null) {
            this.f107a = cVar;
            this.b = this.f107a;
            return cVar;
        }
        cVar2.c = cVar;
        cVar.d = cVar2;
        this.b = cVar;
        return cVar;
    }

    public V b(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            Iterator<f<K, V>> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a_(a2);
            }
        }
        if (a2.d != null) {
            a2.d.c = a2.c;
        } else {
            this.f107a = a2.c;
        }
        if (a2.c != null) {
            a2.c.d = a2.d;
        } else {
            this.b = a2.d;
        }
        a2.c = null;
        a2.d = null;
        return a2.b;
    }

    public int a() {
        return this.d;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f107a, this.b);
        this.c.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0020b c0020b = new C0020b(this.b, this.f107a);
        this.c.put(c0020b, false);
        return c0020b;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f107a;
    }

    public Map.Entry<K, V> e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != bVar.a()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        c<K, V> f110a;
        c<K, V> b;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f110a = cVar2;
            this.b = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // androidx.a.a.b.b.f
        public void a_(c<K, V> cVar) {
            if (this.f110a == cVar && cVar == this.b) {
                this.b = null;
                this.f110a = null;
            }
            c<K, V> cVar2 = this.f110a;
            if (cVar2 == cVar) {
                this.f110a = b(cVar2);
            }
            if (this.b == cVar) {
                this.b = b();
            }
        }

        private c<K, V> b() {
            c<K, V> cVar = this.b;
            c<K, V> cVar2 = this.f110a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return a(cVar);
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.b;
            this.b = b();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.c;
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* renamed from: androidx.a.a.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0020b<K, V> extends e<K, V> {
        C0020b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.d;
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> b;
        private boolean c = true;

        d() {
        }

        @Override // androidx.a.a.b.b.f
        public void a_(c<K, V> cVar) {
            c<K, V> cVar2 = this.b;
            if (cVar == cVar2) {
                this.b = cVar2.d;
                this.c = this.b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c) {
                return b.this.f107a != null;
            }
            c<K, V> cVar = this.b;
            return (cVar == null || cVar.c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.c) {
                this.c = false;
                this.b = b.this.f107a;
            } else {
                c<K, V> cVar = this.b;
                this.b = cVar != null ? cVar.c : null;
            }
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f108a;
        final V b;
        c<K, V> c;
        c<K, V> d;

        c(K k, V v) {
            this.f108a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f108a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f108a + "=" + this.b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f108a.equals(cVar.f108a) && this.b.equals(cVar.b);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f108a.hashCode() ^ this.b.hashCode();
        }
    }
}
