package com.tencent.hawk.bridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.internal.security.CertificateUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class DevPacket {
    private static final String READ_PHONE_STATE_PERMISSION = "android.permission.READ_PHONE_STATE";
    private static Pair<Float, Float> sCPUFreqPair = new Pair<>(Float.valueOf(-1.0f), Float.valueOf(-1.0f));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum CPU_FREQ {
        MIN,
        MAX
    }

    @SuppressLint({"NewApi"})
    public static String getMacAddr(Context context) {
        return "0";
    }

    public boolean isEmulator(Context context) {
        return false;
    }

    public static int getMemory() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
                String[] split = readLine.split("\\s+");
                if (split != null && split.length >= 1) {
                    int intValue = Integer.valueOf(split[1]).intValue() / 1024;
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return intValue;
                }
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return -1;
            } catch (Exception unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static int getCpuCoreNum() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.hawk.bridge.DevPacket.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            if (listFiles != null) {
                return listFiles.length;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getDisplayMetrics(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Point point = new Point();
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
                return "" + String.valueOf(point.x) + " x " + String.valueOf(point.y);
            }
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return "" + String.valueOf(displayMetrics.widthPixels) + " x " + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception unused) {
            defaultDisplay.getMetrics(displayMetrics);
            return Constant.strError;
        }
    }

    @SuppressLint({"NewApi"})
    public static int getDpx(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return -1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
            return point.x;
        }
        try {
            Class<?> cls = Class.forName("android.view.Display");
            if (cls == null) {
                return -1;
            }
            Method method = cls.getMethod("getRealMetrics", DisplayMetrics.class);
            if (method == null) {
                return -1;
            }
            try {
                method.invoke(defaultDisplay, displayMetrics);
                return displayMetrics.widthPixels;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return -1;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return -1;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return -1;
            }
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return -1;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return -1;
        }
    }

    @SuppressLint({"NewApi"})
    public static int getDpy(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return -1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
            return point.y;
        }
        try {
            Class<?> cls = Class.forName("android.view.Display");
            if (cls == null) {
                return -1;
            }
            Method method = cls.getMethod("getRealMetrics", DisplayMetrics.class);
            if (method == null) {
                return -1;
            }
            try {
                method.invoke(defaultDisplay, displayMetrics);
                return displayMetrics.heightPixels;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return -1;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return -1;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return -1;
            }
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return -1;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return -1;
        }
    }

    @SuppressLint({"NewApi"})
    public static int getMaxPixelsInDpy(Context context) {
        Display defaultDisplay;
        Method method;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return -1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
            return point.x > point.y ? point.x : point.y;
        }
        try {
            Class<?> cls = Class.forName("android.view.Display");
            if (cls == null || (method = cls.getMethod("getRealMetrics", DisplayMetrics.class)) == null) {
                return -1;
            }
            method.invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels > displayMetrics.widthPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels;
        } catch (ClassNotFoundException e) {
            e = e;
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e2) {
            e = e2;
            e.printStackTrace();
            return -1;
        } catch (IllegalArgumentException e3) {
            e = e3;
            e.printStackTrace();
            return -1;
        } catch (NoSuchMethodException e4) {
            e = e4;
            e.printStackTrace();
            return -1;
        } catch (InvocationTargetException e5) {
            e = e5;
            e.printStackTrace();
            return -1;
        }
    }

    public static String getManu() {
        return Build.BRAND;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    @SuppressLint({"NewApi"})
    public static String getCpuABI() {
        if (Build.VERSION.SDK_INT >= 21) {
            StringBuffer stringBuffer = new StringBuffer();
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr == null) {
                return "arm64-v8a";
            }
            for (String str : strArr) {
                stringBuffer.append(str);
            }
            return stringBuffer.toString();
        }
        return Build.CPU_ABI;
    }

    public static String getReleaseVersion() {
        return Build.VERSION.RELEASE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:5|6|(2:8|(4:10|11|12|13))|19|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        r1.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static float getCpuMinFreq() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5e
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5e
            java.lang.String r3 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5e
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r0 == 0) goto L41
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.String r2 = ""
            java.lang.String r3 = r0.trim()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r2 != 0) goto L41
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r2 = 1232348160(0x49742400, float:1000000.0)
            float r0 = r0 / r2
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            double r3 = (double) r0     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r0 = 2
            java.math.RoundingMode r3 = java.math.RoundingMode.UP     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.math.BigDecimal r0 = r2.setScale(r0, r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            float r0 = r0.floatValue()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            goto L42
        L41:
            r0 = 0
        L42:
            r1.close()     // Catch: java.io.IOException -> L46
            goto L4a
        L46:
            r1 = move-exception
            r1.printStackTrace()
        L4a:
            return r0
        L4b:
            r0 = move-exception
            goto L53
        L4d:
            goto L5f
        L4f:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L53:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.io.IOException -> L59
            goto L5d
        L59:
            r1 = move-exception
            r1.printStackTrace()
        L5d:
            throw r0
        L5e:
            r1 = r0
        L5f:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r1 = move-exception
            r1.printStackTrace()
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.DevPacket.getCpuMinFreq():float");
    }

    private static float getTargetCpuFreq(int i, CPU_FREQ cpu_freq) {
        String str;
        BufferedReader bufferedReader;
        if (cpu_freq == CPU_FREQ.MIN) {
            str = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq";
        } else {
            if (cpu_freq != CPU_FREQ.MAX) {
                return -1.0f;
            }
            str = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
        }
        float f = 0.0f;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (NumberFormatException unused2) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (!"".equals(readLine.trim().trim())) {
                    f = new BigDecimal(Float.parseFloat(r5.trim()) / 1000000.0f).setScale(2, RoundingMode.UP).floatValue();
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
            return f;
        } catch (IOException unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
            }
            return -1.0f;
        } catch (NumberFormatException unused6) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused7) {
                }
            }
            return -1.0f;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused8) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Pair<Float, Float> getCpuFreq(int i) {
        float f = 0.0f;
        if (sCPUFreqPair.getLeft().floatValue() > 0.0f && sCPUFreqPair.getRight().floatValue() > 0.0f) {
            return sCPUFreqPair;
        }
        float f2 = 10.0f;
        for (int i2 = 0; i2 < i; i2++) {
            float targetCpuFreq = getTargetCpuFreq(i2, CPU_FREQ.MAX);
            if (targetCpuFreq > 0.1f && targetCpuFreq < f2) {
                f2 = targetCpuFreq;
            }
            if (targetCpuFreq > 0.1f && f < targetCpuFreq) {
                f = targetCpuFreq;
            }
        }
        HawkLogger.d("FREQ: " + f2 + "  " + f);
        sCPUFreqPair = new Pair<>(Float.valueOf(f), Float.valueOf(f2));
        return sCPUFreqPair;
    }

    public static String getCpuName() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"));
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return Constant.strError;
                }
                String[] split = readLine.split(":\\s+", 2);
                if (split != null && split.length >= 1) {
                    String str = split[1];
                    try {
                        bufferedReader2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return str;
                }
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return Constant.strError;
            } catch (Exception unused) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return Constant.strError;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @SuppressLint({"NewApi"})
    private static Pair<Long, Long> getPathSz(File file) {
        long blockSize;
        long blockCount;
        long availableBlocks;
        if (file == null) {
            return new Pair<>(0L, 0L);
        }
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            blockCount = statFs.getBlockCountLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = statFs.getBlockSize();
            blockCount = statFs.getBlockCount();
            availableBlocks = statFs.getAvailableBlocks();
        }
        return new Pair<>(Long.valueOf((blockCount * blockSize) >> 20), Long.valueOf((availableBlocks * blockSize) >> 20));
    }

    private static String getExtendedMemoryPath(Context context) {
        Class<?> cls;
        Method method;
        Method method2;
        Method method3;
        Object invoke;
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager == null) {
            return null;
        }
        try {
            cls = Class.forName("android.os.storage.StorageVolume");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        if (cls == null || (method = storageManager.getClass().getMethod("getVolumeList", new Class[0])) == null || (method2 = cls.getMethod("getPath", new Class[0])) == null || (method3 = cls.getMethod("isRemovable", new Class[0])) == null || (invoke = method.invoke(storageManager, new Object[0])) == null) {
            return null;
        }
        int length = Array.getLength(invoke);
        for (int i = 0; i < length; i++) {
            Object obj = Array.get(invoke, i);
            if (obj != null) {
                Object invoke2 = method2.invoke(obj, new Object[0]);
                Object invoke3 = method3.invoke(obj, new Object[0]);
                if (invoke2 != null && invoke3 != null) {
                    String valueOf = String.valueOf(invoke2);
                    if (Boolean.parseBoolean(String.valueOf(invoke3))) {
                        return valueOf;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean checkMountStat() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L97
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L97
            java.lang.String r3 = "/proc/mounts"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L97
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L97
        Ld:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r0 == 0) goto L72
            java.lang.String r2 = "vfat"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r2 != 0) goto L23
            java.lang.String r2 = "/mnt"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r2 == 0) goto Ld
        L23:
            java.lang.String r2 = "/dev/block/vold"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r2 == 0) goto Ld
            java.lang.String r2 = "/mnt/secure"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r2 != 0) goto Ld
            java.lang.String r2 = "/mnt/asec"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r2 != 0) goto Ld
            java.lang.String r2 = "/mnt/obb"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r2 != 0) goto Ld
            java.lang.String r2 = "/dev/mapper"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r2 != 0) goto Ld
            java.lang.String r2 = "tmpfs"
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lc2
            if (r0 != 0) goto Ld
            r0 = 1
            r1.close()     // Catch: java.io.IOException -> L58
            goto L71
        L58:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "checkMountStat2"
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.tencent.hawk.bridge.HawkLogger.e(r1)
        L71:
            return r0
        L72:
            r1.close()     // Catch: java.io.IOException -> L76
            goto Lc0
        L76:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L7c:
            java.lang.String r2 = "checkMountStat2"
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.tencent.hawk.bridge.HawkLogger.e(r0)
            goto Lc0
        L90:
            r0 = move-exception
            goto L9b
        L92:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto Lc3
        L97:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L9b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc2
            r2.<init>()     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r3 = "checkMountStat1"
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> Lc2
            r2.append(r0)     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> Lc2
            com.tencent.hawk.bridge.HawkLogger.e(r0)     // Catch: java.lang.Throwable -> Lc2
            if (r1 == 0) goto Lc0
            r1.close()     // Catch: java.io.IOException -> Lb9
            goto Lc0
        Lb9:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L7c
        Lc0:
            r0 = 0
            return r0
        Lc2:
            r0 = move-exception
        Lc3:
            if (r1 == 0) goto Le2
            r1.close()     // Catch: java.io.IOException -> Lc9
            goto Le2
        Lc9:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "checkMountStat2"
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.tencent.hawk.bridge.HawkLogger.e(r1)
        Le2:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.DevPacket.checkMountStat():boolean");
    }

    public static Pair<Long, Long> getExternalFlashSz(Context context) {
        if (!checkMountStat()) {
            return new Pair<>(1L, 1L);
        }
        String extendedMemoryPath = getExtendedMemoryPath(context);
        if (extendedMemoryPath == null) {
            return new Pair<>(2L, 2L);
        }
        HawkLogger.d("ExternalFlashSz is :" + extendedMemoryPath);
        try {
            return getPathSz(new File(extendedMemoryPath));
        } catch (Exception e) {
            HawkLogger.e("ExternalMem error: " + e.getMessage());
            return new Pair<>(3L, 3L);
        }
    }

    @SuppressLint({"NewApi"})
    public static Pair<Long, Long> GetInternalFlashSz(Context context) {
        File dataDirectory = Environment.getDataDirectory();
        if (dataDirectory == null) {
            new Pair(0L, 0L);
        }
        return getPathSz(dataDirectory);
    }

    public static Pair<String, Integer> getPkgVersionInfo(Context context) {
        if (context == null || context.getApplicationInfo() == null) {
            return new Pair<>(Constant.strError, -1);
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return new Pair<>(Constant.strError, -1);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null && packageInfo.versionName != null) {
                return new Pair<>(packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
            }
            return new Pair<>(Constant.strError, -1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return new Pair<>(Constant.strError, -1);
        }
    }

    public static long getIMEI(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0)) == null) {
            return 0L;
        }
        long j = sharedPreferences.getLong(Constant.APM_UUID, 0L);
        if (j == 0) {
            j = UUID.randomUUID().getMostSignificantBits();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(Constant.APM_UUID, j);
                edit.commit();
            }
        }
        return j;
    }

    public static boolean checkPermission(Context context) {
        return context.checkCallingOrSelfPermission(READ_PHONE_STATE_PERMISSION) == 0;
    }

    private static long parseHex(String str) {
        try {
            return Long.parseLong(str, 16);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long getIMEIUnderPermission(Context context, int i) {
        String str;
        if (context == null) {
            return 0L;
        }
        if (i == 0 && !checkPermission(context)) {
            HawkLogger.e("imei check permission,failed " + i);
            return 0L;
        }
        if (i == 1) {
            return 1L;
        }
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            str = "1";
        }
        if (str != null) {
            return parseHex(str);
        }
        return 1L;
    }

    public static String getAndroidId(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string == null ? "0" : string;
        } catch (Exception e) {
            HawkLogger.e("GetAndroidId failed: " + e.getMessage());
            return "0";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getHardwareInfo() {
        Throwable th;
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            return Constant.APM_CFG_GPU_NA;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return Constant.APM_CFG_GPU_NA;
                        }
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return Constant.strError;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } while (!readLine.contains("Hardware"));
            String[] split = readLine.split(CertificateUtil.DELIMITER);
            if (split != null && split.length >= 2) {
                if (split[1] == null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return "Error";
                }
                String lowerCase = split[1].trim().toLowerCase(Locale.ENGLISH);
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return lowerCase;
            }
            try {
                bufferedReader.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return Constant.APM_CFG_GPU_NA;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public static DisplayMetrics getDisplayInfo(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception e) {
            HawkLogger.d("getDisplayInfo error" + e.getMessage());
        }
        if (windowManager == null) {
            return displayMetrics;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }
}
