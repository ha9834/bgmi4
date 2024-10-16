package com.intlgame.webview;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface WebViewAIDL extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements WebViewAIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.intlgame.webview.WebViewAIDL
        public void writeLog(int i, String str) throws RemoteException {
        }
    }

    void writeLog(int i, String str) throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements WebViewAIDL {
        private static final String DESCRIPTOR = "com.intlgame.webview.WebViewAIDL";
        static final int TRANSACTION_writeLog = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static WebViewAIDL asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof WebViewAIDL)) {
                return (WebViewAIDL) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            writeLog(parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements WebViewAIDL {
            public static WebViewAIDL sDefaultImpl;
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

            @Override // com.intlgame.webview.WebViewAIDL
            public void writeLog(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().writeLog(i, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(WebViewAIDL webViewAIDL) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (webViewAIDL == null) {
                return false;
            }
            Proxy.sDefaultImpl = webViewAIDL;
            return true;
        }

        public static WebViewAIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
