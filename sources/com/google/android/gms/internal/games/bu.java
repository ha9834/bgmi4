package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class bu extends bw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(zzcz zzczVar, String str, GoogleApiClient googleApiClient, String str2) {
        super(str, googleApiClient);
        this.f4234a = str2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzf(this, this.f4234a);
    }
}
