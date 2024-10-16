package kotlin.b;

import java.lang.reflect.Method;
import kotlin.jvm.internal.h;
import kotlin.random.Random;

/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kotlin.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0226a {

        /* renamed from: a, reason: collision with root package name */
        public static final Method f6937a;
        public static final Method b;
        public static final C0226a c = new C0226a();

        /* JADX WARN: Removed duplicated region for block: B:10:0x0046 A[LOOP:0: B:2:0x0015->B:10:0x0046, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x004a A[EDGE_INSN: B:11:0x004a->B:12:0x004a BREAK  A[LOOP:0: B:2:0x0015->B:10:0x0046], SYNTHETIC] */
        static {
            /*
                kotlin.b.a$a r0 = new kotlin.b.a$a
                r0.<init>()
                kotlin.b.a.C0226a.c = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.h.a(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                r5 = 0
                if (r4 >= r2) goto L49
                r6 = r1[r4]
                java.lang.String r7 = "it"
                kotlin.jvm.internal.h.a(r6, r7)
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.h.a(r7, r8)
                if (r7 == 0) goto L42
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                kotlin.jvm.internal.h.a(r7, r8)
                java.lang.Object r7 = kotlin.collections.d.b(r7)
                java.lang.Class r7 = (java.lang.Class) r7
                boolean r7 = kotlin.jvm.internal.h.a(r7, r0)
                if (r7 == 0) goto L42
                r7 = 1
                goto L43
            L42:
                r7 = 0
            L43:
                if (r7 == 0) goto L46
                goto L4a
            L46:
                int r4 = r4 + 1
                goto L15
            L49:
                r6 = r5
            L4a:
                kotlin.b.a.C0226a.f6937a = r6
                int r0 = r1.length
            L4d:
                if (r3 >= r0) goto L66
                r2 = r1[r3]
                java.lang.String r4 = "it"
                kotlin.jvm.internal.h.a(r2, r4)
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.h.a(r4, r6)
                if (r4 == 0) goto L63
                goto L67
            L63:
                int r3 = r3 + 1
                goto L4d
            L66:
                r2 = r5
            L67:
                kotlin.b.a.C0226a.b = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.b.a.C0226a.<clinit>():void");
        }

        private C0226a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        h.b(th, "cause");
        h.b(th2, "exception");
        Method method = C0226a.f6937a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public Random a() {
        return new kotlin.random.b();
    }
}
