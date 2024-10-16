package com.tencent.abase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.tencent.abase.log.XLog;
import java.util.List;

/* loaded from: classes2.dex */
public class SolidConfigReader {
    private Context m_context;

    public void Dump() {
    }

    public void UnInit() {
    }

    public void Init(Context context) {
        this.m_context = context;
    }

    public int GetInt(String str, String str2, int i) {
        ApplicationInfo applicationInfo;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return i;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) == null || applicationInfo.metaData == null) {
                return i;
            }
            return applicationInfo.metaData.getInt(str + "." + str2, i);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public String GetString(String str, String str2, String str3) {
        ApplicationInfo applicationInfo;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return str3;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) == null || applicationInfo.metaData == null) {
                return str3;
            }
            return applicationInfo.metaData.getString(str + "." + str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return str3;
        }
    }

    public boolean GetBool(String str, String str2, boolean z) {
        ApplicationInfo applicationInfo;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return z;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) == null || applicationInfo.metaData == null) {
                return z;
            }
            return applicationInfo.metaData.getBoolean(str + "." + str2, z);
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public void GetAllKeys(String str, List<String> list) {
        ApplicationInfo applicationInfo;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return;
        }
        if (str == null || list == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) == null || applicationInfo.metaData == null) {
                return;
            }
            for (String str2 : applicationInfo.metaData.keySet()) {
                int length = str.length();
                if (str2.length() > length && str2.substring(0, length).equals(str)) {
                    list.add(str2.substring(length + 1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean IsContainKey(String str, String str2) {
        ApplicationInfo applicationInfo;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return false;
        }
        if (str == null || str2 == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) != null && applicationInfo.metaData != null) {
                for (String str3 : applicationInfo.metaData.keySet()) {
                    int length = str.length();
                    if (str3.length() > length && str3.substring(0, length).equals(str) && str2.equals(str3.substring(length + 1))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String GetMetaString(Context context, String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "";
        }
        if (str == null || !str.equals("Application")) {
            return str3;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager != null ? packageManager.getApplicationInfo(context.getPackageName(), 128).metaData.getString(str2) : str3;
        } catch (Exception e) {
            e.printStackTrace();
            return str3;
        }
    }
}
