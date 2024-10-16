package com.ihoc.mgpa.l.a;

import com.ihoc.mgpa.n.m;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f5659a;
    private Object b = null;
    private Method c;
    private Method d;
    private Method e;

    private a() {
    }

    public static a a() {
        if (f5659a == null) {
            synchronized (a.class) {
                if (f5659a == null) {
                    f5659a = new a();
                    f5659a.b();
                }
            }
        }
        return f5659a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() {
        /*
            r6 = this;
            java.lang.String r0 = "com.tencent.tdm.TDataMaster"
            java.lang.String r1 = "getInstance"
            java.lang.Object r0 = com.ihoc.mgpa.n.n.a(r0, r1)
            r1 = 0
            if (r0 == 0) goto L15
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "check tdm old version success!"
        Lf:
            com.ihoc.mgpa.n.m.c(r3, r2)
            r6.b = r0
            goto L32
        L15:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r2 = "check tdm old version failed, start to check tdm international version!"
            com.ihoc.mgpa.n.m.c(r2, r0)
            java.lang.String r0 = "com.tdatamaster.tdm.TDataMaster"
            java.lang.String r2 = "getInstance"
            java.lang.Object r0 = com.ihoc.mgpa.n.n.a(r0, r2)
            if (r0 == 0) goto L2b
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "check tdm international version success!"
            goto Lf
        L2b:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r2 = "check tdm failed, ple integrate tdm in your project!"
            com.ihoc.mgpa.n.m.d(r2, r0)
        L32:
            java.lang.Object r0 = r6.b
            if (r0 == 0) goto L73
            r2 = 3
            java.lang.Class[] r2 = new java.lang.Class[r2]
            java.lang.Class r3 = java.lang.Integer.TYPE
            r2[r1] = r3
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r4 = 1
            r2[r4] = r3
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            r5 = 2
            r2[r5] = r3
            java.lang.String r3 = "reportEvent"
            java.lang.reflect.Method r0 = com.ihoc.mgpa.n.n.a(r0, r3, r2)
            r6.c = r0
            java.lang.Object r0 = r6.b
            java.lang.Class[] r2 = new java.lang.Class[r5]
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r1] = r3
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r4] = r3
            java.lang.String r3 = "setDeviceInfo"
            java.lang.reflect.Method r0 = com.ihoc.mgpa.n.n.a(r0, r3, r2)
            r6.d = r0
            java.lang.Object r0 = r6.b
            java.lang.Class[] r2 = new java.lang.Class[r4]
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r1] = r3
            java.lang.String r1 = "getStringDeviceInfo"
            java.lang.reflect.Method r0 = com.ihoc.mgpa.n.n.a(r0, r1, r2)
            r6.e = r0
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.l.a.a.b():void");
    }

    public String a(String str) {
        try {
            if (this.b != null && this.e != null) {
                Object invoke = this.e.invoke(this.b, str);
                if (invoke == null) {
                    m.a("get data from tdm failed. the device info get null! key: %s", str);
                    return null;
                }
                int i = invoke.getClass().getDeclaredField("status").getInt(invoke);
                if (i != 0) {
                    m.a("get data from tdm failed. get %s failed, status: %d", str, Integer.valueOf(i));
                    return null;
                }
                Object obj = invoke.getClass().getDeclaredField("value").get(invoke);
                if (obj instanceof String) {
                    return (String) obj;
                }
                return null;
            }
            m.b("get data from tdm failed. ple check tdm version.", new Object[0]);
            return null;
        } catch (Exception e) {
            m.a("get data from tdm exception. the key: %s", str);
            m.a("get data from tdm exception. ple check tdm version.", e);
            return null;
        }
    }

    public void a(int i, String str, HashMap<String, String> hashMap) {
        try {
            if (this.b != null && this.c != null) {
                this.c.invoke(this.b, Integer.valueOf(i), str, hashMap);
                return;
            }
            m.b("use tdm report failed!", new Object[0]);
        } catch (Exception e) {
            m.a("use tdm report exception!", e);
        }
    }

    public void a(String str, String str2) {
        try {
            if (this.b != null && this.d != null) {
                this.d.invoke(this.b, str, str2);
                return;
            }
            m.b("set xid to tdm failed. ple check tdm version.", new Object[0]);
        } catch (Exception e) {
            m.a("set data to tdm exception. the key: %s", str);
            m.a("set data to tdm exception. ple check tdm version.", e);
        }
    }
}
