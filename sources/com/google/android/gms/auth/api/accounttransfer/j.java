package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends com.google.android.gms.internal.auth.zzs {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AccountTransferClient.c f1231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AccountTransferClient.c cVar) {
        this.f1231a = cVar;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zzd() {
        this.f1231a.a((AccountTransferClient.c) null);
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void onFailure(Status status) {
        this.f1231a.a(status);
    }
}
