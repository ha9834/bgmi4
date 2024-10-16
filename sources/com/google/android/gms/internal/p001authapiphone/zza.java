package com.google.android.gms.internal.p001authapiphone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f3801a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(IBinder iBinder, String str) {
        this.f3801a = iBinder;
        this.b = str;
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
            this.f3801a.transact(1, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3801a;
    }
}
