package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzh {

    /* renamed from: a, reason: collision with root package name */
    private static Logger f1267a = new Logger("GoogleSignInCommon", new String[0]);

    public static Intent zzc(Context context, GoogleSignInOptions googleSignInOptions) {
        f1267a.d("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ConfigDBHelper.TABLE_NAME_CONFIG, signInConfiguration);
        intent.putExtra(ConfigDBHelper.TABLE_NAME_CONFIG, bundle);
        return intent;
    }

    public static Intent zzd(Context context, GoogleSignInOptions googleSignInOptions) {
        f1267a.d("getFallbackSignInIntent()", new Object[0]);
        Intent zzc = zzc(context, googleSignInOptions);
        zzc.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return zzc;
    }

    public static Intent zze(Context context, GoogleSignInOptions googleSignInOptions) {
        f1267a.d("getNoImplementationSignInIntent()", new Object[0]);
        Intent zzc = zzc(context, googleSignInOptions);
        zzc.setAction("com.google.android.gms.auth.NO_IMPL");
        return zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.common.api.OptionalPendingResult<com.google.android.gms.auth.api.signin.GoogleSignInResult> zzc(com.google.android.gms.common.api.GoogleApiClient r5, android.content.Context r6, com.google.android.gms.auth.api.signin.GoogleSignInOptions r7, boolean r8) {
        /*
            com.google.android.gms.common.logging.Logger r0 = com.google.android.gms.auth.api.signin.internal.zzh.f1267a
            java.lang.String r1 = "silentSignIn()"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            com.google.android.gms.common.logging.Logger r0 = com.google.android.gms.auth.api.signin.internal.zzh.f1267a
            java.lang.String r1 = "getEligibleSavedSignInResult()"
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            com.google.android.gms.auth.api.signin.internal.zzp r0 = com.google.android.gms.auth.api.signin.internal.zzp.zzd(r6)
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r0 = r0.zzi()
            r1 = 0
            if (r0 == 0) goto L87
            android.accounts.Account r3 = r0.getAccount()
            android.accounts.Account r4 = r7.getAccount()
            if (r3 != 0) goto L31
            if (r4 != 0) goto L2f
            r3 = 1
            goto L35
        L2f:
            r3 = 0
            goto L35
        L31:
            boolean r3 = r3.equals(r4)
        L35:
            if (r3 == 0) goto L87
            boolean r3 = r7.isServerAuthCodeRequested()
            if (r3 != 0) goto L87
            boolean r3 = r7.isIdTokenRequested()
            if (r3 == 0) goto L57
            boolean r3 = r0.isIdTokenRequested()
            if (r3 == 0) goto L87
            java.lang.String r3 = r7.getServerClientId()
            java.lang.String r4 = r0.getServerClientId()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L87
        L57:
            java.util.HashSet r3 = new java.util.HashSet
            java.util.ArrayList r0 = r0.getScopes()
            r3.<init>(r0)
            java.util.HashSet r0 = new java.util.HashSet
            java.util.ArrayList r4 = r7.getScopes()
            r0.<init>(r4)
            boolean r0 = r3.containsAll(r0)
            if (r0 == 0) goto L87
            com.google.android.gms.auth.api.signin.internal.zzp r0 = com.google.android.gms.auth.api.signin.internal.zzp.zzd(r6)
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = r0.zzh()
            if (r0 == 0) goto L87
            boolean r3 = r0.isExpired()
            if (r3 != 0) goto L87
            com.google.android.gms.auth.api.signin.GoogleSignInResult r3 = new com.google.android.gms.auth.api.signin.GoogleSignInResult
            com.google.android.gms.common.api.Status r4 = com.google.android.gms.common.api.Status.RESULT_SUCCESS
            r3.<init>(r0, r4)
            goto L88
        L87:
            r3 = r1
        L88:
            if (r3 == 0) goto L98
            com.google.android.gms.common.logging.Logger r6 = com.google.android.gms.auth.api.signin.internal.zzh.f1267a
            java.lang.String r7 = "Eligible saved sign in result found"
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r6.d(r7, r8)
            com.google.android.gms.common.api.OptionalPendingResult r5 = com.google.android.gms.common.api.PendingResults.immediatePendingResult(r3, r5)
            return r5
        L98:
            if (r8 == 0) goto Laa
            com.google.android.gms.auth.api.signin.GoogleSignInResult r6 = new com.google.android.gms.auth.api.signin.GoogleSignInResult
            com.google.android.gms.common.api.Status r7 = new com.google.android.gms.common.api.Status
            r8 = 4
            r7.<init>(r8)
            r6.<init>(r1, r7)
            com.google.android.gms.common.api.OptionalPendingResult r5 = com.google.android.gms.common.api.PendingResults.immediatePendingResult(r6, r5)
            return r5
        Laa:
            com.google.android.gms.common.logging.Logger r8 = com.google.android.gms.auth.api.signin.internal.zzh.f1267a
            java.lang.String r0 = "trySilentSignIn()"
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r8.d(r0, r1)
            com.google.android.gms.auth.api.signin.internal.a r8 = new com.google.android.gms.auth.api.signin.internal.a
            r8.<init>(r5, r6, r7)
            com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl r5 = r5.enqueue(r8)
            com.google.android.gms.common.api.internal.OptionalPendingResultImpl r6 = new com.google.android.gms.common.api.internal.OptionalPendingResultImpl
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzh.zzc(com.google.android.gms.common.api.GoogleApiClient, android.content.Context, com.google.android.gms.auth.api.signin.GoogleSignInOptions, boolean):com.google.android.gms.common.api.OptionalPendingResult");
    }

    public static PendingResult<Status> zzc(GoogleApiClient googleApiClient, Context context, boolean z) {
        f1267a.d("Signing out", new Object[0]);
        a(context);
        if (z) {
            return PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClient);
        }
        return googleApiClient.execute(new c(googleApiClient));
    }

    public static PendingResult<Status> zzd(GoogleApiClient googleApiClient, Context context, boolean z) {
        f1267a.d("Revoking access", new Object[0]);
        String savedRefreshToken = Storage.getInstance(context).getSavedRefreshToken();
        a(context);
        if (z) {
            return zzd.zzc(savedRefreshToken);
        }
        return googleApiClient.execute(new e(googleApiClient));
    }

    private static void a(Context context) {
        zzp.zzd(context).clear();
        Iterator<GoogleApiClient> it = GoogleApiClient.getAllClients().iterator();
        while (it.hasNext()) {
            it.next().maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
    }

    public static GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount")) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.RESULT_SUCCESS;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }
}
