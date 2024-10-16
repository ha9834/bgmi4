package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f3864a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(IBinder iBinder, String str) {
        this.f3864a = iBinder;
        this.b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3864a;
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
                this.f3864a.transact(i, parcel, obtain, 0);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f3864a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i, Parcel parcel) throws RemoteException {
        try {
            this.f3864a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
