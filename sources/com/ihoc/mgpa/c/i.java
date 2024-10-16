package com.ihoc.mgpa.c;

import com.epicgames.ue4.GameActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ihoc.mgpa.f.C0240f;
import com.ihoc.mgpa.j.z;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static volatile i f5502a;
    private boolean b = false;
    private int c = -1;
    private ArrayList<Integer> d = new ArrayList<>();

    private i() {
        d();
    }

    public static i a() {
        if (f5502a == null) {
            synchronized (i.class) {
                if (f5502a == null) {
                    f5502a = new i();
                }
            }
        }
        return f5502a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.ihoc.mgpa.n.m.a("TGPA", "curr netLatency level is " + i);
        if (com.ihoc.mgpa.i.f.aa()) {
            C0240f.b().a(com.ihoc.mgpa.a.e.NET_LATENCY_LEVEL.a(), String.valueOf(i));
        } else {
            z.c().b().a(com.ihoc.mgpa.a.e.NET_LATENCY_LEVEL.a(), String.valueOf(i));
        }
    }

    private void a(String str) {
        com.ihoc.mgpa.n.m.a("TGPA", "netLatency level config is " + str);
        if (com.ihoc.mgpa.i.f.aa()) {
            C0240f.b().a(com.ihoc.mgpa.a.e.NET_LATENCY_LEVEL_CONFIG.a(), str);
        } else {
            z.c().b().a(com.ihoc.mgpa.a.e.NET_LATENCY_LEVEL_CONFIG.a(), str);
        }
    }

    private void a(boolean z) {
        String str;
        String str2;
        com.ihoc.mgpa.g.q qVar = com.ihoc.mgpa.g.o.b().c.p;
        if (z) {
            a(qVar.a());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "localMonitor");
            jSONObject.put("cmd", "ping");
            if (z) {
                str = "action";
                str2 = "start";
            } else {
                str = "action";
                str2 = "stop";
            }
            jSONObject.put(str, str2);
            jSONObject.put("name", "lynshang ping");
            HashMap hashMap = new HashMap();
            hashMap.put("freq", String.valueOf(qVar.b()));
            hashMap.put("size", GameActivity.CPU_ARCHITECTURE_TYPE_32);
            hashMap.put("ipList", qVar.c());
            hashMap.put(FirebaseAnalytics.Param.CONTENT, qVar.g());
            jSONObject.put("param", new JSONObject(hashMap));
            com.ihoc.mgpa.k.c.a().a(jSONObject.toString(), new h(this, qVar));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void d() {
        if (this.b) {
            com.ihoc.mgpa.n.m.a("TGPA", "TransceiverHelper: TransceiverTool is available.");
            return;
        }
        try {
            a(false);
            this.b = true;
            com.ihoc.mgpa.n.m.a("TGPA", "TransceiverHelper: TransceiverTool is available.");
        } catch (Throwable th) {
            th.printStackTrace();
            com.ihoc.mgpa.n.m.b("TGPA", "TransceiverHelper: TransceiverTool is not available.");
            this.b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.d.size() > 0) {
            com.ihoc.mgpa.i.m.b(this.d);
            this.d.clear();
        }
    }

    public void b() {
        if (this.b) {
            a(true);
            this.d.clear();
        }
    }

    public void c() {
        if (this.b) {
            a(false);
            e();
        }
    }
}
