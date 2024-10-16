package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzaf;
import com.google.android.gms.internal.auth.zzz;

/* loaded from: classes.dex */
final class c extends AccountTransferClient.c {
    private final /* synthetic */ zzaf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AccountTransferClient accountTransferClient, zzaf zzafVar) {
        super(null);
        this.b = zzafVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.b
    protected final void a(zzz zzzVar) throws RemoteException {
        zzzVar.zza(this.f1225a, this.b);
    }
}
