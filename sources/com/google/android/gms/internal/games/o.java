package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o extends zzaz {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4273a;
    private final /* synthetic */ long b;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(zzal zzalVar, GoogleApiClient googleApiClient, String str, long j, String str2) {
        super(googleApiClient);
        this.f4273a = str;
        this.b = j;
        this.d = str2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4273a, this.b, this.d);
    }
}
