package com.tencent.midas.oversea.business.h5;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IWebInterface extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IWebInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.midas.oversea.business.h5.IWebInterface
        public void onResult(int i, int i2, String str) throws RemoteException {
        }

        @Override // com.tencent.midas.oversea.business.h5.IWebInterface
        public String queryCacheIP(String str) throws RemoteException {
            return null;
        }
    }

    void onResult(int i, int i2, String str) throws RemoteException;

    String queryCacheIP(String str) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IWebInterface {
        private static final String DESCRIPTOR = "com.tencent.midas.oversea.business.h5.IWebInterface";
        static final int TRANSACTION_onResult = 1;
        static final int TRANSACTION_queryCacheIP = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IWebInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IWebInterface)) {
                return (IWebInterface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onResult(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    String queryCacheIP = queryCacheIP(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(queryCacheIP);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IWebInterface {
            public static IWebInterface sDefaultImpl;
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

            @Override // com.tencent.midas.oversea.business.h5.IWebInterface
            public void onResult(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onResult(i, i2, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.midas.oversea.business.h5.IWebInterface
            public String queryCacheIP(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryCacheIP(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IWebInterface iWebInterface) {
            if (Proxy.sDefaultImpl != null || iWebInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWebInterface;
            return true;
        }

        public static IWebInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
