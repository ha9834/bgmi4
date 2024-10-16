package com.tencent.msdk.stat.common;

import java.io.File;

/* loaded from: classes.dex */
class n {
    public static boolean a() {
        for (String str : new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"}) {
            try {
                if (new File(str + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
