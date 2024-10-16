package com.samsung.android.game.tsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.game.compatibility.SharedMemory;
import com.samsung.android.game.tsdk.ISceneSdkListener;
import com.samsung.android.game.tsdk.IToTGPACallback;

/* loaded from: classes2.dex */
public interface ISceneSdkService extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ISceneSdkService {
        private static final String DESCRIPTOR = "com.samsung.android.game.tsdk.ISceneSdkService";
        static final int TRANSACTION_applyHardwareResource = 4;
        static final int TRANSACTION_applyThreadGuarantee = 5;
        static final int TRANSACTION_getVendorSupportStrategy = 10;
        static final int TRANSACTION_getVersion = 6;
        static final int TRANSACTION_initLowLatencyIPC = 7;
        static final int TRANSACTION_initSceneSdk = 1;
        static final int TRANSACTION_registerToTGPACallback = 9;
        static final int TRANSACTION_setSceneSdkListener = 2;
        static final int TRANSACTION_totgpa = 8;
        static final int TRANSACTION_updateGameInfo = 3;

        /* loaded from: classes2.dex */
        private static class Proxy implements ISceneSdkService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public int applyHardwareResource(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public int applyThreadGuarantee(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
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

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public String getVendorSupportStrategy(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public float getVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public int initLowLatencyIPC(String str, SharedMemory sharedMemory) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (sharedMemory != null) {
                        obtain.writeInt(1);
                        sharedMemory.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public boolean initSceneSdk() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public int registerToTGPACallback(IToTGPACallback iToTGPACallback, float f) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iToTGPACallback != null ? iToTGPACallback.asBinder() : null);
                    obtain.writeFloat(f);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public boolean setSceneSdkListener(ISceneSdkListener iSceneSdkListener) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSceneSdkListener != null ? iSceneSdkListener.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public String totgpa() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.game.tsdk.ISceneSdkService
            public int updateGameInfo(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISceneSdkService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISceneSdkService)) ? new Proxy(iBinder) : (ISceneSdkService) queryLocalInterface;
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
                    boolean initSceneSdk = initSceneSdk();
                    parcel2.writeNoException();
                    parcel2.writeInt(initSceneSdk ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean sceneSdkListener = setSceneSdkListener(ISceneSdkListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(sceneSdkListener ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int updateGameInfo = updateGameInfo(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(updateGameInfo);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int applyHardwareResource = applyHardwareResource(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(applyHardwareResource);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    int applyThreadGuarantee = applyThreadGuarantee(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(applyThreadGuarantee);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    float version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeFloat(version);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int initLowLatencyIPC = initLowLatencyIPC(parcel.readString(), parcel.readInt() != 0 ? SharedMemory.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(initLowLatencyIPC);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    String str = totgpa();
                    parcel2.writeNoException();
                    parcel2.writeString(str);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int registerToTGPACallback = registerToTGPACallback(IToTGPACallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readFloat());
                    parcel2.writeNoException();
                    parcel2.writeInt(registerToTGPACallback);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    String vendorSupportStrategy = getVendorSupportStrategy(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vendorSupportStrategy);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int applyHardwareResource(String str);

    int applyThreadGuarantee(String str);

    String getVendorSupportStrategy(String str);

    float getVersion();

    int initLowLatencyIPC(String str, SharedMemory sharedMemory);

    boolean initSceneSdk();

    int registerToTGPACallback(IToTGPACallback iToTGPACallback, float f);

    boolean setSceneSdkListener(ISceneSdkListener iSceneSdkListener);

    String totgpa();

    int updateGameInfo(String str);
}
