package com.uqm.crashsight;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.android.IR;
import com.uqm.crashsight.proguard.c;
import com.uqm.crashsight.proguard.d;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import java.util.Map;

/* loaded from: classes.dex */
public class CrashSight {
    public static final String SDK_IS_DEV = "false";

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6544a = false;
    public static Context applicationContext = null;
    private static String[] b = {"CrashSightCrashModule"};
    private static String[] c = {"CrashSightRqdModule", "CrashSightCrashModule", "CrashSightBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void init(Context context, String str, boolean z, CrashSightStrategy crashSightStrategy) {
        synchronized (CrashSight.class) {
            if (f6544a) {
                return;
            }
            f6544a = true;
            Context a2 = q.a(context);
            applicationContext = a2;
            if (a2 == null) {
                Log.e(m.f6622a, "init arg 'context' should not be null!");
                return;
            }
            if (isDev()) {
                b = c;
            }
            for (String str2 : b) {
                try {
                    if (str2.equals("CrashSightCrashModule")) {
                        b.a(CrashModule.getInstance());
                    } else if (!str2.equals("CrashSightBetaModule") && !str2.equals("CrashSightRqdModule")) {
                        str2.equals("CrashSightFeedbackModule");
                    }
                } catch (Throwable th) {
                    m.b(th);
                }
            }
            b.f6546a = enable;
            b.a(applicationContext, str, z, crashSightStrategy);
        }
    }

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (CrashSight.class) {
            com.uqm.crashsight.crashreport.common.info.a b2 = com.uqm.crashsight.crashreport.common.info.a.b();
            if (b2 == null) {
                return null;
            }
            if (TextUtils.isEmpty(b2.m)) {
                d a2 = d.a();
                if (a2 == null) {
                    return b2.m;
                }
                Map<String, byte[]> a3 = a2.a(556, (c) null, true);
                if (a3 != null && (bArr = a3.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return b2.m;
        }
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean(SDK_IS_DEV.replace(IR.account.EMAIL_TAG, "")));
        }
        return isDev.booleanValue();
    }
}
