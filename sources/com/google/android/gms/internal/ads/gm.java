package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class gm implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2194a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gm(zzazm zzazmVar, Context context, Context context2) {
        this.f2194a = context;
        this.b = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.f2194a != null) {
            zzawz.zzds("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.f2194a.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzawz.zzds("Attempting to read user agent from local cache.");
            sharedPreferences = this.b.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzawz.zzds("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.b);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzawz.zzds("Persisting user agent.");
            }
        }
        return string;
    }
}
