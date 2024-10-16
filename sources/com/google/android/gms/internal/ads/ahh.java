package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* loaded from: classes2.dex */
public final class ahh<K, V> implements Comparable<ahh>, Map.Entry<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final Comparable f1877a;
    private V b;
    private final /* synthetic */ aha c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahh(aha ahaVar, Map.Entry<K, V> entry) {
        this(ahaVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ahh(aha ahaVar, K k, V v) {
        this.c = ahaVar;
        this.f1877a = k;
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
        return a(this.f1877a, entry.getKey()) && a(this.b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f1877a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f1877a);
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
        return this.f1877a;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ahh ahhVar) {
        return ((Comparable) getKey()).compareTo((Comparable) ahhVar.getKey());
    }
}
