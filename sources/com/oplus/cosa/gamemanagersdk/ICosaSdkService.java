package com.oplus.cosa.gamemanagersdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface ICosaSdkService extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements ICosaSdkService {
        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
        public boolean applyHardwareResource(String str) {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
        public String getTouchLogPath() {
            return null;
        }

        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
        public String getVendorSupportStrategy() {
            return null;
        }

        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
        public String getVersion() {
            return null;
        }

        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
        public boolean isTouchLogSupport() {
            return false;
        }

        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
        public boolean registerCosaSdk(IBinder iBinder) {
            return false;
        }

        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
        public void registerNotifier() {
        }

        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
        public boolean updateGameInfo(String str) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ICosaSdkService {
        private static final String DESCRIPTOR = "com.oplus.cosa.gamemanagersdk.ICosaSdkService";
        static final int TRANSACTION_applyHardwareResource = 3;
        static final int TRANSACTION_getTouchLogPath = 8;
        static final int TRANSACTION_getVendorSupportStrategy = 6;
        static final int TRANSACTION_getVersion = 5;
        static final int TRANSACTION_isTouchLogSupport = 7;
        static final int TRANSACTION_registerCosaSdk = 1;
        static final int TRANSACTION_registerNotifier = 4;
        static final int TRANSACTION_updateGameInfo = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements ICosaSdkService {
            public static ICosaSdkService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
            public boolean applyHardwareResource(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().applyHardwareResource(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
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

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
            public String getTouchLogPath() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getTouchLogPath();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
            public String getVendorSupportStrategy() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getVendorSupportStrategy();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
            public String getVersion() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getVersion();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
            public boolean isTouchLogSupport() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isTouchLogSupport();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
            public boolean registerCosaSdk(IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerCosaSdk(iBinder);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
            public void registerNotifier() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerNotifier();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkService
            public boolean updateGameInfo(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateGameInfo(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICosaSdkService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICosaSdkService)) ? new Proxy(iBinder) : (ICosaSdkService) queryLocalInterface;
        }

        public static ICosaSdkService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICosaSdkService iCosaSdkService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCosaSdkService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCosaSdkService;
            return true;
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
                    boolean registerCosaSdk = registerCosaSdk(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    parcel2.writeInt(registerCosaSdk ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean updateGameInfo = updateGameInfo(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(updateGameInfo ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean applyHardwareResource = applyHardwareResource(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(applyHardwareResource ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerNotifier();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    String version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(version);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String vendorSupportStrategy = getVendorSupportStrategy();
                    parcel2.writeNoException();
                    parcel2.writeString(vendorSupportStrategy);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isTouchLogSupport = isTouchLogSupport();
                    parcel2.writeNoException();
                    parcel2.writeInt(isTouchLogSupport ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    String touchLogPath = getTouchLogPath();
                    parcel2.writeNoException();
                    parcel2.writeString(touchLogPath);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean applyHardwareResource(String str);

    String getTouchLogPath();

    String getVendorSupportStrategy();

    String getVersion();

    boolean isTouchLogSupport();

    boolean registerCosaSdk(IBinder iBinder);

    void registerNotifier();

    boolean updateGameInfo(String str);
}
