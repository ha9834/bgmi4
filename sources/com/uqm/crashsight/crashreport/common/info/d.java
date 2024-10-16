package com.uqm.crashsight.crashreport.common.info;

import com.uqm.crashsight.proguard.l;
import com.uqm.crashsight.proguard.m;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d {
    private static d d;

    /* renamed from: a, reason: collision with root package name */
    private long f6573a = -1;
    private boolean b = true;
    private boolean c = false;
    private com.uqm.crashsight.crashreport.a e = null;
    private boolean f = false;
    private boolean g = false;

    public static d a() {
        return d;
    }

    public static synchronized void a(com.uqm.crashsight.crashreport.a aVar) {
        synchronized (d.class) {
            if (d == null) {
                d dVar = new d();
                d = dVar;
                dVar.e = aVar;
            }
        }
    }

    private synchronized long d() {
        return this.f6573a;
    }

    private synchronized boolean e() {
        return this.b;
    }

    public final synchronized void a(boolean z) {
        m.c("oom info manager setAppForegroundLast:" + z, new Object[0]);
        this.b = z;
        g();
    }

    private synchronized boolean f() {
        return this.c;
    }

    public final synchronized void b(boolean z) {
        this.c = true;
        g();
    }

    public final synchronized void b() {
        try {
            if (this.f) {
                m.e("oom info manager is reset", new Object[0]);
            } else {
                this.f = true;
                g();
            }
        } catch (Exception e) {
            m.e("reset oom info manager error", new Object[0]);
            m.b(e);
        }
    }

    private synchronized void g() {
        try {
            if (!this.f) {
                l.a("has not received cloud strategy, just cache", new Object[0]);
            } else {
                if (this.e != null) {
                    this.e.updateAppState(h());
                }
            }
        } catch (Exception e) {
            m.e("update oom info manager error", new Object[0]);
            m.b(e);
        }
    }

    private synchronized String h() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("recordedBootTime", d());
            jSONObject.put("isAppForegroundLast", e());
            jSONObject.put("isCrashCaught", f());
        } catch (Exception e) {
            m.e("oom info to json error", new Object[0]);
            m.b(e);
            return "";
        }
        return jSONObject.toString();
    }

    public final synchronized boolean c() {
        try {
        } catch (Exception e) {
            m.e("load oom info error", new Object[0]);
            m.b(e);
        }
        if (this.g) {
            l.d("oom info manager is loaded", new Object[0]);
            return false;
        }
        this.g = true;
        if (this.e != null) {
            String readAppState = this.e.readAppState();
            m.c("OomInfoManager load:" + readAppState, new Object[0]);
            if (readAppState != null && readAppState.length() > 0) {
                JSONObject jSONObject = new JSONObject(readAppState);
                return jSONObject.getBoolean("isAppForegroundLast") && !jSONObject.getBoolean("isCrashCaught");
            }
        }
        return false;
    }
}
