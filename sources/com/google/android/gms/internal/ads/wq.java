package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
final class wq extends zzatl {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbsv f2593a;
    private final /* synthetic */ zzbri b;
    private final /* synthetic */ zzbse c;
    private final /* synthetic */ zzbvj d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public wq(zzcnw zzcnwVar, zzbsv zzbsvVar, zzbri zzbriVar, zzbse zzbseVar, zzbvj zzbvjVar) {
        this.f2593a = zzbsvVar;
        this.b = zzbriVar;
        this.c = zzbseVar;
        this.d = zzbvjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzae(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzag(IObjectWrapper iObjectWrapper) {
        this.f2593a.zzta();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.f2593a.zzsz();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.b.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.c.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zza(IObjectWrapper iObjectWrapper, zzato zzatoVar) {
        this.d.zza(zzatoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.d.zzrq();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.c.onRewardedVideoCompleted();
    }
}
