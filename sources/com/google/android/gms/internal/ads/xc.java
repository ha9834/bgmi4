package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

/* loaded from: classes2.dex */
final class xc implements zzf {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbvy f2604a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xc(zzcpa zzcpaVar, zzbvy zzbvyVar) {
        this.f2604a = zzbvyVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzg(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzky() {
        this.f2604a.zzadf().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzkz() {
        this.f2604a.zzadg().onAdImpression();
        this.f2604a.zzadh().zzagx();
    }
}
