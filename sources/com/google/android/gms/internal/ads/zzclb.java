package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzclb extends zzatl implements zzbsm {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzatk f3305a;

    @GuardedBy("this")
    private zzbsn b;

    @GuardedBy("this")
    private zzbvo c;

    public final synchronized void zza(zzatk zzatkVar) {
        this.f3305a = zzatkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final synchronized void zza(zzbsn zzbsnVar) {
        this.b = zzbsnVar;
    }

    public final synchronized void zza(zzbvo zzbvoVar) {
        this.c = zzbvoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzae(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzae(iObjectWrapper);
        }
        if (this.c != null) {
            this.c.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzd(iObjectWrapper, i);
        }
        if (this.c != null) {
            this.c.zzdl(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzah(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzah(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzato zzatoVar) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zza(iObjectWrapper, zzatoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzaj(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzai(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zze(iObjectWrapper, i);
        }
        if (this.b != null) {
            this.b.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzak(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzal(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzag(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzaf(iObjectWrapper);
        }
        if (this.b != null) {
            this.b.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.f3305a != null) {
            this.f3305a.zzb(bundle);
        }
    }
}
