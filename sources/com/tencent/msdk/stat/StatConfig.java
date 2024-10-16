package com.tencent.msdk.stat;

import android.content.Context;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.support.res.values.HSConsts;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.tencent.msdk.stat.common.StatConstants;
import com.tencent.msdk.stat.common.StatLogger;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class StatConfig {
    private static String B;
    private static String C;
    private static String F;
    private static StatLogger p = com.tencent.msdk.stat.common.j.b();

    /* renamed from: a, reason: collision with root package name */
    static h f6283a = new h(2);
    static h b = new h(1);
    private static StatReportStrategy q = StatReportStrategy.APP_LAUNCH;
    private static boolean r = false;
    private static boolean s = true;
    private static int t = NetworkConstants.UPLOAD_CONNECT_TIMEOUT;
    private static int u = 100000;
    private static int v = 30;
    private static int w = 10;
    private static int x = 100;
    private static int y = 30;
    private static int z = 1;
    static String c = "__HIBERNATE__";
    static String d = "__HIBERNATE__TIME";
    static String e = "__MTA_KILL__";
    private static String A = null;
    private static String D = "mta_channel";
    static String f = "";
    private static int E = 180;
    static boolean g = false;
    static int h = 1000;
    static long i = LogUtils.LOG_FUSE_TIME;
    private static int G = 1024;
    static boolean j = true;
    private static long H = 0;
    private static long I = 300000;
    public static boolean isAutoExceptionCaught = true;
    static volatile String k = StatConstants.MTA_SERVER;
    private static volatile String J = StatConstants.MTA_REPORT_FULL_URL;
    private static int K = 0;
    private static volatile int L = 0;
    private static int M = 20;
    private static int N = 0;
    private static boolean O = false;
    private static int P = 4096;
    private static boolean Q = false;
    private static String R = null;
    static boolean l = true;
    static int m = 0;
    static long n = LogUtils.LOG_FUSE_TIME;
    static int o = 512;
    private static i S = null;
    private static JSONObject T = null;
    private static String U = null;
    private static JSONObject V = null;
    private static HashSet<String> W = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return v;
    }

    static String a(Context context) {
        return com.tencent.msdk.stat.common.p.a(com.tencent.msdk.stat.common.o.a(context, "_mta_ky_tag_", (String) null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(int i2) {
        synchronized (StatConfig.class) {
            L = i2;
        }
    }

    static void a(long j2) {
        com.tencent.msdk.stat.common.o.b(k.a(), c, j2);
        setEnableStatService(false);
        p.warn("MTA is disable for current SDK version");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, h hVar) {
        if (hVar.f6329a != b.f6329a) {
            if (hVar.f6329a == f6283a.f6329a) {
                f6283a = hVar;
            }
        } else {
            b = hVar;
            a(b.b);
            if (!b.b.isNull("iplist")) {
                a.a(context).a(b.b.getString("iplist"));
            }
            updateDontReportEventIdsSet(b.b.optString("__DONT_REPORT_EI_LIST__", null));
        }
    }

    static void a(Context context, h hVar, JSONObject jSONObject) {
        boolean z2 = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    int i2 = jSONObject.getInt(next);
                    if (hVar.d != i2) {
                        z2 = true;
                    }
                    hVar.d = i2;
                } else if (next.equalsIgnoreCase(IR.path.DOCS_IMSDK_CHANNEL)) {
                    String string = jSONObject.getString(IR.path.DOCS_IMSDK_CHANNEL);
                    if (string.length() > 0) {
                        hVar.b = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase("m")) {
                    hVar.c = jSONObject.getString("m");
                }
            }
            if (z2) {
                aj a2 = aj.a(k.a());
                if (a2 != null) {
                    a2.a(hVar);
                }
                if (hVar.f6329a == b.f6329a) {
                    a(hVar.b);
                    b(hVar.b);
                }
            }
            a(context, hVar);
        } catch (Throwable th) {
            p.e(th);
        }
    }

    static void a(Context context, String str) {
        if (str != null) {
            com.tencent.msdk.stat.common.o.b(context, "_mta_ky_tag_", com.tencent.msdk.stat.common.p.b(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        h hVar;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(b.f6329a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    hVar = b;
                } else if (next.equalsIgnoreCase(Integer.toString(f6283a.f6329a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    hVar = f6283a;
                } else {
                    if (!next.equalsIgnoreCase(HSConsts.READ_STATUS_KEY)) {
                        return;
                    }
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(next));
                    if (statReportStrategy != null) {
                        q = statReportStrategy;
                        if (isDebugEnable()) {
                            p.d("Change to ReportStrategy:" + statReportStrategy.name());
                        }
                    }
                }
                a(context, hVar, jSONObject2);
            }
        } catch (JSONException e2) {
            p.e((Throwable) e2);
        }
    }

    static void a(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(HSConsts.READ_STATUS_KEY));
            if (statReportStrategy != null) {
                setStatSendStrategy(statReportStrategy);
            }
        } catch (JSONException unused) {
            if (isDebugEnable()) {
                p.i("rs not found.");
            }
        }
    }

    static boolean a(int i2, int i3, int i4) {
        return i2 >= i3 && i2 <= i4;
    }

    private static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String str2 = B;
        if (str2 == null) {
            B = str;
            return true;
        }
        if (str2.contains(str)) {
            return false;
        }
        B += "|" + str;
        return true;
    }

    static boolean a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject.isNull(str)) {
            return false;
        }
        String optString = jSONObject.optString(str);
        return com.tencent.msdk.stat.common.j.c(str2) && com.tencent.msdk.stat.common.j.c(optString) && str2.equalsIgnoreCase(optString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        N++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i2) {
        if (i2 < 0) {
            return;
        }
        N = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040 A[Catch: Exception -> 0x01e2, TryCatch #0 {Exception -> 0x01e2, blocks: (B:2:0x0000, B:4:0x000c, B:8:0x0018, B:10:0x0021, B:12:0x002b, B:13:0x002d, B:15:0x0040, B:17:0x0046, B:18:0x0061, B:19:0x0032, B:21:0x0036, B:23:0x007a, B:25:0x0085, B:26:0x008d, B:28:0x0097, B:29:0x00b0, B:31:0x00bc, B:32:0x00d7, B:34:0x00f2, B:35:0x0110, B:37:0x012b, B:38:0x0144, B:40:0x015f, B:41:0x0178, B:43:0x018c, B:44:0x01af, B:46:0x01bb, B:48:0x01d8), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void b(android.content.Context r6, org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msdk.stat.StatConfig.b(android.content.Context, org.json.JSONObject):void");
    }

    static void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            b(k.a(), jSONObject);
            String string = jSONObject.getString(c);
            if (isDebugEnable()) {
                p.d("hibernateVer:" + string + ", current version:" + StatConstants.VERSION);
            }
            long b2 = com.tencent.msdk.stat.common.j.b(string);
            if (com.tencent.msdk.stat.common.j.b(StatConstants.VERSION) <= b2) {
                a(b2);
            }
        } catch (JSONException unused) {
            p.d("__HIBERNATE__ not found.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c() {
        return N;
    }

    public static synchronized String getAppKey(Context context) {
        synchronized (StatConfig.class) {
            if (B != null) {
                return B;
            }
            if (context != null && B == null) {
                B = com.tencent.msdk.stat.common.j.f(context);
            }
            if (B == null || B.trim().length() == 0) {
                p.e("AppKey can not be null or empty, please read Developer's Guide first!");
            }
            return B;
        }
    }

    public static String getAppVersion() {
        return U;
    }

    public static JSONObject getCommonAttr(Context context) {
        if (T == null) {
            try {
                T = new JSONObject(com.tencent.msdk.stat.common.o.a(context, "mta.common.attr.tag", new JSONObject().toString()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return T;
    }

    public static int getCurSessionStatReportCount() {
        return L;
    }

    public static JSONObject getCustomGlobalReportContent() {
        return V;
    }

    public static String getCustomProperty(String str) {
        try {
            return f6283a.b.getString(str);
        } catch (Throwable th) {
            p.e(th);
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        String string;
        try {
            string = f6283a.b.getString(str);
        } catch (Throwable th) {
            p.e(th);
        }
        return string != null ? string : str2;
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            p.error("Context for getCustomUid is null.");
            return null;
        }
        if (R == null) {
            try {
                R = com.tencent.msdk.stat.common.o.a(context, "MTA_CUSTOM_UID", "");
            } catch (ClassCastException e2) {
                p.e((Throwable) e2);
            }
        }
        return R;
    }

    public static long getFlushDBSpaceMS() {
        return n;
    }

    public static synchronized String getInstallChannel(Context context) {
        synchronized (StatConfig.class) {
            if (C != null) {
                return C;
            }
            C = com.tencent.msdk.stat.common.o.a(context, D, "");
            if (C == null || C.trim().length() == 0) {
                C = com.tencent.msdk.stat.common.j.g(context);
            }
            if (C == null || C.trim().length() == 0) {
                p.w("installChannel can not be null or empty, please read Developer's Guide first!");
            }
            return C;
        }
    }

    public static String getLocalMidOnly(Context context) {
        return com.tencent.msdk.a.a.c.a(context).a();
    }

    public static String getMTAPreferencesFileName() {
        return F;
    }

    public static int getMaxBatchReportCount() {
        return y;
    }

    public static int getMaxDaySessionNumbers() {
        return M;
    }

    public static int getMaxImportantDataSendRetryCount() {
        return x;
    }

    public static int getMaxParallelTimmingEvents() {
        return G;
    }

    public static int getMaxReportEventLength() {
        return P;
    }

    public static int getMaxSendRetryCount() {
        return w;
    }

    public static int getMaxSessionStatReportCount() {
        return K;
    }

    public static int getMaxStoreEventCount() {
        return u;
    }

    public static String getMid(Context context) {
        return com.tencent.msdk.a.a.c.a(context).a();
    }

    public static long getMsPeriodForMethodsCalledLimitClear() {
        return i;
    }

    public static int getNumEventsCachedInMemory() {
        return m;
    }

    public static int getNumEventsCommitPerSec() {
        return z;
    }

    public static int getNumOfMethodsCalledLimit() {
        return h;
    }

    public static String getQQ() {
        return f;
    }

    public static String getQQ(Context context) {
        return com.tencent.msdk.stat.common.o.a(context, "mta.acc.qq", f);
    }

    public static int getReportCompressedSize() {
        return o;
    }

    public static int getSendPeriodMinutes() {
        return E;
    }

    public static int getSessionTimoutMillis() {
        return t;
    }

    public static String getStatReportHost() {
        return k;
    }

    public static String getStatReportUrl() {
        return J;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return q;
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable() {
        return r;
    }

    public static boolean isEnableConcurrentProcess() {
        return Q;
    }

    public static boolean isEnableSmartReporting() {
        return j;
    }

    public static boolean isEnableStatService() {
        return s;
    }

    public static boolean isEventIdInDontReportEventIdsSet(String str) {
        HashSet<String> hashSet = W;
        if (hashSet == null || hashSet.size() == 0 || !com.tencent.msdk.stat.common.j.c(str)) {
            return false;
        }
        return W.contains(str.toLowerCase());
    }

    public static boolean isReportEventsByOrder() {
        return l;
    }

    public static void setAppKey(Context context, String str) {
        StatLogger statLogger;
        String str2;
        if (context == null) {
            statLogger = p;
            str2 = "ctx in StatConfig.setAppKey() is null";
        } else {
            if (str != null && str.length() <= 256) {
                if (B == null) {
                    B = a(context);
                }
                if (a(str) || a(com.tencent.msdk.stat.common.j.f(context))) {
                    a(context, B);
                    return;
                }
                return;
            }
            statLogger = p;
            str2 = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes";
        }
        statLogger.error(str2);
    }

    public static void setAppKey(String str) {
        StatLogger statLogger;
        String str2;
        if (str == null) {
            statLogger = p;
            str2 = "appkey in StatConfig.setAppKey() is null";
        } else if (str.length() <= 256) {
            B = str;
            return;
        } else {
            statLogger = p;
            str2 = "The length of appkey cann't exceed 256 bytes.";
        }
        statLogger.error(str2);
    }

    public static void setAppVersion(String str) {
        U = str;
    }

    public static void setAutoExceptionCaught(boolean z2) {
        isAutoExceptionCaught = z2;
    }

    public static void setCommonAttr(Context context, JSONObject jSONObject) {
        T = jSONObject;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.tencent.msdk.stat.common.o.b(context, "mta.common.attr.tag", jSONObject.toString());
    }

    public static void setCustomGlobalReportContent(JSONObject jSONObject) {
        V = jSONObject;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            p.error("Context for setCustomUid is null.");
        } else {
            com.tencent.msdk.stat.common.o.b(context, "MTA_CUSTOM_UID", str);
            R = str;
        }
    }

    public static void setDebugEnable(boolean z2) {
        r = z2;
        com.tencent.msdk.stat.common.j.b().setDebugEnable(z2);
    }

    public static void setEnableConcurrentProcess(boolean z2) {
        Q = z2;
    }

    public static void setEnableSmartReporting(boolean z2) {
        j = z2;
    }

    public static void setEnableStatService(boolean z2) {
        s = z2;
        if (z2) {
            return;
        }
        p.warn("!!!!!!MTA StatService has been disabled!!!!!!");
    }

    public static void setFlushDBSpaceMS(long j2) {
        if (j2 > 0) {
            n = j2;
        }
    }

    public static void setInstallChannel(Context context, String str) {
        if (str.length() > 128) {
            p.error("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            C = str;
            com.tencent.msdk.stat.common.o.b(context, D, str);
        }
    }

    public static void setInstallChannel(String str) {
        if (str.length() > 128) {
            p.error("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            C = str;
        }
    }

    public static void setMTAPreferencesFileName(String str) {
        F = str;
    }

    public static void setMaxBatchReportCount(int i2) {
        if (a(i2, 2, 1000)) {
            y = i2;
        } else {
            p.error("setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    public static void setMaxDaySessionNumbers(int i2) {
        if (i2 <= 0) {
            p.e("maxDaySessionNumbers must be greater than 0.");
        } else {
            M = i2;
        }
    }

    public static void setMaxImportantDataSendRetryCount(int i2) {
        if (i2 > 100) {
            x = i2;
        }
    }

    public static void setMaxParallelTimmingEvents(int i2) {
        if (a(i2, 1, 4096)) {
            G = i2;
        } else {
            p.error("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    public static void setMaxReportEventLength(int i2) {
        if (i2 <= 0) {
            p.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            P = i2;
        }
    }

    public static void setMaxSendRetryCount(int i2) {
        if (a(i2, 1, 1000)) {
            w = i2;
        } else {
            p.error("setMaxSendRetryCount can not exceed the range of [1,1000].");
        }
    }

    public static void setMaxSessionStatReportCount(int i2) {
        if (i2 < 0) {
            p.error("maxSessionStatReportCount cannot be less than 0.");
        } else {
            K = i2;
        }
    }

    public static void setMaxStoreEventCount(int i2) {
        if (a(i2, 0, 500000)) {
            u = i2;
        } else {
            p.error("setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    public static void setNumEventsCachedInMemory(int i2) {
        if (i2 >= 0) {
            m = i2;
        }
    }

    public static void setNumEventsCommitPerSec(int i2) {
        if (i2 > 0) {
            z = i2;
        }
    }

    public static void setNumOfMethodsCalledLimit(int i2, long j2) {
        h = i2;
        if (j2 >= 1000) {
            i = j2;
        }
    }

    public static void setQQ(Context context, String str) {
        com.tencent.msdk.stat.common.o.b(context, "mta.acc.qq", str);
        f = str;
    }

    public static void setReportCompressedSize(int i2) {
        if (i2 > 0) {
            o = i2;
        }
    }

    public static void setReportEventsByOrder(boolean z2) {
        l = z2;
    }

    public static void setSendPeriodMinutes(int i2) {
        if (a(i2, 1, 10080)) {
            E = i2;
        } else {
            p.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    public static void setSessionTimoutMillis(int i2) {
        if (a(i2, 1000, 86400000)) {
            t = i2;
        } else {
            p.error("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    public static void setStatExCallBack(i iVar) {
        S = iVar;
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            p.error("statReportUrl cannot be null or empty.");
            return;
        }
        J = str;
        try {
            k = new URI(J).getHost();
        } catch (Exception e2) {
            p.w(e2);
        }
        if (isDebugEnable()) {
            p.i("url:" + J + ", domain:" + k);
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        q = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            StatServiceImpl.c = 0L;
        }
        if (isDebugEnable()) {
            p.d("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static void updateDontReportEventIdsSet(String str) {
        if (com.tencent.msdk.stat.common.j.c(str)) {
            String[] split = str.toLowerCase().split(";");
            if (split.length > 0) {
                if (W == null) {
                    W = new HashSet<>(split.length);
                }
                W.addAll(Arrays.asList(split));
            }
        }
    }
}
