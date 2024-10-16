package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class gl implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(zzazm zzazmVar, Context context) {
        this.f2193a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences = this.f2193a.getSharedPreferences("admob_user_agent", 0);
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzawz.zzds("User agent is not initialized on Google Play Services. Initializing.");
            String defaultUserAgent = WebSettings.getDefaultUserAgent(this.f2193a);
            SharedPreferencesUtils.publishWorldReadableSharedPreferences(this.f2193a, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
            return defaultUserAgent;
        }
        zzawz.zzds("User agent is already initialized on Google Play Services.");
        return string;
    }
}
