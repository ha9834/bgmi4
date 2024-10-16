package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zzm implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f4418a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzm(IBinder iBinder, String str) {
        this.f4418a = iBinder;
        this.b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f4418a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f4418a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
