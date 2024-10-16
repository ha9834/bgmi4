package com.tdatamaster.tdm.device;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.content.a;
import com.adjust.sdk.Constants;
import com.tdatamaster.a.b;
import com.tdatamaster.b.a;
import com.tdatamaster.tdm.BuildConfig;
import com.tdatamaster.tdm.system.TDMLog;
import com.tdatamaster.tdm.system.TDMUtils;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public class DeviceInfoCollect {
    private static final String ANDROID_CPU_INFO_PATH = "/sys/devices/system/cpu/";
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.tdatamaster.tdm.device.DeviceInfoCollect.4
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    };
    private static final String DefaultUUID = "UUID";
    private static DeviceInfoCollect instance = null;
    private static final String tag = "DeviceInfoCollect";
    private volatile boolean mIsBeaconInit = false;
    private DeviceInfo<Long> m_szMemeryAvail;
    private DeviceInfo<Long> m_szMemoryTotal;
    private DeviceInfo<Long> m_szScreenHeight;
    private DeviceInfo<Long> m_szScreenWidth;
    private DeviceInfo<Long> m_szSpaceAvail;
    private DeviceInfo<Long> m_szSpaceTotal;

    private DeviceInfoCollect() {
    }

    public static DeviceInfoCollect getInstance() {
        if (instance == null) {
            instance = new DeviceInfoCollect();
        }
        return instance;
    }

    public DeviceInfo<String> GetSysVersion() {
        try {
            return new DeviceInfo<>(Build.VERSION.RELEASE);
        } catch (NoSuchFieldError unused) {
            TDMLog.e(tag, "get_sys_version failed");
            return new DeviceInfo<>(null, 100);
        }
    }

    public DeviceInfo<String> GetBundleId(Context context) {
        return new DeviceInfo<>(context.getPackageName());
    }

    public DeviceInfo<String> GetAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (str == null) {
                str = "Unknown";
            }
            return new DeviceInfo<>(String.format(Locale.ENGLISH, "%s(%d)", str, Integer.valueOf(i)));
        } catch (Exception e) {
            TDMLog.e(tag, "GetAppVersion Exception");
            TDMLog.i(tag, "Exception Track: " + e);
            return new DeviceInfo<>(null, 100);
        }
    }

    public DeviceInfo<String> GetModel() {
        return new DeviceInfo<>(Build.MODEL);
    }

    public DeviceInfo<String> GetBrand() {
        return new DeviceInfo<>(Build.BRAND);
    }

    @TargetApi(16)
    private void GetMemoryInfo(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                this.m_szMemoryTotal = new DeviceInfo<>(Long.valueOf(memoryInfo.totalMem >> 20));
            } else {
                this.m_szMemoryTotal = new DeviceInfo<>(null, 7);
            }
            this.m_szMemeryAvail = new DeviceInfo<>(Long.valueOf(memoryInfo.availMem >> 20));
        } catch (Exception e) {
            TDMLog.e(tag, "GetMemoryInfo failed");
            TDMLog.i(tag, "Exception Track: " + e);
            this.m_szMemoryTotal = new DeviceInfo<>(null, 100);
            this.m_szMemeryAvail = new DeviceInfo<>(null, 100);
        }
    }

    public DeviceInfo<Long> GetTotalMemory(Context context) {
        if (this.m_szMemoryTotal == null) {
            GetMemoryInfo(context);
        }
        return this.m_szMemoryTotal;
    }

    @TargetApi(18)
    private void GetSpaceInfo() {
        long blockSize;
        long blockCount;
        long availableBlocks;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return;
            }
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
                availableBlocks = statFs.getAvailableBlocks();
            }
            this.m_szSpaceTotal = new DeviceInfo<>(Long.valueOf((blockCount * blockSize) >> 20));
            this.m_szSpaceAvail = new DeviceInfo<>(Long.valueOf((blockSize * availableBlocks) >> 20));
        } catch (Exception e) {
            TDMLog.e(tag, "getStorage failed");
            TDMLog.i(tag, "exception track: " + e);
            this.m_szSpaceTotal = new DeviceInfo<>(null, 100);
            this.m_szSpaceAvail = new DeviceInfo<>(null, 100);
        }
    }

    public DeviceInfo<Long> GetTotalSpace() {
        if (this.m_szSpaceTotal == null) {
            GetSpaceInfo();
        }
        return this.m_szSpaceTotal;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
    
        r0 = r0.split(com.facebook.internal.security.CertificateUtil.DELIMITER)[1];
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @android.annotation.TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.tdatamaster.tdm.device.DeviceInfo<java.lang.String> GetCPUName() {
        /*
            r8 = this;
            java.lang.String r0 = "/proc/cpuinfo"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            r3 = 21
            if (r1 < r3) goto L23
            java.lang.String[] r1 = android.os.Build.SUPPORTED_ABIS     // Catch: java.lang.NoSuchFieldError -> Lc
            goto L14
        Lc:
            java.lang.String r1 = "DeviceInfoCollect"
            java.lang.String r3 = "get SUPPORTED_ABIS failed"
            com.tdatamaster.tdm.system.TDMLog.e(r1, r3)
            r1 = r2
        L14:
            r3 = 0
            if (r1 == 0) goto L35
            int r4 = r1.length
            if (r4 <= 0) goto L35
            r1 = r1[r3]
            java.lang.String r3 = "x86"
            boolean r3 = r1.equalsIgnoreCase(r3)
            goto L35
        L23:
            java.lang.String r1 = ""
            java.lang.String r1 = android.os.Build.CPU_ABI     // Catch: java.lang.NoSuchFieldError -> L28
            goto L2f
        L28:
            java.lang.String r3 = "DeviceInfoCollect"
            java.lang.String r4 = "get CPU_ABI failed"
            com.tdatamaster.tdm.system.TDMLog.e(r3, r4)
        L2f:
            java.lang.String r3 = "x86"
            boolean r3 = r1.equalsIgnoreCase(r3)
        L35:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Exception -> La7
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> La7
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Exception -> La7
            r5.<init>(r0)     // Catch: java.lang.Exception -> La7
            java.lang.String r0 = "UTF-8"
            r4.<init>(r5, r0)     // Catch: java.lang.Exception -> La7
            r1.<init>(r4)     // Catch: java.lang.Exception -> La7
            java.lang.String r0 = ""
            r4 = r2
        L49:
            if (r0 == 0) goto L75
            java.lang.String r5 = "Hardware"
            boolean r5 = r0.contains(r5)     // Catch: java.lang.Exception -> L73
            r6 = 1
            if (r5 == 0) goto L5d
            java.lang.String r5 = ":"
            java.lang.String[] r0 = r0.split(r5)     // Catch: java.lang.Exception -> L73
            r0 = r0[r6]     // Catch: java.lang.Exception -> L73
            goto L97
        L5d:
            java.lang.String r5 = "model name"
            boolean r5 = r0.contains(r5)     // Catch: java.lang.Exception -> L73
            if (r5 == 0) goto L6e
            java.lang.String r5 = ":"
            java.lang.String[] r0 = r0.split(r5)     // Catch: java.lang.Exception -> L73
            r0 = r0[r6]     // Catch: java.lang.Exception -> L73
            r4 = r0
        L6e:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Exception -> L73
            goto L49
        L73:
            r0 = move-exception
            goto L79
        L75:
            r0 = r2
            goto L97
        L77:
            r0 = move-exception
            r4 = r2
        L79:
            java.lang.String r5 = "DeviceInfoCollect"
            java.lang.String r6 = "GetCPUName, readLine Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r5, r6)     // Catch: java.lang.Exception -> La7
            java.lang.String r5 = "DeviceInfoCollect"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La7
            r6.<init>()     // Catch: java.lang.Exception -> La7
            java.lang.String r7 = "Exception Track: "
            r6.append(r7)     // Catch: java.lang.Exception -> La7
            r6.append(r0)     // Catch: java.lang.Exception -> La7
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Exception -> La7
            com.tdatamaster.tdm.system.TDMLog.i(r5, r0)     // Catch: java.lang.Exception -> La7
            r0 = r2
        L97:
            r1.close()     // Catch: java.lang.Exception -> La7
            if (r0 != 0) goto La1
            if (r3 == 0) goto La1
            if (r4 == 0) goto La1
            r0 = r4
        La1:
            com.tdatamaster.tdm.device.DeviceInfo r1 = new com.tdatamaster.tdm.device.DeviceInfo
            r1.<init>(r0)
            return r1
        La7:
            r0 = move-exception
            java.lang.String r1 = "DeviceInfoCollect"
            java.lang.String r3 = "GetCPUName Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r1, r3)
            java.lang.String r1 = "DeviceInfoCollect"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception Track: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.tdatamaster.tdm.system.TDMLog.i(r1, r0)
            com.tdatamaster.tdm.device.DeviceInfo r0 = new com.tdatamaster.tdm.device.DeviceInfo
            r1 = 100
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.device.DeviceInfoCollect.GetCPUName():com.tdatamaster.tdm.device.DeviceInfo");
    }

    public DeviceInfo<String> GetDeviceID(Context context) {
        if (a.b(context, "android.permission.READ_PHONE_STATE") != 0) {
            TDMLog.e(tag, "getDeviceID, Permission Denied. ");
            return new DeviceInfo<>(null, 2);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                TDMLog.e(tag, "telephonyManager is null");
                return new DeviceInfo<>(null, 100);
            }
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null && !deviceId.isEmpty()) {
                return new DeviceInfo<>(deviceId);
            }
            TDMLog.e(tag, "get deviceID is empty");
            return new DeviceInfo<>(null, 100);
        } catch (Exception e) {
            TDMLog.e(tag, "get DeviceID failed");
            TDMLog.i(tag, "Exception Track: " + e);
            return new DeviceInfo<>(null, 100);
        }
    }

    public DeviceInfo<String> GetUUID(Context context) {
        String str = "";
        if (a.b(context, "android.permission.READ_PHONE_STATE") != 0) {
            TDMLog.e(tag, "getDeviceID, Permission Denied. ");
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    TDMLog.e(tag, "telephonyManager is null");
                } else {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Exception e) {
                TDMLog.e(tag, "get DeviceID failed");
                TDMLog.i(tag, "Exception Track: " + e);
            }
        }
        String str2 = null;
        try {
            str2 = Build.SERIAL;
        } catch (NoSuchFieldError unused) {
            TDMLog.e(tag, "get serial failed");
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("%");
            sb.append(str);
        }
        if (str2 != null) {
            sb.append("%");
            sb.append(str2);
        }
        if (string != null) {
            sb.append("%");
            sb.append(string);
        }
        String sb2 = sb.toString();
        if (sb2.length() == 0) {
            TDMLog.e(tag, "uuid is null");
            return new DeviceInfo<>("UUID", 100);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            if (messageDigest == null) {
                TDMLog.e(tag, "digest is null, return default uuid");
                return new DeviceInfo<>("UUID", 100);
            }
            messageDigest.update(sb2.getBytes(Charset.forName("UTF-8")));
            byte[] digest = messageDigest.digest();
            StringBuilder sb3 = new StringBuilder();
            for (byte b : digest) {
                sb3.append(Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
            }
            return new DeviceInfo<>(sb3.toString().toUpperCase(Locale.ENGLISH));
        } catch (Exception e2) {
            TDMLog.e(tag, "GetUUID Exception");
            TDMLog.i(tag, "Exception Track: " + e2);
            return new DeviceInfo<>("UUID", 100);
        }
    }

    public DeviceInfo<String> GetAndroidID(Context context) {
        return new DeviceInfo<>(Settings.Secure.getString(context.getContentResolver(), "android_id"));
    }

    @TargetApi(17)
    private void GetScreenSize(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f = displayMetrics.widthPixels;
            float f2 = displayMetrics.heightPixels;
            if (f > f2) {
                this.m_szScreenHeight = new DeviceInfo<>(Long.valueOf(f));
                this.m_szScreenWidth = new DeviceInfo<>(Long.valueOf(f2));
            } else {
                this.m_szScreenHeight = new DeviceInfo<>(Long.valueOf(f2));
                this.m_szScreenWidth = new DeviceInfo<>(Long.valueOf(f));
            }
        } catch (Exception e) {
            TDMLog.e(tag, "get GetScreenSize failed");
            TDMLog.i(tag, "Exception Track: " + e);
            this.m_szScreenHeight = new DeviceInfo<>(null, 100);
            this.m_szScreenWidth = new DeviceInfo<>(null, 100);
        }
    }

    public DeviceInfo<Long> GetScreenHeight(Context context) {
        if (this.m_szScreenHeight == null) {
            GetScreenSize(context);
        }
        return this.m_szScreenHeight;
    }

    public DeviceInfo<Long> GetScreenWidth(Context context) {
        if (this.m_szScreenWidth == null) {
            GetScreenSize(context);
        }
        return this.m_szScreenWidth;
    }

    public DeviceInfo<Long> GetCPUMaxFreqKHz() {
        Long l = GetCPUCores().value;
        if (l == null) {
            return new DeviceInfo<>(null, 100);
        }
        int i = -1;
        for (int i2 = 0; i2 < l.longValue(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            fileInputStream.read(bArr);
                            int i3 = 0;
                            while (bArr[i3] >= 48 && bArr[i3] <= 57 && i3 < bArr.length) {
                                i3++;
                            }
                            Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3, Charset.forName("UTF-8"))));
                            if (valueOf.intValue() > i) {
                                i = valueOf.intValue();
                            }
                        } catch (NumberFormatException e) {
                            TDMLog.e(tag, "fail to get cpuFreq by /sys/devices/,then use /proc/cpuinfo");
                            TDMLog.i(tag, "Exception Track: " + e);
                        }
                    } finally {
                        fileInputStream.close();
                    }
                }
            } catch (IOException e2) {
                TDMLog.i(tag, "GetCPUMaxFreqKHz IOException");
                TDMLog.i(tag, "Exception Track: " + e2);
                return new DeviceInfo<>(null, 100);
            }
        }
        TDMLog.d(tag, "GetCPUMaxFreqKHz temp maxFreq : " + i);
        if (i == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                if (parseFileForValue > i) {
                    i = parseFileForValue;
                }
                fileInputStream2.close();
            } catch (Throwable th) {
                fileInputStream2.close();
                throw th;
            }
        }
        if (i == -1) {
            return new DeviceInfo<>(null, 100);
        }
        return new DeviceInfo<>(Long.valueOf(i));
    }

    public DeviceInfo<Long> GetCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return new DeviceInfo<>(1L);
        }
        try {
            return new DeviceInfo<>(Long.valueOf(new File(ANDROID_CPU_INFO_PATH).listFiles(CPU_FILTER).length));
        } catch (NullPointerException e) {
            TDMLog.e(tag, "GetCPUCores NullPointerException");
            TDMLog.i(tag, "Exception Track: " + e);
            return new DeviceInfo<>(null, 100);
        } catch (SecurityException e2) {
            TDMLog.e(tag, "GetCPUCores SecurityException");
            TDMLog.i(tag, "Exception Track: " + e2);
            return new DeviceInfo<>(null, 100);
        }
    }

    public void GetQIMEI(Context context) {
        if (!this.mIsBeaconInit) {
            HashMap hashMap = new HashMap();
            hashMap.put("TEST_MODE", Boolean.valueOf(TDMUtils.GetInstance().isTestMode()));
            hashMap.put("APP_ID", TDMUtils.GetInstance().getBeaconAppId());
            hashMap.put("APP_VERSION", BuildConfig.VERSION_NAME);
            b.a().a(hashMap);
            this.mIsBeaconInit = true;
        }
        b.a().a(context, new b.a() { // from class: com.tdatamaster.tdm.device.DeviceInfoCollect.1
            @Override // com.tdatamaster.a.b.a
            public void onResult(int i, Object obj) {
                if (i == 0) {
                    DeviceInfoHolder.GetInstance().setDeviceInfo(DeviceInfoName.QIMEI_STRING, (String) obj);
                    return;
                }
                TDMLog.e("TDMQimei", "Error when get qimei, code:" + i + ", msg:" + obj);
            }
        });
    }

    public void GetQIMEI36(Context context) {
        if (!this.mIsBeaconInit) {
            HashMap hashMap = new HashMap();
            hashMap.put("TEST_MODE", Boolean.valueOf(TDMUtils.GetInstance().isTestMode()));
            hashMap.put("APP_ID", TDMUtils.GetInstance().getBeaconAppId());
            hashMap.put("APP_VERSION", BuildConfig.VERSION_NAME);
            b.a().a(hashMap);
            this.mIsBeaconInit = true;
        }
        b.a().b(context, new b.a() { // from class: com.tdatamaster.tdm.device.DeviceInfoCollect.2
            @Override // com.tdatamaster.a.b.a
            public void onResult(int i, Object obj) {
                if (i == 0) {
                    DeviceInfoHolder.GetInstance().setDeviceInfo(DeviceInfoName.QIMEI36_STRING, (String) obj);
                    return;
                }
                TDMLog.e("TDMQimei", "Error when get qimei, code:" + i + ", msg:" + obj);
            }
        });
    }

    public void GetTuringTicket(Context context) {
        com.tdatamaster.b.a.a().a(context, new a.InterfaceC0179a() { // from class: com.tdatamaster.tdm.device.DeviceInfoCollect.3
            @Override // com.tdatamaster.b.a.InterfaceC0179a
            public void onResult(int i, Object obj) {
                if (i == 0) {
                    DeviceInfoHolder.GetInstance().setDeviceInfo(DeviceInfoName.TURING_TICKET_STRING, (String) obj);
                    return;
                }
                TDMLog.w("TDMTurning", "Error when get turing ticket, code:" + i + ", msg:" + obj);
            }
        });
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    for (int i2 = i; i2 < read; i2++) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        }
                        if (i3 == str.length() - 1) {
                            return extractValue(bArr, i2);
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException e) {
            TDMLog.e(tag, "parseFileForValue IOException");
            TDMLog.i(tag, "Exception Track: " + e);
            return -1;
        } catch (NumberFormatException e2) {
            TDMLog.e(tag, "parseFileForValue NumberFormatException");
            TDMLog.i(tag, "Exception Track: " + e2);
            return -1;
        }
    }

    private static int extractValue(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (bArr[i] >= 48 && bArr[i] <= 57) {
                int i2 = i + 1;
                while (i2 < bArr.length && bArr[i2] >= 48 && bArr[i2] <= 57) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public DeviceInfo<String> GetMacAddress(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            NetworkInterface byName = NetworkInterface.getByName("eth1");
            if (byName == null) {
                TDMLog.w(tag, "networkInterface eth1 is null");
                byName = NetworkInterface.getByName("wlan0");
            }
            if (byName != null) {
                for (byte b : byName.getHardwareAddress()) {
                    stringBuffer.append(String.format("%02X:", Byte.valueOf(b)));
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                return new DeviceInfo<>(stringBuffer.toString());
            }
            return new DeviceInfo<>(null);
        } catch (Exception e) {
            TDMLog.i(tag, "GetMacAdress Exception e:" + e);
            return new DeviceInfo<>(null, 100);
        }
    }
}
