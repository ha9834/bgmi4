package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;

/* loaded from: classes2.dex */
final class aa extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbi f3871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(zzbi zzbiVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f3871a = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        Contents contents;
        zzeo zzeoVar = (zzeo) zzawVar.getService();
        contents = this.f3871a.b;
        zzeoVar.zza(new zzo(contents.getRequestId(), false), new zzgs(this));
    }
}
