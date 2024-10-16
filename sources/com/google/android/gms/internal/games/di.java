package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class di extends a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4262a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(zzu zzuVar, GoogleApiClient googleApiClient, String str, int i) {
        super(googleApiClient, null);
        this.f4262a = str;
        this.b = i;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this.f4262a, this.b);
    }
}
