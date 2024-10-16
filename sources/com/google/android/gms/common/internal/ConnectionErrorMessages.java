package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class ConnectionErrorMessages {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("sCache")
    private static final androidx.b.g<String, String> f1447a = new androidx.b.g<>();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getErrorTitle(android.content.Context r3, int r4) {
        /*
            android.content.res.Resources r0 = r3.getResources()
            r1 = 20
            if (r4 == r1) goto L90
            r1 = 0
            switch(r4) {
                case 1: goto L89;
                case 2: goto L82;
                case 3: goto L7b;
                case 4: goto L7a;
                case 5: goto L6c;
                case 6: goto L7a;
                case 7: goto L5e;
                case 8: goto L56;
                case 9: goto L4e;
                case 10: goto L46;
                case 11: goto L3e;
                default: goto Lc;
            }
        Lc:
            switch(r4) {
                case 16: goto L36;
                case 17: goto L28;
                case 18: goto L7a;
                default: goto Lf;
            }
        Lf:
            java.lang.String r3 = "GoogleApiAvailability"
            r0 = 33
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "Unexpected error code "
            r2.append(r0)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            android.util.Log.e(r3, r4)
            return r1
        L28:
            java.lang.String r4 = "GoogleApiAvailability"
            java.lang.String r0 = "The specified account could not be signed in."
            android.util.Log.e(r4, r0)
            java.lang.String r4 = "common_google_play_services_sign_in_failed_title"
            java.lang.String r3 = a(r3, r4)
            return r3
        L36:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "One of the API components you attempted to connect to is not available."
            android.util.Log.e(r3, r4)
            return r1
        L3e:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "The application is not licensed to the user."
            android.util.Log.e(r3, r4)
            return r1
        L46:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "Developer error occurred. Please see logs for detailed information"
            android.util.Log.e(r3, r4)
            return r1
        L4e:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "Google Play services is invalid. Cannot recover."
            android.util.Log.e(r3, r4)
            return r1
        L56:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "Internal error occurred. Please see logs for detailed information"
            android.util.Log.e(r3, r4)
            return r1
        L5e:
            java.lang.String r4 = "GoogleApiAvailability"
            java.lang.String r0 = "Network error occurred. Please retry request later."
            android.util.Log.e(r4, r0)
            java.lang.String r4 = "common_google_play_services_network_error_title"
            java.lang.String r3 = a(r3, r4)
            return r3
        L6c:
            java.lang.String r4 = "GoogleApiAvailability"
            java.lang.String r0 = "An invalid account was specified when connecting. Please provide a valid account."
            android.util.Log.e(r4, r0)
            java.lang.String r4 = "common_google_play_services_invalid_account_title"
            java.lang.String r3 = a(r3, r4)
            return r3
        L7a:
            return r1
        L7b:
            int r3 = com.google.android.gms.base.R.string.common_google_play_services_enable_title
            java.lang.String r3 = r0.getString(r3)
            return r3
        L82:
            int r3 = com.google.android.gms.base.R.string.common_google_play_services_update_title
            java.lang.String r3 = r0.getString(r3)
            return r3
        L89:
            int r3 = com.google.android.gms.base.R.string.common_google_play_services_install_title
            java.lang.String r3 = r0.getString(r3)
            return r3
        L90:
            java.lang.String r4 = "GoogleApiAvailability"
            java.lang.String r0 = "The current user profile is restricted and could not use authenticated features."
            android.util.Log.e(r4, r0)
            java.lang.String r4 = "common_google_play_services_restricted_profile_title"
            java.lang.String r3 = a(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.ConnectionErrorMessages.getErrorTitle(android.content.Context, int):java.lang.String");
    }

    public static String getErrorNotificationTitle(Context context, int i) {
        String errorTitle;
        if (i == 6) {
            errorTitle = a(context, "common_google_play_services_resolution_required_title");
        } else {
            errorTitle = getErrorTitle(context, i);
        }
        return errorTitle == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : errorTitle;
    }

    public static String getErrorMessage(Context context, int i) {
        Resources resources = context.getResources();
        String appName = getAppName(context);
        if (i == 5) {
            return a(context, "common_google_play_services_invalid_account_text", appName);
        }
        if (i == 7) {
            return a(context, "common_google_play_services_network_error_text", appName);
        }
        if (i == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, appName);
        }
        if (i != 20) {
            switch (i) {
                case 1:
                    return resources.getString(R.string.common_google_play_services_install_text, appName);
                case 2:
                    return DeviceProperties.isWearableWithoutPlayStore(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, appName);
                case 3:
                    return resources.getString(R.string.common_google_play_services_enable_text, appName);
                default:
                    switch (i) {
                        case 16:
                            return a(context, "common_google_play_services_api_unavailable_text", appName);
                        case 17:
                            return a(context, "common_google_play_services_sign_in_failed_text", appName);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, appName);
                        default:
                            return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, appName);
                    }
            }
        }
        return a(context, "common_google_play_services_restricted_profile_text", appName);
    }

    public static String getErrorNotificationMessage(Context context, int i) {
        if (i == 6) {
            return a(context, "common_google_play_services_resolution_required_text", getAppName(context));
        }
        return getErrorMessage(context, i);
    }

    public static String getErrorDialogButtonMessage(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_button);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(android.R.string.ok);
        }
    }

    public static String getAppName(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    private static String a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a2 = a(context, str);
        if (a2 == null) {
            a2 = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a2, str2);
    }

    private static String a(Context context, String str) {
        synchronized (f1447a) {
            String str2 = f1447a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            f1447a.put(str, string);
            return string;
        }
    }

    public static String getDefaultNotificationChannelName(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    private ConnectionErrorMessages() {
    }
}
