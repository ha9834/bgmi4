package com.ihoc.mgpa.h;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class i implements j {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f5596a;

    public i(IBinder iBinder) {
        this.f5596a = iBinder;
    }

    @Override // com.ihoc.mgpa.h.j
    public final String a() {
        String str = "";
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f5596a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return str;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5596a;
    }
}
