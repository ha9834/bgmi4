package com.ihoc.mgpa.j;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private static volatile z f5654a;
    public static B b = B.NotCheck;
    public static A c = A.UNKOWN;

    private z() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private C0249a a(String str) {
        char c2;
        try {
            switch (str.hashCode()) {
                case -2084170162:
                    if (str.equals("tgpabinder")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1206476313:
                    if (str.equals(Constants.REFERRER_API_HUAWEI)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -897048717:
                    if (str.equals("socket")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -759499589:
                    if (str.equals("xiaomi")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -184765532:
                    if (str.equals("tgpabinder2")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3418016:
                    if (str.equals("oppo")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 66409258:
                    if (str.equals("koghuawei")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 112220422:
                    if (str.equals("vivo2")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 375836854:
                    if (str.equals("kogsocket")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1864941562:
                    if (str.equals("samsung")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1978613624:
                    if (str.equals("samsung2")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    return S.g();
                case 1:
                    return C0257i.g();
                case 2:
                    return V.g();
                case 3:
                    return C0260l.g();
                case 4:
                    return O.g();
                case 5:
                    return G.g();
                case 6:
                    return C0252d.g();
                case 7:
                    return C0254f.g();
                case '\b':
                    return x.g();
                case '\t':
                    return w.g();
                case '\n':
                    return L.g();
                default:
                    com.ihoc.mgpa.n.m.b("[SdkProxyFactory]: get sdk by cloud channel, no proxy is found, ple check cloud config!", new Object[0]);
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.b("[SdkProxyFactory]: convert cloud channel to enum failed. channel: %s", str);
            return null;
        }
    }

    private void a(ArrayList<String> arrayList) {
        com.ihoc.mgpa.n.m.a("[SdkProxyFactory]: check available proxy by cloud. ", new Object[0]);
        C0249a c0249a = new C0249a();
        Iterator<String> it = arrayList.iterator();
        C0249a c0249a2 = c0249a;
        while (it.hasNext()) {
            C0249a a2 = a(it.next());
            if (a2 != null) {
                c0249a2.a(a2);
                c0249a2 = a2;
            }
        }
        c0249a.a();
    }

    public static z c() {
        if (f5654a == null) {
            synchronized (z.class) {
                if (f5654a == null) {
                    f5654a = new z();
                }
            }
        }
        return f5654a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r1.equals("vivo") != false) goto L27;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x006d. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d() {
        /*
            r5 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "[SdkProxyFactory]: check available proxy by default. "
            com.ihoc.mgpa.n.m.a(r2, r1)
            java.lang.String r1 = com.ihoc.mgpa.n.f.c()
            java.lang.String r1 = r1.toLowerCase()
            com.ihoc.mgpa.j.G r2 = com.ihoc.mgpa.j.G.g()
            com.ihoc.mgpa.j.L r3 = com.ihoc.mgpa.j.L.g()
            r2.a(r3)
            com.ihoc.mgpa.j.L r3 = com.ihoc.mgpa.j.L.g()
            int r4 = r1.hashCode()
            switch(r4) {
                case -1619859642: goto L62;
                case -1206476313: goto L58;
                case -934971466: goto L4e;
                case -759499589: goto L44;
                case 3418016: goto L3a;
                case 3620012: goto L31;
                case 1864941562: goto L27;
                default: goto L26;
            }
        L26:
            goto L6c
        L27:
            java.lang.String r0 = "samsung"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 6
            goto L6d
        L31:
            java.lang.String r4 = "vivo"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L6c
            goto L6d
        L3a:
            java.lang.String r0 = "oppo"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 1
            goto L6d
        L44:
            java.lang.String r0 = "xiaomi"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 4
            goto L6d
        L4e:
            java.lang.String r0 = "realme"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 2
            goto L6d
        L58:
            java.lang.String r0 = "huawei"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 3
            goto L6d
        L62:
            java.lang.String r0 = "blackshark"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 5
            goto L6d
        L6c:
            r0 = -1
        L6d:
            switch(r0) {
                case 0: goto La5;
                case 1: goto La0;
                case 2: goto La0;
                case 3: goto L9b;
                case 4: goto L88;
                case 5: goto L88;
                case 6: goto L78;
                default: goto L70;
            }
        L70:
            com.ihoc.mgpa.j.S r0 = com.ihoc.mgpa.j.S.g()
        L74:
            r3.a(r0)
            goto Laa
        L78:
            com.ihoc.mgpa.j.w r0 = com.ihoc.mgpa.j.w.g()
            r3.a(r0)
            com.ihoc.mgpa.j.w r0 = com.ihoc.mgpa.j.w.g()
            com.ihoc.mgpa.j.x r1 = com.ihoc.mgpa.j.x.g()
            goto L97
        L88:
            com.ihoc.mgpa.j.V r0 = com.ihoc.mgpa.j.V.g()
            r3.a(r0)
            com.ihoc.mgpa.j.V r0 = com.ihoc.mgpa.j.V.g()
            com.ihoc.mgpa.j.S r1 = com.ihoc.mgpa.j.S.g()
        L97:
            r0.a(r1)
            goto Laa
        L9b:
            com.ihoc.mgpa.j.d r0 = com.ihoc.mgpa.j.C0252d.g()
            goto L74
        La0:
            com.ihoc.mgpa.j.l r0 = com.ihoc.mgpa.j.C0260l.g()
            goto L74
        La5:
            com.ihoc.mgpa.j.O r0 = com.ihoc.mgpa.j.O.g()
            goto L74
        Laa:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.j.z.d():void");
    }

    public void a() {
        if (c != A.UNKOWN) {
            com.ihoc.mgpa.n.m.a("[SdkProxyFactory]: vendor sdktype %s had connected, needn't check again.", c.a());
            return;
        }
        com.ihoc.mgpa.g.D d = com.ihoc.mgpa.g.o.b().c.b;
        ArrayList<String> a2 = d != null ? d.a() : null;
        if (a2 != null) {
            a(a2);
        } else {
            com.ihoc.mgpa.n.m.d("[SdkProxyFactory]: no vendor channel list is found in cloud config, ple check!", new Object[0]);
            d();
        }
    }

    public C0249a b() {
        switch (y.f5653a[c.ordinal()]) {
            case 1:
                return O.g();
            case 2:
                return C0260l.g();
            case 3:
                return S.g();
            case 4:
                return C0257i.g();
            case 5:
                return V.g();
            case 6:
                return G.g();
            case 7:
                return C0252d.g();
            case 8:
                return C0254f.g();
            case 9:
                return x.g();
            case 10:
                return w.g();
            case 11:
                return L.g();
            default:
                return new C0249a();
        }
    }
}
