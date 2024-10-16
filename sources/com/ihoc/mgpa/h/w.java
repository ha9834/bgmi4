package com.ihoc.mgpa.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface w extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements w {

        /* renamed from: com.ihoc.mgpa.h.w$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0138a implements w {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f5608a;

            C0138a(IBinder iBinder) {
                this.f5608a = iBinder;
            }

            @Override // com.ihoc.mgpa.h.w
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                        this.f5608a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return "";
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5608a;
            }
        }

        public static w a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof w)) ? new C0138a(iBinder) : (w) queryLocalInterface;
        }
    }

    String a();
}
