package com.google.android.gms.internal.plus;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;

/* loaded from: classes2.dex */
public final class zze implements Account {
    @Override // com.google.android.gms.plus.Account
    public final void clearDefaultAccount(GoogleApiClient googleApiClient) {
        com.google.android.gms.plus.internal.zzh zza = Plus.zza(googleApiClient, false);
        if (zza != null) {
            zza.zza();
        }
    }

    @Override // com.google.android.gms.plus.Account
    public final String getAccountName(GoogleApiClient googleApiClient) {
        return Plus.zza(googleApiClient, true).getAccountName();
    }

    @Override // com.google.android.gms.plus.Account
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new b(this, googleApiClient));
    }
}
