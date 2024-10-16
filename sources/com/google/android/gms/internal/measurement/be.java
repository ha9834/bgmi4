package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class be<T> implements zzdb<T> {

    /* renamed from: a, reason: collision with root package name */
    private volatile zzdb<T> f4483a;
    private volatile boolean b;

    @NullableDecl
    private T c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(zzdb<T> zzdbVar) {
        this.f4483a = (zzdb) zzcz.checkNotNull(zzdbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final T get() {
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    T t = this.f4483a.get();
                    this.c = t;
                    this.b = true;
                    this.f4483a = null;
                    return t;
                }
            }
        }
        return this.c;
    }

    public final String toString() {
        Object obj = this.f4483a;
        if (obj == null) {
            String valueOf = String.valueOf(this.c);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
