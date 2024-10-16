package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* loaded from: classes2.dex */
public final class zzto {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f3745a;
    private final zztn b;

    public zzto(Handler handler, zztn zztnVar) {
        this.f3745a = zztnVar != null ? (Handler) zzsk.checkNotNull(handler) : null;
        this.b = zztnVar;
    }

    public final void zzc(zznc zzncVar) {
        if (this.b != null) {
            this.f3745a.post(new aoc(this, zzncVar));
        }
    }

    public final void zzc(String str, long j, long j2) {
        if (this.b != null) {
            this.f3745a.post(new aod(this, str, j, j2));
        }
    }

    public final void zzc(zzlh zzlhVar) {
        if (this.b != null) {
            this.f3745a.post(new aoe(this, zzlhVar));
        }
    }

    public final void zzg(int i, long j) {
        if (this.b != null) {
            this.f3745a.post(new aof(this, i, j));
        }
    }

    public final void zzb(int i, int i2, int i3, float f) {
        if (this.b != null) {
            this.f3745a.post(new aog(this, i, i2, i3, f));
        }
    }

    public final void zzc(Surface surface) {
        if (this.b != null) {
            this.f3745a.post(new aoh(this, surface));
        }
    }

    public final void zzd(zznc zzncVar) {
        if (this.b != null) {
            this.f3745a.post(new aoi(this, zzncVar));
        }
    }
}
