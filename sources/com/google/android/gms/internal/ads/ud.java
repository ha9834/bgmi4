package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes2.dex */
final class ud implements zzban<ParcelFileDescriptor> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzarr f2537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ud(zzcig zzcigVar, zzarr zzarrVar) {
        this.f2537a = zzarrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        try {
            this.f2537a.zza(zzaym.zza(th, zzcgm.zze(th)));
        } catch (RemoteException e) {
            zzawz.zza("Service can't call client", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.f2537a.zzb(parcelFileDescriptor);
        } catch (RemoteException e) {
            zzawz.zza("Service can't call client", e);
        }
    }
}
