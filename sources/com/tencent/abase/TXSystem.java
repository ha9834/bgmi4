package com.tencent.abase;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.adjust.sdk.Constants;
import com.tencent.abase.log.XLog;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TXSystem {
    private static final String AES_KEY = "";
    private int m_szTargetVersion;
    private String m_szModel = null;
    private String m_szSysVersion = null;
    private String m_szBundleId = null;

    public String GetBundleId(Context context) {
        try {
            this.m_szBundleId = context.getPackageName();
            return this.m_szBundleId;
        } catch (Exception e) {
            XLog.e("TXSystem", "GetBundleId Exception:" + e);
            return null;
        }
    }

    public String GetModel() {
        this.m_szModel = Build.MODEL;
        String str = this.m_szModel;
        return str != null ? str : "Model unknown";
    }

    public String GetSysVersion() {
        this.m_szSysVersion = Build.VERSION.RELEASE;
        String str = this.m_szSysVersion;
        return str != null ? str : "SysVersion unknown";
    }

    public int GetTargetVersion(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            this.m_szTargetVersion = packageManager.getPackageInfo(context.getPackageName(), 1).applicationInfo.targetSdkVersion;
            return this.m_szTargetVersion;
        } catch (PackageManager.NameNotFoundException e) {
            XLog.e("TXSystem", "GetTargetVersion Exception:" + e);
            return 0;
        }
    }

    public String GetAppVersion(Context context) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 1)) == null) {
                return "";
            }
            if (TX.Instance.getSolidConfigBool("GCloud.GCloudCore", "EnableVersionCode", false)) {
                return packageInfo.versionName + "." + packageInfo.versionCode;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            XLog.e("TXSystem", "GetGameVersion Exception:" + e);
            return "";
        }
    }

    public String GetUdid(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        StringBuilder sb = new StringBuilder();
        sb.append("%");
        sb.append("");
        sb.append("%");
        sb.append("");
        if (string != null) {
            sb.append("%");
            sb.append(string);
        }
        String sb2 = sb.toString();
        if (sb2.length() == 0) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            if (messageDigest == null) {
                return "";
            }
            messageDigest.update(sb2.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb3 = new StringBuilder();
            for (byte b : digest) {
                sb3.append(Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
            }
            return sb3.toString().toUpperCase(Locale.ENGLISH);
        } catch (NoSuchAlgorithmException unused) {
            XLog.w("Exception", "NoSuchAlgorithmException:MD5");
            return "";
        }
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }
}
