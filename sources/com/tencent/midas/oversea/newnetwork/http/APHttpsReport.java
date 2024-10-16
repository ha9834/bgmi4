package com.tencent.midas.oversea.newnetwork.http;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GlobalData;
import java.io.DataOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* loaded from: classes.dex */
public class APHttpsReport extends Thread {
    public static final String TAG = "APHttpsReport";
    private URL url = null;
    private HttpsURLConnection httpsURLConnection = null;
    private String reportData = "";

    public void report(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.reportData = str;
        APLog.d(TAG, "ReportData: " + this.reportData);
        start();
    }

    public void report(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.reportData = APTools.map2UrlParams(map);
        APLog.i(TAG, "reportData: " + this.reportData);
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        startReport();
    }

    private void startReport() {
        constructUrl();
        post();
    }

    private void createSSLConnection() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            if (this.httpsURLConnection != null) {
                this.httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            }
        } catch (Exception e) {
            e.printStackTrace();
            APLog.e(TAG, e.getMessage());
        }
    }

    private void post() {
        HttpsURLConnection httpsURLConnection;
        URL url = this.url;
        try {
            if (url == null) {
                APLog.e(TAG, "url is null.");
                return;
            }
            try {
                this.httpsURLConnection = (HttpsURLConnection) url.openConnection();
                createSSLConnection();
                this.httpsURLConnection.setDoOutput(true);
                this.httpsURLConnection.setRequestMethod("POST");
                this.httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(this.reportData.getBytes().length));
                DataOutputStream dataOutputStream = new DataOutputStream(this.httpsURLConnection.getOutputStream());
                dataOutputStream.write(this.reportData.getBytes());
                dataOutputStream.close();
                parseResponse();
                httpsURLConnection = this.httpsURLConnection;
                if (httpsURLConnection == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                APLog.e(TAG, e.getMessage());
                httpsURLConnection = this.httpsURLConnection;
                if (httpsURLConnection == null) {
                    return;
                }
            }
            httpsURLConnection.disconnect();
        } catch (Throwable th) {
            HttpsURLConnection httpsURLConnection2 = this.httpsURLConnection;
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[Catch: IOException -> 0x007f, TryCatch #3 {IOException -> 0x007f, blocks: (B:44:0x007b, B:34:0x0083, B:35:0x0086, B:37:0x008a), top: B:43:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a A[Catch: IOException -> 0x007f, TRY_LEAVE, TryCatch #3 {IOException -> 0x007f, blocks: (B:44:0x007b, B:34:0x0083, B:35:0x0086, B:37:0x008a), top: B:43:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String parseResponse() {
        /*
            r7 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5f
            r2.<init>()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5f
            javax.net.ssl.HttpsURLConnection r3 = r7.httpsURLConnection     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            int r3 = r3.getResponseCode()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            java.lang.String r4 = "APHttpsReport"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            r5.<init>()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            java.lang.String r6 = "responseCode = "
            r5.append(r6)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            r5.append(r3)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            com.tencent.midas.comm.APLog.i(r4, r5)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L41
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            javax.net.ssl.HttpsURLConnection r4 = r7.httpsURLConnection     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            java.io.InputStream r1 = r4.getInputStream()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
        L32:
            int r4 = r1.read(r3)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            if (r4 <= 0) goto L3d
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
            goto L32
        L3d:
            java.lang.String r0 = r2.toString()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L78
        L41:
            if (r1 == 0) goto L49
            r1.close()     // Catch: java.io.IOException -> L47
            goto L49
        L47:
            r1 = move-exception
            goto L56
        L49:
            r2.close()     // Catch: java.io.IOException -> L47
            javax.net.ssl.HttpsURLConnection r1 = r7.httpsURLConnection     // Catch: java.io.IOException -> L47
            if (r1 == 0) goto L77
            javax.net.ssl.HttpsURLConnection r1 = r7.httpsURLConnection     // Catch: java.io.IOException -> L47
            r1.disconnect()     // Catch: java.io.IOException -> L47
            goto L77
        L56:
            r1.printStackTrace()
            goto L77
        L5a:
            r3 = move-exception
            goto L61
        L5c:
            r0 = move-exception
            r2 = r1
            goto L79
        L5f:
            r3 = move-exception
            r2 = r1
        L61:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.io.IOException -> L47
        L69:
            if (r2 == 0) goto L6e
            r2.close()     // Catch: java.io.IOException -> L47
        L6e:
            javax.net.ssl.HttpsURLConnection r1 = r7.httpsURLConnection     // Catch: java.io.IOException -> L47
            if (r1 == 0) goto L77
            javax.net.ssl.HttpsURLConnection r1 = r7.httpsURLConnection     // Catch: java.io.IOException -> L47
            r1.disconnect()     // Catch: java.io.IOException -> L47
        L77:
            return r0
        L78:
            r0 = move-exception
        L79:
            if (r1 == 0) goto L81
            r1.close()     // Catch: java.io.IOException -> L7f
            goto L81
        L7f:
            r1 = move-exception
            goto L90
        L81:
            if (r2 == 0) goto L86
            r2.close()     // Catch: java.io.IOException -> L7f
        L86:
            javax.net.ssl.HttpsURLConnection r1 = r7.httpsURLConnection     // Catch: java.io.IOException -> L7f
            if (r1 == 0) goto L93
            javax.net.ssl.HttpsURLConnection r1 = r7.httpsURLConnection     // Catch: java.io.IOException -> L7f
            r1.disconnect()     // Catch: java.io.IOException -> L7f
            goto L93
        L90:
            r1.printStackTrace()
        L93:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.oversea.newnetwork.http.APHttpsReport.parseResponse():java.lang.String");
    }

    private void constructUrl() {
        String reportDomain = GlobalData.singleton().NetCfg().getReportDomain();
        if (TextUtils.isEmpty(reportDomain)) {
            return;
        }
        String str = "https://" + reportDomain + "/heartbeat/overseas_common_android";
        APLog.i(TAG, "url = " + str);
        try {
            this.url = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
