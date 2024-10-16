package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzb extends com.google.android.gms.internal.auth.zzb implements zza {
    public zzb() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzc((Account) com.google.android.gms.internal.auth.zzc.zza(parcel, Account.CREATOR));
                return true;
            case 2:
                zza(com.google.android.gms.internal.auth.zzc.zza(parcel));
                return true;
            default:
                return false;
        }
    }
}
