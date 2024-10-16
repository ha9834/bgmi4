package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class i extends p {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4267a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(zzal zzalVar, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, null);
        this.f4267a = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzb(this, this.f4267a);
    }
}
