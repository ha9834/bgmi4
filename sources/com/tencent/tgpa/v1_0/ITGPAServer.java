package com.tencent.tgpa.v1_0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tgpa.v1_0.ICallBack;

/* loaded from: classes.dex */
public interface ITGPAServer extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ITGPAServer {
        private static final String DESCRIPTOR = "com.tencent.tgpa.v1_0.ITGPAServer";
        static final int TRANSACTION_getInterfaceVersion = 1;
        static final int TRANSACTION_getServerVersion = 5;
        static final int TRANSACTION_getSupportState = 3;
        static final int TRANSACTION_getSupportStrategy = 6;
        static final int TRANSACTION_getSystemData = 9;
        static final int TRANSACTION_init = 2;
        static final int TRANSACTION_registerGameCallback = 7;
        static final int TRANSACTION_setForeground = 4;
        static final int TRANSACTION_unregisterGameCallback = 10;
        static final int TRANSACTION_updateGameInfo = 8;

        /* loaded from: classes.dex */
        private static class Proxy implements ITGPAServer {
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

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public String getInterfaceVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public String getServerVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public int getSupportState() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public String getSupportStrategy() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public String getSystemData(int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public void init(IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public void registerGameCallback(ICallBack iCallBack) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallBack != null ? iCallBack.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public void setForeground(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public void unregisterGameCallback() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tgpa.v1_0.ITGPAServer
            public void updateGameInfo(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
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

        public static ITGPAServer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITGPAServer)) ? new Proxy(iBinder) : (ITGPAServer) queryLocalInterface;
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
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    String interfaceVersion = getInterfaceVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(interfaceVersion);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    init(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int supportState = getSupportState();
                    parcel2.writeNoException();
                    parcel2.writeInt(supportState);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    setForeground(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    String serverVersion = getServerVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(serverVersion);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String supportStrategy = getSupportStrategy();
                    parcel2.writeNoException();
                    parcel2.writeString(supportStrategy);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerGameCallback(ICallBack.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateGameInfo(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    String systemData = getSystemData(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(systemData);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterGameCallback();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getInterfaceVersion();

    String getServerVersion();

    int getSupportState();

    String getSupportStrategy();

    String getSystemData(int i, String str);

    void init(IBinder iBinder);

    void registerGameCallback(ICallBack iCallBack);

    void setForeground(boolean z);

    void unregisterGameCallback();

    void updateGameInfo(String str);
}
