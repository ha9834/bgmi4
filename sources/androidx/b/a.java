package androidx.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: a, reason: collision with root package name */
    f<K, V> f374a;

    public a() {
    }

    public a(int i) {
        super(i);
    }

    public a(g gVar) {
        super(gVar);
    }

    private f<K, V> b() {
        if (this.f374a == null) {
            this.f374a = new f<K, V>() { // from class: androidx.b.a.1
                @Override // androidx.b.f
                protected int a() {
                    return a.this.h;
                }

                @Override // androidx.b.f
                protected Object a(int i, int i2) {
                    return a.this.g[(i << 1) + i2];
                }

                @Override // androidx.b.f
                protected int a(Object obj) {
                    return a.this.a(obj);
                }

                @Override // androidx.b.f
                protected int b(Object obj) {
                    return a.this.b(obj);
                }

                @Override // androidx.b.f
                protected Map<K, V> b() {
                    return a.this;
                }

                @Override // androidx.b.f
                protected void a(K k, V v) {
                    a.this.put(k, v);
                }

                @Override // androidx.b.f
                protected V a(int i, V v) {
                    return a.this.a(i, (int) v);
                }

                @Override // androidx.b.f
                protected void a(int i) {
                    a.this.d(i);
                }

                @Override // androidx.b.f
                protected void c() {
                    a.this.clear();
                }
            };
        }
        return this.f374a;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean a(Collection<?> collection) {
        return f.c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }
}
