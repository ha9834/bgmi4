package com.ihoc.mgpa.dataforwardsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ihoc.mgpa.dataforwardsdk.ICallBack;

/* loaded from: classes2.dex */
public interface IDataForward extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IDataForward {
        private static final String DESCRIPTOR = "com.ihoc.mgpa.dataforwardsdk.IDataForward";
        static final int TRANSACTION_registerGameCallback = 1;
        static final int TRANSACTION_updateGameInfo = 2;

        /* loaded from: classes2.dex */
        private static class Proxy implements IDataForward {
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

            @Override // com.ihoc.mgpa.dataforwardsdk.IDataForward
            public void registerGameCallback(ICallBack iCallBack) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallBack != null ? iCallBack.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ihoc.mgpa.dataforwardsdk.IDataForward
            public void updateGameInfo(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDataForward asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDataForward)) ? new Proxy(iBinder) : (IDataForward) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                registerGameCallback(ICallBack.Stub.asInterface(parcel.readStrongBinder()));
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                updateGameInfo(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void registerGameCallback(ICallBack iCallBack);

    void updateGameInfo(String str);
}
