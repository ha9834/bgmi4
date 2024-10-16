package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzanp extends zzamw {

    /* renamed from: a, reason: collision with root package name */
    private final Adapter f2765a;
    private final zzatk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanp(Adapter adapter, zzatk zzatkVar) {
        this.f2765a = adapter;
        this.b = zzatkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdImpression() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLeftApplication() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoEnd() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPlay() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzafe zzafeVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzamy zzamyVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(zzato zzatoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzcs(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzcz(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLoaded() throws RemoteException {
        zzatk zzatkVar = this.b;
        if (zzatkVar != null) {
            zzatkVar.zzaf(ObjectWrapper.wrap(this.f2765a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdOpened() throws RemoteException {
        zzatk zzatkVar = this.b;
        if (zzatkVar != null) {
            zzatkVar.zzag(ObjectWrapper.wrap(this.f2765a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClosed() throws RemoteException {
        zzatk zzatkVar = this.b;
        if (zzatkVar != null) {
            zzatkVar.zzai(ObjectWrapper.wrap(this.f2765a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzatq zzatqVar) throws RemoteException {
        zzatk zzatkVar = this.b;
        if (zzatkVar != null) {
            zzatkVar.zza(ObjectWrapper.wrap(this.f2765a), new zzato(zzatqVar.getType(), zzatqVar.getAmount()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzsm() throws RemoteException {
        zzatk zzatkVar = this.b;
        if (zzatkVar != null) {
            zzatkVar.zzah(ObjectWrapper.wrap(this.f2765a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzsn() throws RemoteException {
        zzatk zzatkVar = this.b;
        if (zzatkVar != null) {
            zzatkVar.zzal(ObjectWrapper.wrap(this.f2765a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClicked() throws RemoteException {
        zzatk zzatkVar = this.b;
        if (zzatkVar != null) {
            zzatkVar.zzaj(ObjectWrapper.wrap(this.f2765a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdFailedToLoad(int i) throws RemoteException {
        zzatk zzatkVar = this.b;
        if (zzatkVar != null) {
            zzatkVar.zze(ObjectWrapper.wrap(this.f2765a), i);
        }
    }
}
