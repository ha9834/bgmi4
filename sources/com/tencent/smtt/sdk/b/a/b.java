package com.tencent.smtt.sdk.b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import com.facebook.internal.ServerProtocol;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedInputStream;
import java.util.Map;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f6509a;
    private ResolveInfo b;
    private Drawable c;
    private String d;
    private String e;
    private int f;

    public Drawable a(Map<String, Drawable> map) {
        Drawable a2 = a(this.f6509a, c());
        if (a2 != null) {
            return a2;
        }
        ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.loadIcon(this.f6509a.getPackageManager());
        }
        return this.c;
    }

    public String a() {
        ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.loadLabel(this.f6509a.getPackageManager()).toString();
        }
        return this.d;
    }

    public ResolveInfo b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, ResolveInfo resolveInfo) {
        this.f = 0;
        this.f6509a = context.getApplicationContext();
        this.b = resolveInfo;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Drawable drawable, String str, String str2) {
        this.f = 0;
        this.f6509a = context.getApplicationContext();
        this.b = null;
        this.c = drawable;
        this.d = str;
        this.e = str2;
    }

    public String c() {
        ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.activityInfo.packageName;
        }
        String str = this.e;
        return str == null ? "" : str;
    }

    public void a(ResolveInfo resolveInfo) {
        this.b = resolveInfo;
    }

    public static Drawable a(Context context, String str) {
        if (TbsConfig.APP_QB.equals(str)) {
            try {
                return d.a("application_icon");
            } catch (Throwable th) {
                Log.e("error", "getApkIcon Error:" + Log.getStackTraceString(th));
                return null;
            }
        }
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            TypedValue typedValue = new TypedValue();
            resourcesForApplication.getValue(applicationInfo.icon, typedValue, true);
            try {
                return Drawable.createFromResourceStream(resourcesForApplication, typedValue, new BufferedInputStream(resourcesForApplication.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString()).createInputStream()), null);
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e) {
            Log.e(ServerProtocol.DIALOG_PARAM_SDK_VERSION, "e = " + e);
            return null;
        }
    }
}
