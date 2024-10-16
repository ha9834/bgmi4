package com.ihoc.mgpa.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ihoc.mgpa.g.g;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.ihoc.mgpa.f.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0240f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile C0240f f5529a;
    private com.ihoc.mgpa.g.y b;
    private a c;
    private HandlerThread d = new HandlerThread("tgpa_spa_collector");
    private HashMap<String, String> e = new HashMap<>();
    private ArrayList<String> f = new ArrayList<>();
    private ArrayList<String> g = new ArrayList<>();
    private ArrayList<String> h = new ArrayList<>();
    private ArrayList<String> i = new ArrayList<>();
    private ArrayList<String> j = new ArrayList<>();
    private ArrayList<String> k = new ArrayList<>();
    private ArrayList<String> l = new ArrayList<>();
    private ArrayList<String> m = new ArrayList<>();
    private ArrayList<String> n = new ArrayList<>();
    private ArrayList<String> o = new ArrayList<>();
    private ArrayList<String> p = new ArrayList<>();
    private StringBuilder q = new StringBuilder();
    private StringBuilder r = new StringBuilder();
    private StringBuilder s = new StringBuilder();
    private StringBuilder t = new StringBuilder();
    private StringBuilder u = new StringBuilder();
    private StringBuilder v = new StringBuilder();
    private StringBuilder w = new StringBuilder();
    private StringBuilder x = new StringBuilder();
    private StringBuilder y = new StringBuilder();
    private StringBuilder z = new StringBuilder();

    /* renamed from: com.ihoc.mgpa.f.f$a */
    /* loaded from: classes2.dex */
    private class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private int f5530a;

        public a(Looper looper) {
            super(looper);
            this.f5530a = 0;
        }

        private void a() {
            StringBuilder sb;
            String str;
            StringBuilder sb2;
            String str2;
            StringBuilder sb3;
            String str3;
            StringBuilder sb4;
            String str4;
            StringBuilder sb5;
            String str5;
            StringBuilder sb6;
            String str6;
            StringBuilder sb7;
            String str7;
            StringBuilder sb8;
            String str8;
            StringBuilder sb9;
            String str9;
            StringBuilder sb10;
            String str10;
            while (true) {
                JSONObject jSONObject = new JSONObject(com.ihoc.mgpa.j.z.c().b().d());
                if (jSONObject.has("cpu_level")) {
                    sb = C0240f.this.q;
                    str = String.valueOf(jSONObject.get("cpu_level"));
                } else {
                    sb = C0240f.this.q;
                    str = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb.append(str);
                if (jSONObject.has("gpu_level")) {
                    sb2 = C0240f.this.r;
                    str2 = String.valueOf(jSONObject.get("gpu_level"));
                } else {
                    sb2 = C0240f.this.r;
                    str2 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb2.append(str2);
                if (jSONObject.has("cpu_load")) {
                    sb3 = C0240f.this.s;
                    str3 = String.valueOf(jSONObject.get("cpu_load"));
                } else {
                    sb3 = C0240f.this.s;
                    str3 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb3.append(str3);
                if (jSONObject.has("gpu_load")) {
                    sb4 = C0240f.this.t;
                    str4 = String.valueOf(jSONObject.get("gpu_load"));
                } else {
                    sb4 = C0240f.this.t;
                    str4 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb4.append(str4);
                if (jSONObject.has("cpu_temp")) {
                    sb5 = C0240f.this.u;
                    str5 = String.valueOf(jSONObject.get("cpu_temp"));
                } else {
                    sb5 = C0240f.this.u;
                    str5 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb5.append(str5);
                if (jSONObject.has("fps_limit")) {
                    sb6 = C0240f.this.v;
                    str6 = String.valueOf(jSONObject.get("fps_limit"));
                } else {
                    sb6 = C0240f.this.v;
                    str6 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb6.append(str6);
                if (jSONObject.has("fps")) {
                    sb7 = C0240f.this.w;
                    str7 = String.valueOf(jSONObject.get("fps"));
                } else {
                    sb7 = C0240f.this.w;
                    str7 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb7.append(str7);
                if (jSONObject.has("game_overheat")) {
                    sb8 = C0240f.this.x;
                    str8 = String.valueOf(jSONObject.get("game_overheat"));
                } else {
                    sb8 = C0240f.this.x;
                    str8 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb8.append(str8);
                if (jSONObject.has("frame_drops")) {
                    sb9 = C0240f.this.y;
                    str9 = String.valueOf(jSONObject.get("frame_drops"));
                } else {
                    sb9 = C0240f.this.y;
                    str9 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb9.append(str9);
                if (jSONObject.has("rpic_set")) {
                    sb10 = C0240f.this.z;
                    str10 = String.valueOf(jSONObject.get("rpic_set"));
                } else {
                    sb10 = C0240f.this.z;
                    str10 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
                }
                sb10.append(str10);
                this.f5530a++;
                if (this.f5530a >= 5) {
                    C0240f.this.h();
                    C0240f.this.f();
                    this.f5530a = 0;
                    return;
                }
                C0240f.this.q.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.r.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.s.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.t.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.u.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.v.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.w.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.x.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.y.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                C0240f.this.z.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                SystemClock.sleep(998L);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            String str2;
            super.handleMessage(message);
            if (message.what != 1) {
                str = "TGPA";
                str2 = "DataHandler:handleMessage: can not find msg type.";
            } else {
                com.ihoc.mgpa.n.m.a("TGPA", "SSPDataHandler: start to collect data. ");
                try {
                    a();
                    if (C0240f.this.f.size() >= 12) {
                        C0240f.this.g();
                        C0240f.this.e();
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    str = "TGPA";
                    str2 = "DataHandler:handleMessage: run exception.";
                }
            }
            com.ihoc.mgpa.n.m.a(str, str2);
        }
    }

    private C0240f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ihoc.mgpa.i.g a(String str) {
        if (str == null) {
            com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper: get local config content null.");
            return com.ihoc.mgpa.i.g.READ_LOCAL_CONFIG_EXCEPTION;
        }
        if (str.isEmpty()) {
            com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper: local config content is empty.");
            return com.ihoc.mgpa.i.g.GET_LOCAL_CONFIG_EMPTY;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.ihoc.mgpa.g.y yVar = new com.ihoc.mgpa.g.y();
            if (!yVar.a(jSONObject)) {
                com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper: parse json failed. ");
                return com.ihoc.mgpa.i.g.PARSE_JSON_CONFIG_EXCEPTION;
            }
            this.b = yVar;
            com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper: parse json success. ");
            return com.ihoc.mgpa.i.g.VMP_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper:  content is not json.");
            return com.ihoc.mgpa.i.g.DOWNLOAD_CONFIG_CONTENT_NOT_JSON;
        }
    }

    public static C0240f b() {
        if (f5529a == null) {
            synchronized (C0240f.class) {
                if (f5529a == null) {
                    f5529a = new C0240f();
                }
            }
        }
        return f5529a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.HashMap<java.lang.String, java.lang.String> b(int r5, java.lang.String r6) {
        /*
            r4 = this;
            com.ihoc.mgpa.g.y r0 = r4.b
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r5 = "TGPA"
            java.lang.String r6 = "SSPHelper: no ssp cloud config was found. "
            com.ihoc.mgpa.n.m.a(r5, r6)
            return r1
        Ld:
            java.lang.String r0 = "nokey"
            com.ihoc.mgpa.a.e r2 = com.ihoc.mgpa.a.e.a(r5)
            int[] r3 = com.ihoc.mgpa.f.C0239e.f5528a
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r3 = 1
            if (r2 == r3) goto L53
            r3 = 2
            if (r2 == r3) goto L47
            r3 = 3
            if (r2 == r3) goto L3b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "SSPHelper: do not need to check sspkey when key: "
            r6.append(r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "TGPA"
            com.ihoc.mgpa.n.m.a(r6, r5)
            goto L85
        L3b:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            com.ihoc.mgpa.i.f.l = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L5e
        L47:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            com.ihoc.mgpa.i.f.i = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L5e
        L53:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            com.ihoc.mgpa.i.f.q = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L5e:
            java.lang.String r6 = com.ihoc.mgpa.i.f.q
            r5.append(r6)
            java.lang.String r6 = "|"
            r5.append(r6)
            java.lang.String r6 = com.ihoc.mgpa.i.f.v
            r5.append(r6)
            java.lang.String r6 = "|"
            r5.append(r6)
            java.lang.String r6 = com.ihoc.mgpa.i.f.i
            r5.append(r6)
            java.lang.String r6 = "|"
            r5.append(r6)
            java.lang.String r6 = com.ihoc.mgpa.i.f.l
            r5.append(r6)
            java.lang.String r0 = r5.toString()
        L85:
            com.ihoc.mgpa.g.y r5 = r4.b
            java.util.HashMap r5 = r5.a(r0)
            if (r5 == 0) goto La9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "SSPHelper: check sspkey: "
            r6.append(r1)
            r6.append(r0)
            java.lang.String r0 = " is in ssp config."
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "TGPA"
            com.ihoc.mgpa.n.m.a(r0, r6)
            return r5
        La9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "SSPHelper: check sspkey: "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r6 = " is not in ssp config."
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "TGPA"
            com.ihoc.mgpa.n.m.a(r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.f.C0240f.b(int, java.lang.String):java.util.HashMap");
    }

    private void c(int i, String str) {
        int i2 = C0239e.f5528a[com.ihoc.mgpa.a.e.a(i).ordinal()];
        if (i2 == 1) {
            com.ihoc.mgpa.i.f.q = String.valueOf(str);
        } else if (i2 == 2) {
            com.ihoc.mgpa.i.f.i = String.valueOf(str);
        } else {
            if (i2 != 3) {
                return;
            }
            com.ihoc.mgpa.i.f.l = String.valueOf(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f.clear();
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.k.clear();
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.o.clear();
        this.p.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.q = new StringBuilder();
        this.r = new StringBuilder();
        this.s = new StringBuilder();
        this.t = new StringBuilder();
        this.u = new StringBuilder();
        this.v = new StringBuilder();
        this.w = new StringBuilder();
        this.x = new StringBuilder();
        this.y = new StringBuilder();
        this.z = new StringBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.e.put("cpu_level", com.ihoc.mgpa.n.b.a(this.f, "|"));
        this.e.put("gpu_level", com.ihoc.mgpa.n.b.a(this.g, "|"));
        this.e.put("cpu_load", com.ihoc.mgpa.n.b.a(this.h, "|"));
        this.e.put("gpu_load", com.ihoc.mgpa.n.b.a(this.i, "|"));
        this.e.put("cpu_temp", com.ihoc.mgpa.n.b.a(this.j, "|"));
        this.e.put("fps_limit", com.ihoc.mgpa.n.b.a(this.k, "|"));
        this.e.put("spa_fps", com.ihoc.mgpa.n.b.a(this.l, "|"));
        this.e.put("game_overheat", com.ihoc.mgpa.n.b.a(this.m, "|"));
        this.e.put("frame_drops", com.ihoc.mgpa.n.b.a(this.n, "|"));
        this.e.put("rpic_set", com.ihoc.mgpa.n.b.a(this.o, "|"));
        this.e.put("happen_time", com.ihoc.mgpa.n.b.a(this.p, "|"));
        com.ihoc.mgpa.i.m.k(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f.add(this.q.toString());
        this.g.add(this.r.toString());
        this.h.add(this.s.toString());
        this.i.add(this.t.toString());
        this.j.add(this.u.toString());
        this.k.add(this.v.toString());
        this.l.add(this.w.toString());
        this.m.add(this.x.toString());
        this.n.add(this.y.toString());
        this.o.add(this.z.toString());
        this.p.add(com.ihoc.mgpa.n.d.a());
    }

    public void a() {
        a aVar = this.c;
        if (aVar != null) {
            Message.obtain(aVar, 1).sendToTarget();
        }
    }

    public void a(int i, String str) {
        if (com.ihoc.mgpa.j.z.c == com.ihoc.mgpa.j.A.UNKOWN || !com.ihoc.mgpa.j.z.c().b().e()) {
            com.ihoc.mgpa.j.z.c().b().a(i, str);
            return;
        }
        HashMap<String, String> b = b(i, str);
        if (b == null) {
            com.ihoc.mgpa.j.z.c().b().b(i, str);
        } else {
            b.put(String.valueOf(i), str);
            com.ihoc.mgpa.j.z.c().b().b(b);
        }
    }

    public void a(HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            c(Integer.parseInt(entry.getKey()), entry.getValue());
        }
        if (this.b != null) {
            String str = com.ihoc.mgpa.i.f.q + "|" + com.ihoc.mgpa.i.f.v + "|" + com.ihoc.mgpa.i.f.i + "|" + com.ihoc.mgpa.i.f.l;
            HashMap<String, String> a2 = this.b.a(str);
            if (a2 != null) {
                com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper: check sspkey: " + str + " is in ssp config.");
                hashMap.putAll(a2);
            }
        }
        com.ihoc.mgpa.j.z.c().b().b(hashMap);
    }

    public void c() {
        String sb;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(com.ihoc.mgpa.n.a.e());
            sb2.append(File.separator);
            sb2.append(".tgpaspa");
            sb = sb2.toString();
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper: read ssp local config exception.");
        }
        if (com.ihoc.mgpa.n.i.a(sb) && a(com.ihoc.mgpa.n.i.i(sb)) == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper: ssp local config parse success.");
        } else {
            com.ihoc.mgpa.n.m.a("TGPA", "SSPHelper: ssp local config parse failed. ");
            new com.ihoc.mgpa.g.g(g.a.SSPConfig).a(new C0238d(this));
        }
    }

    public void d() {
        String str;
        String str2;
        if (!com.ihoc.mgpa.i.f.ba()) {
            str = "TGPA";
            str2 = "SSPHelper: ssp data report func is not open.";
        } else if (!this.d.isAlive()) {
            this.d.start();
            this.c = new a(this.d.getLooper());
            return;
        } else {
            str = "TGPA";
            str2 = "SSPHelper: ssp data collect thread is already alive, do not need create again!";
        }
        com.ihoc.mgpa.n.m.a(str, str2);
    }
}
