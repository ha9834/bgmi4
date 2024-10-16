package com.oplus.cosa.gamemanagersdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface ICosaSdkCallback extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements ICosaSdkCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkCallback
        public void systemCallBack(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ICosaSdkCallback {
        private static final String DESCRIPTOR = "com.oplus.cosa.gamemanagersdk.ICosaSdkCallback";
        static final int TRANSACTION_systemCallBack = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements ICosaSdkCallback {
            public static ICosaSdkCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkCallback
            public void systemCallBack(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().systemCallBack(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICosaSdkCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICosaSdkCallback)) ? new Proxy(iBinder) : (ICosaSdkCallback) queryLocalInterface;
        }

        public static ICosaSdkCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICosaSdkCallback iCosaSdkCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCosaSdkCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCosaSdkCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            systemCallBack(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void systemCallBack(String str);
}
