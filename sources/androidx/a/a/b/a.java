package androidx.a.a.b;

import androidx.a.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> b = new HashMap<>();

    @Override // androidx.a.a.b.b
    protected b.c<K, V> a(K k) {
        return this.b.get(k);
    }

    @Override // androidx.a.a.b.b
    public V a(K k, V v) {
        b.c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.b;
        }
        this.b.put(k, b(k, v));
        return null;
    }

    @Override // androidx.a.a.b.b
    public V b(K k) {
        V v = (V) super.b(k);
        this.b.remove(k);
        return v;
    }

    public boolean c(K k) {
        return this.b.containsKey(k);
    }

    public Map.Entry<K, V> d(K k) {
        if (c(k)) {
            return this.b.get(k).d;
        }
        return null;
    }
}
