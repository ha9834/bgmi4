package com.ihoc.mgpa.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface m extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements m {

        /* renamed from: com.ihoc.mgpa.h.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0136a implements m {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f5599a;

            C0136a(IBinder iBinder) {
                this.f5599a = iBinder;
            }

            @Override // com.ihoc.mgpa.h.m
            public String a() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f5599a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        str = obtain2.readString();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        str = null;
                    }
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5599a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcel] */
            /* JADX WARN: Type inference failed for: r0v2 */
            @Override // com.ihoc.mgpa.h.m
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f5599a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            return false;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    obtain = 1;
                    return true;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static m a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new C0136a(iBinder) : (m) queryLocalInterface;
        }
    }

    String a();

    boolean c();
}
