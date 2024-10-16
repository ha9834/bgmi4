package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class af extends aj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(zzbn zzbnVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.f4202a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzh(this, this.f4202a);
    }
}
