package com.ihoc.mgpa.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface c extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: com.ihoc.mgpa.h.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0134a implements c {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f5590a;

            public C0134a(IBinder iBinder) {
                this.f5590a = iBinder;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.ihoc.mgpa.h.c
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        this.f5590a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            return true;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return false;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5590a;
            }

            @Override // com.ihoc.mgpa.h.c
            public String c() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        this.f5590a.transact(3, obtain, obtain2, 0);
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
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0134a(iBinder) : (c) queryLocalInterface;
        }
    }

    boolean a();

    String c();
}
