package com.google.android.gms.internal.firebase_remote_config;

import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.uqm.crashsight.CrashSight;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class zzfk implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f4171a = new String[128];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private String i;
    private boolean j;

    public zzfk(Writer writer) {
        a(6);
        this.g = CertificateUtil.DELIMITER;
        this.j = true;
        this.c = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.f = null;
            this.g = CertificateUtil.DELIMITER;
        } else {
            this.f = str;
            this.g = ": ";
        }
    }

    public final void setLenient(boolean z) {
        this.h = true;
    }

    public final zzfk zzef() throws IOException {
        b();
        return a(1, "[");
    }

    public final zzfk zzeg() throws IOException {
        return a(1, 2, "]");
    }

    public final zzfk zzeh() throws IOException {
        b();
        return a(3, "{");
    }

    public final zzfk zzei() throws IOException {
        return a(3, 5, "}");
    }

    private final zzfk a(int i, String str) throws IOException {
        d();
        a(i);
        this.c.write(str);
        return this;
    }

    private final zzfk a(int i, int i2, String str) throws IOException {
        int a2 = a();
        if (a2 != i2 && a2 != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.i != null) {
            throw new IllegalStateException("Dangling name: " + this.i);
        }
        this.e--;
        if (a2 == i2) {
            c();
        }
        this.c.write(str);
        return this;
    }

    private final void a(int i) {
        int i2 = this.e;
        int[] iArr = this.d;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.d = iArr2;
        }
        int[] iArr3 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        iArr3[i3] = i;
    }

    private final int a() {
        int i = this.e;
        if (i == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.d[i - 1];
    }

    private final void b(int i) {
        this.d[this.e - 1] = i;
    }

    public final zzfk zzbf(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.i != null) {
            throw new IllegalStateException();
        }
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.i = str;
        return this;
    }

    private final void b() throws IOException {
        if (this.i != null) {
            int a2 = a();
            if (a2 == 5) {
                this.c.write(44);
            } else if (a2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            c();
            b(4);
            a(this.i);
            this.i = null;
        }
    }

    public final zzfk zzbg(String str) throws IOException {
        if (str == null) {
            return zzel();
        }
        b();
        d();
        a(str);
        return this;
    }

    public final zzfk zzel() throws IOException {
        if (this.i != null) {
            if (this.j) {
                b();
            } else {
                this.i = null;
                return this;
            }
        }
        d();
        this.c.write(Constants.NULL_VERSION_ID);
        return this;
    }

    public final zzfk zzd(boolean z) throws IOException {
        b();
        d();
        this.c.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : CrashSight.SDK_IS_DEV);
        return this;
    }

    public final zzfk zzb(double d) throws IOException {
        b();
        if (!this.h && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        d();
        this.c.append((CharSequence) Double.toString(d));
        return this;
    }

    public final zzfk zzf(long j) throws IOException {
        b();
        d();
        this.c.write(Long.toString(j));
        return this;
    }

    public final zzfk zza(Number number) throws IOException {
        if (number == null) {
            return zzel();
        }
        b();
        String obj = number.toString();
        if (!this.h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        d();
        this.c.append((CharSequence) obj);
        return this;
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.c.close();
        int i = this.e;
        if (i > 1 || (i == 1 && this.d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String[] r0 = com.google.android.gms.internal.firebase_remote_config.zzfk.f4171a
            java.io.Writer r1 = r7.c
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r8.length()
            r2 = 0
            r3 = 0
        Lf:
            if (r2 >= r1) goto L3e
            char r4 = r8.charAt(r2)
            r5 = 128(0x80, float:1.794E-43)
            if (r4 >= r5) goto L1e
            r4 = r0[r4]
            if (r4 != 0) goto L2b
            goto L3b
        L1e:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r4 != r5) goto L25
            java.lang.String r4 = "\\u2028"
            goto L2b
        L25:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r5) goto L3b
            java.lang.String r4 = "\\u2029"
        L2b:
            if (r3 >= r2) goto L34
            java.io.Writer r5 = r7.c
            int r6 = r2 - r3
            r5.write(r8, r3, r6)
        L34:
            java.io.Writer r3 = r7.c
            r3.write(r4)
            int r3 = r2 + 1
        L3b:
            int r2 = r2 + 1
            goto Lf
        L3e:
            if (r3 >= r1) goto L46
            java.io.Writer r0 = r7.c
            int r1 = r1 - r3
            r0.write(r8, r3, r1)
        L46:
            java.io.Writer r8 = r7.c
            java.lang.String r0 = "\""
            r8.write(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzfk.a(java.lang.String):void");
    }

    private final void c() throws IOException {
        if (this.f == null) {
            return;
        }
        this.c.write("\n");
        int i = this.e;
        for (int i2 = 1; i2 < i; i2++) {
            this.c.write(this.f);
        }
    }

    private final void d() throws IOException {
        switch (a()) {
            case 1:
                b(2);
                c();
                return;
            case 2:
                this.c.append(',');
                c();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.c.append((CharSequence) this.g);
                b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        b(7);
    }

    static {
        for (int i = 0; i <= 31; i++) {
            f4171a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f4171a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        b = strArr2;
        strArr2[60] = "\\u003c";
        String[] strArr3 = b;
        strArr3[62] = "\\u003e";
        strArr3[38] = "\\u0026";
        strArr3[61] = "\\u003d";
        strArr3[39] = "\\u0027";
    }
}
