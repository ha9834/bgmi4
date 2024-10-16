package com.ihoc.mgpa.n;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.view.Display;
import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f5669a = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};

    public static int a(int i) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/sys/devices/system/cpu/cpu");
            sb.append(i);
            sb.append("/cpufreq/scaling_cur_freq");
            String j = i.j(sb.toString());
            if (j != null) {
                return Integer.parseInt(j) / 1000;
            }
        } catch (Exception unused) {
            m.a("parse cpu freq num to int exception. ", new Object[0]);
        }
        return -1;
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            m.a("can not find app: %s , get version code failed.", str);
            return 0;
        }
    }

    public static String a() {
        String str;
        try {
            str = i.a("/proc/cpuinfo", "Hardware");
        } catch (Exception unused) {
            m.b("TGPA", "DeviceUtil:getCPU: Could not open file /proc/cpuinfo");
            str = null;
        }
        return p.b(str) ? q.a("ro.hardware", null) : str.substring(str.indexOf(58, str.indexOf("Hardware")) + 1).trim();
    }

    public static boolean a(String str) {
        try {
            return a.a().getPackageManager().checkPermission(str, a.a().getPackageName()) != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean a(String str, Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Exception unused) {
            m.b("TGPA", "App doesn't exsit, package_name:  " + str);
            return false;
        }
    }

    public static int b() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new e()).length;
        } catch (Exception unused) {
            m.a("parse cpu num from cpu list exception. ", new Object[0]);
            return 0;
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            m.a("can not find app: %s , get version name failed.", str);
            str2 = null;
        }
        return str2 == null ? "0" : str2;
    }

    public static boolean b(int i) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/sys/devices/system/cpu/cpu");
            sb.append(i);
            sb.append("/online");
            String j = i.j(sb.toString());
            if (j != null) {
                if (Integer.parseInt(j) == 0) {
                    return false;
                }
            }
        } catch (Exception unused) {
            m.a("parse cpu online to int exception. ", new Object[0]);
        }
        return true;
    }

    public static int c(Context context) {
        int i = 60;
        if (Build.VERSION.SDK_INT < 23) {
            return 60;
        }
        try {
            Display display = ((DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)).getDisplay(0);
            if (display == null) {
                return 60;
            }
            int refreshRate = (int) display.getMode().getRefreshRate();
            try {
                if (Math.abs(refreshRate - 60) < 5) {
                    return 60;
                }
                if (Math.abs(refreshRate - 90) < 5) {
                    return 90;
                }
                if (Math.abs(refreshRate - 120) < 5) {
                    return 120;
                }
                return refreshRate;
            } catch (Exception e) {
                e = e;
                i = refreshRate;
                e.printStackTrace();
                m.b("get device current refreshRate exception.", new Object[0]);
                return i;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String c() {
        return Build.MANUFACTURER;
    }

    public static int d(Context context) {
        int i = 60;
        if (Build.VERSION.SDK_INT < 23) {
            return 60;
        }
        try {
            Display display = ((DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)).getDisplay(0);
            if (display == null) {
                return 60;
            }
            int i2 = 60;
            for (Display.Mode mode : display.getSupportedModes()) {
                try {
                    int refreshRate = (int) mode.getRefreshRate();
                    if (refreshRate > i2) {
                        i2 = refreshRate;
                    }
                } catch (Exception e) {
                    e = e;
                    i = i2;
                    e.printStackTrace();
                    m.b("get device support refreshRate exception.", new Object[0]);
                    return i;
                }
            }
            if (Math.abs(i2 - 60) < 5) {
                return 60;
            }
            if (Math.abs(i2 - 90) < 5) {
                return 90;
            }
            if (Math.abs(i2 - 120) < 5) {
                return 120;
            }
            return i2;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String d() {
        return com.ihoc.mgpa.l.a.a();
    }

    public static String e(Context context) {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(Uri.fromFile(new File("foo.apk")), "application/vnd.android.package-archive");
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(queryIntentActivities.get(0).activityInfo.packageName, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean e() {
        for (String str : f5669a) {
            File file = new File(str + "su");
            if (file.isFile() && file.exists()) {
                return true;
            }
        }
        return false;
    }
}
