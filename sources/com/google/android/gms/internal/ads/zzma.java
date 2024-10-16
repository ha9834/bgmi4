package com.google.android.gms.internal.ads;

import android.os.Handler;

/* loaded from: classes2.dex */
public final class zzma {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f3683a;
    private final zzlz b;

    public zzma(Handler handler, zzlz zzlzVar) {
        this.f3683a = zzlzVar != null ? (Handler) zzsk.checkNotNull(handler) : null;
        this.b = zzlzVar;
    }

    public final void zzc(zznc zzncVar) {
        if (this.b != null) {
            this.f3683a.post(new alb(this, zzncVar));
        }
    }

    public final void zzc(String str, long j, long j2) {
        if (this.b != null) {
            this.f3683a.post(new alc(this, str, j, j2));
        }
    }

    public final void zzc(zzlh zzlhVar) {
        if (this.b != null) {
            this.f3683a.post(new ald(this, zzlhVar));
        }
    }

    public final void zzd(int i, long j, long j2) {
        if (this.b != null) {
            this.f3683a.post(new ale(this, i, j, j2));
        }
    }

    public final void zzd(zznc zzncVar) {
        if (this.b != null) {
            this.f3683a.post(new alf(this, zzncVar));
        }
    }

    public final void zzah(int i) {
        if (this.b != null) {
            this.f3683a.post(new alg(this, i));
        }
    }
}
