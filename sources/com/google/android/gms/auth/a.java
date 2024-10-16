package com.google.android.gms.auth;

import android.accounts.Account;
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
public final class a implements f<TokenData> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Account f1216a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Bundle c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Account account, String str, Bundle bundle) {
        this.f1216a = account;
        this.b = str;
        this.c = bundle;
    }

    @Override // com.google.android.gms.auth.f
    public final /* synthetic */ TokenData a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object b;
        Logger logger;
        b = zzd.b(zzf.zza(iBinder).zza(this.f1216a, this.b, this.c));
        Bundle bundle = (Bundle) b;
        TokenData zza = TokenData.zza(bundle, "tokenDetails");
        if (zza != null) {
            return zza;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzay zzc = zzay.zzc(string);
        if (!zzay.zza(zzc)) {
            if (zzay.NETWORK_ERROR.equals(zzc) || zzay.SERVICE_UNAVAILABLE.equals(zzc) || zzay.INTNERNAL_ERROR.equals(zzc)) {
                throw new IOException(string);
            }
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
