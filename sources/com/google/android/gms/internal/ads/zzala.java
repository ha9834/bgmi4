package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzala extends zzbbw<zzajw> {
    private zzayp<zzajw> b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f2748a = new Object();
    private boolean c = false;
    private int d = 0;

    public zzala(zzayp<zzajw> zzaypVar) {
        this.b = zzaypVar;
    }

    public final zzakw zzrx() {
        zzakw zzakwVar = new zzakw(this);
        synchronized (this.f2748a) {
            zza(new by(this, zzakwVar), new bz(this, zzakwVar));
            Preconditions.checkState(this.d >= 0);
            this.d++;
        }
        return zzakwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        synchronized (this.f2748a) {
            Preconditions.checkState(this.d > 0);
            zzawz.zzds("Releasing 1 reference for JS Engine");
            this.d--;
            b();
        }
    }

    public final void zzrz() {
        synchronized (this.f2748a) {
            Preconditions.checkState(this.d >= 0);
            zzawz.zzds("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.c = true;
            b();
        }
    }

    private final void b() {
        synchronized (this.f2748a) {
            Preconditions.checkState(this.d >= 0);
            if (this.c && this.d == 0) {
                zzawz.zzds("No reference is left (including root). Cleaning up engine.");
                zza(new ca(this), new zzbbu());
            } else {
                zzawz.zzds("There are still references to the engine. Not destroying.");
            }
        }
    }
}
