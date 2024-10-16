package com.uqm.crashsight.proguard;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private static int f6627a = 1;
    private static Method b = null;
    private static Class<?> c = null;
    private static long d = 0;
    private static com.uqm.crashsight.crashreport.a e = null;
    private static boolean f = false;
    private static int g = 10;
    private static boolean h;
    private static a i = new a();

    static /* synthetic */ long a(long j) {
        d = 0L;
        return 0L;
    }

    /* loaded from: classes3.dex */
    public static class a {
        static long o;

        /* renamed from: a, reason: collision with root package name */
        String f6628a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        long h;
        long i = 0;
        long j;
        long k;
        long l;
        int m;
        int n;

        static {
            try {
                o = com.uqm.crashsight.crashreport.common.info.c.i();
            } catch (Exception unused) {
                o = 0L;
            }
        }

        public a() {
            p.a(0L);
            this.j = 0L;
            this.k = 0L;
            this.l = 0L;
            this.m = 0;
        }

        public final String toString() {
            return String.format(Locale.ENGLISH, "level=%d, totalRam=%d B, pss=%d B, vss=%d B, availRam=%d B", Integer.valueOf(this.m), Long.valueOf(o), Long.valueOf(this.j), Long.valueOf(this.k), Long.valueOf(this.l));
        }
    }

    public static void a(com.uqm.crashsight.crashreport.a aVar) {
        e = aVar;
    }

    public static void a(int i2) {
        i.m = i2;
    }

    public static synchronized void a() {
        synchronized (p.class) {
            if (f) {
                e.gpmProcessInfoGetPerfDataFromNative();
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (p.class) {
            h = z;
        }
    }

    public static synchronized void b(int i2) {
        synchronized (p.class) {
            g = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1 A[Catch: all -> 0x00fa, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x00f6, B:13:0x0018, B:15:0x0023, B:17:0x005a, B:36:0x0061, B:38:0x006c, B:22:0x0098, B:24:0x00a0, B:25:0x00b7, B:28:0x00bd, B:30:0x00c1, B:31:0x00ca, B:33:0x00d9, B:34:0x00e3, B:43:0x007e, B:44:0x0027, B:47:0x002f, B:50:0x0043), top: B:3:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9 A[Catch: all -> 0x00fa, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x00f6, B:13:0x0018, B:15:0x0023, B:17:0x005a, B:36:0x0061, B:38:0x006c, B:22:0x0098, B:24:0x00a0, B:25:0x00b7, B:28:0x00bd, B:30:0x00c1, B:31:0x00ca, B:33:0x00d9, B:34:0x00e3, B:43:0x007e, B:44:0x0027, B:47:0x002f, B:50:0x0043), top: B:3:0x0003, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.uqm.crashsight.proguard.p.a b() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.p.b():com.uqm.crashsight.proguard.p$a");
    }

    private static JSONObject a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.uqm.crashsight.crashreport.common.info.a b2 = com.uqm.crashsight.crashreport.common.info.a.b();
            if (b2 != null) {
                jSONObject.put("M00", b2.k);
                jSONObject.put("M01", b2.h());
                jSONObject.put("M02", b2.h);
                jSONObject.put("M03", b2.i);
                jSONObject.put("M04", b2.q());
                jSONObject.put("M05", b2.r());
                jSONObject.put("M06", com.uqm.crashsight.crashreport.common.info.a.g());
                jSONObject.put("M07", b2.D());
                jSONObject.put("M08", b2.M());
            }
            jSONObject.put("M09", aVar.i);
            jSONObject.put("M13", aVar.m);
            jSONObject.put("M14", a.o);
            jSONObject.put("M15", aVar.j);
            jSONObject.put("M16", aVar.k);
            jSONObject.put("M17", aVar.l);
            jSONObject.put("M18", aVar.n);
            com.uqm.crashsight.crashreport.common.info.b a2 = com.uqm.crashsight.crashreport.common.info.b.a();
            if (a2 != null) {
                jSONObject.put("M10", a2.d());
                jSONObject.put("M11", a2.b());
                jSONObject.put("M12", a2.c());
            }
        } catch (Exception e2) {
            m.e("MemStatMgr toJson error", new Object[0]);
            m.b(e2);
        }
        return jSONObject;
    }

    public static String a(List<a> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            return jSONArray.toString();
        } catch (Exception e2) {
            m.e("memInfoList toJson error", new Object[0]);
            m.b(e2);
            return "";
        }
    }

    public static void a(List<a> list, long j) {
        com.uqm.crashsight.crashreport.common.info.a b2 = com.uqm.crashsight.crashreport.common.info.a.b();
        a aVar = list.get((int) (j % list.size()));
        if (aVar != null) {
            if (b2 != null) {
                aVar.f6628a = b2.h();
                aVar.b = b2.h;
                aVar.c = b2.i;
                aVar.d = b2.q();
                aVar.e = b2.r();
                aVar.f = com.uqm.crashsight.crashreport.common.info.a.g();
                aVar.g = b2.D();
                aVar.h = b2.M();
            }
            aVar.i = System.currentTimeMillis();
            aVar.j = i.j;
            aVar.k = i.k;
            aVar.l = i.l;
            aVar.m = i.m;
            aVar.n = i.n;
        }
    }
}
