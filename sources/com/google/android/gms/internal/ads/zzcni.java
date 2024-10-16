package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzcni extends zzcoj {

    /* renamed from: a, reason: collision with root package name */
    private zzbvj f3336a;
    private zzbrp b;

    public zzcni(zzbri zzbriVar, zzbrt zzbrtVar, zzbse zzbseVar, zzbso zzbsoVar, zzbrp zzbrpVar, zzbtp zzbtpVar, zzbvq zzbvqVar, zzbsv zzbsvVar, zzbvj zzbvjVar) {
        super(zzbriVar, zzbrtVar, zzbseVar, zzbsoVar, zzbtpVar, zzbsvVar, zzbvqVar);
        this.f3336a = zzbvjVar;
        this.b = zzbrpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void zzsm() {
        this.f3336a.zzrq();
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void zzcs(int i) throws RemoteException {
        this.b.zzcs(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void zzsn() throws RemoteException {
        this.f3336a.zzrr();
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void zza(zzatq zzatqVar) throws RemoteException {
        this.f3336a.zza(new zzato(zzatqVar.getType(), zzatqVar.getAmount()));
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void zzb(zzato zzatoVar) {
        this.f3336a.zza(zzatoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void onVideoEnd() {
        this.f3336a.zzrr();
    }
}
