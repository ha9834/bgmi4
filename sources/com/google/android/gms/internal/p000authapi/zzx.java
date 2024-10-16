package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* loaded from: classes2.dex */
public final class zzx extends zzc implements zzw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zzw
    public final void zzc(zzu zzuVar, CredentialRequest credentialRequest) throws RemoteException {
        Parcel a2 = a();
        zze.zzc(a2, zzuVar);
        zze.zzc(a2, credentialRequest);
        a(1, a2);
    }

    @Override // com.google.android.gms.internal.p000authapi.zzw
    public final void zzc(zzu zzuVar, zzy zzyVar) throws RemoteException {
        Parcel a2 = a();
        zze.zzc(a2, zzuVar);
        zze.zzc(a2, zzyVar);
        a(2, a2);
    }

    @Override // com.google.android.gms.internal.p000authapi.zzw
    public final void zzc(zzu zzuVar, zzs zzsVar) throws RemoteException {
        Parcel a2 = a();
        zze.zzc(a2, zzuVar);
        zze.zzc(a2, zzsVar);
        a(3, a2);
    }

    @Override // com.google.android.gms.internal.p000authapi.zzw
    public final void zzc(zzu zzuVar) throws RemoteException {
        Parcel a2 = a();
        zze.zzc(a2, zzuVar);
        a(4, a2);
    }
}
