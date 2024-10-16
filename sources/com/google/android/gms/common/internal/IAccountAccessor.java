package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAccountAccessor extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IAccountAccessor {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        /* loaded from: classes.dex */
        public static class zza extends com.google.android.gms.internal.common.zza implements IAccountAccessor {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.IAccountAccessor
            public final Account getAccount() throws RemoteException {
                Parcel a2 = a(2, a());
                Account account = (Account) com.google.android.gms.internal.common.zzc.zza(a2, Account.CREATOR);
                a2.recycle();
                return account;
            }
        }

        public static IAccountAccessor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 2) {
                return false;
            }
            Account account = getAccount();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzc.zzb(parcel2, account);
            return true;
        }
    }

    Account getAccount() throws RemoteException;
}
