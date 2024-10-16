package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class f extends zzaj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ e f3817a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f3817a = eVar;
    }

    @Override // com.google.android.gms.internal.auth.zzaj, com.google.android.gms.internal.auth.zzal
    public final void zzb(String str) {
        if (str != null) {
            this.f3817a.setResult((e) new zzax(str));
        } else {
            this.f3817a.setResult((e) e.a(new Status(AuthApiStatusCodes.AUTH_APP_CERT_ERROR)));
        }
    }
}
