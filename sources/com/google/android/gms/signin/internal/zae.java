package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class zae extends com.google.android.gms.internal.base.zab implements zad {
    public zae() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 3:
                zaa((ConnectionResult) com.google.android.gms.internal.base.zac.zaa(parcel, ConnectionResult.CREATOR), (zaa) com.google.android.gms.internal.base.zac.zaa(parcel, zaa.CREATOR));
                break;
            case 4:
                zag((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR));
                break;
            case 5:
            default:
                return false;
            case 6:
                zah((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR));
                break;
            case 7:
                zaa((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR), (GoogleSignInAccount) com.google.android.gms.internal.base.zac.zaa(parcel, GoogleSignInAccount.CREATOR));
                break;
            case 8:
                zab((zaj) com.google.android.gms.internal.base.zac.zaa(parcel, zaj.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
