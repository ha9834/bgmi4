package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class zl implements zzcva<zzcvf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f2665a;
    private final Context b;

    public zl(zzbbl zzbblVar, Context context) {
        this.f2665a = zzbblVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvf> zzalm() {
        return this.f2665a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zm

            /* renamed from: a, reason: collision with root package name */
            private final zl f2666a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2666a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2666a.a();
            }
        });
    }

    private static String a(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = packageInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo a2 = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a2 == null || (activityInfo = a2.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = activityInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcvf a() throws Exception {
        boolean z;
        PackageManager packageManager = this.b.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = a(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = a(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
        boolean isLatchsky = DeviceProperties.isLatchsky(this.b);
        boolean isSidewinder = DeviceProperties.isSidewinder(this.b);
        String language = locale.getLanguage();
        String a2 = a(this.b, packageManager);
        String a3 = a(this.b);
        String str = Build.FINGERPRINT;
        Context context = this.b;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzdtv.zzbu(context));
                        break;
                    }
                }
            }
        }
        z = false;
        return new zzcvf(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, a2, a3, str, z, Build.MODEL);
    }
}
