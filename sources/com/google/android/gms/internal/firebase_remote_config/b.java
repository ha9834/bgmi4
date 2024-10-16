package com.google.android.gms.internal.firebase_remote_config;

import com.amazonaws.services.s3.Headers;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* loaded from: classes2.dex */
final class b extends zzaj {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f4039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HttpURLConnection httpURLConnection) {
        this.f4039a = httpURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaj
    public final void addHeader(String str, String str2) {
        this.f4039a.addRequestProperty(str, str2);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaj
    public final void zza(int i, int i2) {
        this.f4039a.setReadTimeout(i2);
        this.f4039a.setConnectTimeout(i);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaj
    public final zzai zzaj() throws IOException {
        HttpURLConnection httpURLConnection = this.f4039a;
        if (zzai() != null) {
            String contentType = getContentType();
            if (contentType != null) {
                addHeader("Content-Type", contentType);
            }
            String contentEncoding = getContentEncoding();
            if (contentEncoding != null) {
                addHeader(Headers.CONTENT_ENCODING, contentEncoding);
            }
            long contentLength = getContentLength();
            if (contentLength >= 0) {
                httpURLConnection.setRequestProperty("Content-Length", Long.toString(contentLength));
            }
            String requestMethod = httpURLConnection.getRequestMethod();
            if ("POST".equals(requestMethod) || "PUT".equals(requestMethod)) {
                httpURLConnection.setDoOutput(true);
                if (contentLength >= 0 && contentLength <= 2147483647L) {
                    httpURLConnection.setFixedLengthStreamingMode((int) contentLength);
                } else {
                    httpURLConnection.setChunkedStreamingMode(0);
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    zzai().writeTo(outputStream);
                    try {
                    } catch (IOException e) {
                        throw e;
                    }
                } finally {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } else {
                Object[] objArr = {requestMethod};
                if (!(contentLength == 0)) {
                    throw new IllegalArgumentException(zzdy.zza("%s with non-zero content length is not supported", objArr));
                }
            }
        }
        try {
            httpURLConnection.connect();
            return new a(httpURLConnection);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
