package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class l extends m {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ k f3823a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f3823a = kVar;
    }

    @Override // com.google.android.gms.internal.auth.m, com.google.android.gms.auth.account.zza
    public final void zza(boolean z) {
        Status status;
        k kVar = this.f3823a;
        if (z) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzh.f3837a;
        }
        kVar.setResult((k) new p(status));
    }
}
