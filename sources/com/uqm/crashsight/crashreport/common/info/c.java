package com.uqm.crashsight.crashreport.common.info;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.services.s3.internal.Constants;
import com.tencent.mtt.engine.http.HttpUtils;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f6572a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    private static final String[] b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};
    private static final String[] c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    public static String d() {
        return Constants.NULL_VERSION_ID;
    }

    public static String e() {
        return Constants.NULL_VERSION_ID;
    }

    public static String f() {
        return Constants.NULL_VERSION_ID;
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (m.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (m.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (m.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String a(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return str == null ? Constants.NULL_VERSION_ID : str.toLowerCase();
        } catch (Throwable th) {
            if (!m.a(th)) {
                m.a("Failed to get Android ID.", new Object[0]);
            }
            return str;
        }
    }

    private static boolean r() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (m.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0062, code lost:
    
        r0 = java.lang.System.getProperty("os.arch");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r4, boolean r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L60
            java.lang.String r5 = "ro.product.cpu.abilist"
            java.lang.String r5 = com.uqm.crashsight.proguard.q.a(r4, r5)     // Catch: java.lang.Throwable -> L5e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            java.lang.String r2 = "ro.product.cpu.abilist"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5e
            r1.append(r5)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L5e
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L5e
            com.uqm.crashsight.proguard.m.a(r1, r3)     // Catch: java.lang.Throwable -> L5e
            boolean r1 = com.uqm.crashsight.proguard.q.a(r5)     // Catch: java.lang.Throwable -> L5e
            if (r1 != 0) goto L2b
            java.lang.String r1 = "fail"
            boolean r1 = r5.equals(r1)     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L31
        L2b:
            java.lang.String r5 = "ro.product.cpu.abi"
            java.lang.String r5 = com.uqm.crashsight.proguard.q.a(r4, r5)     // Catch: java.lang.Throwable -> L5e
        L31:
            boolean r4 = com.uqm.crashsight.proguard.q.a(r5)     // Catch: java.lang.Throwable -> L5e
            if (r4 != 0) goto L60
            java.lang.String r4 = "fail"
            boolean r4 = r5.equals(r4)     // Catch: java.lang.Throwable -> L5e
            if (r4 == 0) goto L40
            goto L60
        L40:
            java.lang.Class<com.uqm.crashsight.crashreport.common.info.c> r4 = com.uqm.crashsight.crashreport.common.info.c.class
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            java.lang.String r1 = "ABI list: "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L5e
            r0.append(r5)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5e
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L5e
            com.uqm.crashsight.proguard.m.b(r4, r0, r1)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r4 = ","
            java.lang.String[] r4 = r5.split(r4)     // Catch: java.lang.Throwable -> L5e
            r0 = r4[r2]     // Catch: java.lang.Throwable -> L5e
            goto L60
        L5e:
            r4 = move-exception
            goto L75
        L60:
            if (r0 != 0) goto L68
            java.lang.String r4 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r4)     // Catch: java.lang.Throwable -> L5e
        L68:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            r4.<init>()     // Catch: java.lang.Throwable -> L5e
            r4.append(r0)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L5e
            return r4
        L75:
            boolean r5 = com.uqm.crashsight.proguard.m.a(r4)
            if (r5 != 0) goto L7e
            r4.printStackTrace()
        L7e:
            java.lang.String r4 = "fail"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.common.info.c.a(android.content.Context, boolean):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                String[] strArr = Build.SUPPORTED_ABIS;
                if (strArr != null && strArr.length != 0) {
                    m.c("getCpuAbiNew: " + strArr[0], new Object[0]);
                    return strArr[0];
                }
                return a(context, true);
            }
            return Build.CPU_ABI;
        } catch (Throwable th) {
            if (m.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static long g() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long h() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.BufferedReader] */
    public static long i() {
        FileReader fileReader;
        Throwable th;
        Throwable th2;
        BufferedReader bufferedReader;
        ?? r0 = "/proc/meminfo";
        try {
            try {
                fileReader = new FileReader("/proc/meminfo");
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            r0 = 0;
        }
        try {
            bufferedReader = new BufferedReader(fileReader, ProgressEvent.PART_COMPLETED_EVENT_CODE);
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        if (!m.a(e)) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e2) {
                        if (!m.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                    return parseLong;
                }
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    if (!m.a(e3)) {
                        e3.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return -1L;
                } catch (IOException e4) {
                    if (m.a(e4)) {
                        return -1L;
                    }
                    e4.printStackTrace();
                    return -1L;
                }
            } catch (Throwable th5) {
                th2 = th5;
                if (!m.a(th2)) {
                    th2.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        if (!m.a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e6) {
                    if (m.a(e6)) {
                        return -2L;
                    }
                    e6.printStackTrace();
                    return -2L;
                }
            }
        } catch (Throwable th6) {
            th2 = th6;
            bufferedReader = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.BufferedReader] */
    public static long j() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        Throwable th2;
        ?? r0 = "/proc/self/stat";
        try {
            try {
                fileReader = new FileReader("/proc/self/stat");
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                bufferedReader = new BufferedReader(fileReader, ProgressEvent.PART_COMPLETED_EVENT_CODE);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            if (!m.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1L;
                        } catch (IOException e2) {
                            if (m.a(e2)) {
                                return -1L;
                            }
                            e2.printStackTrace();
                            return -1L;
                        }
                    }
                    String[] split = readLine.split("\\s+");
                    if (split.length >= 40) {
                        long parseLong = Long.parseLong(split[22].trim());
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            if (!m.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            if (!m.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        return parseLong;
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        if (!m.a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e6) {
                        if (m.a(e6)) {
                            return -2L;
                        }
                        e6.printStackTrace();
                        return -2L;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (!m.a(th)) {
                        th.printStackTrace();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            if (!m.a(e7)) {
                                e7.printStackTrace();
                            }
                        }
                    }
                    if (fileReader == null) {
                        return -3L;
                    }
                    try {
                        fileReader.close();
                        return -3L;
                    } catch (IOException e8) {
                        if (m.a(e8)) {
                            return -3L;
                        }
                        e8.printStackTrace();
                        return -3L;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
        } catch (Throwable th6) {
            fileReader = null;
            th = th6;
            bufferedReader = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long k() {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.common.info.c.k():long");
    }

    public static long l() {
        if (!r()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (m.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long m() {
        if (!r()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (m.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String n() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (m.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String o() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (m.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r4) {
        /*
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r4.getSystemService(r1)     // Catch: java.lang.Exception -> L77
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1     // Catch: java.lang.Exception -> L77
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L77
            if (r1 != 0) goto L12
            r4 = 0
            return r4
        L12:
            int r2 = r1.getType()     // Catch: java.lang.Exception -> L77
            r3 = 1
            if (r2 != r3) goto L1d
            java.lang.String r0 = "WIFI"
            goto L81
        L1d:
            int r1 = r1.getType()     // Catch: java.lang.Exception -> L77
            if (r1 != 0) goto L81
            java.lang.String r1 = "phone"
            java.lang.Object r4 = r4.getSystemService(r1)     // Catch: java.lang.Exception -> L77
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch: java.lang.Exception -> L77
            if (r4 == 0) goto L81
            int r4 = r4.getNetworkType()     // Catch: java.lang.Exception -> L77
            switch(r4) {
                case 1: goto L61;
                case 2: goto L5e;
                case 3: goto L5b;
                case 4: goto L58;
                case 5: goto L55;
                case 6: goto L52;
                case 7: goto L4f;
                case 8: goto L4c;
                case 9: goto L49;
                case 10: goto L46;
                case 11: goto L43;
                case 12: goto L40;
                case 13: goto L3d;
                case 14: goto L3a;
                case 15: goto L37;
                default: goto L34;
            }     // Catch: java.lang.Exception -> L77
        L34:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
            goto L64
        L37:
            java.lang.String r0 = "HSPA+"
            goto L81
        L3a:
            java.lang.String r0 = "eHRPD"
            goto L81
        L3d:
            java.lang.String r0 = "LTE"
            goto L81
        L40:
            java.lang.String r0 = "EVDO_B"
            goto L81
        L43:
            java.lang.String r0 = "iDen"
            goto L81
        L46:
            java.lang.String r0 = "HSPA"
            goto L81
        L49:
            java.lang.String r0 = "HSUPA"
            goto L81
        L4c:
            java.lang.String r0 = "HSDPA"
            goto L81
        L4f:
            java.lang.String r0 = "1xRTT"
            goto L81
        L52:
            java.lang.String r0 = "EVDO_A"
            goto L81
        L55:
            java.lang.String r0 = "EVDO_0"
            goto L81
        L58:
            java.lang.String r0 = "CDMA"
            goto L81
        L5b:
            java.lang.String r0 = "UMTS"
            goto L81
        L5e:
            java.lang.String r0 = "EDGE"
            goto L81
        L61:
            java.lang.String r0 = "GPRS"
            goto L81
        L64:
            java.lang.String r2 = "MOBILE("
            r1.<init>(r2)     // Catch: java.lang.Exception -> L77
            r1.append(r4)     // Catch: java.lang.Exception -> L77
            java.lang.String r4 = ")"
            r1.append(r4)     // Catch: java.lang.Exception -> L77
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Exception -> L77
            r0 = r4
            goto L81
        L77:
            r4 = move-exception
            boolean r1 = com.uqm.crashsight.proguard.m.a(r4)
            if (r1 != 0) goto L81
            r4.printStackTrace()
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.common.info.c.b(android.content.Context):java.lang.String");
    }

    public static String c(Context context) {
        String a2 = q.a(context, "ro.miui.ui.version.name");
        if (!q.a(a2) && !a2.equals("fail")) {
            return "XiaoMi/MIUI/" + a2;
        }
        String a3 = q.a(context, "ro.build.version.emui");
        if (!q.a(a3) && !a3.equals("fail")) {
            return "HuaWei/EMOTION/" + a3;
        }
        String a4 = q.a(context, "ro.lenovo.series");
        if (!q.a(a4) && !a4.equals("fail")) {
            return "Lenovo/VIBE/" + q.a(context, "ro.build.version.incremental");
        }
        String a5 = q.a(context, "ro.build.nubia.rom.name");
        if (!q.a(a5) && !a5.equals("fail")) {
            return "Zte/NUBIA/" + a5 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + q.a(context, "ro.build.nubia.rom.code");
        }
        String a6 = q.a(context, "ro.meizu.product.model");
        if (!q.a(a6) && !a6.equals("fail")) {
            return "Meizu/FLYME/" + q.a(context, "ro.build.display.id");
        }
        String a7 = q.a(context, "ro.build.version.opporom");
        if (!q.a(a7) && !a7.equals("fail")) {
            return "Oppo/COLOROS/" + a7;
        }
        String a8 = q.a(context, "ro.vivo.os.build.display.id");
        if (!q.a(a8) && !a8.equals("fail")) {
            return "vivo/FUNTOUCH/" + a8;
        }
        String a9 = q.a(context, "ro.aa.romver");
        if (!q.a(a9) && !a9.equals("fail")) {
            return "htc/" + a9 + "/" + q.a(context, "ro.build.description");
        }
        String a10 = q.a(context, "ro.lewa.version");
        if (!q.a(a10) && !a10.equals("fail")) {
            return "tcl/" + a10 + "/" + q.a(context, "ro.build.display.id");
        }
        String a11 = q.a(context, "ro.gn.gnromvernumber");
        if (!q.a(a11) && !a11.equals("fail")) {
            return "amigo/" + a11 + "/" + q.a(context, "ro.build.display.id");
        }
        String a12 = q.a(context, "ro.build.tyd.kbstyle_version");
        if (!q.a(a12) && !a12.equals("fail")) {
            return "dido/" + a12;
        }
        return q.a(context, "ro.build.fingerprint") + "/" + q.a(context, "ro.build.rom.id");
    }

    public static String d(Context context) {
        return q.a(context, "ro.board.platform");
    }

    public static boolean p() {
        boolean z;
        String[] strArr = f6572a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (new File(strArr[i]).exists()) {
                z = true;
                break;
            }
            i++;
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z;
    }

    public static boolean e(Context context) {
        int i;
        if (h(context) != null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            String[] strArr = c;
            if (i >= strArr.length) {
                break;
            }
            if (i == 0) {
                i = new File(strArr[i]).exists() ? i + 1 : 0;
                arrayList.add(Integer.valueOf(i));
            } else {
                if (!new File(strArr[i]).exists()) {
                }
                arrayList.add(Integer.valueOf(i));
            }
        }
        return (arrayList.isEmpty() ? null : arrayList.toString()) != null;
    }

    private static String h(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = b;
            if (i >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i], 1);
                arrayList.add(Integer.valueOf(i));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static boolean f(Context context) {
        return (((i(context) | t()) | u()) | s()) > 0;
    }

    private static int s() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    private static int i(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (Exception unused2) {
            return i;
        }
    }

    private static int t() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e) {
            int i = 0;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    i |= 32;
                }
            }
            return i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int u() {
        BufferedReader bufferedReader;
        IOException e;
        UnsupportedEncodingException e2;
        FileNotFoundException e3;
        int i = 0;
        BufferedReader bufferedReader2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                HashSet hashSet = new HashSet();
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), HttpUtils.DEFAULT_ENCODE_NAME));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                            hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                        }
                    } catch (FileNotFoundException e4) {
                        e3 = e4;
                        e3.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return i;
                    } catch (UnsupportedEncodingException e5) {
                        e2 = e5;
                        e2.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return i;
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return i;
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (((String) next).toLowerCase().contains("xposed")) {
                        i |= 64;
                    }
                    if (((String) next).contains("com.saurik.substrate")) {
                        i |= 128;
                    }
                }
                bufferedReader.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        } catch (FileNotFoundException e8) {
            bufferedReader = null;
            e3 = e8;
        } catch (UnsupportedEncodingException e9) {
            bufferedReader = null;
            e2 = e9;
        } catch (IOException e10) {
            bufferedReader = null;
            e = e10;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    bufferedReader2.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
        return i;
    }

    public static boolean q() {
        double maxMemory = Runtime.getRuntime().maxMemory();
        Double.isNaN(maxMemory);
        float f = (float) (maxMemory / 1048576.0d);
        double d = Runtime.getRuntime().totalMemory();
        Double.isNaN(d);
        float f2 = (float) (d / 1048576.0d);
        float f3 = f - f2;
        m.c("maxMemory : %f", Float.valueOf(f));
        m.c("totalMemory : %f", Float.valueOf(f2));
        m.c("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }

    public static String g(Context context) {
        return q.a(context, "hw_sc.build.platform.version");
    }

    public static int a(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        if (runningAppProcessInfo == null) {
            try {
                runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            } catch (Exception e) {
                m.e(e.toString(), new Object[0]);
                return -1;
            }
        }
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.lastTrimLevel;
    }
}
