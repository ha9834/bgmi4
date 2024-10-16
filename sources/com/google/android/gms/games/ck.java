package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zze;

/* loaded from: classes.dex */
final class ck extends Games.b {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1639a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.f1639a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zze zzeVar) throws RemoteException {
        zzeVar.zza(this.f1639a, this);
    }
}
