package com.ihoc.mgpa.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.MemoryFile;
import android.os.Vibrator;
import android.util.Log;
import com.ihoc.mgpa.e.a.b;
import com.ihoc.mgpa.e.a.c;
import com.ihoc.mgpa.e.a.d;

/* loaded from: classes2.dex */
public class a extends com.ihoc.mgpa.e.a.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f5511a;
    private Vibrator b;
    private Class d;
    private c g;
    private Context h;
    private boolean c = true;
    private MemoryFile e = null;
    private final boolean f = true;

    @SuppressLint({"PrivateApi"})
    private a() {
        try {
            this.d = Class.forName("android.os.RichTapVibrationEffect");
        } catch (ClassNotFoundException unused) {
            Log.i("TGPA_AACHaptic", "failed to reflect class: \"android.os.RichTapVibrationEffect\"!");
        }
        if (this.d == null) {
            try {
                this.d = Class.forName("android.os.VibrationEffect");
            } catch (ClassNotFoundException unused2) {
                Log.i("TGPA_AACHaptic", "failed to reflect class: \"android.os.VibrationEffect\"!");
            }
        }
    }

    public static a a() {
        if (f5511a == null) {
            synchronized (a.class) {
                if (f5511a == null) {
                    f5511a = new a();
                }
            }
        }
        return f5511a;
    }

    public a a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context shouldn't be null");
        }
        Log.d("TGPA_AACHaptic", "init ,version:1.1.20210122 versionCode:33");
        this.b = (Vibrator) context.getSystemService("vibrator");
        this.h = context;
        a(true);
        return f5511a;
    }

    public void a(int i, int i2) {
        if (i < 1 || i > 255) {
            throw new IllegalArgumentException("Wrong parameter {amplitude: " + i + "}, which should be [1, 255]!");
        }
        if (i2 < 0 || i2 > 1000) {
            throw new IllegalArgumentException("Wrong parameter {interval: " + i2 + "}, which should be [0, 1000]!");
        }
        if (this.c) {
            d.a(this.h).a(i2, i, 0);
        } else {
            this.g.b(new b(null, -1, i2, i, -1));
        }
    }

    public void a(String str, int i, int i2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Wrong parameter {string: " + str + "} is null!");
        }
        if (i < 1) {
            throw new IllegalArgumentException("Wrong parameter {loop: " + i + "} less than 1!");
        }
        if (this.c) {
            d.a(this.h).a(str, i, 0, i2, 0);
            return;
        }
        c();
        this.g.a(new b(str, i, 0, i2, 0));
    }

    public void a(boolean z) {
        boolean z2;
        StringBuilder sb = new StringBuilder();
        sb.append("useNonRichTap start nonRichTap = ");
        sb.append(!this.c);
        Log.d("TGPA_AACHaptic", sb.toString());
        if (d()) {
            z2 = !z;
        } else {
            Log.w("TGPA_AACHaptic", "the system doesn't integrate richTap software");
            z2 = false;
        }
        this.c = z2;
        if (!b()) {
            c cVar = this.g;
            if (cVar != null) {
                cVar.c();
                this.g = null;
            }
        } else if (this.g == null) {
            this.g = new c(this.h);
            this.g.start();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("useNonRichTap end nonRichTap = ");
        sb2.append(!this.c);
        Log.d("TGPA_AACHaptic", sb2.toString());
    }

    public boolean b() {
        return (d() && this.c) ? false : true;
    }

    public void c() {
        Log.d("TGPA_AACHaptic", "stop");
        if (this.c) {
            Context context = this.h;
            if (context != null) {
                d.a(context).a();
            }
        } else {
            c cVar = this.g;
            if (cVar != null) {
                cVar.d();
            }
        }
        Vibrator vibrator = this.b;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d() {
        /*
            r8 = this;
            android.os.Vibrator r0 = r8.b
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r0 = "TGPA_AACHaptic"
            java.lang.String r2 = "Please call the init method first"
        L9:
            android.util.Log.e(r0, r2)
            return r1
        Ld:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r0 >= r2) goto L18
            java.lang.String r0 = "TGPA_AACHaptic"
            java.lang.String r2 = "android api is lower than o,can not support!!"
            goto L9
        L18:
            java.lang.Class r0 = r8.d
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L44
            java.lang.String r4 = "createPatternHeWithParam"
            r5 = 5
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L3d
            java.lang.Class<int[]> r6 = int[].class
            r5[r1] = r6     // Catch: java.lang.Exception -> L3d
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3d
            r5[r3] = r6     // Catch: java.lang.Exception -> L3d
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3d
            r5[r2] = r6     // Catch: java.lang.Exception -> L3d
            r6 = 3
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3d
            r5[r6] = r7     // Catch: java.lang.Exception -> L3d
            r6 = 4
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3d
            r5[r6] = r7     // Catch: java.lang.Exception -> L3d
            r0.getMethod(r4, r5)     // Catch: java.lang.Exception -> L3d
            goto L45
        L3d:
            java.lang.String r0 = "TGPA_AACHaptic"
            java.lang.String r3 = "The system doesn't integrate richTap software"
            android.util.Log.e(r0, r3)
        L44:
            r3 = 0
        L45:
            if (r3 == 0) goto L7d
            java.lang.Class r0 = r8.d
            if (r0 == 0) goto L7d
            java.lang.String r4 = "checkIfRichTapSupport"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L79
            java.lang.reflect.Method r0 = r0.getMethod(r4, r5)     // Catch: java.lang.Exception -> L79
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L79
            java.lang.Object r0 = r0.invoke(r4, r5)     // Catch: java.lang.Exception -> L79
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Exception -> L79
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L79
            java.lang.String r4 = "TGPA_AACHaptic"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            r5.<init>()     // Catch: java.lang.Exception -> L79
            java.lang.String r6 = "checkIfRichTapSupport result:"
            r5.append(r6)     // Catch: java.lang.Exception -> L79
            r5.append(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L79
            android.util.Log.d(r4, r5)     // Catch: java.lang.Exception -> L79
            if (r2 != r0) goto L7d
            goto L7e
        L79:
            r0 = move-exception
            r0.printStackTrace()
        L7d:
            r1 = r3
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.e.a.d():boolean");
    }
}
