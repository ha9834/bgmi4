package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzz;

/* loaded from: classes.dex */
final class i extends AccountTransferClient.c {
    private final /* synthetic */ zzab b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(AccountTransferClient accountTransferClient, zzab zzabVar) {
        super(null);
        this.b = zzabVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.b
    protected final void a(zzz zzzVar) throws RemoteException {
        zzzVar.zza(this.f1225a, this.b);
    }
}
