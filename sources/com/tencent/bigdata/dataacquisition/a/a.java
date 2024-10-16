package com.tencent.bigdata.dataacquisition.a;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.appevents.UserDataStore;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.io.FileFilter;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f6154a = null;
    private static DisplayMetrics b = null;
    private static int c = -1;
    private static long d = -1;
    private static C0180a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.bigdata.dataacquisition.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0180a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.bigdata.dataacquisition.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0181a implements FileFilter {
            C0181a() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        }

        C0180a() {
        }

        static int a() {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new C0181a()).length;
            } catch (Exception e) {
                e.printStackTrace();
                return 1;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x004f, code lost:
        
            if (r1 != null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
        
            return r0 * 1000;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
        
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
        
            if (r1 == null) goto L19;
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static int b() {
            /*
                r0 = 0
                r1 = 0
                java.lang.String r2 = ""
                r3 = 2
                java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r4 = "/system/bin/cat"
                r3[r0] = r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r4 = 1
                java.lang.String r5 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
                r3[r4] = r5     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.ProcessBuilder r4 = new java.lang.ProcessBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r4.<init>(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.Process r3 = r4.start()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.io.InputStream r1 = r3.getInputStream()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r3 = 24
                byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            L21:
                int r4 = r1.read(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r5 = -1
                if (r4 == r5) goto L3d
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r4.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r4.append(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r4.append(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                goto L21
            L3d:
                java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                int r3 = r2.length()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                if (r3 <= 0) goto L4f
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                int r0 = r2.intValue()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            L4f:
                if (r1 == 0) goto L60
            L51:
                r1.close()     // Catch: java.lang.Exception -> L60
                goto L60
            L55:
                r0 = move-exception
                goto L63
            L57:
                r2 = move-exception
                java.lang.String r3 = "getMaxCpuFreq err"
                com.tencent.bigdata.dataacquisition.b.a.a(r3, r2)     // Catch: java.lang.Throwable -> L55
                if (r1 == 0) goto L60
                goto L51
            L60:
                int r0 = r0 * 1000
                return r0
            L63:
                if (r1 == 0) goto L68
                r1.close()     // Catch: java.lang.Exception -> L68
            L68:
                throw r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.dataacquisition.a.a.C0180a.b():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x004f, code lost:
        
            if (r1 != null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
        
            return r0 * 1000;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
        
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        
            if (r1 == null) goto L19;
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static int c() {
            /*
                r0 = 0
                r1 = 0
                java.lang.String r2 = ""
                r3 = 2
                java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                java.lang.String r4 = "/system/bin/cat"
                r3[r0] = r4     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                r4 = 1
                java.lang.String r5 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"
                r3[r4] = r5     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                java.lang.ProcessBuilder r4 = new java.lang.ProcessBuilder     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                r4.<init>(r3)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                java.lang.Process r3 = r4.start()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                java.io.InputStream r1 = r3.getInputStream()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                r3 = 24
                byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            L21:
                int r4 = r1.read(r3)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                r5 = -1
                if (r4 == r5) goto L3d
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                r4.<init>()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                r4.append(r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                r4.append(r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                goto L21
            L3d:
                java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                int r3 = r2.length()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                if (r3 <= 0) goto L4f
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
                int r0 = r2.intValue()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            L4f:
                if (r1 == 0) goto L60
            L51:
                r1.close()     // Catch: java.lang.Exception -> L60
                goto L60
            L55:
                r0 = move-exception
                goto L63
            L57:
                r2 = move-exception
                java.lang.String r3 = "getMinCpuFreq"
                com.tencent.bigdata.dataacquisition.b.a.a(r3, r2)     // Catch: java.lang.Throwable -> L55
                if (r1 == 0) goto L60
                goto L51
            L60:
                int r0 = r0 * 1000
                return r0
            L63:
                if (r1 == 0) goto L68
                r1.close()     // Catch: java.lang.Exception -> L68
            L68:
                throw r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.dataacquisition.a.a.C0180a.c():int");
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static java.lang.String d() {
            /*
                r0 = 0
                java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L32
                java.lang.String r2 = "/proc/cpuinfo"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L32
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L32
                r2.<init>(r1)     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L32
                java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L40
                boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L40
                if (r1 != 0) goto L28
                java.lang.String r1 = ":\\s+"
                r3 = 2
                java.lang.String[] r0 = r0.split(r1, r3)     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L40
                int r1 = r0.length     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L40
                if (r1 <= 0) goto L28
                r1 = 1
                r0 = r0[r1]     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L40
                r2.close()     // Catch: java.lang.Exception -> L27
            L27:
                return r0
            L28:
                r2.close()     // Catch: java.lang.Exception -> L3d
                goto L3d
            L2c:
                r0 = move-exception
                goto L35
            L2e:
                r1 = move-exception
                r2 = r0
                r0 = r1
                goto L41
            L32:
                r1 = move-exception
                r2 = r0
                r0 = r1
            L35:
                java.lang.String r1 = "getCpuName"
                com.tencent.bigdata.dataacquisition.b.a.a(r1, r0)     // Catch: java.lang.Throwable -> L40
                if (r2 == 0) goto L3d
                goto L28
            L3d:
                java.lang.String r0 = ""
                return r0
            L40:
                r0 = move-exception
            L41:
                if (r2 == 0) goto L46
                r2.close()     // Catch: java.lang.Exception -> L46
            L46:
                throw r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.dataacquisition.a.a.C0180a.d():java.lang.String");
        }
    }

    /* loaded from: classes2.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static int f6155a = -1;

        public static boolean a() {
            int i = f6155a;
            if (i == 1) {
                return true;
            }
            if (i == 0) {
                return false;
            }
            for (String str : new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"}) {
                try {
                    if (new File(str + "su").exists()) {
                        f6155a = 1;
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            f6155a = 0;
            return false;
        }
    }

    public static Integer a(Context context) {
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

    public static String a() {
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            return "Intel";
        }
        try {
            byte[] bArr = new byte[1024];
            new RandomAccessFile("/proc/cpuinfo", AnalyticsEventKey.SMART_INTENT_SEARCH_RANK).read(bArr);
            String str = new String(bArr);
            int indexOf = str.indexOf(0);
            return indexOf != -1 ? str.substring(0, indexOf) : str;
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.a("getCpuString", th);
            return "";
        }
    }

    public static String b() {
        String str;
        StringBuilder sb;
        String str2;
        String a2 = a();
        if (a2.contains("ARMv5")) {
            str = "armv5";
        } else if (a2.contains("ARMv6")) {
            str = "armv6";
        } else if (a2.contains("ARMv7")) {
            str = "armv7";
        } else {
            if (!a2.contains("Intel")) {
                return "unknown";
            }
            str = "x86";
        }
        if (a2.contains("neon")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_neon";
        } else if (a2.contains("vfpv3")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_vfpv3";
        } else if (a2.contains(" vfp")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_vfp";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_none";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (!com.tencent.bigdata.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return true;
            }
            com.tencent.bigdata.dataacquisition.b.a.a("Network error");
            return false;
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.a("isNetworkAvailable error", th);
            return false;
        }
    }

    public static byte c(Context context) {
        if (context != null) {
            try {
                if (com.tencent.bigdata.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        return (byte) 0;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                        if (activeNetworkInfo.getType() == 1) {
                            return (byte) 1;
                        }
                        if (activeNetworkInfo.getType() != 0) {
                            return (byte) 0;
                        }
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return (byte) 2;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 15:
                                return (byte) 3;
                            case 12:
                            case 14:
                            default:
                                return (byte) 0;
                            case 13:
                                return (byte) 4;
                        }
                    }
                    return (byte) -1;
                }
            } catch (Exception e2) {
                com.tencent.bigdata.dataacquisition.b.a.a("getNetworkType: ", e2);
            }
        }
        return (byte) -1;
    }

    public static String c() {
        long d2 = d() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return String.valueOf((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1000000) + "/" + String.valueOf(d2);
    }

    public static long d() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (com.tencent.bigdata.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                return "WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName());
            }
            return false;
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.a("Check isWiFiActive error", th);
            return false;
        }
    }

    public static String e(Context context) {
        String str = null;
        try {
            if (com.tencent.bigdata.dataacquisition.b.a.a(context, "android.permission.INTERNET") && com.tencent.bigdata.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            extraInfo = "WIFI";
                        } else if (typeName.equalsIgnoreCase("MOBILE")) {
                            if (extraInfo == null) {
                                extraInfo = "MOBILE";
                            }
                        } else if (extraInfo == null) {
                            str = typeName;
                        }
                        str = extraInfo;
                    }
                }
            } else {
                com.tencent.bigdata.dataacquisition.b.a.b("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            }
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.b(th);
        }
        return str;
    }

    public static boolean e() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e2) {
            com.tencent.bigdata.dataacquisition.b.a.a("isSDCardMounted", e2);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r0 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long f() {
        /*
            long r0 = com.tencent.bigdata.dataacquisition.a.a.d
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L9
            return r0
        L9:
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L42
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L42
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L42
            r5 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L42
            java.lang.String r1 = r0.readLine()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            java.lang.String r4 = "\\s+"
            java.lang.String[] r1 = r1.split(r4)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r4 = 1
            r1 = r1[r4]     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            int r1 = r1 * 1024
            long r2 = (long) r1
        L30:
            r0.close()     // Catch: java.lang.Exception -> L46
            goto L46
        L34:
            r1 = move-exception
            goto L3c
        L36:
            goto L43
        L38:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L3c:
            if (r0 == 0) goto L41
            r0.close()     // Catch: java.lang.Exception -> L41
        L41:
            throw r1
        L42:
            r0 = r1
        L43:
            if (r0 == 0) goto L46
            goto L30
        L46:
            com.tencent.bigdata.dataacquisition.a.a.d = r2
            long r0 = com.tencent.bigdata.dataacquisition.a.a.d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.dataacquisition.a.a.f():long");
    }

    public static DisplayMetrics f(Context context) {
        if (b == null) {
            b = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(b);
        }
        return b;
    }

    public static String g(Context context) {
        if (f6154a == null) {
            f6154a = Build.MODEL;
        }
        return f6154a;
    }

    public static boolean h(Context context) {
        return ((SensorManager) context.getSystemService("sensor")) != null;
    }

    public static int i(Context context) {
        int i = c;
        if (i >= 0) {
            return i;
        }
        try {
            return b.a() ? 1 : 0;
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.a("call hasRootAccess Error:", th);
            return 0;
        }
    }

    public static String j(Context context) {
        String path;
        try {
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.a("getExternalStorageInfo err:", th);
        }
        if (!com.tencent.bigdata.dataacquisition.b.a.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.tencent.bigdata.dataacquisition.b.a.a("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted") && (path = Environment.getExternalStorageDirectory().getPath()) != null) {
            StatFs statFs = new StatFs(path);
            return String.valueOf((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000000) + "/" + String.valueOf((statFs.getBlockCount() * statFs.getBlockSize()) / 1000000);
        }
        return null;
    }

    public static int k(Context context) {
        if (!com.tencent.bigdata.dataacquisition.b.a.a(context, "android.permission.BLUETOOTH")) {
            return 0;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return -1;
        }
        return defaultAdapter.isEnabled() ? 1 : 0;
    }

    public static String l(Context context) {
        return String.valueOf(p(context) / 1000000) + "/" + String.valueOf(f() / 1000000);
    }

    public static JSONObject m(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            q(context);
            int b2 = C0180a.b();
            if (b2 > 0) {
                jSONObject.put("fx", b2 / 1000000);
            }
            q(context);
            int c2 = C0180a.c();
            if (c2 > 0) {
                jSONObject.put(UserDataStore.FIRST_NAME, c2 / 1000000);
            }
            q(context);
            int a2 = C0180a.a();
            if (a2 > 0) {
                jSONObject.put(AnalyticsEventKey.FAQ_SEARCH_RESULT_COUNT, a2);
            }
            q(context);
            String d2 = C0180a.d();
            if (d2 != null && d2.length() == 0) {
                q(context);
                jSONObject.put("na", C0180a.d());
            }
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.a("getCpuInfo", th);
        }
        return jSONObject;
    }

    public static String n(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sensorList.size(); i++) {
                sb.append(sensorList.get(i).getType());
                if (i != sensorList.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.a("getAllSensors", th);
            return "";
        }
    }

    public static JSONArray o(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < sensorList.size(); i++) {
                Sensor sensor = sensorList.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", sensor.getName());
                jSONObject.put("vendor", sensor.getVendor());
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Throwable th) {
            com.tencent.bigdata.dataacquisition.b.a.a("getSensors:" + th.toString());
            return null;
        }
    }

    private static long p(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static synchronized C0180a q(Context context) {
        C0180a c0180a;
        synchronized (a.class) {
            if (e == null) {
                e = new C0180a();
            }
            c0180a = e;
        }
        return c0180a;
    }
}
