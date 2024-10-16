package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    private static final a b = new a(null);

    @VisibleForTesting
    private static int c = b.f1249a;

    /* loaded from: classes.dex */
    private static class a implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private a() {
        }

        @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
        public final /* synthetic */ GoogleSignInAccount convert(GoogleSignInResult googleSignInResult) {
            return googleSignInResult.getSignInAccount();
        }

        /* synthetic */ a(c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public enum b {

        /* renamed from: a, reason: collision with root package name */
        public static final int f1249a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {f1249a, b, c, d};

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new ApiExceptionMapper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    private final synchronized int b() {
        if (c == b.f1249a) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0) {
                c = b.d;
            } else if (googleApiAvailability.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, null) == null && DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") != 0) {
                c = b.c;
            } else {
                c = b.b;
            }
        }
        return c;
    }

    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        switch (c.f1255a[b() - 1]) {
            case 1:
                return zzh.zzd(applicationContext, getApiOptions());
            case 2:
                return zzh.zzc(applicationContext, getApiOptions());
            default:
                return zzh.zze(applicationContext, getApiOptions());
        }
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        return PendingResultUtil.toTask(zzh.zzc(asGoogleApiClient(), getApplicationContext(), getApiOptions(), b() == b.c), b);
    }

    public Task<Void> signOut() {
        return PendingResultUtil.toVoidTask(zzh.zzc(asGoogleApiClient(), getApplicationContext(), b() == b.c));
    }

    public Task<Void> revokeAccess() {
        return PendingResultUtil.toVoidTask(zzh.zzd(asGoogleApiClient(), getApplicationContext(), b() == b.c));
    }
}
