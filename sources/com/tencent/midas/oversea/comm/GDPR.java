package com.tencent.midas.oversea.comm;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.local.LocalMid;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.APMidasPayAPI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.UUID;

/* loaded from: classes.dex */
public class GDPR {
    public static final String TAG = "GDPR";
    private static String androidId = "";
    private static String cacheUserIp = "";
    private static String deviceGuid = "";
    private static String deviceInfo = "";
    public static boolean ifCollect = true;
    private static String psuedoId = "";
    private static String userIMEI = "";
    private static String userMAC = "";
    private static String xgMid = "";

    public static String getDeviceType() {
        return !ifCollect ? "" : Build.MODEL;
    }

    public static String getDeviceName() {
        return !ifCollect ? "" : Build.USER;
    }

    public static String getSysVersion() {
        return !ifCollect ? "" : Build.VERSION.RELEASE;
    }

    public static String getDeviceManufacturer() {
        return !ifCollect ? "" : Build.MANUFACTURER;
    }

    public static String getDevice() {
        return !ifCollect ? "" : Build.DEVICE;
    }

    public static String getDeviceInfo(Context context) {
        if (!ifCollect) {
            return "";
        }
        if (!TextUtils.isEmpty(deviceInfo)) {
            return deviceInfo;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("imei=");
        sb.append(getDeviceId(context));
        sb.append("&mac=");
        sb.append(getMacAddress(context));
        sb.append("&androidId=");
        sb.append(getAndroidId(context));
        sb.append("&deviceGuid=");
        sb.append(getDeviceGuid(context));
        sb.append("&psuedoId=");
        sb.append(getPsuedoId());
        sb.append("&androidSdkVersion=");
        sb.append(Build.VERSION.SDK_INT);
        String str = Build.DEVICE;
        if (!TextUtils.isEmpty(str)) {
            sb.append("&device=");
            sb.append(str);
        }
        sb.append("&manufacturer=");
        sb.append(Build.MANUFACTURER);
        sb.append("&sdkVersion=");
        sb.append(Build.VERSION.RELEASE);
        sb.append("&showModel=");
        sb.append(Build.MODEL);
        sb.append("&phoneIp=");
        sb.append(getLocalIp());
        sb.append("&oper=");
        sb.append(getOperator(context));
        String availMemory2 = getAvailMemory2(context);
        if (!TextUtils.isEmpty(availMemory2)) {
            sb.append("&availableMemory=");
            sb.append(availMemory2);
        }
        String totalMemory = getTotalMemory(context);
        if (!TextUtils.isEmpty(totalMemory)) {
            sb.append("&totalMemory=");
            sb.append(totalMemory);
        }
        String[] cpuInfo = getCpuInfo();
        if (cpuInfo.length == 2) {
            sb.append("&cup=");
            sb.append(cpuInfo[0]);
            sb.append("&cupFrequency=");
            sb.append(cpuInfo[1]);
        }
        deviceInfo = sb.toString();
        return deviceInfo;
    }

    public static String getWifiSSID(Context context) {
        if (!ifCollect) {
            return "";
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "";
        } catch (Exception e) {
            APLog.i(TAG, "getWifiSSID failed: " + e.getMessage());
            return "";
        }
    }

    public static String getMacAddress(Context context) {
        WifiInfo connectionInfo;
        if (!ifCollect) {
            return "";
        }
        if (!TextUtils.isEmpty(userMAC)) {
            return userMAC;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                userMAC = connectionInfo.getMacAddress();
            }
            if (TextUtils.isEmpty(userMAC) || "02:00:00:00:00:00".equals(userMAC)) {
                byte[] hardwareAddress = NetworkInterface.getByInetAddress(InetAddress.getByName(getLocalIp())).getHardwareAddress();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < hardwareAddress.length; i++) {
                    if (i != 0) {
                        stringBuffer.append(':');
                    }
                    String hexString = Integer.toHexString(hardwareAddress[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                    if (hexString.length() == 1) {
                        hexString = 0 + hexString;
                    }
                    stringBuffer.append(hexString);
                }
                userMAC = stringBuffer.toString().toUpperCase();
            }
        } catch (Exception e) {
            APLog.e(TAG, "getMacAddress failed: " + e.getMessage());
        }
        APLog.d(TAG, "MAC: " + userMAC);
        return userMAC;
    }

    public static String getLocalIp() {
        if (!ifCollect) {
            return "";
        }
        if (!TextUtils.isEmpty(cacheUserIp)) {
            return cacheUserIp;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                        cacheUserIp = nextElement.getHostAddress();
                        return cacheUserIp;
                    }
                }
            }
            return "";
        } catch (Exception e) {
            APLog.e(TAG, "getLocalIp(): " + e.getMessage());
            return "";
        }
    }

    public static String getAvailMemory2(Context context) {
        if (!ifCollect) {
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "";
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return Formatter.formatFileSize(context, memoryInfo.availMem);
        } catch (Exception e) {
            APLog.e(TAG, "getAvailMemory2: " + e.getMessage());
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7 A[Catch: Exception -> 0x00a3, TRY_LEAVE, TryCatch #7 {Exception -> 0x00a3, blocks: (B:43:0x009f, B:36:0x00a7), top: B:42:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getTotalMemory(android.content.Context r11) {
        /*
            boolean r0 = com.tencent.midas.oversea.comm.GDPR.ifCollect
            if (r0 != 0) goto L7
            java.lang.String r11 = ""
            return r11
        L7:
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6f
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6f
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L66
            r5 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L66
            java.lang.String r3 = r0.readLine()     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            if (r3 == 0) goto L55
            java.lang.String r5 = "\\s+"
            java.lang.String[] r5 = r3.split(r5)     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            int r6 = r5.length     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            r7 = 0
        L26:
            if (r7 >= r6) goto L41
            r8 = r5[r7]     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            r9.<init>()     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            r9.append(r8)     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            java.lang.String r8 = "\t"
            r9.append(r8)     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            java.lang.String r8 = r9.toString()     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            android.util.Log.i(r3, r8)     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            int r7 = r7 + 1
            goto L26
        L41:
            if (r5 == 0) goto L55
            int r3 = r5.length     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            r6 = 2
            if (r3 < r6) goto L55
            r3 = 1
            r3 = r5[r3]     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            int r1 = r3.intValue()     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L9c
            int r1 = r1 * 1024
            long r1 = (long) r1
        L55:
            r0.close()     // Catch: java.lang.Exception -> L5c
            r4.close()     // Catch: java.lang.Exception -> L5c
            goto L97
        L5c:
            r0 = move-exception
            r0.printStackTrace()
            goto L97
        L61:
            r3 = move-exception
            goto L73
        L63:
            r11 = move-exception
            r0 = r3
            goto L9d
        L66:
            r0 = move-exception
            r10 = r3
            r3 = r0
            r0 = r10
            goto L73
        L6b:
            r11 = move-exception
            r0 = r3
            r4 = r0
            goto L9d
        L6f:
            r0 = move-exception
            r4 = r3
            r3 = r0
            r0 = r4
        L73:
            java.lang.String r5 = "GDPR"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r6.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = "getTotalMemory(): "
            r6.append(r7)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L9c
            r6.append(r3)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L9c
            com.tencent.midas.comm.APLog.e(r5, r3)     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L92
            r0.close()     // Catch: java.lang.Exception -> L5c
        L92:
            if (r4 == 0) goto L97
            r4.close()     // Catch: java.lang.Exception -> L5c
        L97:
            java.lang.String r11 = android.text.format.Formatter.formatFileSize(r11, r1)
            return r11
        L9c:
            r11 = move-exception
        L9d:
            if (r0 == 0) goto La5
            r0.close()     // Catch: java.lang.Exception -> La3
            goto La5
        La3:
            r0 = move-exception
            goto Lab
        La5:
            if (r4 == 0) goto Lae
            r4.close()     // Catch: java.lang.Exception -> La3
            goto Lae
        Lab:
            r0.printStackTrace()
        Lae:
            throw r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.oversea.comm.GDPR.getTotalMemory(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[] getCpuInfo() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String[] strArr = {"", ""};
        if (!ifCollect) {
            return strArr;
        }
        String str = null;
        r5 = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/cpuinfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader, 8192);
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e = e3;
                fileReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                fileReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = str;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\s+");
                for (int i = 2; i < split.length; i++) {
                    strArr[0] = strArr[0] + split[i] + " ";
                }
            } else {
                strArr[0] = strArr[0] + "";
            }
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                String[] split2 = readLine2.split("\\s+");
                if (split2 != null && split2.length >= 3) {
                    strArr[1] = strArr[1] + split2[2];
                } else {
                    strArr[1] = strArr[1] + "";
                }
            } else {
                strArr[1] = strArr[1] + "";
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e4) {
            e = e4;
            bufferedReader2 = bufferedReader;
            APLog.e(TAG, "getCpuInfo(): " + e.getMessage());
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            str = "cpuinfo=";
            sb.append("cpuinfo=");
            sb.append(strArr[0]);
            sb.append(" cupinfo2=");
            sb.append(strArr[1]);
            printStream.println(sb.toString());
            return strArr;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                    throw th;
                }
            }
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
        PrintStream printStream2 = System.out;
        StringBuilder sb2 = new StringBuilder();
        str = "cpuinfo=";
        sb2.append("cpuinfo=");
        sb2.append(strArr[0]);
        sb2.append(" cupinfo2=");
        sb2.append(strArr[1]);
        printStream2.println(sb2.toString());
        return strArr;
    }

    public static String getUUID() {
        if (!ifCollect) {
            return "";
        }
        try {
            return UUID.randomUUID().toString();
        } catch (Exception e) {
            APLog.e(TAG, "getUUID(): " + e.getMessage());
            return "";
        }
    }

    public static String getAndroidId(Context context) {
        if (!ifCollect) {
            return "";
        }
        if (!TextUtils.isEmpty(androidId)) {
            return androidId;
        }
        try {
            androidId = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return androidId;
        } catch (Exception e) {
            APLog.i(TAG, "getAndroidId failed: " + e.getMessage());
            return "";
        }
    }

    public static String getXgMid() {
        if (!ifCollect) {
            return "";
        }
        if (!TextUtils.isEmpty(xgMid)) {
            return xgMid;
        }
        try {
            xgMid = LocalMid.getInstance(APMidasPayAPI.singleton().getApplicationContext()).getLocalMid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xgMid;
    }

    public static String getDeviceId(Context context) {
        if (!ifCollect) {
            return "";
        }
        if (!TextUtils.isEmpty(userIMEI)) {
            return userIMEI;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            userIMEI = telephonyManager.getDeviceId();
            return userIMEI;
        } catch (Exception e) {
            APLog.e(TAG, "getDeviceId failed: " + e.getMessage());
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getOperator(android.content.Context r5) {
        /*
            boolean r0 = com.tencent.midas.oversea.comm.GDPR.ifCollect
            if (r0 == 0) goto L87
            if (r5 != 0) goto L8
            goto L87
        L8:
            java.lang.String r0 = ""
            java.lang.String r1 = "phone"
            java.lang.Object r5 = r5.getSystemService(r1)
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5
            r1 = -1
            if (r5 == 0) goto L71
            int r2 = r5.getPhoneType()     // Catch: java.lang.Exception -> L54
            r3 = 1
            if (r2 != r3) goto L21
            java.lang.String r0 = r5.getSubscriberId()     // Catch: java.lang.Exception -> L54
            goto L2b
        L21:
            int r2 = r5.getPhoneType()     // Catch: java.lang.Exception -> L54
            if (r2 == 0) goto L2b
            java.lang.String r0 = r5.getSimOperator()     // Catch: java.lang.Exception -> L54
        L2b:
            r5 = 3
            if (r0 == 0) goto L3e
            int r2 = r0.length()     // Catch: java.lang.Exception -> L54
            if (r2 < r5) goto L3e
            r2 = 0
            java.lang.String r2 = r0.substring(r2, r5)     // Catch: java.lang.Exception -> L54
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L54
            goto L3f
        L3e:
            r2 = -1
        L3f:
            if (r0 == 0) goto L72
            int r3 = r0.length()     // Catch: java.lang.Exception -> L52
            r4 = 5
            if (r3 < r4) goto L72
            java.lang.String r5 = r0.substring(r5, r4)     // Catch: java.lang.Exception -> L52
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L52
            r1 = r5
            goto L72
        L52:
            r5 = move-exception
            goto L56
        L54:
            r5 = move-exception
            r2 = -1
        L56:
            java.lang.String r0 = "GDPR"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getOperatorInfo(): "
            r3.append(r4)
            java.lang.String r5 = r5.getMessage()
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            com.tencent.midas.comm.APLog.e(r0, r5)
            goto L72
        L71:
            r2 = -1
        L72:
            java.lang.String r5 = ""
            r0 = 460(0x1cc, float:6.45E-43)
            if (r2 != r0) goto L86
            switch(r1) {
                case 0: goto L84;
                case 1: goto L81;
                case 2: goto L84;
                case 3: goto L7e;
                case 4: goto L7b;
                case 5: goto L7e;
                case 6: goto L81;
                case 7: goto L84;
                default: goto L7b;
            }
        L7b:
            java.lang.String r5 = ""
            goto L86
        L7e:
            java.lang.String r5 = "vnet"
            goto L86
        L81:
            java.lang.String r5 = "unicom"
            goto L86
        L84:
            java.lang.String r5 = "gmcc"
        L86:
            return r5
        L87:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.oversea.comm.GDPR.getOperator(android.content.Context):java.lang.String");
    }

    public static String getPsuedoId() {
        if (!ifCollect) {
            return "";
        }
        if (!TextUtils.isEmpty(psuedoId)) {
            return psuedoId;
        }
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        try {
            psuedoId = new UUID(str.hashCode(), Build.class.getField("SERIAL").get(null).toString().hashCode()).toString();
            APLog.d(TAG, "get serial success");
        } catch (Exception unused) {
            APLog.d(TAG, "get serial exception");
            psuedoId = new UUID(str.hashCode(), "serial".hashCode()).toString();
        }
        return psuedoId;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ec A[Catch: IOException -> 0x0126, FileNotFoundException -> 0x0142, TryCatch #2 {FileNotFoundException -> 0x0142, IOException -> 0x0126, blocks: (B:11:0x0015, B:13:0x0023, B:17:0x0059, B:19:0x0064, B:21:0x006a, B:22:0x009d, B:24:0x00a5, B:26:0x00b4, B:28:0x00dd, B:30:0x00e3, B:32:0x00ec, B:33:0x00f5, B:35:0x00fb, B:36:0x00fe), top: B:10:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb A[Catch: IOException -> 0x0126, FileNotFoundException -> 0x0142, TryCatch #2 {FileNotFoundException -> 0x0142, IOException -> 0x0126, blocks: (B:11:0x0015, B:13:0x0023, B:17:0x0059, B:19:0x0064, B:21:0x006a, B:22:0x009d, B:24:0x00a5, B:26:0x00b4, B:28:0x00dd, B:30:0x00e3, B:32:0x00ec, B:33:0x00f5, B:35:0x00fb, B:36:0x00fe), top: B:10:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getDeviceGuid(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.oversea.comm.GDPR.getDeviceGuid(android.content.Context):java.lang.String");
    }
}
