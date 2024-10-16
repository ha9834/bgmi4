package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* loaded from: classes2.dex */
public final class zzdmb {

    /* renamed from: a, reason: collision with root package name */
    private static final aeh f3580a;
    private static final int b;

    public static void zza(Throwable th, Throwable th2) {
        f3580a.a(th, th2);
    }

    /* loaded from: classes2.dex */
    static final class a extends aeh {
        a() {
        }

        @Override // com.google.android.gms.internal.ads.aeh
        public final void a(Throwable th, Throwable th2) {
        }

        @Override // com.google.android.gms.internal.ads.aeh
        public final void a(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.google.android.gms.internal.ads.aeh
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    public static void zzg(Throwable th) {
        f3580a.a(th);
    }

    public static void zza(Throwable th, PrintWriter printWriter) {
        f3580a.a(th, printWriter);
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = a()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L15
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> L2a
            r3 = 19
            if (r2 < r3) goto L15
            com.google.android.gms.internal.ads.ael r2 = new com.google.android.gms.internal.ads.ael     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L15:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L2a
            r2 = r2 ^ r0
            if (r2 == 0) goto L24
            com.google.android.gms.internal.ads.aek r2 = new com.google.android.gms.internal.ads.aek     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L24:
            com.google.android.gms.internal.ads.zzdmb$a r2 = new com.google.android.gms.internal.ads.zzdmb$a     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L2a:
            r2 = move-exception
            goto L2e
        L2c:
            r2 = move-exception
            r1 = 0
        L2e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.ads.zzdmb$a> r4 = com.google.android.gms.internal.ads.zzdmb.a.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.ads.zzdmb$a r2 = new com.google.android.gms.internal.ads.zzdmb$a
            r2.<init>()
        L63:
            com.google.android.gms.internal.ads.zzdmb.f3580a = r2
            if (r1 != 0) goto L68
            goto L6c
        L68:
            int r0 = r1.intValue()
        L6c:
            com.google.android.gms.internal.ads.zzdmb.b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmb.<clinit>():void");
    }
}
