package com.google.android.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f1116a;
    private final String b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder) {
        this.f1116a = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a(Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f1116a.transact(1, parcel, obtain, 0);
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
        return this.f1116a;
    }
}
