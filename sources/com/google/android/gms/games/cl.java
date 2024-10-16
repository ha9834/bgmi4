package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zze;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cl extends Games.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(GoogleApiClient googleApiClient) {
        super(googleApiClient, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zze zzeVar) throws RemoteException {
        zzeVar.zzb(this);
    }
}
