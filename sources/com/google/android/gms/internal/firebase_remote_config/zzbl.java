package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzbl<K, V> extends AbstractMap<K, V> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    int f4131a;
    private Object[] b;

    /* loaded from: classes2.dex */
    final class b extends AbstractSet<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return zzbl.this.f4131a;
        }
    }

    /* loaded from: classes2.dex */
    final class c implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4134a;
        private int b;

        c() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b < zzbl.this.f4131a;
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i = this.b - 1;
            if (this.f4134a || i < 0) {
                throw new IllegalArgumentException();
            }
            zzbl.this.remove(i);
            this.b--;
            this.f4134a = true;
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            int i = this.b;
            if (i == zzbl.this.f4131a) {
                throw new NoSuchElementException();
            }
            this.b++;
            this.f4134a = false;
            return new a(i);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f4131a;
    }

    /* loaded from: classes2.dex */
    final class a implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private int f4132a;

        a(int i) {
            this.f4132a = i;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return (K) zzbl.this.zzf(this.f4132a);
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return (V) zzbl.this.zzg(this.f4132a);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            return (V) zzbl.this.set(this.f4132a, v);
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object key = getKey();
            Object value = getValue();
            return (key != null ? key.hashCode() : 0) ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = getKey();
            Object key2 = entry.getKey();
            if (key == key2 || (key != null && key.equals(key2))) {
                Object value = getValue();
                Object value2 = entry.getValue();
                if (value == value2 || (value != null && value.equals(value2))) {
                    return true;
                }
            }
            return false;
        }
    }

    public final K zzf(int i) {
        if (i < 0 || i >= this.f4131a) {
            return null;
        }
        return (K) this.b[i << 1];
    }

    public final V zzg(int i) {
        if (i < 0 || i >= this.f4131a) {
            return null;
        }
        return a((i << 1) + 1);
    }

    public final V set(int i, V v) {
        int i2 = this.f4131a;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = (i << 1) + 1;
        V a2 = a(i3);
        this.b[i3] = v;
        return a2;
    }

    public final V remove(int i) {
        return b(i << 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return -2 != a(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        return a(a(obj) + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int a2 = a(k) >> 1;
        if (a2 == -1) {
            a2 = this.f4131a;
        }
        if (a2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i = a2 + 1;
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] objArr = this.b;
        int i2 = i << 1;
        int length = objArr == null ? 0 : objArr.length;
        if (i2 > length) {
            int i3 = ((length / 2) * 3) + 1;
            if (i3 % 2 != 0) {
                i3++;
            }
            if (i3 < i2) {
                i3 = i2;
            }
            if (i3 == 0) {
                this.b = null;
            } else {
                int i4 = this.f4131a;
                Object[] objArr2 = this.b;
                if (i4 == 0 || i3 != objArr2.length) {
                    Object[] objArr3 = new Object[i3];
                    this.b = objArr3;
                    if (i4 != 0) {
                        System.arraycopy(objArr2, 0, objArr3, 0, i4 << 1);
                    }
                }
            }
        }
        int i5 = a2 << 1;
        V a3 = a(i5 + 1);
        a(i5, k, v);
        if (i > this.f4131a) {
            this.f4131a = i;
        }
        return a3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        return b(a(obj));
    }

    private final void a(int i, K k, V v) {
        Object[] objArr = this.b;
        objArr[i] = k;
        objArr[i + 1] = v;
    }

    private final V a(int i) {
        if (i < 0) {
            return null;
        }
        return (V) this.b[i];
    }

    private final int a(Object obj) {
        int i = this.f4131a << 1;
        Object[] objArr = this.b;
        for (int i2 = 0; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return i2;
                }
            } else {
                if (obj.equals(obj2)) {
                    return i2;
                }
            }
        }
        return -2;
    }

    private final V b(int i) {
        int i2 = this.f4131a << 1;
        if (i < 0 || i >= i2) {
            return null;
        }
        V a2 = a(i + 1);
        Object[] objArr = this.b;
        int i3 = (i2 - i) - 2;
        if (i3 != 0) {
            System.arraycopy(objArr, i + 2, objArr, i, i3);
        }
        this.f4131a--;
        a(i2 - 2, null, null);
        return a2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f4131a = 0;
        this.b = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        int i = this.f4131a << 1;
        Object[] objArr = this.b;
        for (int i2 = 1; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else {
                if (obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.AbstractMap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbl<K, V> clone() {
        try {
            zzbl<K, V> zzblVar = (zzbl) super.clone();
            Object[] objArr = this.b;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                zzblVar.b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return zzblVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
