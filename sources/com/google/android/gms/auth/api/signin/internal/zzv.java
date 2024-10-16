package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* loaded from: classes.dex */
public final class zzv extends com.google.android.gms.internal.p000authapi.zzc implements zzu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzu
    public final void zzc(zzs zzsVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.p000authapi.zze.zzc(a2, zzsVar);
        com.google.android.gms.internal.p000authapi.zze.zzc(a2, googleSignInOptions);
        a(101, a2);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzu
    public final void zzd(zzs zzsVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.p000authapi.zze.zzc(a2, zzsVar);
        com.google.android.gms.internal.p000authapi.zze.zzc(a2, googleSignInOptions);
        a(102, a2);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzu
    public final void zze(zzs zzsVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.p000authapi.zze.zzc(a2, zzsVar);
        com.google.android.gms.internal.p000authapi.zze.zzc(a2, googleSignInOptions);
        a(103, a2);
    }
}
