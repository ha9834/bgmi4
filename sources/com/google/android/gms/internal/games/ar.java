package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class ar extends as {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f4211a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(zzbz zzbzVar, GoogleApiClient googleApiClient, int i, int i2, int i3) {
        super(googleApiClient, null);
        this.f4211a = i;
        this.b = i2;
        this.d = i3;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4211a, this.b, this.d);
    }
}
