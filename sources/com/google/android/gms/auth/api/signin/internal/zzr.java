package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzr extends com.google.android.gms.internal.p000authapi.zzd implements zzq {
    public zzr() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zzd
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzj();
                return true;
            case 2:
                zzk();
                return true;
            default:
                return false;
        }
    }
}
