package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aq extends au {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String[] f4210a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(zzbz zzbzVar, GoogleApiClient googleApiClient, String[] strArr) {
        super(googleApiClient, null);
        this.f4210a = strArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzb(this, this.f4210a);
    }
}
