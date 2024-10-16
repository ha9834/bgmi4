package com.gcloudsdk.apollo.apollovoice.httpclient;

import com.gcloudsdk.apollo.ApolloVoiceLog;
import com.tencent.grobot.lite.presenter.PresenterCode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public class URLRequest {
    private byte[] body;
    private long delegate;
    private String getFilePath;
    private String method;
    private String postFilePath;
    private URL reqConnURL;
    private URLResponse response;
    private int timeout;
    private HttpURLConnection urlConn;
    private final int AV_HTTP_STATUS_SUCC = 0;
    private final int AV_HTTP_STATUS_FAIL = 1;
    private final int AV_HTTP_STATUS_TIMEOUT = 2;
    private final int AV_HTTP_STATUS_INVALIED_HOST = 3;
    private final int AV_HTTP_STATUS_INVALIED_URL = 4;
    private final int AV_HTTP_STATUS_NOHEADERS = 5;
    private final int AV_HTTP_STATUS_READBODY = 6;
    private final int AV_HTTP_STATUS_SEND_INCOMPLETE = 7;
    private final int AV_HTTP_STATUS_GET_CREATEFILE = 8;
    private final int AV_HTTP_STATUS_GET_WRITEFILE = 9;
    private final int AV_HTTP_STATUS_POST_READFILE = 10;
    private final int HTTP_OK = 0;
    private final int HTTP_CANNOT_FIND_FILE = -100;
    private final int HTTP_OPEN_FILE_SECURITY_EXCEPTION = -101;
    private final int HTTP_OPEN_FILE_OTERH_EXCEPTION = PresenterCode.Code_Encoder_PkgReqBody_Error;
    private final int HTTP_UNKNOWN_HOST_EXCEPTION = PresenterCode.Code_Encoder_PkgReq_Error;
    private final int HTTP_TIMEOUT_EXCEPTION = PresenterCode.Code_Encoder_Http_Error;
    private final int HTTP_POST_OTHER_EXCEPTION = -105;
    private final int HTTP_NO_HEADER_ERROR = -106;
    private final int HTTP_RESPONSE_ERROR_404 = -107;
    private final int HTTP_RESPONSE_FILE_NOT_FOUND_EXCEPTION = -108;
    private final int HTTP_RESPONSE_OTHER_EXCEPTION = -109;
    private final int HTTP_WRITE_FILE_ACCESS_EXCEPTION = -110;
    private final int HTTP_WRITE_FILE_SECURITY_EXCEPTION = -111;
    private final int HTTP_WRITE_FILE_OTHER_EXCEPTION = -112;
    private final int HTTP_READ_AND_WRITE_DATA_EXCEPTION = -113;

    public static native void response(int i, long j, int i2, String str, String str2, String str3, byte[] bArr, String[] strArr);

    public int initWithURL(String str, int i) {
        this.response = new URLResponse();
        URLResponse uRLResponse = this.response;
        uRLResponse.URL = str;
        this.method = "GET";
        this.timeout = i;
        try {
            this.reqConnURL = new URL(uRLResponse.URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URL url = this.reqConnURL;
        if (url == null) {
            ApolloVoiceLog.LogE("reqConnURL");
            return -1;
        }
        try {
            this.urlConn = (HttpURLConnection) url.openConnection();
            ApolloVoiceLog.LogI("After open Connection With URL: " + str);
            if (this.urlConn == null) {
                ApolloVoiceLog.LogI("urlConn == null");
                return -1;
            }
            if (HttpsUtils.connnectWithIP(str)) {
                HttpURLConnection httpURLConnection = this.urlConn;
                if (httpURLConnection instanceof HttpsURLConnection) {
                    try {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(HttpsUtils.getHostNameVerify(str));
                    } catch (IllegalArgumentException e2) {
                        ApolloVoiceLog.LogE("Maybe HttpsUtils's HostnameVerifier or SSLSocketFactory is null!");
                        e2.printStackTrace();
                    }
                } else {
                    ApolloVoiceLog.LogI("urlConn is not an instance of HttpsURLConnection.");
                }
            }
            try {
                this.urlConn.setRequestMethod(this.method);
                this.urlConn.setReadTimeout(i);
                if (this.method == "POST") {
                    this.urlConn.setDoOutput(true);
                    this.urlConn.setUseCaches(false);
                }
                this.urlConn.setConnectTimeout(i);
                return 0;
            } catch (ProtocolException e3) {
                e3.printStackTrace();
                return -1;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    public void getFile(String str) {
        setMethod("GET");
        sendRequest(str);
    }

    public void postFile(String str) {
        setMethod("POST");
        sendRequest(str);
    }

    public void sendRequest() {
        this.method = "GET";
        sendRequest("");
    }

    public void sendRequest(String str) {
        new Thread(new RequestTask(str), "GVoiceRequest").start();
    }

    public void response2cpp(int i) {
        ApolloVoiceLog.LogI("url[" + this.response.URL + "]response2cpp with result :" + i);
        if (i != 0) {
            response(i, this.delegate, 0, "", this.response.URL, "", null, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.response.headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && key != null) {
                arrayList.add(key);
                arrayList.add(value);
            }
        }
        response(i, this.delegate, this.response.status, this.response.statusMsg, this.response.URL, this.response.version, this.response.body, (String[]) arrayList.toArray(new String[0]));
    }

    public void setMethod(String str) {
        this.method = str;
        try {
            this.urlConn.setRequestMethod(str);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    public void setDelegate(long j) {
        this.delegate = j;
    }

    public void addHead(String str, String str2) {
        this.urlConn.setRequestProperty(str, str2);
    }

    public void setBody(byte[] bArr) {
        this.body = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RequestTask implements Runnable {
        private String filepath;

        public RequestTask(String str) {
            this.filepath = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:212:0x04ce A[Catch: Exception -> 0x04d8, TRY_LEAVE, TryCatch #54 {Exception -> 0x04d8, blocks: (B:210:0x04c6, B:212:0x04ce), top: B:209:0x04c6 }] */
        /* JADX WARN: Removed duplicated region for block: B:215:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:219:0x04be A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:224:0x04b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:310:0x0570 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:317:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:318:0x0566 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:328:0x05a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:335:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:336:0x059e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:346:0x0537 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:353:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:354:0x052d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:363:0x05be A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:370:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:371:0x05b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v37, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9, types: [java.io.InputStream] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1480
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.apollovoice.httpclient.URLRequest.RequestTask.run():void");
        }
    }
}
