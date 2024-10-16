package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.vending.licensing.ILicenseResultListener;

/* loaded from: classes.dex */
public interface ILicensingService extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements ILicensingService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.vending.licensing.ILicensingService
        public void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException {
        }
    }

    void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ILicensingService {
        private static final String DESCRIPTOR = "com.android.vending.licensing.ILicensingService";
        static final int TRANSACTION_checkLicense = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ILicensingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ILicensingService)) {
                return (ILicensingService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                checkLicense(parcel.readLong(), parcel.readString(), ILicenseResultListener.Stub.asInterface(parcel.readStrongBinder()));
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
        public static class Proxy implements ILicensingService {
            public static ILicensingService sDefaultImpl;
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

            @Override // com.android.vending.licensing.ILicensingService
            public void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iLicenseResultListener != null ? iLicenseResultListener.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().checkLicense(j, str, iLicenseResultListener);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ILicensingService iLicensingService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iLicensingService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLicensingService;
            return true;
        }

        public static ILicensingService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
