package com.google.android.gms.internal.firebase_remote_config;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* loaded from: classes2.dex */
public final class dw<K, V> implements Comparable<dw>, Map.Entry<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final Comparable f4084a;
    private V b;
    private final /* synthetic */ dn c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(dn dnVar, Map.Entry<K, V> entry) {
        this(dnVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public dw(dn dnVar, K k, V v) {
        this.c = dnVar;
        this.f4084a = k;
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
        return a(this.f4084a, entry.getKey()) && a(this.b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f4084a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f4084a);
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
        return this.f4084a;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(dw dwVar) {
        return ((Comparable) getKey()).compareTo((Comparable) dwVar.getKey());
    }
}
