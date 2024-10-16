package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzw implements zzu {
    private final IBinder zzbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(IBinder iBinder) {
        this.zzbv = iBinder;
    }

    @Override // com.google.firebase.iid.zzu
    public final void send(Message message) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        obtain.writeInt(1);
        message.writeToParcel(obtain, 0);
        try {
            this.zzbv.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zzbv;
    }
}
