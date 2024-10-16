package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* loaded from: classes.dex */
public final class zzb {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f1147a;

    public zzb(Context context) {
        try {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            this.f1147a = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f1147a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float a(String str, float f) {
        try {
            if (this.f1147a == null) {
                return 0.0f;
            }
            return this.f1147a.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(String str, String str2) {
        try {
            return this.f1147a == null ? str2 : this.f1147a.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        try {
            if (this.f1147a == null) {
                return false;
            }
            return this.f1147a.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}
