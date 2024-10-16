package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzjs implements zzkf {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f3665a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> b = new AtomicReference<>();
    private final boolean c;
    private final int d;
    private final int e;
    private final String f;
    private final zzkn<String> g;
    private final HashMap<String, String> h;
    private final zzke i;
    private zzjq j;
    private HttpURLConnection k;
    private InputStream l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private long q;

    public zzjs(String str, zzkn<String> zzknVar, zzke zzkeVar, int i, int i2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f = str;
        this.g = null;
        this.i = null;
        this.h = new HashMap<>();
        this.d = i;
        this.e = i2;
        this.c = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzjp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zza(com.google.android.gms.internal.ads.zzjq r19) throws com.google.android.gms.internal.ads.zzjx {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.zza(com.google.android.gms.internal.ads.zzjq):long");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i, int i2) throws zzjx {
        try {
            if (this.p != this.n) {
                byte[] andSet = b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.p != this.n) {
                    int read = this.l.read(andSet, 0, (int) Math.min(this.n - this.p, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.p += read;
                    if (this.i != null) {
                        this.i.zzab(read);
                    }
                }
                b.set(andSet);
            }
            if (this.o != -1) {
                i2 = (int) Math.min(i2, this.o - this.q);
            }
            if (i2 == 0) {
                return -1;
            }
            int read2 = this.l.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.o != -1 && this.o != this.q) {
                    throw new EOFException();
                }
                return -1;
            }
            this.q += read2;
            if (this.i != null) {
                this.i.zzab(read2);
            }
            return read2;
        } catch (IOException e) {
            throw new zzjx(e, this.j);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0037, code lost:
    
        if (r2 > 2048) goto L21;
     */
    @Override // com.google.android.gms.internal.ads.zzjp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws com.google.android.gms.internal.ads.zzjx {
        /*
            r8 = this;
            r0 = 0
            java.io.InputStream r1 = r8.l     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto L7c
            java.net.HttpURLConnection r1 = r8.k     // Catch: java.lang.Throwable -> L8e
            long r2 = r8.o     // Catch: java.lang.Throwable -> L8e
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L12
            long r2 = r8.o     // Catch: java.lang.Throwable -> L8e
            goto L17
        L12:
            long r2 = r8.o     // Catch: java.lang.Throwable -> L8e
            long r6 = r8.q     // Catch: java.lang.Throwable -> L8e
            long r2 = r2 - r6
        L17:
            int r6 = com.google.android.gms.internal.ads.zzkq.SDK_INT     // Catch: java.lang.Throwable -> L8e
            r7 = 19
            if (r6 == r7) goto L23
            int r6 = com.google.android.gms.internal.ads.zzkq.SDK_INT     // Catch: java.lang.Throwable -> L8e
            r7 = 20
            if (r6 != r7) goto L6a
        L23:
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L33
            int r2 = r1.read()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            r3 = -1
            if (r2 != r3) goto L39
            goto L6a
        L33:
            r4 = 2048(0x800, double:1.0118E-320)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L6a
        L39:
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            java.lang.String r3 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            if (r3 != 0) goto L51
            java.lang.String r3 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            if (r2 == 0) goto L6a
        L51:
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            java.lang.Class r2 = r2.getSuperclass()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            java.lang.String r3 = "unexpectedEndOfInput"
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
            r2.invoke(r1, r3)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L8e
        L6a:
            java.io.InputStream r1 = r8.l     // Catch: java.io.IOException -> L73 java.lang.Throwable -> L8e
            r1.close()     // Catch: java.io.IOException -> L73 java.lang.Throwable -> L8e
            r1 = 0
            r8.l = r1     // Catch: java.lang.Throwable -> L8e
            goto L7c
        L73:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzjx r2 = new com.google.android.gms.internal.ads.zzjx     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.internal.ads.zzjq r3 = r8.j     // Catch: java.lang.Throwable -> L8e
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L8e
            throw r2     // Catch: java.lang.Throwable -> L8e
        L7c:
            boolean r1 = r8.m
            if (r1 == 0) goto L8d
            r8.m = r0
            com.google.android.gms.internal.ads.zzke r0 = r8.i
            if (r0 == 0) goto L89
            r0.zzgd()
        L89:
            r8.a()
            return
        L8d:
            return
        L8e:
            r1 = move-exception
            boolean r2 = r8.m
            if (r2 == 0) goto L9f
            r8.m = r0
            com.google.android.gms.internal.ads.zzke r0 = r8.i
            if (r0 == 0) goto L9c
            r0.zzgd()
        L9c:
            r8.a()
        L9f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.close():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final HttpURLConnection a(URL url, long j, long j2, boolean z) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.d);
        httpURLConnection.setReadTimeout(this.e);
        httpURLConnection.setDoOutput(false);
        synchronized (this.h) {
            for (Map.Entry<String, String> entry : this.h.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (j != 0 || j2 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                long j3 = (j + j2) - 1;
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append(j3);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty(Headers.RANGE, sb2);
        }
        httpURLConnection.setRequestProperty(HttpHeader.USER_AGENT, this.f);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpStack.HEADER_ACCEPT_ENCODING, "identity");
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long a(java.net.HttpURLConnection r9) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r9.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L36
            long r1 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L11
            goto L38
        L11:
            java.lang.String r1 = "HttpDataSource"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r3 = r3 + 28
            r2.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Length ["
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = "]"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
        L36:
            r1 = -1
        L38:
            java.lang.String r3 = "Content-Range"
            java.lang.String r9 = r9.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 != 0) goto Ld3
            java.util.regex.Pattern r3 = com.google.android.gms.internal.ads.zzjs.f3665a
            java.util.regex.Matcher r3 = r3.matcher(r9)
            boolean r4 = r3.find()
            if (r4 == 0) goto Ld3
            r4 = 2
            java.lang.String r4 = r3.group(r4)     // Catch: java.lang.NumberFormatException -> Lae
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.lang.NumberFormatException -> Lae
            r6 = 1
            java.lang.String r3 = r3.group(r6)     // Catch: java.lang.NumberFormatException -> Lae
            long r6 = java.lang.Long.parseLong(r3)     // Catch: java.lang.NumberFormatException -> Lae
            long r4 = r4 - r6
            r6 = 1
            long r4 = r4 + r6
            r6 = 0
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 >= 0) goto L6e
            r1 = r4
            goto Ld3
        L6e:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 == 0) goto Ld3
            java.lang.String r3 = "HttpDataSource"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r7 = java.lang.String.valueOf(r0)     // Catch: java.lang.NumberFormatException -> Lae
            int r7 = r7.length()     // Catch: java.lang.NumberFormatException -> Lae
            int r7 = r7 + 26
            java.lang.String r8 = java.lang.String.valueOf(r9)     // Catch: java.lang.NumberFormatException -> Lae
            int r8 = r8.length()     // Catch: java.lang.NumberFormatException -> Lae
            int r7 = r7 + r8
            r6.<init>(r7)     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r7 = "Inconsistent headers ["
            r6.append(r7)     // Catch: java.lang.NumberFormatException -> Lae
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r0 = "] ["
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Lae
            r6.append(r9)     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r0 = "]"
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r0 = r6.toString()     // Catch: java.lang.NumberFormatException -> Lae
            android.util.Log.w(r3, r0)     // Catch: java.lang.NumberFormatException -> Lae
            long r0 = java.lang.Math.max(r1, r4)     // Catch: java.lang.NumberFormatException -> Lae
            r1 = r0
            goto Ld3
        Lae:
            java.lang.String r0 = "HttpDataSource"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r9)
            int r4 = r4.length()
            int r4 = r4 + 27
            r3.<init>(r4)
            java.lang.String r4 = "Unexpected Content-Range ["
            r3.append(r4)
            r3.append(r9)
            java.lang.String r9 = "]"
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.e(r0, r9)
        Ld3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.a(java.net.HttpURLConnection):long");
    }

    private final void a() {
        HttpURLConnection httpURLConnection = this.k;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.k = null;
        }
    }
}
