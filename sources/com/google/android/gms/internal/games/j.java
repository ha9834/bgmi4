package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class j extends p {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4268a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(zzal zzalVar, GoogleApiClient googleApiClient, String str, boolean z) {
        super(googleApiClient, null);
        this.f4268a = str;
        this.b = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzb(this, this.f4268a, this.b);
    }
}
