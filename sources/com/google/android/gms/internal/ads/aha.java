package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aha<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final int f1873a;
    private List<ahh> b;
    private Map<K, V> c;
    private boolean d;
    private volatile ahj e;
    private Map<K, V> f;
    private volatile ahd g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzdnu<FieldDescriptorType>> aha<FieldDescriptorType, Object> a(int i) {
        return new ahb(i);
    }

    private aha(int i) {
        this.f1873a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.d) {
            return;
        }
        if (this.c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.c);
        }
        this.c = unmodifiableMap;
        if (this.f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f);
        }
        this.f = unmodifiableMap2;
        this.d = true;
    }

    public final boolean b() {
        return this.d;
    }

    public final int c() {
        return this.b.size();
    }

    public final Map.Entry<K, V> b(int i) {
        return this.b.get(i);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        if (this.c.isEmpty()) {
            return ahe.a();
        }
        return this.c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b.size() + this.c.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((aha<K, V>) comparable) >= 0 || this.c.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((aha<K, V>) comparable);
        if (a2 >= 0) {
            return (V) this.b.get(a2).getValue();
        }
        return this.c.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        f();
        int a2 = a((aha<K, V>) k);
        if (a2 >= 0) {
            return (V) this.b.get(a2).setValue(v);
        }
        f();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.f1873a);
        }
        int i = -(a2 + 1);
        if (i >= this.f1873a) {
            return g().put(k, v);
        }
        int size = this.b.size();
        int i2 = this.f1873a;
        if (size == i2) {
            ahh remove = this.b.remove(i2 - 1);
            g().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.b.add(i, new ahh(this, k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((aha<K, V>) comparable);
        if (a2 >= 0) {
            return (V) c(a2);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V c(int i) {
        f();
        V v = (V) this.b.remove(i).getValue();
        if (!this.c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.b.add(new ahh(this, it.next()));
            it.remove();
        }
        return v;
    }

    private final int a(K k) {
        int size = this.b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.b.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new ahj(this, null);
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> e() {
        if (this.g == null) {
            this.g = new ahd(this, null);
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
            this.f = ((TreeMap) this.c).descendingMap();
        }
        return (SortedMap) this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aha)) {
            return super.equals(obj);
        }
        aha ahaVar = (aha) obj;
        int size = size();
        if (size != ahaVar.size()) {
            return false;
        }
        int c = c();
        if (c != ahaVar.c()) {
            return entrySet().equals(ahaVar.entrySet());
        }
        for (int i = 0; i < c; i++) {
            if (!b(i).equals(ahaVar.b(i))) {
                return false;
            }
        }
        if (c != size) {
            return this.c.equals(ahaVar.c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int c = c();
        int i = 0;
        for (int i2 = 0; i2 < c; i2++) {
            i += this.b.get(i2).hashCode();
        }
        return this.c.size() > 0 ? i + this.c.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((aha<K, V>) obj, (Comparable) obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aha(int i, ahb ahbVar) {
        this(i);
    }
}
