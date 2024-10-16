package com.google.android.gms.internal.games;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class zzej {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<zzeh> f4286a = new AtomicReference<>();

    protected abstract zzeh a();

    public final void flush() {
        zzeh zzehVar = this.f4286a.get();
        if (zzehVar != null) {
            zzehVar.flush();
        }
    }

    public final void zza(String str, int i) {
        zzeh zzehVar = this.f4286a.get();
        if (zzehVar == null) {
            zzehVar = a();
            if (!this.f4286a.compareAndSet(null, zzehVar)) {
                zzehVar = this.f4286a.get();
            }
        }
        zzehVar.zzg(str, i);
    }
}
