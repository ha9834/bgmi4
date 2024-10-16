package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zzc implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f3809a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzc(IBinder iBinder, String str) {
        this.f3809a = iBinder;
        this.b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3809a;
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
            this.f3809a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
