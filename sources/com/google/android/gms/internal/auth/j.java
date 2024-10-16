package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class j extends m {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ i f3821a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f3821a = iVar;
    }

    @Override // com.google.android.gms.internal.auth.m, com.google.android.gms.auth.account.zza
    public final void zzc(Account account) {
        Status status;
        i iVar = this.f3821a;
        if (account != null) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzh.f3837a;
        }
        iVar.setResult((i) new n(status, account));
    }
}
