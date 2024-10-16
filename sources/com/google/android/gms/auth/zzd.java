package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f1274a = {"com.google", "com.google.work", "cn.google"};

    @SuppressLint({"InlinedApi"})
    public static final String KEY_CALLER_UID = "callerUid";

    @SuppressLint({"InlinedApi"})
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    private static final ComponentName b = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final Logger c = new Logger("Auth", "GoogleAuthUtil");

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        a(account);
        return zzb(context, account, str, bundle).zzb();
    }

    public static TokenData zzb(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        Preconditions.checkNotEmpty(str, "Scope cannot be empty or null.");
        a(account);
        a(context, 8400000);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) a(context, b, new a(account, str, bundle2));
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        a(context, 8400000);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        a(context, b, new b(str, bundle));
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        a(context, 8400000);
        return (List) a(context, b, new c(str, i));
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        a(context, 8400000);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        a(account);
        a(context, 8400000);
        return (Bundle) a(context, b, new d(account));
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        a(context, 11400000);
        return (Boolean) a(context, b, new e(context.getApplicationInfo().packageName));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void a(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (TextUtils.isEmpty(account.name)) {
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
        for (String str : f1274a) {
            if (str.equals(account.type)) {
                return;
            }
        }
        throw new IllegalArgumentException("Account type not supported");
    }

    private static void a(Context context, int i) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (GooglePlayServicesNotAvailableException e) {
            throw new GoogleAuthException(e.getMessage());
        } catch (GooglePlayServicesRepairableException e2) {
            throw new GooglePlayServicesAvailabilityException(e2.getConnectionStatusCode(), e2.getMessage(), e2.getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T b(T t) throws IOException {
        if (t != null) {
            return t;
        }
        c.w("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }

    private static <T> T a(Context context, ComponentName componentName, f<T> fVar) throws IOException, GoogleAuthException {
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        try {
            if (gmsClientSupervisor.bindService(componentName, blockingServiceConnection, "GoogleAuthUtil")) {
                try {
                    return fVar.a(blockingServiceConnection.getService());
                } catch (RemoteException | InterruptedException e) {
                    c.i("GoogleAuthUtil", "Error on service connection.", e);
                    throw new IOException("Error on service connection.", e);
                }
            }
            throw new IOException("Could not bind to service.");
        } finally {
            gmsClientSupervisor.unbindService(componentName, blockingServiceConnection, "GoogleAuthUtil");
        }
    }
}
