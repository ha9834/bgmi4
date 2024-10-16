package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzf;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements f<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Account f1272a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Account account) {
        this.f1272a = account;
    }

    @Override // com.google.android.gms.auth.f
    public final /* synthetic */ Bundle a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object b;
        b = zzd.b(zzf.zza(iBinder).zza(this.f1272a));
        return (Bundle) b;
    }
}
