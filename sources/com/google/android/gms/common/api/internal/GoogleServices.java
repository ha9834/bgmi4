package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public final class GoogleServices {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1314a = new Object();

    @GuardedBy("sLock")
    private static GoogleServices b;
    private final String c;
    private final Status d;
    private final boolean e;
    private final boolean f;

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            r3 = resources.getInteger(identifier) != 0;
            this.f = !r3;
        } else {
            this.f = false;
        }
        this.e = r3;
        String zzc = zzp.zzc(context);
        zzc = zzc == null ? new StringResourceValueReader(context).getString("google_app_id") : zzc;
        if (TextUtils.isEmpty(zzc)) {
            this.d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.c = null;
        } else {
            this.c = zzc;
            this.d = Status.RESULT_SUCCESS;
        }
    }

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(String str, boolean z) {
        this.c = str;
        this.d = Status.RESULT_SUCCESS;
        this.e = z;
        this.f = !z;
    }

    @KeepForSdk
    public static Status initialize(Context context, String str, boolean z) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (f1314a) {
            if (b != null) {
                return b.a(str);
            }
            GoogleServices googleServices = new GoogleServices(str, z);
            b = googleServices;
            return googleServices.d;
        }
    }

    @VisibleForTesting
    @KeepForSdk
    final Status a(String str) {
        String str2 = this.c;
        if (str2 != null && !str2.equals(str)) {
            String str3 = this.c;
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 97);
            sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
            sb.append(str3);
            sb.append("'.");
            return new Status(10, sb.toString());
        }
        return Status.RESULT_SUCCESS;
    }

    @KeepForSdk
    public static Status initialize(Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (f1314a) {
            if (b == null) {
                b = new GoogleServices(context);
            }
            status = b.d;
        }
        return status;
    }

    @KeepForSdk
    public static String getGoogleAppId() {
        return b("getGoogleAppId").c;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices b2 = b("isMeasurementEnabled");
        return b2.d.isSuccess() && b2.e;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return b("isMeasurementExplicitlyDisabled").f;
    }

    @KeepForSdk
    private static GoogleServices b(String str) {
        GoogleServices googleServices;
        synchronized (f1314a) {
            if (b == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
            googleServices = b;
        }
        return googleServices;
    }
}
