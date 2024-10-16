package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f6158a;
    private static Class<?> b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static boolean g;

    public static boolean a(Context context, QQToken qQToken) {
        return h.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f.invoke(f6158a, true);
            } else {
                f.invoke(f6158a, false);
            }
        } catch (Exception e2) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f6158a = Class.forName("com.tencent.stat.StatConfig");
            b = Class.forName("com.tencent.stat.StatService");
            c = b.getMethod("reportQQ", Context.class, String.class);
            d = b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            e = b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f = f6158a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f6158a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f6158a, false);
            f6158a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f6158a, true);
            f6158a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f6158a, 1440);
            Class<?> cls = Class.forName("com.tencent.stat.StatReportStrategy");
            f6158a.getMethod("setStatSendStrategy", cls).invoke(f6158a, cls.getField("PERIOD").get(null));
            b.getMethod("startStatService", Context.class, String.class, String.class).invoke(b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            g = true;
        } catch (Exception e2) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "0", "0", "0");
        }
        if (g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    c.invoke(b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (g) {
            b(context, qQToken);
            try {
                d.invoke(b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
