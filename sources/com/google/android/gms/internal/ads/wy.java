package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

/* loaded from: classes2.dex */
final class wy implements zzf {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbr f2600a;
    private final /* synthetic */ zzcxu b;
    private final /* synthetic */ zzcxm c;
    private final /* synthetic */ zzcoz d;
    private final /* synthetic */ zzcor e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public wy(zzcor zzcorVar, zzbbr zzbbrVar, zzcxu zzcxuVar, zzcxm zzcxmVar, zzcoz zzcozVar) {
        this.e = zzcorVar;
        this.f2600a = zzbbrVar;
        this.b = zzcxuVar;
        this.c = zzcxmVar;
        this.d = zzcozVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzky() {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzkz() {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzg(View view) {
        zzcou zzcouVar;
        zzbbr zzbbrVar = this.f2600a;
        zzcouVar = this.e.d;
        zzbbrVar.set(zzcouVar.zza(this.b, this.c, view, this.d));
    }
}
