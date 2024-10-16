package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zze implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f4650a;
    private final String b = "com.android.vending.billing.IInAppBillingService";

    /* JADX INFO: Access modifiers changed from: protected */
    public zze(IBinder iBinder, String str) {
        this.f4650a = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f4650a.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4650a;
    }
}
