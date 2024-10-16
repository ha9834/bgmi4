package com.tencent.msdk.stat.common;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.msdk.stat.StatConfig;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import com.tencent.msdk.stat.aj;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    String f6320a;
    String b;
    DisplayMetrics c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    String m;
    String n;
    Context o;
    private String p;
    private String q;
    private String r;
    private String s;

    private d(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.b = StatConstants.VERSION;
        this.d = Build.VERSION.SDK_INT;
        this.e = Build.MODEL;
        this.f = Build.MANUFACTURER;
        this.g = Locale.getDefault().getLanguage();
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.o = context.getApplicationContext();
        this.c = j.d(this.o);
        this.f6320a = j.i(this.o);
        if (statSpecifyReportedInfo != null) {
            this.h = statSpecifyReportedInfo.getInstallChannel();
        }
        if (!j.c(this.h)) {
            this.h = StatConfig.getInstallChannel(this.o);
        }
        this.i = j.h(this.o);
        this.j = TimeZone.getDefault().getID();
        this.l = j.n(this.o);
        this.k = j.o(this.o);
        this.m = this.o.getPackageName();
        if (this.d >= 14) {
            this.p = j.u(this.o);
        }
        this.q = j.t(this.o).toString();
        this.r = j.s(this.o);
        this.s = j.d();
        this.n = j.B(this.o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, Thread thread) {
        String str;
        String localMidOnly;
        if (thread == null) {
            if (this.c != null) {
                jSONObject.put("sr", this.c.widthPixels + "*" + this.c.heightPixels);
                jSONObject.put("dpi", this.c.xdpi + "*" + this.c.ydpi);
            }
            if (com.tencent.msdk.stat.a.a(this.o).e()) {
                JSONObject jSONObject2 = new JSONObject();
                p.a(jSONObject2, "bs", p.d(this.o));
                p.a(jSONObject2, "ss", p.e(this.o));
                if (jSONObject2.length() > 0) {
                    p.a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray a2 = p.a(this.o, 10);
            if (a2 != null && a2.length() > 0) {
                p.a(jSONObject, "wflist", a2.toString());
            }
            str = "sen";
            localMidOnly = this.p;
        } else {
            p.a(jSONObject, "thn", thread.getName());
            p.a(jSONObject, "qq", StatConfig.getQQ(this.o));
            p.a(jSONObject, "cui", StatConfig.getCustomUserId(this.o));
            if (j.c(this.r) && this.r.split("/").length == 2) {
                p.a(jSONObject, "fram", this.r.split("/")[0]);
            }
            if (j.c(this.s) && this.s.split("/").length == 2) {
                p.a(jSONObject, "from", this.s.split("/")[0]);
            }
            if (aj.a(this.o).b(this.o) != null) {
                jSONObject.put("ui", aj.a(this.o).b(this.o).b());
            }
            str = "mid";
            localMidOnly = StatConfig.getLocalMidOnly(this.o);
        }
        p.a(jSONObject, str, localMidOnly);
        p.a(jSONObject, "pcn", j.p(this.o));
        p.a(jSONObject, "osn", Build.VERSION.RELEASE);
        p.a(jSONObject, "av", this.f6320a);
        p.a(jSONObject, "ch", this.h);
        p.a(jSONObject, "mf", this.f);
        p.a(jSONObject, "sv", this.b);
        p.a(jSONObject, "osd", Build.DISPLAY);
        p.a(jSONObject, "prod", Build.PRODUCT);
        p.a(jSONObject, "tags", Build.TAGS);
        p.a(jSONObject, "id", Build.ID);
        p.a(jSONObject, "fng", Build.FINGERPRINT);
        p.a(jSONObject, "lch", this.n);
        p.a(jSONObject, "ov", Integer.toString(this.d));
        jSONObject.put("os", 1);
        p.a(jSONObject, "op", this.i);
        p.a(jSONObject, "lg", this.g);
        p.a(jSONObject, "md", this.e);
        p.a(jSONObject, "tz", this.j);
        int i = this.l;
        if (i != 0) {
            jSONObject.put("jb", i);
        }
        p.a(jSONObject, "sd", this.k);
        p.a(jSONObject, "apn", this.m);
        p.a(jSONObject, "cpu", this.q);
        p.a(jSONObject, "abi", Build.CPU_ABI);
        p.a(jSONObject, "abi2", Build.CPU_ABI2);
        p.a(jSONObject, "ram", this.r);
        p.a(jSONObject, "rom", this.s);
    }
}
