package com.ihoc.mgpa.n;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f5664a;

    public static Context a() {
        if (f5664a == null) {
            try {
                f5664a = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        if (f5664a == null) {
            m.b("TGPA", "AppUtil: context is null! U should init sdk first.");
        }
        return f5664a;
    }

    private static String a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Exception unused) {
            m.b("TGPA", "GetMetaString exception");
            return null;
        }
    }

    public static String a(String str) {
        Context context = f5664a;
        if (context != null) {
            return a(context, str);
        }
        m.b("TGPA", "GetMetaString application context is null. ");
        return null;
    }

    public static void a(Context context) {
        if (context != null) {
            f5664a = context.getApplicationContext();
        }
    }

    public static String b() {
        Context context = f5664a;
        if (context == null) {
            return "";
        }
        File file = null;
        try {
            file = context.getExternalFilesDir("");
        } catch (Exception e) {
            e.printStackTrace();
            m.b("TGPA", "getAppExFilesDir exception");
        }
        return file == null ? "" : file.getPath();
    }

    public static String c() {
        Context context = f5664a;
        return context == null ? "" : context.getPackageName();
    }

    public static Class<?> d() {
        Context a2 = a();
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo resolveInfo : a2.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.equals(a2.getPackageName())) {
                try {
                    return Class.forName(resolveInfo.activityInfo.name);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String e() {
        return b() + File.separator + "TGPA";
    }

    public static String f() {
        return e() + File.separator + "Log";
    }

    public static String g() {
        return e() + File.separator + "PreDownload";
    }
}
