package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzabr extends zzaac {

    /* renamed from: a, reason: collision with root package name */
    private zzait f2691a;

    @Override // com.google.android.gms.internal.ads.zzaab
    public final String getVersionString() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void setAppMuted(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void setAppVolume(float f) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zza(zzamp zzampVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzbu(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzbv(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzc(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final float zzpq() throws RemoteException {
        return 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final boolean zzpr() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zza() throws RemoteException {
        zzbad.zzen("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzazt.zzyr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.h

            /* renamed from: a, reason: collision with root package name */
            private final zzabr f2206a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2206a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2206a.a();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zza(zzait zzaitVar) throws RemoteException {
        this.f2691a = zzaitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final List<zzaio> zzps() throws RemoteException {
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        zzait zzaitVar = this.f2691a;
        if (zzaitVar != null) {
            try {
                zzaitVar.zzc(Collections.EMPTY_LIST);
            } catch (RemoteException e) {
                zzbad.zzd("Could not notify onComplete event.", e);
            }
        }
    }
}
