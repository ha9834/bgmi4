package com.tencent.midas.oversea.newnetwork.model;

import android.text.TextUtils;
import com.tencent.imsdk.android.IR;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.HttpURL;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;

/* loaded from: classes.dex */
public class APDataReportReq extends APMidasHttpRequestBase {
    public static final String TAG = "APDataReportReq";
    private String reportData = "";
    private boolean needReport = true;

    public APDataReportReq setData(String str) {
        this.reportData = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void initUrl() {
        HttpURL httpURL = new HttpURL("https", GlobalData.singleton().NetCfg().getReportDomain());
        httpURL.suffix = String.format(MConstants.AP_LOG_DATA, GlobalData.singleton().offerID);
        setURL(httpURL);
        APLog.i(TAG, "LogData URL: " + getFullURLString());
    }

    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase, com.tencent.midas.http.core.Request
    public void onHttpStart() {
        super.onHttpStart();
    }

    public APDataReportReq setUp() {
        initUrl();
        constructParam();
        return this;
    }

    public boolean needReport() {
        return GlobalData.singleton().isSendReport && this.needReport;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void constructParam() {
        super.constructParam();
        if (TextUtils.isEmpty(this.reportData)) {
            this.needReport = false;
            return;
        }
        String encodeGzip = encodeGzip(this.reportData);
        if (!TextUtils.isEmpty(encodeGzip) && encodeGzip.length() < this.reportData.length()) {
            addHttpParameters("t", "g");
            addHttpParameters(IR.path.DOCS_IMSDK_CHANNEL, encodeGzip);
            APLog.d("DataReport", "c=" + encodeGzip);
            return;
        }
        addHttpParameters(this.reportData, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x004d -> B:16:0x0074). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String encodeGzip(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L60
            r2.<init>()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L60
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            byte[] r7 = r7.getBytes()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
        L1a:
            int r1 = r4.read(r7)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            r5 = -1
            if (r1 == r5) goto L26
            r5 = 0
            r3.write(r7, r5, r1)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            goto L1a
        L26:
            r3.flush()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            r3.close()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            byte[] r7 = r2.toByteArray()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            r1 = 2
            byte[] r7 = android.util.Base64.encode(r7, r1)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            java.lang.String r7 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r1, r7)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            r2.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r7 = move-exception
            r7.printStackTrace()
        L48:
            r4.close()     // Catch: java.io.IOException -> L4c
            goto L74
        L4c:
            r7 = move-exception
            r7.printStackTrace()
            goto L74
        L51:
            r7 = move-exception
            goto L77
        L53:
            r7 = move-exception
            goto L5a
        L55:
            r7 = move-exception
            r4 = r1
            goto L77
        L58:
            r7 = move-exception
            r4 = r1
        L5a:
            r1 = r2
            goto L62
        L5c:
            r7 = move-exception
            r2 = r1
            r4 = r2
            goto L77
        L60:
            r7 = move-exception
            r4 = r1
        L62:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r7 = move-exception
            r7.printStackTrace()
        L6f:
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.io.IOException -> L4c
        L74:
            return r0
        L75:
            r7 = move-exception
            r2 = r1
        L77:
            if (r2 == 0) goto L81
            r2.close()     // Catch: java.io.IOException -> L7d
            goto L81
        L7d:
            r0 = move-exception
            r0.printStackTrace()
        L81:
            if (r4 == 0) goto L8b
            r4.close()     // Catch: java.io.IOException -> L87
            goto L8b
        L87:
            r0 = move-exception
            r0.printStackTrace()
        L8b:
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.oversea.newnetwork.model.APDataReportReq.encodeGzip(java.lang.String):java.lang.String");
    }
}
