package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzay;
import com.google.android.gms.internal.auth.zzf;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements f<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f1273a = str;
    }

    @Override // com.google.android.gms.auth.f
    public final /* synthetic */ Boolean a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object b;
        Logger logger;
        b = zzd.b(zzf.zza(iBinder).zza(this.f1273a));
        Bundle bundle = (Bundle) b;
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzay zzc = zzay.zzc(string);
        if (zzay.SUCCESS.equals(zzc)) {
            return true;
        }
        if (!zzay.zza(zzc)) {
            throw new GoogleAuthException(string);
        }
        logger = zzd.c;
        String valueOf = String.valueOf(zzc);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
        sb.append("isUserRecoverableError status: ");
        sb.append(valueOf);
        logger.w("GoogleAuthUtil", sb.toString());
        throw new UserRecoverableAuthException(string, intent);
    }
}
