package com.tencent.msdk.stat.a;

import android.content.Context;
import android.os.Build;
import com.helpshift.support.res.values.HSConsts;
import com.tencent.msdk.a.a.i;
import com.tencent.msdk.stat.StatConfig;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import com.tencent.msdk.stat.aj;
import com.tencent.msdk.stat.common.j;
import com.tencent.msdk.stat.common.p;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final List<e> f6291a = Arrays.asList(e.NETWORK_DETECTOR);
    protected static String j = null;
    protected String b;
    protected long c = System.currentTimeMillis() / 1000;
    protected int d;
    protected com.tencent.msdk.stat.common.a e;
    protected int f;
    protected String g;
    protected String h;
    protected String i;
    protected boolean k;
    protected boolean l;
    protected int m;
    protected Context n;
    protected StatSpecifyReportedInfo o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.b = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = false;
        this.l = false;
        this.m = 0;
        this.o = null;
        this.n = context;
        this.d = i;
        this.i = j.i(context);
        if (statSpecifyReportedInfo != null) {
            this.o = statSpecifyReportedInfo;
            if (j.c(statSpecifyReportedInfo.getAppKey())) {
                this.b = statSpecifyReportedInfo.getAppKey();
            }
            if (j.c(statSpecifyReportedInfo.getInstallChannel())) {
                this.h = statSpecifyReportedInfo.getInstallChannel();
            }
            if (j.c(statSpecifyReportedInfo.getVersion())) {
                this.i = statSpecifyReportedInfo.getVersion();
            }
            this.k = statSpecifyReportedInfo.isImportant();
        }
        if (!j.c(this.b)) {
            this.b = StatConfig.getAppKey(context);
        }
        if (!j.c(this.h)) {
            this.h = StatConfig.getInstallChannel(context);
        }
        this.g = StatConfig.getCustomUserId(context);
        this.e = aj.a(context).b(context);
        e a2 = a();
        if (f6291a.contains(a2)) {
            this.f = -a().a();
            if (a2 != e.NETWORK_DETECTOR) {
                this.l = true;
            }
        } else {
            this.f = j.r(context).intValue();
        }
        if (!i.c(j)) {
            j = StatConfig.getLocalMidOnly(context);
            if (!j.c(j)) {
                j = "0";
            }
        }
        this.m = j.n(context);
    }

    public abstract e a();

    public abstract boolean a(JSONObject jSONObject);

    public boolean b(JSONObject jSONObject) {
        String str;
        try {
            p.a(jSONObject, "ky", this.b);
            jSONObject.put("et", a().a());
            if (this.e != null) {
                jSONObject.put("ui", this.e.b());
                p.a(jSONObject, "mc", this.e.c());
                int d = this.e.d();
                jSONObject.put("ut", d);
                if (d == 0 && j.v(this.n) == 1) {
                    jSONObject.put(HSConsts.ISSUE_ARCHIVAL_KEY, 1);
                }
            }
            p.a(jSONObject, "cui", this.g);
            String appVersion = StatConfig.getAppVersion();
            if (j.c(appVersion)) {
                p.a(jSONObject, "av", appVersion);
                str = "appv";
            } else {
                str = "av";
            }
            p.a(jSONObject, str, this.i);
            if (this.k) {
                jSONObject.put("impt", 1);
            }
            p.a(jSONObject, "mid", j);
            jSONObject.put("idx", this.f);
            jSONObject.put("si", this.d);
            jSONObject.put("ts", this.c);
            JSONObject commonAttr = StatConfig.getCommonAttr(this.n);
            if (commonAttr != null && commonAttr.length() > 0) {
                jSONObject.put("com", commonAttr.toString());
            }
            jSONObject.put("dts", j.a(this.n, false));
            jSONObject.put("os", 1);
            p.a(jSONObject, "ov", Integer.toString(Build.VERSION.SDK_INT));
            p.a(jSONObject, "md", Build.MODEL);
            jSONObject.put("jb", this.m);
            p.a(jSONObject, "mf", Build.MANUFACTURER);
            JSONObject customGlobalReportContent = StatConfig.getCustomGlobalReportContent();
            if (customGlobalReportContent != null && customGlobalReportContent.length() > 0) {
                jSONObject.put("cc", customGlobalReportContent.toString());
            }
            p.a(jSONObject, "qq", StatConfig.getQQ());
            return a(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    public long c() {
        return this.c;
    }

    public StatSpecifyReportedInfo d() {
        return this.o;
    }

    public Context e() {
        return this.n;
    }

    public boolean f() {
        return this.k;
    }

    public String g() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
