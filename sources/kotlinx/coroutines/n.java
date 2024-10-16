package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f7024a = l.class.desiredAssertionStatus();
    private static final boolean b;
    private static final boolean c;
    private static final AtomicLong d;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        if (r0.equals("auto") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        if (r0.equals("on") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        if (r0.equals("") != false) goto L24;
     */
    static {
        /*
            java.lang.Class<kotlinx.coroutines.l> r0 = kotlinx.coroutines.l.class
            boolean r0 = r0.desiredAssertionStatus()
            kotlinx.coroutines.n.f7024a = r0
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.n.a(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L13
            goto L2f
        L13:
            int r3 = r0.hashCode()
            if (r3 == 0) goto L45
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L3c
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L32
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L69
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
        L2f:
            boolean r0 = kotlinx.coroutines.n.f7024a
            goto L4e
        L32:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
            r0 = 0
            goto L4e
        L3c:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
            goto L4d
        L45:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
        L4d:
            r0 = 1
        L4e:
            kotlinx.coroutines.n.b = r0
            boolean r0 = kotlinx.coroutines.n.b
            if (r0 == 0) goto L5d
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.n.a(r0, r2)
            if (r0 == 0) goto L5d
            r1 = 1
        L5d:
            kotlinx.coroutines.n.c = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.n.d = r0
            return
        L69:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.n.<clinit>():void");
    }

    public static final boolean a() {
        return f7024a;
    }

    public static final boolean b() {
        return c;
    }
}
