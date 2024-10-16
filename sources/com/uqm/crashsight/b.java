package com.uqm.crashsight;

import android.content.Context;
import android.util.Log;
import com.uqm.crashsight.proguard.d;
import com.uqm.crashsight.proguard.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6546a = true;
    public static List<a> b = new ArrayList();
    public static boolean c;
    private static d d;
    private static boolean e;

    private static boolean a(com.uqm.crashsight.crashreport.common.info.a aVar) {
        List<String> list = aVar.p;
        aVar.getClass();
        return list != null && list.contains("crashSight");
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, CrashSightStrategy crashSightStrategy) {
        synchronized (b.class) {
            if (e) {
                m.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                Log.w(m.f6622a, "[init] context of init() is null, check it.");
                return;
            }
            com.uqm.crashsight.crashreport.common.info.a a2 = com.uqm.crashsight.crashreport.common.info.a.a(context);
            if (a(a2)) {
                f6546a = false;
                return;
            }
            String f = a2.f();
            if (f == null) {
                Log.e(m.f6622a, "[init] meta data of CS_APPID in AndroidManifest.xml should be set.");
            } else {
                a(context, f, a2.v, crashSightStrategy);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0198 A[Catch: all -> 0x0249, TryCatch #0 {, blocks: (B:4:0x0009, B:7:0x0015, B:10:0x0029, B:12:0x0033, B:17:0x003e, B:21:0x0049, B:24:0x0052, B:26:0x0056, B:27:0x0092, B:29:0x00d4, B:32:0x00d8, B:34:0x00e6, B:36:0x00f2, B:38:0x00f8, B:39:0x010f, B:42:0x011e, B:44:0x0124, B:46:0x012e, B:48:0x0134, B:49:0x014b, B:50:0x015c, B:52:0x017a, B:53:0x018e, B:55:0x0198, B:57:0x019e, B:58:0x01b5, B:60:0x01c4, B:62:0x01ca, B:64:0x01d0, B:65:0x01e7, B:67:0x01f3, B:69:0x015f, B:71:0x016a, B:73:0x0174, B:75:0x0187, B:77:0x018b, B:79:0x0200, B:82:0x0208, B:84:0x0218, B:86:0x022e, B:96:0x0231, B:98:0x0236, B:99:0x023d, B:90:0x0225, B:92:0x022b), top: B:3:0x0009, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ca A[Catch: all -> 0x0249, TryCatch #0 {, blocks: (B:4:0x0009, B:7:0x0015, B:10:0x0029, B:12:0x0033, B:17:0x003e, B:21:0x0049, B:24:0x0052, B:26:0x0056, B:27:0x0092, B:29:0x00d4, B:32:0x00d8, B:34:0x00e6, B:36:0x00f2, B:38:0x00f8, B:39:0x010f, B:42:0x011e, B:44:0x0124, B:46:0x012e, B:48:0x0134, B:49:0x014b, B:50:0x015c, B:52:0x017a, B:53:0x018e, B:55:0x0198, B:57:0x019e, B:58:0x01b5, B:60:0x01c4, B:62:0x01ca, B:64:0x01d0, B:65:0x01e7, B:67:0x01f3, B:69:0x015f, B:71:0x016a, B:73:0x0174, B:75:0x0187, B:77:0x018b, B:79:0x0200, B:82:0x0208, B:84:0x0218, B:86:0x022e, B:96:0x0231, B:98:0x0236, B:99:0x023d, B:90:0x0225, B:92:0x022b), top: B:3:0x0009, inners: #1, #2 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void a(android.content.Context r20, java.lang.String r21, boolean r22, com.uqm.crashsight.CrashSightStrategy r23) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.b.a(android.content.Context, java.lang.String, boolean, com.uqm.crashsight.CrashSightStrategy):void");
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!b.contains(aVar)) {
                b.add(aVar);
            }
        }
    }
}
