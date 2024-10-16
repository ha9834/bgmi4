package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.query.Query;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a extends k {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Query f3870a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(zzaf zzafVar, GoogleApiClient googleApiClient, Query query) {
        super(googleApiClient);
        this.f3870a = query;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgk(this.f3870a), new l(this));
    }
}
