package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

/* loaded from: classes2.dex */
public final class zzg extends zza implements zze {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.auth.IAuthManagerService");
    }

    @Override // com.google.android.gms.internal.auth.zze
    public final Bundle zza(String str, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        zzc.zza(a2, bundle);
        Parcel a3 = a(2, a2);
        Bundle bundle2 = (Bundle) zzc.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.auth.zze
    public final AccountChangeEventsResponse zza(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, accountChangeEventsRequest);
        Parcel a3 = a(3, a2);
        AccountChangeEventsResponse accountChangeEventsResponse = (AccountChangeEventsResponse) zzc.zza(a3, AccountChangeEventsResponse.CREATOR);
        a3.recycle();
        return accountChangeEventsResponse;
    }

    @Override // com.google.android.gms.internal.auth.zze
    public final Bundle zza(Account account, String str, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, account);
        a2.writeString(str);
        zzc.zza(a2, bundle);
        Parcel a3 = a(5, a2);
        Bundle bundle2 = (Bundle) zzc.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.auth.zze
    public final Bundle zza(Account account) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, account);
        Parcel a3 = a(7, a2);
        Bundle bundle = (Bundle) zzc.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.auth.zze
    public final Bundle zza(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(8, a2);
        Bundle bundle = (Bundle) zzc.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle;
    }
}
