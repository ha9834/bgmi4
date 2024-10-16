package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;

/* loaded from: classes.dex */
final class e extends AccountTransferClient.a<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ d f1228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, AccountTransferClient.b bVar) {
        super(bVar);
        this.f1228a = dVar;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zza(byte[] bArr) {
        this.f1228a.a((d) bArr);
    }
}
