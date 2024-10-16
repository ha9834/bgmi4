package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzgc<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzgc f4566a;
    private boolean zzacz;

    private zzgc() {
        this.zzacz = true;
    }

    private zzgc(Map<K, V> map) {
        super(map);
        this.zzacz = true;
    }

    public static <K, V> zzgc<K, V> zzvl() {
        return f4566a;
    }

    public final void zza(zzgc<K, V> zzgcVar) {
        a();
        if (zzgcVar.isEmpty()) {
            return;
        }
        putAll(zzgcVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        a();
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        a();
        zzez.a(k);
        zzez.a(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        a();
        for (K k : map.keySet()) {
            zzez.a(k);
            zzez.a(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        a();
        return (V) super.remove(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005e A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5f
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L5b
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L16
            r7 = 0
            goto L5c
        L16:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L5b
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L36
            r7 = 0
            goto L5c
        L36:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L53
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L53
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L57
        L53:
            boolean r3 = r4.equals(r3)
        L57:
            if (r3 != 0) goto L1e
            r7 = 0
            goto L5c
        L5b:
            r7 = 1
        L5c:
            if (r7 == 0) goto L5f
            return r0
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgc.equals(java.lang.Object):boolean");
    }

    private static int a(Object obj) {
        if (obj instanceof byte[]) {
            return zzez.hashCode((byte[]) obj);
        }
        if (obj instanceof zzfc) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += a(entry.getValue()) ^ a(entry.getKey());
        }
        return i;
    }

    public final zzgc<K, V> zzvm() {
        return isEmpty() ? new zzgc<>() : new zzgc<>(this);
    }

    public final void zzry() {
        this.zzacz = false;
    }

    public final boolean isMutable() {
        return this.zzacz;
    }

    private final void a() {
        if (!this.zzacz) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzgc zzgcVar = new zzgc();
        f4566a = zzgcVar;
        zzgcVar.zzacz = false;
    }
}
