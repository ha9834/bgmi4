package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class zzdd<T> implements zzdb<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private volatile transient boolean f4550a;

    @NullableDecl
    private transient T b;
    private final zzdb<T> zzabs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdd(zzdb<T> zzdbVar) {
        this.zzabs = (zzdb) zzcz.checkNotNull(zzdbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final T get() {
        if (!this.f4550a) {
            synchronized (this) {
                if (!this.f4550a) {
                    T t = this.zzabs.get();
                    this.b = t;
                    this.f4550a = true;
                    return t;
                }
            }
        }
        return this.b;
    }

    public final String toString() {
        Object obj;
        if (this.f4550a) {
            String valueOf = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.zzabs;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
