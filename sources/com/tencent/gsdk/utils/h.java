package com.tencent.gsdk.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.gsdk.api.GSDKSystem;

/* loaded from: classes2.dex */
public class h {
    public static int a(Context context) {
        if (context == null) {
            return -1;
        }
        if (a() == 4) {
            String a2 = a(((WifiManager) context.getSystemService("wifi")).getDhcpInfo().gateway);
            int a3 = a(a2);
            g.b("ping gateway, ip: " + a2 + ", delay: " + a3);
            return a3;
        }
        g.b("ping gateway fail, not wifi");
        return -1;
    }

    public static int a() {
        return c.c(GSDKSystem.getInstance().a());
    }

    private static String a(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gsdk.utils.h.a(java.lang.String):int");
    }
}
