package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzqh implements zzql, zzqm {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f3711a;
    private final zzrw b;
    private final zznq c;
    private final Handler e;
    private final zzqi f;
    private final int i;
    private zzqm j;
    private zzlr k;
    private boolean l;
    private final int d = -1;
    private final String h = null;
    private final zzlt g = new zzlt();

    public zzqh(Uri uri, zzrw zzrwVar, zznq zznqVar, int i, Handler handler, zzqi zzqiVar, String str, int i2) {
        this.f3711a = uri;
        this.b = zzrwVar;
        this.c = zznqVar;
        this.e = handler;
        this.f = zzqiVar;
        this.i = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zzjf() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zza(zzkv zzkvVar, boolean z, zzqm zzqmVar) {
        this.j = zzqmVar;
        this.k = new zzqz(-9223372036854775807L, false);
        zzqmVar.zzb(this.k, null);
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final zzqj zza(int i, zzrt zzrtVar) {
        zzsk.checkArgument(i == 0);
        return new ane(this.f3711a, this.b.zzju(), this.c.zzih(), this.d, this.e, this.f, this, zzrtVar, null, this.i);
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zzb(zzqj zzqjVar) {
        ((ane) zzqjVar).a();
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zzjg() {
        this.j = null;
    }

    @Override // com.google.android.gms.internal.ads.zzqm
    public final void zzb(zzlr zzlrVar, Object obj) {
        boolean z = zzlrVar.zza(0, this.g, false).zzack != -9223372036854775807L;
        if (!this.l || z) {
            this.k = zzlrVar;
            this.l = z;
            this.j.zzb(this.k, null);
        }
    }
}
