package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final String USEX5_FILE_NAME = "usex5.txt";

    /* renamed from: a, reason: collision with root package name */
    private static TbsExtensionFunctionManager f6465a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        if (f6465a == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                if (f6465a == null) {
                    f6465a = new TbsExtensionFunctionManager();
                }
            }
        }
        return f6465a;
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        File file = new File(context.getFilesDir(), str);
        TbsLog.d("TbsExtensionFunMana", file.getAbsolutePath());
        if (z) {
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        return true;
                    }
                } catch (IOException e) {
                    TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                    e.printStackTrace();
                    return false;
                }
            }
        } else if (file.exists()) {
            if (file.delete()) {
                return true;
            }
            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
            return false;
        }
        return true;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (file.exists()) {
            if (file.isFile()) {
                return true;
            }
        }
        return false;
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4);
        } else {
            sharedPreferences = context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
        }
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
    }
}
