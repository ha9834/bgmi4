package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6750a;

    private MapFieldLite() {
        this.f6750a = true;
    }

    private MapFieldLite(Map<K, V> map) {
        super(map);
        this.f6750a = true;
    }

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        b = mapFieldLite;
        mapFieldLite.f6750a = false;
    }

    public static <K, V> MapFieldLite<K, V> a() {
        return b;
    }

    public final void a(MapFieldLite<K, V> mapFieldLite) {
        if (!this.f6750a) {
            throw new UnsupportedOperationException();
        }
        if (mapFieldLite.isEmpty()) {
            return;
        }
        putAll(mapFieldLite);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (!this.f6750a) {
            throw new UnsupportedOperationException();
        }
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        if (!this.f6750a) {
            throw new UnsupportedOperationException();
        }
        Internal.a(k);
        Internal.a(v);
        return (V) super.put(k, v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        if (!this.f6750a) {
            throw new UnsupportedOperationException();
        }
        for (K k : map.keySet()) {
            Internal.a(k);
            Internal.a(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        if (!this.f6750a) {
            throw new UnsupportedOperationException();
        }
        return (V) super.remove(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean a(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            V v = map2.get(entry.getKey());
            if (!(((value instanceof byte[]) && (v instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) v) : value.equals(v))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return (obj instanceof Map) && a(this, (Map) obj);
    }

    private static int a(Object obj) {
        if (obj instanceof byte[]) {
            return Internal.c((byte[]) obj);
        }
        if (obj instanceof Internal.EnumLite) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(Map<K, V> map) {
        int i = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i += a(entry.getValue()) ^ a(entry.getKey());
        }
        return i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return a((Map) this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> b(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                value = (V) Arrays.copyOf(bArr, bArr.length);
            }
            linkedHashMap.put(key, value);
        }
        return linkedHashMap;
    }

    public final MapFieldLite<K, V> b() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    public final void c() {
        this.f6750a = false;
    }

    public final boolean d() {
        return this.f6750a;
    }
}
