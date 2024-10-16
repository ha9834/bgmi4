package com.samsung.android.game.tencentsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface ISceneSdkListener extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ISceneSdkListener {
        private static final String DESCRIPTOR = "com.samsung.android.game.tencentsdk.ISceneSdkListener";
        static final int TRANSACTION_resultCallBack = 2;
        static final int TRANSACTION_systemCallBack = 1;

        /* loaded from: classes2.dex */
        private static class Proxy implements ISceneSdkListener {
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

            @Override // com.samsung.android.game.tencentsdk.ISceneSdkListener
            public void resultCallBack(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tencentsdk.ISceneSdkListener
            public void systemCallBack(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISceneSdkListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISceneSdkListener)) ? new Proxy(iBinder) : (ISceneSdkListener) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                systemCallBack(parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                resultCallBack(parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void resultCallBack(int i, int i2);

    void systemCallBack(int i);
}
