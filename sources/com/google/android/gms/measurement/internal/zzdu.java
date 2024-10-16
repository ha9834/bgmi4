package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzdu<V> {
    private static final Object f = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final String f4927a;
    private final cp<V> b;
    private final V c;
    private final V d;
    private final Object e;
    private volatile V g;
    private volatile V h;

    private zzdu(String str, V v, V v2, cp<V> cpVar) {
        this.e = new Object();
        this.g = null;
        this.h = null;
        this.f4927a = str;
        this.c = v;
        this.d = v2;
        this.b = cpVar;
    }

    public final String getKey() {
        return this.f4927a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final V get(V v) {
        synchronized (this.e) {
            V v2 = this.g;
        }
        if (v != null) {
            return v;
        }
        if (zzak.f4926a == null) {
            return this.c;
        }
        zzr zzrVar = zzak.f4926a;
        synchronized (f) {
            if (zzr.isMainThread()) {
                return this.h == null ? this.c : this.h;
            }
            if (zzr.isMainThread()) {
                throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
            }
            zzr zzrVar2 = zzak.f4926a;
            try {
                for (zzdu zzduVar : zzak.aH()) {
                    synchronized (f) {
                        if (zzr.isMainThread()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        zzduVar.h = zzduVar.b != null ? zzduVar.b.a() : null;
                    }
                }
            } catch (SecurityException e) {
                zzak.a(e);
            }
            cp<V> cpVar = this.b;
            if (cpVar == null) {
                zzr zzrVar3 = zzak.f4926a;
                return this.c;
            }
            try {
                return cpVar.a();
            } catch (SecurityException e2) {
                zzak.a(e2);
                zzr zzrVar4 = zzak.f4926a;
                return this.c;
            }
        }
    }
}
