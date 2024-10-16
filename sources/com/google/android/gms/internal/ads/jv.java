package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

@zzard
/* loaded from: classes2.dex */
final class jv implements zzrv {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f2277a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> b = new AtomicReference<>();
    private final int d;
    private final int e;
    private final String f;
    private final zzsj<? super jv> h;
    private zzry i;
    private HttpURLConnection j;
    private InputStream k;
    private boolean l;
    private long m;
    private long n;
    private long o;
    private long p;
    private int q;
    private SSLSocketFactory c = new jw(this);
    private Set<Socket> r = new HashSet();
    private final zzsd g = new zzsd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public jv(String str, zzsj<? super jv> zzsjVar, int i, int i2, int i3) {
        this.f = zzsk.checkNotEmpty(str);
        this.h = zzsjVar;
        this.d = i;
        this.e = i2;
        this.q = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0121, code lost:
    
        r25.j = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0123, code lost:
    
        r0 = r25.j.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012b, code lost:
    
        if (r0 < 200) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012f, code lost:
    
        if (r0 <= 299) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0132, code lost:
    
        if (r0 != 200) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0134, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013a, code lost:
    
        if (r26.zzahv == 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013c, code lost:
    
        r3 = r26.zzahv;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0142, code lost:
    
        r25.m = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0149, code lost:
    
        if (r26.zzbk(1) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014f, code lost:
    
        if (r26.zzcd == (-1)) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0151, code lost:
    
        r25.n = r26.zzcd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0170, code lost:
    
        r25.k = r25.j.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0178, code lost:
    
        r25.l = true;
        r0 = r25.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x017d, code lost:
    
        if (r0 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x017f, code lost:
    
        r0.zza(r25, r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0184, code lost:
    
        return r25.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0185, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0186, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018f, code lost:
    
        throw new com.google.android.gms.internal.ads.zzsb(r0, r26, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0156, code lost:
    
        r3 = a(r25.j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015e, code lost:
    
        if (r3 == (-1)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0160, code lost:
    
        r3 = r3 - r25.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0169, code lost:
    
        r25.n = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0167, code lost:
    
        r3 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x016c, code lost:
    
        r25.n = r26.zzcd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0141, code lost:
    
        r3 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x013f, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0190, code lost:
    
        r3 = r25.j.getHeaderFields();
        a();
        r4 = new com.google.android.gms.internal.ads.zzsc(r0, r3, r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a0, code lost:
    
        if (r0 != 416) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a2, code lost:
    
        r4.initCause(new com.google.android.gms.internal.ads.zzrx(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ab, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01ac, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ad, code lost:
    
        a();
        r5 = java.lang.String.valueOf(r26.uri.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c2, code lost:
    
        if (r5.length() != 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c4, code lost:
    
        r4 = "Unable to connect to ".concat(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d3, code lost:
    
        throw new com.google.android.gms.internal.ads.zzsb(r4, r0, r26, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c9, code lost:
    
        r4 = new java.lang.String("Unable to connect to ");
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0223 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e3 A[Catch: IOException -> 0x0244, TryCatch #1 {IOException -> 0x0244, blocks: (B:3:0x000d, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:18:0x00c4, B:20:0x00cd, B:21:0x00d7, B:24:0x00df, B:26:0x00e4, B:28:0x00ec, B:29:0x0101, B:44:0x0121, B:95:0x01d8, B:97:0x01e3, B:99:0x01f4, B:102:0x01fc, B:104:0x020a, B:105:0x0215, B:106:0x0218, B:107:0x020f, B:112:0x0223, B:113:0x022a, B:114:0x00fe, B:117:0x007f, B:119:0x009b, B:120:0x00bf, B:122:0x022b, B:123:0x0243), top: B:2:0x000d }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzrv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zza(com.google.android.gms.internal.ads.zzry r26) throws com.google.android.gms.internal.ads.zzsb {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jv.zza(com.google.android.gms.internal.ads.zzry):long");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i, int i2) throws zzsb {
        try {
            if (this.o != this.m) {
                byte[] andSet = b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.o != this.m) {
                    int read = this.k.read(andSet, 0, (int) Math.min(this.m - this.o, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.o += read;
                    if (this.h != null) {
                        this.h.zzc(this, read);
                    }
                }
                b.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.n != -1) {
                long j = this.n - this.p;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j);
            }
            int read2 = this.k.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.n == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.p += read2;
            if (this.h != null) {
                this.h.zzc(this, read2);
            }
            return read2;
        } catch (IOException e) {
            throw new zzsb(e, this.i, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0038, code lost:
    
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
            java.io.InputStream r2 = r9.k     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L7b
            java.net.HttpURLConnection r2 = r9.j     // Catch: java.lang.Throwable -> L93
            long r3 = r9.n     // Catch: java.lang.Throwable -> L93
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L13
            long r3 = r9.n     // Catch: java.lang.Throwable -> L93
            goto L18
        L13:
            long r3 = r9.n     // Catch: java.lang.Throwable -> L93
            long r7 = r9.p     // Catch: java.lang.Throwable -> L93
            long r3 = r3 - r7
        L18:
            int r7 = com.google.android.gms.internal.ads.zzsy.SDK_INT     // Catch: java.lang.Throwable -> L93
            r8 = 19
            if (r7 == r8) goto L24
            int r7 = com.google.android.gms.internal.ads.zzsy.SDK_INT     // Catch: java.lang.Throwable -> L93
            r8 = 20
            if (r7 != r8) goto L6b
        L24:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L34
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r4 = -1
            if (r3 != r4) goto L3a
            goto L6b
        L34:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L6b
        L3a:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            if (r3 == 0) goto L6b
        L52:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
        L6b:
            java.io.InputStream r2 = r9.k     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L93
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L93
            goto L7b
        L71:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzsb r3 = new com.google.android.gms.internal.ads.zzsb     // Catch: java.lang.Throwable -> L93
            com.google.android.gms.internal.ads.zzry r4 = r9.i     // Catch: java.lang.Throwable -> L93
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L93
            throw r3     // Catch: java.lang.Throwable -> L93
        L7b:
            r9.k = r0
            r9.a()
            boolean r0 = r9.l
            if (r0 == 0) goto L8d
            r9.l = r1
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.jv> r0 = r9.h
            if (r0 == 0) goto L8d
            r0.zze(r9)
        L8d:
            java.util.Set<java.net.Socket> r0 = r9.r
            r0.clear()
            return
        L93:
            r2 = move-exception
            r9.k = r0
            r9.a()
            boolean r0 = r9.l
            if (r0 == 0) goto La6
            r9.l = r1
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.jv> r0 = r9.h
            if (r0 == 0) goto La6
            r0.zze(r9)
        La6:
            java.util.Set<java.net.Socket> r0 = r9.r
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jv.close():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.q = i;
        for (Socket socket : this.r) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.q);
                } catch (SocketException e) {
                    zzawz.zzd("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Socket socket) {
        this.r.add(socket);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long a(java.net.HttpURLConnection r8) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r8.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L34
            long r1 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L11
            goto L36
        L11:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = "]"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzawz.zzen(r1)
        L34:
            r1 = -1
        L36:
            java.lang.String r3 = "Content-Range"
            java.lang.String r8 = r8.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto Lcd
            java.util.regex.Pattern r3 = com.google.android.gms.internal.ads.jv.f2277a
            java.util.regex.Matcher r3 = r3.matcher(r8)
            boolean r4 = r3.find()
            if (r4 == 0) goto Lcd
            r4 = 2
            java.lang.String r4 = r3.group(r4)     // Catch: java.lang.NumberFormatException -> Laa
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.lang.NumberFormatException -> Laa
            r6 = 1
            java.lang.String r3 = r3.group(r6)     // Catch: java.lang.NumberFormatException -> Laa
            long r6 = java.lang.Long.parseLong(r3)     // Catch: java.lang.NumberFormatException -> Laa
            long r4 = r4 - r6
            r6 = 1
            long r4 = r4 + r6
            r6 = 0
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 >= 0) goto L6c
            r1 = r4
            goto Lcd
        L6c:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 == 0) goto Lcd
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch: java.lang.NumberFormatException -> Laa
            int r3 = r3.length()     // Catch: java.lang.NumberFormatException -> Laa
            int r3 = r3 + 26
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch: java.lang.NumberFormatException -> Laa
            int r6 = r6.length()     // Catch: java.lang.NumberFormatException -> Laa
            int r3 = r3 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Laa
            r6.<init>(r3)     // Catch: java.lang.NumberFormatException -> Laa
            java.lang.String r3 = "Inconsistent headers ["
            r6.append(r3)     // Catch: java.lang.NumberFormatException -> Laa
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Laa
            java.lang.String r0 = "] ["
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Laa
            r6.append(r8)     // Catch: java.lang.NumberFormatException -> Laa
            java.lang.String r0 = "]"
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Laa
            java.lang.String r0 = r6.toString()     // Catch: java.lang.NumberFormatException -> Laa
            com.google.android.gms.internal.ads.zzawz.zzep(r0)     // Catch: java.lang.NumberFormatException -> Laa
            long r0 = java.lang.Math.max(r1, r4)     // Catch: java.lang.NumberFormatException -> Laa
            r1 = r0
            goto Lcd
        Laa:
            java.lang.String r0 = java.lang.String.valueOf(r8)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r3.append(r0)
            r3.append(r8)
            java.lang.String r8 = "]"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            com.google.android.gms.internal.ads.zzawz.zzen(r8)
        Lcd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jv.a(java.net.HttpURLConnection):long");
    }

    private final void a() {
        HttpURLConnection httpURLConnection = this.j;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzawz.zzc("Unexpected error while disconnecting", e);
            }
            this.j = null;
        }
    }
}
