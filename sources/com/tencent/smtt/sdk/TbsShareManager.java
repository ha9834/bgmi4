package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.connect.common.Constants;

/* loaded from: classes2.dex */
public class TbsShareManager {

    /* renamed from: a, reason: collision with root package name */
    private static Context f6477a;
    private static boolean b;
    private static String c;
    public static boolean mHasQueryed;

    public static String getHostCorePathAppDefined() {
        return c;
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (f6477a != null && f6477a.equals(context.getApplicationContext())) {
            return b;
        }
        f6477a = context.getApplicationContext();
        String packageName = f6477a.getPackageName();
        for (String str : getCoreProviderAppList()) {
            if (packageName.equals(str)) {
                b = false;
                return false;
            }
        }
        b = true;
        return true;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, TbsConfig.APP_WX, "com.tencent.mobileqq", "com.qzone", Constants.PACKAGE_QQ_SPEED};
    }
}
