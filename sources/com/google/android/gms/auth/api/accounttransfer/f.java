package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends AccountTransferClient.b<DeviceMetaData> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.auth.zzv f1229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(AccountTransferClient accountTransferClient, com.google.android.gms.internal.auth.zzv zzvVar) {
        super(null);
        this.f1229a = zzvVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.b
    protected final void a(zzz zzzVar) throws RemoteException {
        zzzVar.zza(new g(this, this), this.f1229a);
    }
}
