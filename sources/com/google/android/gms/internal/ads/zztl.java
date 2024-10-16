package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zztl {

    /* renamed from: a, reason: collision with root package name */
    private final aob f3744a;
    private final boolean b;
    private final long c;
    private final long d;
    private long e;
    private long f;
    private long g;
    private boolean h;
    private long i;
    private long j;
    private long k;

    public zztl() {
        this(-1.0d);
    }

    public zztl(Context context) {
        this(((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null ? r3.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private zztl(double d) {
        this.b = d != -1.0d;
        if (this.b) {
            this.f3744a = aob.a();
            this.c = (long) (1.0E9d / d);
            this.d = (this.c * 80) / 100;
        } else {
            this.f3744a = null;
            this.c = -1L;
            this.d = -1L;
        }
    }

    public final void enable() {
        this.h = false;
        if (this.b) {
            this.f3744a.b();
        }
    }

    public final void disable() {
        if (this.b) {
            this.f3744a.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzg(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.h
            if (r2 == 0) goto L42
            long r2 = r11.e
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L19
            long r2 = r11.k
            r4 = 1
            long r2 = r2 + r4
            r11.k = r2
            long r2 = r11.g
            r11.f = r2
        L19:
            long r2 = r11.k
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L3a
            long r4 = r11.j
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r11.f
            long r2 = r2 + r4
            boolean r4 = r11.a(r2, r14)
            if (r4 == 0) goto L33
            r11.h = r6
            goto L42
        L33:
            long r4 = r11.i
            long r4 = r4 + r2
            long r6 = r11.j
            long r4 = r4 - r6
            goto L44
        L3a:
            boolean r2 = r11.a(r0, r14)
            if (r2 == 0) goto L42
            r11.h = r6
        L42:
            r4 = r14
            r2 = r0
        L44:
            boolean r6 = r11.h
            r7 = 0
            if (r6 != 0) goto L53
            r11.j = r0
            r11.i = r14
            r11.k = r7
            r14 = 1
            r11.h = r14
        L53:
            r11.e = r12
            r11.g = r2
            com.google.android.gms.internal.ads.aob r12 = r11.f3744a
            if (r12 == 0) goto L86
            long r12 = r12.f1998a
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L62
            goto L86
        L62:
            com.google.android.gms.internal.ads.aob r12 = r11.f3744a
            long r12 = r12.f1998a
            long r14 = r11.c
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L75
            long r14 = r12 - r14
            goto L79
        L75:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L79:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L81
            goto L82
        L81:
            r12 = r14
        L82:
            long r14 = r11.d
            long r12 = r12 - r14
            return r12
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztl.zzg(long, long):long");
    }

    private final boolean a(long j, long j2) {
        return Math.abs((j2 - this.i) - (j - this.j)) > 20000000;
    }
}
