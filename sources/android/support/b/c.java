package android.support.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.b.a;

/* loaded from: classes.dex */
public interface c extends IInterface {
    void a(android.support.b.a aVar, Bundle bundle) throws RemoteException;

    void a(android.support.b.a aVar, String str, Bundle bundle) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "android.support.customtabs.IPostMessageService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("android.support.customtabs.IPostMessageService");
                return true;
            }
            switch (i) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.IPostMessageService");
                    a(a.AbstractBinderC0007a.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.IPostMessageService");
                    a(a.AbstractBinderC0007a.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
