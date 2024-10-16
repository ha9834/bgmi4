package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class b extends zzc {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a f1263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1263a = aVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzs
    public final void zzc(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zzp.zzd(this.f1263a.f1262a).zzc(this.f1263a.b, googleSignInAccount);
        }
        this.f1263a.setResult((a) new GoogleSignInResult(googleSignInAccount, status));
    }
}
