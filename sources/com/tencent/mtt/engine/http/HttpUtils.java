package com.tencent.mtt.engine.http;

import MTT.a;
import android.os.Build;
import android.util.Log;
import com.amazonaws.services.s3.Headers;
import com.helpshift.common.domain.network.NetworkConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class HttpUtils {
    public static final String DEFAULT_ENCODE_NAME = "utf-8";
    public static final String DEFAULT_POST_ADDR = "http://p.mb.qq.com/thirdapp";
    private static final int DEFAULT_TIME_OUT = 20000;
    public static byte[] POST_DATA_KEY = null;
    private static final String TAG = "HttpUtils";
    public static final String WUP_PROXY_DOMAIN = "http://wup.imtt.qq.com:8080";

    static {
        try {
            POST_DATA_KEY = "65dRa93L".getBytes(DEFAULT_ENCODE_NAME);
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static boolean post(byte[] bArr) {
        return post(bArr, WUP_PROXY_DOMAIN);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mtt.engine.http.HttpUtils$1] */
    public static boolean post(final byte[] bArr, final String str) {
        new Thread(TAG) { // from class: com.tencent.mtt.engine.http.HttpUtils.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (bArr == null) {
                    return;
                }
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(20000);
                    if (Build.VERSION.SDK_INT > 13) {
                        httpURLConnection.setRequestProperty(Headers.CONNECTION, "close");
                    }
                    httpURLConnection.setRequestProperty("Content-Type", NetworkConstants.contentType);
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                    try {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.flush();
                        if (httpURLConnection.getResponseCode() == 200) {
                            Log.d(HttpUtils.TAG, "succ");
                        } else {
                            Log.d(HttpUtils.TAG, "fail not 200");
                        }
                    } catch (Exception unused) {
                    }
                } catch (IOException unused2) {
                }
            }
        }.start();
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mtt.engine.http.HttpUtils$2] */
    public static void post(final a aVar) {
        new Thread(TAG) { // from class: com.tencent.mtt.engine.http.HttpUtils.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpUtils.post(aVar, HttpUtils.DEFAULT_POST_ADDR);
            }
        }.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean post(MTT.a r4, java.lang.String r5) {
        /*
            byte[] r0 = com.tencent.mtt.engine.http.HttpUtils.POST_DATA_KEY
            if (r0 != 0) goto L10
            java.lang.String r0 = "65dRa93L"
            java.lang.String r1 = "utf-8"
            byte[] r0 = r0.getBytes(r1)     // Catch: java.io.UnsupportedEncodingException -> Lf
            com.tencent.mtt.engine.http.HttpUtils.POST_DATA_KEY = r0     // Catch: java.io.UnsupportedEncodingException -> Lf
            goto L10
        Lf:
        L10:
            byte[] r0 = com.tencent.mtt.engine.http.HttpUtils.POST_DATA_KEY
            r1 = 0
            if (r0 != 0) goto L16
            return r1
        L16:
            java.net.URL r0 = new java.net.URL     // Catch: java.io.IOException -> La0
            r0.<init>(r5)     // Catch: java.io.IOException -> La0
            java.net.URLConnection r5 = r0.openConnection()     // Catch: java.io.IOException -> La0
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.io.IOException -> La0
            java.lang.String r0 = "POST"
            r5.setRequestMethod(r0)     // Catch: java.io.IOException -> La0
            r0 = 1
            r5.setDoOutput(r0)
            r5.setDoInput(r0)
            r5.setUseCaches(r1)
            r2 = 20000(0x4e20, float:2.8026E-41)
            r5.setConnectTimeout(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 13
            if (r2 <= r3) goto L42
            java.lang.String r2 = "Connection"
            java.lang.String r3 = "close"
            r5.setRequestProperty(r2, r3)
        L42:
            r2 = 0
            byte[] r2 = (byte[]) r2
            if (r4 == 0) goto L5c
            java.lang.StringBuffer r3 = getPostData(r4)     // Catch: java.lang.Exception -> L63
            if (r3 == 0) goto L5c
            java.lang.StringBuffer r4 = getPostData(r4)     // Catch: java.lang.Exception -> L63
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = "utf-8"
            byte[] r2 = r4.getBytes(r3)     // Catch: java.lang.Exception -> L63
            goto L63
        L5c:
            java.lang.String r4 = "HttpUtils"
            java.lang.String r3 = "!!! appInfo or getPostData(appInfo) is null"
            android.util.Log.e(r4, r3)     // Catch: java.lang.Exception -> L63
        L63:
            if (r2 != 0) goto L66
            return r1
        L66:
            byte[] r4 = com.tencent.mtt.engine.http.HttpUtils.POST_DATA_KEY
            byte[] r4 = com.tencent.mtt.des.DesUtils.DesEncrypt(r4, r2, r0)
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r5.setRequestProperty(r2, r3)
            java.lang.String r2 = "Content-Length"
            int r3 = r4.length
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r5.setRequestProperty(r2, r3)
            java.io.OutputStream r2 = r5.getOutputStream()     // Catch: java.lang.Exception -> L9f
            r2.write(r4)     // Catch: java.lang.Exception -> L9f
            r2.flush()     // Catch: java.lang.Exception -> L9f
            int r4 = r5.getResponseCode()     // Catch: java.lang.Exception -> L9f
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L97
            java.lang.String r4 = "poby"
            java.lang.String r5 = "succ"
            android.util.Log.d(r4, r5)     // Catch: java.lang.Exception -> L9f
            return r0
        L97:
            java.lang.String r4 = "poby"
            java.lang.String r5 = "fail not 200"
            android.util.Log.d(r4, r5)     // Catch: java.lang.Exception -> L9f
            return r1
        L9f:
            return r1
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mtt.engine.http.HttpUtils.post(MTT.a, java.lang.String):boolean");
    }

    private static StringBuffer getPostData(a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("sAppName");
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(aVar.f6a, DEFAULT_ENCODE_NAME));
            stringBuffer.append("|");
            stringBuffer.append("sTime");
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(aVar.b, DEFAULT_ENCODE_NAME));
            stringBuffer.append("|");
            stringBuffer.append("sQua");
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(aVar.c, DEFAULT_ENCODE_NAME));
            stringBuffer.append("|");
            stringBuffer.append("sLc");
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(aVar.d, DEFAULT_ENCODE_NAME));
            stringBuffer.append("|");
            stringBuffer.append("sGuid");
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(aVar.e, DEFAULT_ENCODE_NAME));
            stringBuffer.append("|");
            stringBuffer.append("iPv");
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(String.valueOf(aVar.f), DEFAULT_ENCODE_NAME));
            return stringBuffer;
        } catch (Exception unused) {
            return null;
        }
    }
}
