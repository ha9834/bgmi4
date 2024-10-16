package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public interface IStatusCallback extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends com.google.android.gms.internal.base.zab implements IStatusCallback {
        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        /* loaded from: classes.dex */
        public static class zaa extends com.google.android.gms.internal.base.zaa implements IStatusCallback {
            zaa(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
            }

            @Override // com.google.android.gms.common.api.internal.IStatusCallback
            public final void onResult(Status status) throws RemoteException {
                Parcel a2 = a();
                com.google.android.gms.internal.base.zac.zaa(a2, status);
                c(1, a2);
            }
        }

        public static IStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            if (queryLocalInterface instanceof IStatusCallback) {
                return (IStatusCallback) queryLocalInterface;
            }
            return new zaa(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            onResult((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR));
            return true;
        }
    }

    void onResult(Status status) throws RemoteException;
}
