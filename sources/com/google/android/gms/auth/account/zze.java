package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zze extends com.google.android.gms.internal.auth.zza implements zzc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // com.google.android.gms.auth.account.zzc
    public final void zzb(boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.auth.zzc.writeBoolean(a2, z);
        b(1, a2);
    }

    @Override // com.google.android.gms.auth.account.zzc
    public final void zza(zza zzaVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.auth.zzc.zza(a2, zzaVar);
        a2.writeString(str);
        b(2, a2);
    }

    @Override // com.google.android.gms.auth.account.zzc
    public final void zza(zza zzaVar, Account account) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.auth.zzc.zza(a2, zzaVar);
        com.google.android.gms.internal.auth.zzc.zza(a2, account);
        b(3, a2);
    }
}
