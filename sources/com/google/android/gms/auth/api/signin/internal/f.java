package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class f extends zzc {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ e f1265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f1265a = eVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzs
    public final void zzf(Status status) throws RemoteException {
        this.f1265a.setResult((e) status);
    }
}
