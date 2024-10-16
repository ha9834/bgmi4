package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzad;
import com.google.android.gms.internal.auth.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends AccountTransferClient.b<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzad f1227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AccountTransferClient accountTransferClient, zzad zzadVar) {
        super(null);
        this.f1227a = zzadVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.b
    protected final void a(zzz zzzVar) throws RemoteException {
        zzzVar.zza(new e(this, this), this.f1227a);
    }
}
