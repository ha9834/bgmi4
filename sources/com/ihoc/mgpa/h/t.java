package com.ihoc.mgpa.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface t extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements t {

        /* renamed from: com.ihoc.mgpa.h.t$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0137a implements t {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f5605a;

            public C0137a(IBinder iBinder) {
                this.f5605a = iBinder;
            }

            @Override // com.ihoc.mgpa.h.t
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                String str4 = "com.heytap.openid.IOpenID";
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.f5605a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        str4 = obtain2.readString();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return str4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5605a;
            }
        }

        public static t a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof t)) ? new C0137a(iBinder) : (t) queryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
