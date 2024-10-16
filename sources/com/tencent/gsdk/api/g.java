package com.tencent.gsdk.api;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class g {
    public static int a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return Runtime.getRuntime().availableProcessors();
        }
        return m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    private static int m() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.c("getNumCoresOldPhones error:" + e.getMessage());
            return 1;
        }
    }

    public static String b() {
        double d;
        List<Double> a2 = a(a());
        if (a2 == null || a2.size() == 0) {
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            d = a2.get(0).doubleValue();
            for (Double d2 : a2) {
                if (d2.doubleValue() > d) {
                    d = d2.doubleValue();
                }
            }
        }
        return String.valueOf(d);
    }

    private static List<Double> a(int i) {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            String str = "0";
            InputStream inputStream = null;
            try {
                try {
                    inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq").start().getInputStream();
                    byte[] bArr = new byte[24];
                    while (inputStream.read(bArr) != -1) {
                        str = str + new String(bArr);
                    }
                    inputStream.close();
                    if (str != null && str.trim() != null) {
                        arrayList.add(Double.valueOf(Double.parseDouble(str.trim())));
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e = e;
                            sb = new StringBuilder();
                            sb.append("getCPUFreq close input stream error:");
                            sb.append(e.getMessage());
                            com.tencent.gsdk.utils.g.c(sb.toString());
                        }
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            com.tencent.gsdk.utils.g.c("getCPUFreq close input stream error:" + e2.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                com.tencent.gsdk.utils.g.c("getCPUFreq error:" + e3.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        sb = new StringBuilder();
                        sb.append("getCPUFreq close input stream error:");
                        sb.append(e.getMessage());
                        com.tencent.gsdk.utils.g.c(sb.toString());
                    }
                }
            }
        }
        return arrayList;
    }

    public static Map<String, String> c() {
        HashMap hashMap = new HashMap();
        try {
            Scanner scanner = new Scanner(new File("/proc/cpuinfo"));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(": ");
                if (split.length > 1) {
                    hashMap.put(split[0].trim(), split[1].trim());
                }
            }
        } catch (Exception e) {
            Log.e("getCpuInfo", Log.getStackTraceString(e));
        }
        return hashMap;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|2|(14:(14:(14:(14:(14:(13:(1:78)|30|31|32|33|34|35|36|(5:(5:(5:(5:(5:(4:(1:69)|64|65|66)|70|64|65|66)|71|64|65|66)|72|64|65|66)|73|64|65|66)|74|64|65|66)|75|64|65|66)|79|30|31|32|33|34|35|36|(6:38|(6:42|(6:46|(6:50|(6:54|(6:58|(1:62)|69|64|65|66)|70|64|65|66)|71|64|65|66)|72|64|65|66)|73|64|65|66)|74|64|65|66)|75|64|65|66)|80|30|31|32|33|34|35|36|(0)|75|64|65|66)|81|30|31|32|33|34|35|36|(0)|75|64|65|66)|82|30|31|32|33|34|35|36|(0)|75|64|65|66)|83|30|31|32|33|34|35|36|(0)|75|64|65|66)|84|30|31|32|33|34|35|36|(0)|75|64|65|66|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00b7, code lost:
    
        r19 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd A[Catch: Exception -> 0x016b, TryCatch #0 {Exception -> 0x016b, blocks: (B:2:0x0000, B:4:0x002b, B:8:0x0036, B:12:0x0041, B:16:0x004c, B:20:0x0057, B:24:0x0062, B:28:0x006d, B:30:0x0089, B:36:0x00bb, B:38:0x00dd, B:42:0x00e8, B:46:0x00f3, B:50:0x00fe, B:54:0x0109, B:58:0x0114, B:62:0x011f, B:64:0x013b), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static float d() {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gsdk.api.g.d():float");
    }

    public static float e() {
        float f = (float) f();
        float g = (float) g();
        try {
            Thread.sleep(300L);
        } catch (Exception unused) {
        }
        return ((((float) g()) - g) * 100.0f) / (((float) f()) - f);
    }

    public static long f() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            if (split == null) {
                return 0L;
            }
            String str = split[2];
            String str2 = split[3];
            String str3 = split[4];
            String str4 = split[5];
            String str5 = split[6];
            String str6 = split[7];
            String str7 = split[8];
            if (str != null && !str.equals("")) {
                if (str2 != null && !str2.equals("")) {
                    if (str3 != null && !str3.equals("")) {
                        if (str4 != null && !str4.equals("")) {
                            if (str5 != null && !str5.equals("")) {
                                if (str6 != null && !str6.equals("")) {
                                    if (str7 == null || str7.equals("")) {
                                        str7 = "0";
                                    }
                                    return Long.parseLong(str) + Long.parseLong(str2) + Long.parseLong(str3) + Long.parseLong(str4) + Long.parseLong(str5) + Long.parseLong(str6) + Long.parseLong(str7);
                                }
                                str6 = "0";
                                return Long.parseLong(str) + Long.parseLong(str2) + Long.parseLong(str3) + Long.parseLong(str4) + Long.parseLong(str5) + Long.parseLong(str6) + Long.parseLong(str7);
                            }
                            str5 = "0";
                            return Long.parseLong(str) + Long.parseLong(str2) + Long.parseLong(str3) + Long.parseLong(str4) + Long.parseLong(str5) + Long.parseLong(str6) + Long.parseLong(str7);
                        }
                        str4 = "0";
                        return Long.parseLong(str) + Long.parseLong(str2) + Long.parseLong(str3) + Long.parseLong(str4) + Long.parseLong(str5) + Long.parseLong(str6) + Long.parseLong(str7);
                    }
                    str3 = "0";
                    return Long.parseLong(str) + Long.parseLong(str2) + Long.parseLong(str3) + Long.parseLong(str4) + Long.parseLong(str5) + Long.parseLong(str6) + Long.parseLong(str7);
                }
                str2 = "0";
                return Long.parseLong(str) + Long.parseLong(str2) + Long.parseLong(str3) + Long.parseLong(str4) + Long.parseLong(str5) + Long.parseLong(str6) + Long.parseLong(str7);
            }
            str = "0";
            return Long.parseLong(str) + Long.parseLong(str2) + Long.parseLong(str3) + Long.parseLong(str4) + Long.parseLong(str5) + Long.parseLong(str6) + Long.parseLong(str7);
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.c("getTotalCpuTime error:" + e.getMessage());
            return 0L;
        }
    }

    public static long g() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            if (split == null) {
                return 0L;
            }
            String str = split[13];
            String str2 = split[14];
            String str3 = split[15];
            String str4 = split[16];
            if (str == null || str.equals("")) {
                str = "0";
            } else if (str2 == null || str2.equals("")) {
                str2 = "0";
            } else if (str3 == null || str3.equals("")) {
                str3 = "0";
            } else if (str4 == null || str4.equals("")) {
                str4 = "0";
            }
            return Long.parseLong(str) + Long.parseLong(str2) + Long.parseLong(str3) + Long.parseLong(str4);
        } catch (IOException e) {
            com.tencent.gsdk.utils.g.c("getAppCpuTime error:" + e.getMessage());
            return 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long h() {
        FileInputStream fileInputStream;
        StringBuilder sb;
        String str;
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream2 = null;
        int i = 0;
        FileInputStream fileInputStream3 = null;
        long j = -1;
        try {
            try {
                fileInputStream = new FileInputStream("/sys/devices/virtual/thermal/thermal_zone0/temp");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                i = 0;
                int i2 = 0;
                while (i2 < read && i2 < 128 && bArr[i2] != 10) {
                    i2++;
                }
                str = new String(bArr, 0, i2);
            } else {
                str = null;
            }
            if (str != null) {
                j = Long.parseLong(str);
                com.tencent.gsdk.utils.g.a("temp a is:" + j);
                if (j < 100 || j >= 1000) {
                    int i3 = (j > 1000L ? 1 : (j == 1000L ? 0 : -1));
                    i = i3;
                    if (i3 >= 0) {
                        i = (j > LogUtils.LOG_FUSE_TIME ? 1 : (j == LogUtils.LOG_FUSE_TIME ? 0 : -1));
                        i = i;
                        if (i < 0) {
                            j /= 100;
                        }
                    }
                    if (j >= LogUtils.LOG_FUSE_TIME && j < 100000) {
                        j /= 1000;
                    }
                } else {
                    j /= 10;
                }
            }
            try {
                fileInputStream.close();
                fileInputStream2 = i;
            } catch (IOException e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("close stream error:");
                sb.append(e.getMessage());
                com.tencent.gsdk.utils.g.d(sb.toString());
                return j;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            com.tencent.gsdk.utils.g.d("getCPUTemperature read file error:" + e.getMessage());
            fileInputStream2 = fileInputStream3;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                    fileInputStream2 = fileInputStream3;
                } catch (IOException e4) {
                    e = e4;
                    sb = new StringBuilder();
                    sb.append("close stream error:");
                    sb.append(e.getMessage());
                    com.tencent.gsdk.utils.g.d(sb.toString());
                    return j;
                }
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    com.tencent.gsdk.utils.g.d("close stream error:" + e5.getMessage());
                }
            }
            throw th;
        }
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long i() {
        StringBuilder sb;
        byte[] bArr;
        FileInputStream fileInputStream;
        String str;
        FileInputStream fileInputStream2 = null;
        long j = -1;
        try {
            try {
                bArr = new byte[128];
                fileInputStream = new FileInputStream("/sys/class/thermal/thermal_zone10/temp");
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                int i = 0;
                while (i < read && i < 128 && bArr[i] != 10) {
                    i++;
                }
                str = new String(bArr, 0, i);
            } else {
                str = null;
            }
            if (str != null) {
                j = Long.parseLong(str);
                if (j >= 100 && j < 1000) {
                    j /= 10;
                } else if (j >= 1000 && j < LogUtils.LOG_FUSE_TIME) {
                    j /= 100;
                } else if (j >= LogUtils.LOG_FUSE_TIME && j < 100000) {
                    j /= 1000;
                }
            }
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("close stream error:");
                sb.append(e.getMessage());
                com.tencent.gsdk.utils.g.d(sb.toString());
                return j;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            com.tencent.gsdk.utils.g.d("getGPUTemperature read file error:" + e.getMessage());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e = e4;
                    sb = new StringBuilder();
                    sb.append("close stream error:");
                    sb.append(e.getMessage());
                    com.tencent.gsdk.utils.g.d(sb.toString());
                    return j;
                }
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    com.tencent.gsdk.utils.g.d("close stream error:" + e5.getMessage());
                }
            }
            throw th;
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x009a, code lost:
    
        if (r2 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c2, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009c, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
    
        if (r2 == 0) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int j() {
        /*
            r0 = -1
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r3 = "/sys/class/kgsl/kgsl-3d0"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L54
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r5 = "/sys/class/kgsl/kgsl-3d0/gpubusy"
            java.lang.String r6 = "r"
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            if (r1 == 0) goto L50
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            java.lang.String r5 = "\\s+"
            java.lang.String[] r1 = r1.split(r5)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            r5 = r1[r4]     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            long r5 = (long) r5     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            r1 = r1[r3]     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            long r7 = (long) r1
            r9 = 0
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L50
            double r3 = (double) r5
            double r5 = (double) r7
            java.lang.Double.isNaN(r3)
            java.lang.Double.isNaN(r5)
            double r3 = r3 / r5
            r5 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r3 = r3 * r5
            long r0 = java.lang.Math.round(r3)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            int r4 = (int) r0
        L50:
            r0 = r4
            goto L9a
        L52:
            r1 = move-exception
            goto La7
        L54:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r5 = "/proc/mali/utilization"
            r2.<init>(r5)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            if (r2 == 0) goto L98
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r5 = "/proc/mali/utilization"
            java.lang.String r6 = "r"
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            if (r1 == 0) goto L92
            java.lang.String r5 = "="
            int r5 = r1.indexOf(r5)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            int r5 = r5 + r3
            int r3 = r1.length()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.substring(r5, r3)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            java.lang.String r3 = "/"
            int r3 = r1.indexOf(r3)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.substring(r4, r3)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            int r0 = r1.intValue()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            goto L9a
        L92:
            java.lang.String r1 = "get gpu usage failed"
            com.tencent.gsdk.utils.g.c(r1)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> Lc3
            goto L9a
        L98:
            r2 = r1
            r0 = 0
        L9a:
            if (r2 == 0) goto Lc2
        L9c:
            r2.close()     // Catch: java.io.IOException -> Lc2
            goto Lc2
        La0:
            r0 = move-exception
            r2 = r1
            goto Lc4
        La3:
            r2 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
        La7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r3.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = "get gpu usage error: "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> Lc3
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lc3
            com.tencent.gsdk.utils.g.d(r1)     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto Lc2
            goto L9c
        Lc2:
            return r0
        Lc3:
            r0 = move-exception
        Lc4:
            if (r2 == 0) goto Lc9
            r2.close()     // Catch: java.io.IOException -> Lc9
        Lc9:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gsdk.api.g.j():int");
    }

    @SuppressLint({"NewApi"})
    public static long a(Context context) {
        if (context == null) {
            return -1L;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem / 1048576;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            Matcher matcher = Pattern.compile("(\\d+)").matcher(randomAccessFile.readLine());
            String str = "";
            while (matcher.find()) {
                str = matcher.group(1);
                com.tencent.gsdk.utils.g.b("Ram : " + str);
            }
            randomAccessFile.close();
            if (str == null) {
                str = "0";
            }
            return Long.parseLong(str) / 1024;
        } catch (IOException e) {
            com.tencent.gsdk.utils.g.c("getTotalMemory error:" + e.getMessage());
            return -1L;
        }
    }

    public static long b(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager == null) {
                return -1L;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1048576;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.d("Get available memory error:" + e.getMessage());
            return -1L;
        }
    }

    public static long c(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        if (context == null) {
            return -1L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int[] iArr = {Process.myPid()};
            if (activityManager != null && (processMemoryInfo = activityManager.getProcessMemoryInfo(iArr)) != null && processMemoryInfo[0] != null) {
                return processMemoryInfo[0].getTotalPss() / 1024;
            }
            return -1L;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.d("Get process Memory error:" + e.getMessage());
            return -1L;
        }
    }

    public static long k() {
        int myUid = Process.myUid();
        return TrafficStats.getUidRxBytes(myUid) + TrafficStats.getUidTxBytes(myUid);
    }

    public static float d(Context context) {
        if (context == null) {
            return -1.0f;
        }
        try {
            if (context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("temperature", 0) == 0) {
                return -1.0f;
            }
            return r4 / 10;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.c("getBatteryTemperature error:" + e.getMessage());
            return -1.0f;
        }
    }

    public static String l() {
        int i;
        DisplayMetrics displayMetrics;
        int i2 = -1;
        try {
            displayMetrics = new DisplayMetrics();
            ((WindowManager) GSDKSystem.getInstance().a().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e) {
            e = e;
            i = -1;
        }
        try {
            i2 = displayMetrics.widthPixels;
        } catch (Exception e2) {
            e = e2;
            com.tencent.gsdk.utils.g.d("getScreenResolution error:" + e.getMessage());
            return i + "x" + i2;
        }
        return i + "x" + i2;
    }

    public static long e(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            return new File(context.getFilesDir().getAbsoluteFile().toString()).getTotalSpace() / 1000000;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.c("getTotalExternalStorage error:" + e.getMessage());
            return -1L;
        }
    }

    public static long f(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            return new File(context.getFilesDir().getAbsoluteFile().toString()).getFreeSpace() / 1000000;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.c("getFreeExternalStorage error:" + e.getMessage());
            return -1L;
        }
    }
}
