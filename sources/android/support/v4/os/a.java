package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface a extends IInterface {
    void a(int i, Bundle bundle) throws RemoteException;

    /* renamed from: android.support.v4.os.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0018a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0018a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0019a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.os.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0019a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static a f103a;
            private IBinder b;

            C0019a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // android.support.v4.os.a
            public void a(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.b.transact(1, obtain, null, 1) || AbstractBinderC0018a.a() == null) {
                        return;
                    }
                    AbstractBinderC0018a.a().a(i, bundle);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static a a() {
            return C0019a.f103a;
        }
    }
}
