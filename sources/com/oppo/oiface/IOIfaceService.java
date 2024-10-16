package com.oppo.oiface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.oppo.oiface.IOIfaceNotifier;

/* loaded from: classes2.dex */
public interface IOIfaceService extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IOIfaceService {
        private static final String DESCRIPTOR = "com.oppo.oiface.IOIfaceService";
        static final int TRANSACTION_applyHardwareResource = 103;
        static final int TRANSACTION_getOifaceversion = 105;
        static final int TRANSACTION_onAppRegister = 104;
        static final int TRANSACTION_onSystemNotify = 101;
        static final int TRANSACTION_updateGameInfo = 102;

        /* loaded from: classes2.dex */
        private static class Proxy implements IOIfaceService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.oppo.oiface.IOIfaceService
            public void applyHardwareResource(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(103, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.oppo.oiface.IOIfaceService
            public String getOifaceversion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(105, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oppo.oiface.IOIfaceService
            public void onAppRegister() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(104, obtain, obtain2, 1);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oppo.oiface.IOIfaceService
            public void onSystemNotify(IOIfaceNotifier iOIfaceNotifier) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOIfaceNotifier != null ? iOIfaceNotifier.asBinder() : null);
                    this.mRemote.transact(101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oppo.oiface.IOIfaceService
            public void updateGameInfo(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(102, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOIfaceService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOIfaceService)) ? new Proxy(iBinder) : (IOIfaceService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 101:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSystemNotify(IOIfaceNotifier.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 102:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateGameInfo(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 103:
                    parcel.enforceInterface(DESCRIPTOR);
                    applyHardwareResource(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 104:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAppRegister();
                    parcel2.writeNoException();
                    return true;
                case 105:
                    parcel.enforceInterface(DESCRIPTOR);
                    String oifaceversion = getOifaceversion();
                    parcel2.writeNoException();
                    parcel2.writeString(oifaceversion);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void applyHardwareResource(String str);

    String getOifaceversion();

    void onAppRegister();

    void onSystemNotify(IOIfaceNotifier iOIfaceNotifier);

    void updateGameInfo(String str);
}
