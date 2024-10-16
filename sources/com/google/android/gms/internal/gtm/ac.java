package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.amazonaws.http.HttpHeader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ac extends zzan {
    private static final byte[] c = "\n".getBytes();

    /* renamed from: a, reason: collision with root package name */
    private final String f4293a;
    private final ai b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(zzap zzapVar) {
        super(zzapVar);
        this.f4293a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzao.VERSION, Build.VERSION.RELEASE, zzcz.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.b = new ai(zzapVar.zzcn());
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        zza("Network initialized. User agent", this.f4293a);
    }

    public final boolean b() {
        NetworkInfo networkInfo;
        com.google.android.gms.analytics.zzk.zzav();
        q();
        try {
            networkInfo = ((ConnectivityManager) e().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzq("No network connectivity");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.Long> a(java.util.List<com.google.android.gms.internal.gtm.zzcd> r9) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.ac.a(java.util.List):java.util.List");
    }

    private final int a(URL url) {
        Preconditions.checkNotNull(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = b(url);
                httpURLConnection.connect();
                a(httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    i().c();
                }
                zzb("GET status", Integer.valueOf(responseCode));
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return responseCode;
            } catch (IOException e) {
                zzd("Network GET connection error", e);
                if (httpURLConnection == null) {
                    return 0;
                }
                httpURLConnection.disconnect();
                return 0;
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.net.URL, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int a(java.net.URL r4, byte[] r5) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.lang.String r0 = "POST bytes, url"
            int r1 = r5.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.zzb(r0, r1, r4)
            boolean r0 = zzda()
            if (r0 == 0) goto L20
            java.lang.String r0 = "Post payload\n"
            java.lang.String r1 = new java.lang.String
            r1.<init>(r5)
            r3.zza(r0, r1)
        L20:
            r0 = 0
            android.content.Context r1 = r3.e()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            r1.getPackageName()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            java.net.HttpURLConnection r4 = r3.b(r4)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            r1 = 1
            r4.setDoOutput(r1)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            int r1 = r5.length     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            r4.setFixedLengthStreamingMode(r1)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            r4.connect()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            java.io.OutputStream r0 = r4.getOutputStream()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            r0.write(r5)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            r3.a(r4)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            int r5 = r4.getResponseCode()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            r1 = 200(0xc8, float:2.8E-43)
            if (r5 != r1) goto L50
            com.google.android.gms.internal.gtm.zzae r1 = r3.i()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            r1.c()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
        L50:
            java.lang.String r1 = "POST status"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            r3.zzb(r1, r2)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8a
            if (r0 == 0) goto L65
            r0.close()     // Catch: java.io.IOException -> L5f
            goto L65
        L5f:
            r0 = move-exception
            java.lang.String r1 = "Error closing http post connection output stream"
            r3.zze(r1, r0)
        L65:
            if (r4 == 0) goto L6a
            r4.disconnect()
        L6a:
            return r5
        L6b:
            r5 = move-exception
            goto L72
        L6d:
            r5 = move-exception
            r4 = r0
            goto L8b
        L70:
            r5 = move-exception
            r4 = r0
        L72:
            java.lang.String r1 = "Network POST connection error"
            r3.zzd(r1, r5)     // Catch: java.lang.Throwable -> L8a
            if (r0 == 0) goto L83
            r0.close()     // Catch: java.io.IOException -> L7d
            goto L83
        L7d:
            r5 = move-exception
            java.lang.String r0 = "Error closing http post connection output stream"
            r3.zze(r0, r5)
        L83:
            if (r4 == 0) goto L88
            r4.disconnect()
        L88:
            r4 = 0
            return r4
        L8a:
            r5 = move-exception
        L8b:
            if (r0 == 0) goto L97
            r0.close()     // Catch: java.io.IOException -> L91
            goto L97
        L91:
            r0 = move-exception
            java.lang.String r1 = "Error closing http post connection output stream"
            r3.zze(r1, r0)
        L97:
            if (r4 == 0) goto L9c
            r4.disconnect()
        L9c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.ac.a(java.net.URL, byte[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int b(java.net.URL r10, byte[] r11) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.ac.b(java.net.URL, byte[]):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                do {
                } while (inputStream.read(new byte[1024]) > 0);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        zze("Error closing http connection input stream", e);
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        zze("Error closing http connection input stream", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    @VisibleForTesting
    private final HttpURLConnection b(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzby.zzaad.get().intValue());
        httpURLConnection.setReadTimeout(zzby.zzaae.get().intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty(HttpHeader.USER_AGENT, this.f4293a);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private final URL a(zzcd zzcdVar) {
        String concat;
        if (zzcdVar.zzfj()) {
            String valueOf = String.valueOf(zzbq.zzet());
            String valueOf2 = String.valueOf(zzbq.zzev());
            concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            String valueOf3 = String.valueOf(zzbq.zzeu());
            String valueOf4 = String.valueOf(zzbq.zzev());
            concat = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
        try {
            return new URL(concat);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL a(zzcd zzcdVar, String str) {
        String sb;
        if (zzcdVar.zzfj()) {
            String zzet = zzbq.zzet();
            String zzev = zzbq.zzev();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzet).length() + 1 + String.valueOf(zzev).length() + String.valueOf(str).length());
            sb2.append(zzet);
            sb2.append(zzev);
            sb2.append("?");
            sb2.append(str);
            sb = sb2.toString();
        } else {
            String zzeu = zzbq.zzeu();
            String zzev2 = zzbq.zzev();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzeu).length() + 1 + String.valueOf(zzev2).length() + String.valueOf(str).length());
            sb3.append(zzeu);
            sb3.append(zzev2);
            sb3.append("?");
            sb3.append(str);
            sb = sb3.toString();
        }
        try {
            return new URL(sb);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL r() {
        String valueOf = String.valueOf(zzbq.zzet());
        String valueOf2 = String.valueOf(zzby.zzzs.get());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String a(zzcd zzcdVar, boolean z) {
        String valueOf;
        Preconditions.checkNotNull(zzcdVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzcdVar.zzdm().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    a(sb, key, entry.getValue());
                }
            }
            a(sb, "ht", String.valueOf(zzcdVar.zzfh()));
            a(sb, "qt", String.valueOf(d().currentTimeMillis() - zzcdVar.zzfh()));
            if (z) {
                long zzfk = zzcdVar.zzfk();
                if (zzfk != 0) {
                    valueOf = String.valueOf(zzfk);
                } else {
                    valueOf = String.valueOf(zzcdVar.zzfg());
                }
                a(sb, "z", valueOf);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    private static void a(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }
}
