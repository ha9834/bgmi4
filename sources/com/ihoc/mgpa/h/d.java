package com.ihoc.mgpa.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface d extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements d {

        /* renamed from: com.ihoc.mgpa.h.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0135a implements d {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f5591a;

            C0135a(IBinder iBinder) {
                this.f5591a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5591a;
            }

            @Override // com.ihoc.mgpa.h.d
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        try {
                            this.f5591a.transact(3, obtain, obtain2, 0);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C0135a(iBinder) : (d) queryLocalInterface;
        }
    }

    String b();
}
