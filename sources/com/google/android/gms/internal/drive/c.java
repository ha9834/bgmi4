package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
final class c extends j {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(zzaf zzafVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.f3918a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzek(DriveId.zza(this.f3918a), false), new h(this));
    }
}
