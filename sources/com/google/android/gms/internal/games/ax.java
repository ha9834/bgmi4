package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ax extends bh {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4215a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(zzch zzchVar, GoogleApiClient googleApiClient, String str, boolean z, int i) {
        super(googleApiClient, null);
        this.f4215a = str;
        this.b = z;
        this.d = i;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4215a, this.b, this.d);
    }
}
