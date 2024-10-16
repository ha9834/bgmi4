package com.tencent.msdk.stat.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.adjust.sdk.Constants;
import com.facebook.appevents.UserDataStore;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.util.ErrorReportProvider;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.msdk.stat.StatConfig;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static String f6324a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static Random e = null;
    private static DisplayMetrics f = null;
    private static String g = null;
    private static String h = "";
    private static String i = "";
    private static volatile int j = -1;
    private static StatLogger k = null;
    private static String l = null;
    private static String m = null;
    private static volatile int n = -1;
    private static String o = null;
    private static String p = null;
    private static long q = -1;
    private static String r = "";
    private static m s = null;
    private static String t = "__MTA_FIRST_ACTIVATE__";
    private static int u = -1;
    private static long v = -1;
    private static int w = 0;
    private static String x = "";
    private static volatile String y;

    public static boolean A(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.startsWith(packageName)) {
                return runningAppProcessInfo.importance == 400;
            }
        }
        return false;
    }

    public static String B(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) {
            return null;
        }
        return resolveActivity.activityInfo.packageName;
    }

    private static long C(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static int a() {
        return g().nextInt(Integer.MAX_VALUE);
    }

    public static int a(Context context, boolean z) {
        if (z) {
            w = z(context);
        }
        return w;
    }

    public static Long a(String str, String str2, int i2, int i3, Long l2) {
        if (str != null && str2 != null) {
            if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
                str2 = "\\" + str2;
            }
            String[] split = str.split(str2);
            if (split.length == i3) {
                try {
                    Long l3 = 0L;
                    for (String str3 : split) {
                        l3 = Long.valueOf(i2 * (l3.longValue() + Long.valueOf(str3).longValue()));
                    }
                    return l3;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l2;
    }

    public static String a(int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.roll(6, i2);
        return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
    }

    public static String a(long j2) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j2));
    }

    public static String a(Context context, String str) {
        if (StatConfig.isEnableConcurrentProcess()) {
            if (m == null) {
                m = p(context);
            }
            if (m != null) {
                return str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + m;
            }
        }
        return str;
    }

    public static String a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static HttpHost a(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            k.e(th);
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0 || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return null;
        }
        if ((activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) || (extraInfo = activeNetworkInfo.getExtraInfo()) == null) {
            return null;
        }
        if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap")) {
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        }
        return new HttpHost("10.0.0.172", 80);
    }

    public static void a(Context context, int i2) {
        w = i2;
        o.b(context, "mta.qq.com.difftime", i2);
    }

    public static boolean a(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (statSpecifyReportedInfo == null) {
            return false;
        }
        return c(statSpecifyReportedInfo.getAppKey());
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static long b(String str) {
        return a(str, ".", 100, 3, 0L).longValue();
    }

    public static synchronized StatLogger b() {
        StatLogger statLogger;
        synchronized (j.class) {
            if (k == null) {
                k = new StatLogger(StatConstants.LOG_TAG);
                k.setDebugEnable(false);
            }
            statLogger = k;
        }
        return statLogger;
    }

    public static synchronized String b(Context context) {
        synchronized (j.class) {
            if (f6324a != null && f6324a.trim().length() != 0) {
                return f6324a;
            }
            f6324a = p.a(context);
            if (f6324a == null || f6324a.trim().length() == 0) {
                f6324a = Integer.toString(g().nextInt(Integer.MAX_VALUE));
            }
            return f6324a;
        }
    }

    public static long c() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() + ErrorReportProvider.BATCH_TIME;
        } catch (Throwable th) {
            k.e(th);
            return System.currentTimeMillis() + ErrorReportProvider.BATCH_TIME;
        }
    }

    public static synchronized String c(Context context) {
        String str;
        synchronized (j.class) {
            if (c == null || c.trim().length() == 0) {
                c = p.b(context);
            }
            str = c;
        }
        return str;
    }

    public static boolean c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static DisplayMetrics d(Context context) {
        if (f == null) {
            f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f);
        }
        return f;
    }

    public static String d() {
        if (c(p)) {
            return p;
        }
        long e2 = e() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        p = String.valueOf((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1000000) + "/" + String.valueOf(e2);
        return p;
    }

    public static long e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static boolean e(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
        } catch (Throwable th) {
            k.e(th);
        }
        if (!p.a(context, "android.permission.ACCESS_WIFI_STATE")) {
            k.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i2 = 0; i2 < allNetworkInfo.length; i2++) {
                if (allNetworkInfo[i2].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i2].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String f(Context context) {
        String str = b;
        if (str != null) {
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("TA_APPKEY");
            if (string != null) {
                b = string;
                return string;
            }
            k.i("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            k.i("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String g(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            Object obj = applicationInfo.metaData.get("InstallChannel");
            if (obj != null) {
                return obj.toString();
            }
            k.w("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            k.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        }
    }

    private static synchronized Random g() {
        Random random;
        synchronized (j.class) {
            if (e == null) {
                e = new Random();
            }
            random = e;
        }
        return random;
    }

    private static long h() {
        long j2 = q;
        if (j2 > 0) {
            return j2;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            r1 = TextUtils.isEmpty(bufferedReader.readLine()) ? 1L : Integer.valueOf(r3.split("\\s+")[1]).intValue() * 1024;
            bufferedReader.close();
        } catch (Exception unused) {
        }
        q = r1;
        return q;
    }

    public static String h(Context context) {
        TelephonyManager telephonyManager;
        String str = g;
        if (str != null) {
            return str;
        }
        try {
            if (!p.a(context, "android.permission.READ_PHONE_STATE")) {
                k.e("Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (j(context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                g = telephonyManager.getSimOperator();
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return g;
    }

    public static String i(Context context) {
        if (c(h)) {
            return h;
        }
        try {
            h = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (h == null) {
                return "";
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return h;
    }

    public static boolean j(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static String k(Context context) {
        try {
            if (!p.a(context, "android.permission.INTERNET") || !p.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                k.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return "";
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (typeName == null) {
                return "";
            }
            if (typeName.equalsIgnoreCase("WIFI")) {
                extraInfo = "WIFI";
            } else if (typeName.equalsIgnoreCase("MOBILE")) {
                if (extraInfo == null || extraInfo.trim().length() <= 0) {
                    extraInfo = "MOBILE";
                }
            } else if (extraInfo == null || extraInfo.trim().length() <= 0) {
                return typeName;
            }
            return extraInfo;
        } catch (Throwable th) {
            k.e(th);
            return "";
        }
    }

    public static Integer l(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String m(Context context) {
        if (c(i)) {
            return i;
        }
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            k.e(th);
        }
        if (i == null) {
            return "unknown";
        }
        if (i.length() == 0) {
            return "unknown";
        }
        return i;
    }

    public static int n(Context context) {
        if (j > -1) {
            return j;
        }
        j = 0;
        synchronized (j.class) {
            try {
                if (n.a()) {
                    j = 1;
                }
            } catch (Throwable th) {
                k.e(th);
            }
        }
        return j;
    }

    public static String o(Context context) {
        String path;
        if (c(l)) {
            return l;
        }
        try {
        } catch (Throwable th) {
            k.e(th);
        }
        if (!p.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            k.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted") && (path = Environment.getExternalStorageDirectory().getPath()) != null) {
            StatFs statFs = new StatFs(path);
            long availableBlocks = (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000000;
            l = String.valueOf(availableBlocks) + "/" + String.valueOf((statFs.getBlockCount() * statFs.getBlockSize()) / 1000000);
            return l;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(Context context) {
        if (m != null) {
            return m;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                m = next.processName;
                break;
            }
        }
        return m;
    }

    public static String q(Context context) {
        return a(context, StatConstants.DATABASE_NAME);
    }

    public static synchronized Integer r(Context context) {
        Integer valueOf;
        synchronized (j.class) {
            if (n <= 0) {
                n = o.a(context, "MTA_EVENT_INDEX", 0);
                o.b(context, "MTA_EVENT_INDEX", n + 1000);
            } else if (n % 1000 == 0) {
                try {
                    int i2 = n + 1000;
                    if (n >= 2147383647) {
                        i2 = 0;
                    }
                    o.b(context, "MTA_EVENT_INDEX", i2);
                } catch (Throwable th) {
                    k.w(th);
                }
            }
            n++;
            valueOf = Integer.valueOf(n);
        }
        return valueOf;
    }

    public static String s(Context context) {
        try {
            return String.valueOf(C(context) / 1000000) + "/" + String.valueOf(h() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static JSONObject t(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AnalyticsEventKey.FAQ_SEARCH_RESULT_COUNT, k.a());
            String d2 = k.d();
            if (d2 != null && d2.length() > 0) {
                jSONObject.put("na", d2);
            }
            int b2 = k.b();
            if (b2 > 0) {
                jSONObject.put("fx", b2 / 1000000);
            }
            int c2 = k.c();
            if (c2 > 0) {
                jSONObject.put(UserDataStore.FIRST_NAME, c2 / 1000000);
            }
        } catch (Throwable th) {
            Log.w(StatConstants.LOG_TAG, "get cpu error", th);
        }
        return jSONObject;
    }

    public static String u(Context context) {
        List<Sensor> sensorList;
        if (c(r)) {
            return r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                StringBuilder sb = new StringBuilder(sensorList.size() * 10);
                for (int i2 = 0; i2 < sensorList.size(); i2++) {
                    sb.append(sensorList.get(i2).getType());
                    if (i2 != sensorList.size() - 1) {
                        sb.append(",");
                    }
                }
                r = sb.toString();
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return r;
    }

    public static synchronized int v(Context context) {
        synchronized (j.class) {
            if (u != -1) {
                return u;
            }
            w(context);
            return u;
        }
    }

    public static void w(Context context) {
        u = o.a(context, t, 1);
        if (u == 1) {
            o.b(context, t, 0);
        }
    }

    public static boolean x(Context context) {
        if (v < 0) {
            v = o.a(context, "mta.qq.com.checktime", 0L);
        }
        return Math.abs(System.currentTimeMillis() - v) > ErrorReportProvider.BATCH_TIME;
    }

    public static void y(Context context) {
        v = System.currentTimeMillis();
        o.b(context, "mta.qq.com.checktime", v);
    }

    public static int z(Context context) {
        return o.a(context, "mta.qq.com.difftime", 0);
    }
}
