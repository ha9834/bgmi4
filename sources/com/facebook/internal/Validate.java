package com.facebook.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;

/* loaded from: classes.dex */
public final class Validate {
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    public static final String CUSTOM_TAB_REDIRECT_URI_PREFIX = "fbconnect://cct.";
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    public static final Validate INSTANCE = new Validate();
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    private static final String TAG;

    static {
        String name = Validate.class.getName();
        h.a((Object) name, "Validate::class.java.name");
        TAG = name;
    }

    private Validate() {
    }

    public static final void notNull(Object obj, String str) {
        h.b(str, "name");
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument '" + str + "' cannot be null");
    }

    public static final <T> void notEmpty(Collection<? extends T> collection, String str) {
        h.b(collection, "container");
        h.b(str, "name");
        if (!collection.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException(("Container '" + str + "' cannot be empty").toString());
    }

    public static final <T> void containsNoNulls(Collection<? extends T> collection, String str) {
        h.b(collection, "container");
        h.b(str, "name");
        notNull(collection, str);
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static final void containsNoNullOrEmpty(Collection<String> collection, String str) {
        h.b(collection, "container");
        h.b(str, "name");
        notNull(collection, str);
        for (String str2 : collection) {
            if (str2 == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
            if (!(str2.length() > 0)) {
                throw new IllegalArgumentException(("Container '" + str + "' cannot contain empty values").toString());
            }
        }
    }

    public static final <T> void notEmptyAndContainsNoNulls(Collection<? extends T> collection, String str) {
        h.b(collection, "container");
        h.b(str, "name");
        containsNoNulls(collection, str);
        notEmpty(collection, str);
    }

    public static final void runningOnUiThread() {
        if (!h.a(Looper.getMainLooper(), Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    public static final void notNullOrEmpty(String str, String str2) {
        h.b(str2, "name");
        if (!Utility.isNullOrEmpty(str)) {
            return;
        }
        throw new IllegalArgumentException(("Argument '" + str2 + "' cannot be null or empty").toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void oneOf(Object obj, String str, Object... objArr) {
        h.b(str, "name");
        h.b(objArr, "values");
        for (Object obj2 : objArr) {
            if (h.a(obj2, obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + str + "' was not one of the allowed values");
    }

    public static final void sdkInitialized() {
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    public static final String hasAppID() {
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.".toString());
    }

    public static final String hasClientToken() {
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.".toString());
    }

    public static final void hasInternetPermissions(Context context) {
        h.b(context, "context");
        hasInternetPermissions(context, true);
    }

    public static final void hasInternetPermissions(Context context, boolean z) {
        h.b(context, "context");
        notNull(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (!(!z)) {
                throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON.toString());
            }
            Log.w(TAG, NO_INTERNET_PERMISSION_REASON);
        }
    }

    public static final boolean hasWiFiPermission(Context context) {
        h.b(context, "context");
        return hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
    }

    public static final boolean hasChangeWifiStatePermission(Context context) {
        h.b(context, "context");
        return hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
    }

    public static final boolean hasLocationPermission(Context context) {
        h.b(context, "context");
        return hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static final boolean hasBluetoothPermission(Context context) {
        h.b(context, "context");
        return hasPermission(context, "android.permission.BLUETOOTH") && hasPermission(context, "android.permission.BLUETOOTH_ADMIN");
    }

    public static final boolean hasPermission(Context context, String str) {
        h.b(context, "context");
        h.b(str, "permission");
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static final void hasFacebookActivity(Context context) {
        h.b(context, "context");
        hasFacebookActivity(context, true);
    }

    @SuppressLint({"WrongConstant"})
    public static final void hasFacebookActivity(Context context, boolean z) {
        h.b(context, "context");
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfo = (ActivityInfo) null;
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (activityInfo == null) {
            if (!(!z)) {
                throw new IllegalStateException(FACEBOOK_ACTIVITY_NOT_FOUND_REASON.toString());
            }
            Log.w(TAG, FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
        }
    }

    public static final boolean hasCustomTabRedirectActivity(Context context, String str) {
        h.b(context, "context");
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = (List) null;
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            list = packageManager.queryIntentActivities(intent, 64);
        }
        if (list == null) {
            return false;
        }
        Iterator<ResolveInfo> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (!h.a((Object) activityInfo.name, (Object) "com.facebook.CustomTabActivity") || !h.a((Object) activityInfo.packageName, (Object) context.getPackageName())) {
                return false;
            }
            z = true;
        }
        return z;
    }

    public static final void hasContentProvider(Context context) {
        h.b(context, "context");
        notNull(context, "context");
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String str = CONTENT_PROVIDER_BASE + hasAppID;
            if (packageManager.resolveContentProvider(str, 0) != null) {
                return;
            }
            l lVar = l.f6973a;
            Object[] objArr = {str};
            String format = String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(format, *args)");
            throw new IllegalStateException(format.toString());
        }
    }
}
