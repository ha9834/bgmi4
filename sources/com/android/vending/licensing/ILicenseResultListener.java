package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ILicenseResultListener extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements ILicenseResultListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.vending.licensing.ILicenseResultListener
        public void verifyLicense(int i, String str, String str2) throws RemoteException {
        }
    }

    void verifyLicense(int i, String str, String str2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ILicenseResultListener {
        private static final String DESCRIPTOR = "com.android.vending.licensing.ILicenseResultListener";
        static final int TRANSACTION_verifyLicense = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ILicenseResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ILicenseResultListener)) {
                return (ILicenseResultListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                verifyLicense(parcel.readInt(), parcel.readString(), parcel.readString());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ILicenseResultListener {
            public static ILicenseResultListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.android.vending.licensing.ILicenseResultListener
            public void verifyLicense(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().verifyLicense(i, str, str2);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ILicenseResultListener iLicenseResultListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iLicenseResultListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLicenseResultListener;
            return true;
        }

        public static ILicenseResultListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
