package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zac;

/* loaded from: classes.dex */
public interface IResolveAccountCallbacks extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends com.google.android.gms.internal.base.zab implements IResolveAccountCallbacks {
        public Stub() {
            super("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        }

        /* loaded from: classes.dex */
        public static class Proxy extends com.google.android.gms.internal.base.zaa implements IResolveAccountCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
            }

            @Override // com.google.android.gms.common.internal.IResolveAccountCallbacks
            public void onAccountResolutionComplete(ResolveAccountResponse resolveAccountResponse) throws RemoteException {
                Parcel a2 = a();
                zac.zaa(a2, resolveAccountResponse);
                b(2, a2);
            }
        }

        public static IResolveAccountCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            if (queryLocalInterface instanceof IResolveAccountCallbacks) {
                return (IResolveAccountCallbacks) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 2) {
                return false;
            }
            onAccountResolutionComplete((ResolveAccountResponse) zac.zaa(parcel, ResolveAccountResponse.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    void onAccountResolutionComplete(ResolveAccountResponse resolveAccountResponse) throws RemoteException;
}
