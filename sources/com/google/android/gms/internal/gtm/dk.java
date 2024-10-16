package com.google.android.gms.internal.gtm;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* loaded from: classes2.dex */
public final class dk<K, V> implements Comparable<dk>, Map.Entry<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final Comparable f4348a;
    private V b;
    private final /* synthetic */ dd c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dd ddVar, Map.Entry<K, V> entry) {
        this(ddVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public dk(dd ddVar, K k, V v) {
        this.c = ddVar;
        this.f4348a = k;
        this.b = v;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.c.f();
        V v2 = this.b;
        this.b = v;
        return v2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.f4348a, entry.getKey()) && a(this.b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f4348a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f4348a);
        String valueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f4348a;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(dk dkVar) {
        return ((Comparable) getKey()).compareTo((Comparable) dkVar.getKey());
    }
}
