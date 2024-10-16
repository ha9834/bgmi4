package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzsa implements zzrv {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f3728a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> b = new AtomicReference<>();
    private final int d;
    private final int e;
    private final String f;
    private final zzsj<? super zzsa> j;
    private zzry k;
    private HttpURLConnection l;
    private InputStream m;
    private boolean n;
    private long o;
    private long p;
    private long q;
    private long r;
    private final zzsv<String> g = null;
    private final zzsd i = new zzsd();
    private final boolean c = true;
    private final zzsd h = null;

    public zzsa(String str, zzsv<String> zzsvVar, zzsj<? super zzsa> zzsjVar, int i, int i2, boolean z, zzsd zzsdVar) {
        this.f = zzsk.checkNotEmpty(str);
        this.j = zzsjVar;
        this.d = i;
        this.e = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0075, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzrv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zza(com.google.android.gms.internal.ads.zzry r25) throws com.google.android.gms.internal.ads.zzsb {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsa.zza(com.google.android.gms.internal.ads.zzry):long");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i, int i2) throws zzsb {
        try {
            if (this.q != this.o) {
                byte[] andSet = b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.q != this.o) {
                    int read = this.m.read(andSet, 0, (int) Math.min(this.o - this.q, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.q += read;
                    if (this.j != null) {
                        this.j.zzc(this, read);
                    }
                }
                b.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.p != -1) {
                long j = this.p - this.r;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j);
            }
            int read2 = this.m.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.p == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.r += read2;
            if (this.j != null) {
                this.j.zzc(this, read2);
            }
            return read2;
        } catch (IOException e) {
            throw new zzsb(e, this.k, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0038, code lost:
    
        if (r3 > 2048) goto L21;
     */
    @Override // com.google.android.gms.internal.ads.zzrv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws com.google.android.gms.internal.ads.zzsb {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.m     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L7b
            java.net.HttpURLConnection r2 = r9.l     // Catch: java.lang.Throwable -> L8f
            long r3 = r9.p     // Catch: java.lang.Throwable -> L8f
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L13
            long r3 = r9.p     // Catch: java.lang.Throwable -> L8f
            goto L18
        L13:
            long r3 = r9.p     // Catch: java.lang.Throwable -> L8f
            long r7 = r9.r     // Catch: java.lang.Throwable -> L8f
            long r3 = r3 - r7
        L18:
            int r7 = com.google.android.gms.internal.ads.zzsy.SDK_INT     // Catch: java.lang.Throwable -> L8f
            r8 = 19
            if (r7 == r8) goto L24
            int r7 = com.google.android.gms.internal.ads.zzsy.SDK_INT     // Catch: java.lang.Throwable -> L8f
            r8 = 20
            if (r7 != r8) goto L6b
        L24:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L34
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            r4 = -1
            if (r3 != r4) goto L3a
            goto L6b
        L34:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L6b
        L3a:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            if (r3 == 0) goto L6b
        L52:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8f
        L6b:
            java.io.InputStream r2 = r9.m     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8f
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8f
            goto L7b
        L71:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzsb r3 = new com.google.android.gms.internal.ads.zzsb     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.internal.ads.zzry r4 = r9.k     // Catch: java.lang.Throwable -> L8f
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L8f
            throw r3     // Catch: java.lang.Throwable -> L8f
        L7b:
            r9.m = r0
            r9.a()
            boolean r0 = r9.n
            if (r0 == 0) goto L8e
            r9.n = r1
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.zzsa> r0 = r9.j
            if (r0 == 0) goto L8e
            r0.zze(r9)
            return
        L8e:
            return
        L8f:
            r2 = move-exception
            r9.m = r0
            r9.a()
            boolean r0 = r9.n
            if (r0 == 0) goto La2
            r9.n = r1
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.zzsa> r0 = r9.j
            if (r0 == 0) goto La2
            r0.zze(r9)
        La2:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsa.close():void");
    }

    private final HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.d);
        httpURLConnection.setReadTimeout(this.e);
        for (Map.Entry<String, String> entry : this.i.zzjw().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (j != 0 || j2 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty(Headers.RANGE, sb2);
        }
        httpURLConnection.setRequestProperty(HttpHeader.USER_AGENT, this.f);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpStack.HEADER_ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long a(java.net.HttpURLConnection r8) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r8.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L36
            long r1 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L11
            goto L38
        L11:
            java.lang.String r1 = "DefaultHttpDataSource"
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected Content-Length ["
            r3.append(r2)
            r3.append(r0)
            java.lang.String r2 = "]"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.e(r1, r2)
        L36:
            r1 = -1
        L38:
            java.lang.String r3 = "Content-Range"
            java.lang.String r8 = r8.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto Ld3
            java.util.regex.Pattern r3 = com.google.android.gms.internal.ads.zzsa.f3728a
            java.util.regex.Matcher r3 = r3.matcher(r8)
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
            java.lang.String r3 = "DefaultHttpDataSource"
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch: java.lang.NumberFormatException -> Lae
            int r6 = r6.length()     // Catch: java.lang.NumberFormatException -> Lae
            int r6 = r6 + 26
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.NumberFormatException -> Lae
            int r7 = r7.length()     // Catch: java.lang.NumberFormatException -> Lae
            int r6 = r6 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lae
            r7.<init>(r6)     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r6 = "Inconsistent headers ["
            r7.append(r6)     // Catch: java.lang.NumberFormatException -> Lae
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> Lae
            r7.append(r8)     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> Lae
            java.lang.String r0 = r7.toString()     // Catch: java.lang.NumberFormatException -> Lae
            android.util.Log.w(r3, r0)     // Catch: java.lang.NumberFormatException -> Lae
            long r0 = java.lang.Math.max(r1, r4)     // Catch: java.lang.NumberFormatException -> Lae
            r1 = r0
            goto Ld3
        Lae:
            java.lang.String r0 = "DefaultHttpDataSource"
            java.lang.String r3 = java.lang.String.valueOf(r8)
            int r3 = r3.length()
            int r3 = r3 + 27
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Range ["
            r4.append(r3)
            r4.append(r8)
            java.lang.String r8 = "]"
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            android.util.Log.e(r0, r8)
        Ld3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsa.a(java.net.HttpURLConnection):long");
    }

    private final void a() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.l = null;
        }
    }
}
