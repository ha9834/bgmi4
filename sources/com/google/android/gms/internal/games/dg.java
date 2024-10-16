package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class dg extends dj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4260a;
    private final /* synthetic */ String[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(zzu zzuVar, GoogleApiClient googleApiClient, boolean z, String[] strArr) {
        super(googleApiClient, null);
        this.f4260a = z;
        this.b = strArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4260a, this.b);
    }
}
