package com.tencent.mtt.spcialcall.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISpecialCallClient extends IInterface {
    String onJsCall(long j, String str, String str2, String str3) throws RemoteException;

    void onWebViewDestroy(long j) throws RemoteException;

    boolean shouldOverrideUrlLoading(long j, String str) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ISpecialCallClient {
        private static final String DESCRIPTOR = "com.tencent.mtt.spcialcall.remote.ISpecialCallClient";
        static final int TRANSACTION_onJsCall = 2;
        static final int TRANSACTION_onWebViewDestroy = 1;
        static final int TRANSACTION_shouldOverrideUrlLoading = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISpecialCallClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ISpecialCallClient)) {
                return (ISpecialCallClient) queryLocalInterface;
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
                    onWebViewDestroy(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    String onJsCall = onJsCall(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(onJsCall);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean shouldOverrideUrlLoading = shouldOverrideUrlLoading(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(shouldOverrideUrlLoading ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements ISpecialCallClient {
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

            @Override // com.tencent.mtt.spcialcall.remote.ISpecialCallClient
            public void onWebViewDestroy(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.mtt.spcialcall.remote.ISpecialCallClient
            public String onJsCall(long j, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.mtt.spcialcall.remote.ISpecialCallClient
            public boolean shouldOverrideUrlLoading(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
