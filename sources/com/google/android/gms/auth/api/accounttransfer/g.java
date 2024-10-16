package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;

/* loaded from: classes.dex */
final class g extends AccountTransferClient.a<DeviceMetaData> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ f f1230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, AccountTransferClient.b bVar) {
        super(bVar);
        this.f1230a = fVar;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zza(DeviceMetaData deviceMetaData) {
        this.f1230a.a((f) deviceMetaData);
    }
}
