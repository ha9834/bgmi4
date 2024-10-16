package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class ct extends dc {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ct(zze zzeVar, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, null);
        this.f4248a = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzc(this, this.f4248a);
    }
}
