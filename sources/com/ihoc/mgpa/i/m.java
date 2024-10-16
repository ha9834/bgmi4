package com.ihoc.mgpa.i;

import android.os.Build;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.helpshift.analytics.AnalyticsEventKey;
import com.ihoc.mgpa.BuildConfig;
import com.ihoc.mgpa.g.o;
import com.ihoc.mgpa.j.z;
import com.ihoc.mgpa.n.d;
import com.intlgame.webview.WebViewManager;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.connect.common.Constants;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static String f5620a = "";
    private static long b;
    private static int c;

    public static String a() {
        return String.valueOf((System.currentTimeMillis() - b) / 1000);
    }

    public static void a(a aVar, HashMap<String, String> hashMap) {
        com.ihoc.mgpa.n.m.a("TGPA", "[reportData]: " + hashMap);
        p(hashMap);
        l.a().a(aVar, hashMap);
    }

    public static void a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        p(hashMap);
        hashMap.put("dynamic_setting", str);
        hashMap.put(com.ihoc.mgpa.a.f.CALLBACK_OPEN.a(), String.valueOf(f.J()));
        hashMap.put(com.ihoc.mgpa.a.f.FPS_OPEN.a(), String.valueOf(f.P()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_TYPE.a(), String.valueOf(z.c.a()));
        l.a().a(a.VMP_SETTINGS, hashMap);
    }

    public static void a(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        p(hashMap);
        q(hashMap);
        hashMap.put("scene", f.q);
        hashMap.put("start_time", str2);
        hashMap.put("map_id", f.k());
        hashMap.put("match_mark", String.valueOf(f.l()));
        hashMap.put("fps", str);
        String str3 = f.h.get(com.ihoc.mgpa.a.e.FPS_TARGET.b());
        String str4 = f.h.get(com.ihoc.mgpa.a.e.HD_MODEL.b());
        String str5 = f.h.get(com.ihoc.mgpa.a.e.MODEL_LEVEL.b());
        if (str3 != null) {
            hashMap.put(com.ihoc.mgpa.a.e.FPS_TARGET.b(), String.valueOf(str3));
        }
        if (str4 != null) {
            hashMap.put(com.ihoc.mgpa.a.e.HD_MODEL.b(), String.valueOf(str4));
        }
        if (str5 != null) {
            hashMap.put(com.ihoc.mgpa.a.e.MODEL_LEVEL.b(), String.valueOf(str5));
        }
        l.a().a(a.VMP_MATCH_FPS, hashMap);
    }

    public static void a(String str, Throwable th) {
        if (!o.b().b.M || c >= com.ihoc.mgpa.a.c.f5478a) {
            return;
        }
        c++;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("where", str);
        hashMap.put("description", Log.getStackTraceString(th));
        hashMap.put("exception", th.toString());
        p(hashMap);
        l.a().a(a.VMP_HANDLE_EXCEPTION, hashMap);
    }

    public static void a(ArrayList<Float> arrayList) {
        int i;
        float floatValue;
        long m = f.m();
        StringBuilder sb = new StringBuilder();
        Iterator<Float> it = arrayList.iterator();
        StringBuilder sb2 = sb;
        long j = m;
        loop0: while (true) {
            i = 0;
            while (it.hasNext()) {
                floatValue = it.next().floatValue();
                i++;
                if (i < 12) {
                    sb2.append(String.format(Locale.CHINA, "%.2f", Float.valueOf(floatValue)));
                    sb2.append("|");
                }
            }
            sb2.append(String.format(Locale.CHINA, "%.2f", Float.valueOf(floatValue)));
            a(sb2.toString(), com.ihoc.mgpa.n.d.a(j, d.a.PATTERN2.getFormat()));
            j += 60000;
            sb2 = new StringBuilder();
        }
        if (i != 0) {
            for (int i2 = 0; i2 < 11 - i; i2++) {
                sb2.append("|");
            }
            a(sb2.toString(), com.ihoc.mgpa.n.d.a(j, d.a.PATTERN2.getFormat()));
        }
    }

    public static void a(HashMap<String, String> hashMap) {
        p(hashMap);
        l.a().a(a.VMP_DEVICE_CHECK, hashMap);
    }

    public static String b() {
        return f5620a;
    }

    public static void b(String str, String str2) {
        if (f.Y()) {
            HashMap<String, String> hashMap = new HashMap<>();
            p(hashMap);
            q(hashMap);
            hashMap.put("start_time", String.valueOf(f.s()));
            hashMap.put("end_time", com.ihoc.mgpa.n.d.b());
            hashMap.put("scene_id", str2);
            hashMap.put("next_scene", str);
            hashMap.put("map_id", f.k());
            hashMap.put(com.ihoc.mgpa.a.f.PERF_SDKFUC_OPEN_STR.a(), String.valueOf(f.b()));
            hashMap.put(com.ihoc.mgpa.a.f.SDK_SCENEID_SUPPORT.a(), String.valueOf(f.a(f.d())));
            hashMap.put(com.ihoc.mgpa.a.f.SCENE_OPEN.a(), String.valueOf(f.da()));
            hashMap.put(com.ihoc.mgpa.a.f.THREAD_OPEN.a(), String.valueOf(f.ja()));
            hashMap.put(com.ihoc.mgpa.a.f.LIGHT_THREAD_OPEN.a(), String.valueOf(f.S()));
            hashMap.put(com.ihoc.mgpa.a.f.USER_COUNT_OPEN.a(), String.valueOf(f.pa()));
            hashMap.put(com.ihoc.mgpa.a.f.OPTCONFIG_OPEN.a(), String.valueOf(f.V()));
            hashMap.put(com.ihoc.mgpa.a.f.SSPFUNC_OPEN.a(), String.valueOf(f.aa()));
            hashMap.put(com.ihoc.mgpa.a.f.SCENETRANSFORM_OPEN.a(), String.valueOf(f.ea()));
            hashMap.put(com.ihoc.mgpa.a.f.SCENECONTROL_OPEN.a(), String.valueOf(f.fa()));
            l.a().a(a.VMP_SCENETIME, hashMap);
        }
    }

    public static void b(ArrayList<Integer> arrayList) {
        HashMap<String, String> hashMap = new HashMap<>();
        p(hashMap);
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append('|');
            }
            sb.deleteCharAt(sb.length() - 1);
            hashMap.put("netlatency", sb.toString());
        }
        l.a().a(a.VMP_MATCH_NETLATENCY, hashMap);
    }

    public static void b(HashMap<String, String> hashMap) {
        p(hashMap);
        l.a().a(a.VMP_REPORT_UNIQUE_ID, hashMap);
    }

    public static void c() {
        f5620a = com.ihoc.mgpa.n.d.a(d.a.PATTERN1.getFormat()) + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + String.valueOf(com.ihoc.mgpa.n.o.a("XID", null));
        b = System.currentTimeMillis();
    }

    public static void c(HashMap<String, String> hashMap) {
        p(hashMap);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put(Constants.PARAM_PKG_NAME, com.ihoc.mgpa.n.a.c());
        hashMap.put("pkg_version", com.ihoc.mgpa.n.f.b(com.ihoc.mgpa.n.a.a()));
        hashMap.put("pkg_code", String.valueOf(com.ihoc.mgpa.n.f.a(com.ihoc.mgpa.n.a.a())));
        hashMap.put("main_version", String.valueOf(f.j()));
        hashMap.put("sub_version", String.valueOf(f.u()));
        l.a().a(a.VMP_HAPTIC_SETTING, hashMap);
    }

    public static void d(HashMap<String, String> hashMap) {
        p(hashMap);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put(Constants.PARAM_PKG_NAME, com.ihoc.mgpa.n.a.c());
        hashMap.put("pkg_version", com.ihoc.mgpa.n.f.b(com.ihoc.mgpa.n.a.a()));
        hashMap.put("pkg_code", String.valueOf(com.ihoc.mgpa.n.f.a(com.ihoc.mgpa.n.a.a())));
        hashMap.put("main_version", String.valueOf(f.j()));
        hashMap.put("sub_version", String.valueOf(f.u()));
        l.a().a(a.VMP_HAPTIC_SUPPORT, hashMap);
    }

    public static void e(HashMap<String, String> hashMap) {
        p(hashMap);
        hashMap.putAll(o.b().a());
        l.a().a(a.VMP_INIT, hashMap);
    }

    public static void f(HashMap<String, String> hashMap) {
        p(hashMap);
        l.a().a(a.VMP_NOTCH_INFO, hashMap);
    }

    public static void g(HashMap<String, String> hashMap) {
        p(hashMap);
        hashMap.put("package_name", String.valueOf(com.ihoc.mgpa.n.a.c()));
        hashMap.put("game_version", String.valueOf(f.i()));
        hashMap.put("game_code", String.valueOf(f.h()));
        hashMap.put(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, String.valueOf(f.j()));
        hashMap.put("sv", String.valueOf(f.u()));
        hashMap.put("os_sdk", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("scenes", f.c());
        l.a().a(a.VMP_REPORT_PREDOWNLOAD_COPY, hashMap);
    }

    public static void h(HashMap<String, String> hashMap) {
        p(hashMap);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, String.valueOf(f.j()));
        hashMap.put("sv", String.valueOf(f.u()));
        l.a().a(a.VMP_REPORT_PREDOWNLOAD2, hashMap);
    }

    public static void i(HashMap<String, String> hashMap) {
        p(hashMap);
        hashMap.put("package_name", String.valueOf(com.ihoc.mgpa.n.a.c()));
        hashMap.put("game_version", String.valueOf(f.i()));
        hashMap.put("game_code", String.valueOf(f.h()));
        hashMap.put(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, String.valueOf(f.j()));
        hashMap.put("sv", String.valueOf(f.u()));
        l.a().a(a.VMP_REPORT_PREDOWNLOAD3, hashMap);
    }

    public static void j(HashMap<String, String> hashMap) {
        p(hashMap);
        hashMap.put("main_version", f.j());
        hashMap.put("sub_version", f.u());
        hashMap.put("game_version", String.valueOf(f.i()));
        hashMap.put("game_code", String.valueOf(f.h()));
        l.a().a(a.VMP_REPORT_PREDOWNLOAD1, hashMap);
    }

    public static void k(HashMap<String, String> hashMap) {
        p(hashMap);
        q(hashMap);
        String str = f.aa;
        if (str != null) {
            hashMap.put("vendor_version", str);
        }
        hashMap.put(com.ihoc.mgpa.a.f.SSPFUNC_OPEN.a(), String.valueOf(f.aa()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_VENDOR_SUPPORT.a(), String.valueOf(f.G()));
        hashMap.put(com.ihoc.mgpa.a.f.PERF_SDKFUC_OPEN_STR.a(), String.valueOf(f.b()));
        l.a().a(a.VMP_SPA, hashMap);
    }

    public static void l(HashMap<String, String> hashMap) {
        p(hashMap);
        String str = f.aa;
        if (str != null) {
            hashMap.put("vendor_version", str);
        }
        hashMap.put(com.ihoc.mgpa.a.f.SDK_TYPE.a(), String.valueOf(z.c.a()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPORT.a(), String.valueOf(f.ra()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_VENDOR_SUPPORT.a(), String.valueOf(f.G()));
        hashMap.put(com.ihoc.mgpa.a.e.MAIN_VERCODE.b(), String.valueOf(f.j()));
        hashMap.put(com.ihoc.mgpa.a.e.SUB_VERCODE.b(), String.valueOf(f.u()));
        hashMap.put(com.ihoc.mgpa.a.f.TIME_INIT.a(), String.valueOf(b / 1000));
        hashMap.put(com.ihoc.mgpa.a.f.PERF_SDKFUC_OPEN_STR.a(), String.valueOf(f.b()));
        l.a().a(a.VMP_SOCKETINFO, hashMap);
    }

    public static void m(HashMap<String, String> hashMap) {
        p(hashMap);
        l.a().a(a.VMP_STRATEGY_INFO, hashMap);
    }

    public static void n(HashMap<String, String> hashMap) {
        p(hashMap);
        l.a().a(a.VMP_THREAD_AFFINITY_INFO, hashMap);
    }

    public static void o(HashMap<String, String> hashMap) {
        if (f.Y()) {
            p(hashMap);
            l.a().a(a.VMP_CALLBACK, hashMap);
        }
    }

    private static void p(HashMap<String, String> hashMap) {
        hashMap.put("report_time", com.ihoc.mgpa.n.d.a(d.a.PATTERN2.getFormat()));
        hashMap.put("version_code", String.valueOf(BuildConfig.VERSION_CODE));
        hashMap.put(WebViewManager.EXTRA_VERSION_NAME, BuildConfig.VERSION_NAME);
        hashMap.put("vmp_number", b());
        hashMap.put(Constants.JumpUrlConstants.URL_KEY_OPENID, f.q());
        hashMap.put("unique_id", String.valueOf(com.ihoc.mgpa.d.a.d()));
        hashMap.put(DeviceInfoName.XID_STRING, String.valueOf(com.ihoc.mgpa.d.a.b()));
        hashMap.put("manufacturer", com.ihoc.mgpa.n.f.c());
        hashMap.put("model", com.ihoc.mgpa.n.f.d());
        hashMap.put("plat_type", "Android");
        hashMap.put("sdk_tag", f.t());
        if (f.ha()) {
            hashMap.put("mobile_type", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
    }

    private static void q(HashMap<String, String> hashMap) {
        hashMap.put(com.ihoc.mgpa.a.f.SDK_TYPE.a(), String.valueOf(z.c.a()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPORT.a(), String.valueOf(f.ra()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPROT_JP.a(), String.valueOf(f.y()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPROT_CJ.a(), String.valueOf(f.z()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPROT_DH.a(), String.valueOf(f.A()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPROT_XH.a(), String.valueOf(f.B()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPROT_TP.a(), String.valueOf(f.C()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPROT_WL.a(), String.valueOf(f.D()));
        hashMap.put(com.ihoc.mgpa.a.f.SDK_SUPPORT_SPA.a(), String.valueOf(f.E()));
    }
}
