package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zac;

/* loaded from: classes.dex */
public final class zah extends com.google.android.gms.internal.base.zaa implements ISignInButtonCreator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i, int i2) throws RemoteException {
        Parcel a2 = a();
        zac.zaa(a2, iObjectWrapper);
        a2.writeInt(i);
        a2.writeInt(i2);
        Parcel a3 = a(1, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel a2 = a();
        zac.zaa(a2, iObjectWrapper);
        zac.zaa(a2, signInButtonConfig);
        Parcel a3 = a(2, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }
}
