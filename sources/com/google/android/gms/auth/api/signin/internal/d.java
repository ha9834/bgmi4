package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class d extends zzc {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ c f1264a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1264a = cVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzs
    public final void zze(Status status) throws RemoteException {
        this.f1264a.setResult((c) status);
    }
}
