package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class da extends de {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4255a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da(zze zzeVar, String str, GoogleApiClient googleApiClient, String str2, int i) {
        super(str, googleApiClient);
        this.f4255a = str2;
        this.b = i;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4255a, this.b);
    }
}
