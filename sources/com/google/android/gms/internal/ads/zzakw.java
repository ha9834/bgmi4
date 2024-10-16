package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzakw extends zzbbw<zzalf> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2746a = new Object();
    private final zzala b;
    private boolean c;

    public zzakw(zzala zzalaVar) {
        this.b = zzalaVar;
    }

    public final void release() {
        synchronized (this.f2746a) {
            if (this.c) {
                return;
            }
            this.c = true;
            zza(new bv(this), new zzbbu());
            zza(new bw(this), new bx(this));
        }
    }
}
