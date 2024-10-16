package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* loaded from: classes2.dex */
public final class zag extends com.google.android.gms.internal.base.zaa implements zaf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zam(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(7, a2);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zaa(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.base.zac.zaa(a2, iAccountAccessor);
        a2.writeInt(i);
        com.google.android.gms.internal.base.zac.writeBoolean(a2, z);
        b(9, a2);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zaa(zah zahVar, zad zadVar) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.base.zac.zaa(a2, zahVar);
        com.google.android.gms.internal.base.zac.zaa(a2, zadVar);
        b(12, a2);
    }
}
