package com.tencent.abase;

import com.tencent.abase.log.XLog;
import com.tencent.abase.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class URLRequest {
    private static final int ABASE_WWW_FAILED = 1;
    private static final int ABASE_WWW_IOEXCEPTION = 6;
    private static final int ABASE_WWW_NETWORKEXCEPTION = 5;
    private static final int ABASE_WWW_SECURITYEXCEPTION = 7;
    private static final int ABASE_WWW_SUCC = 0;
    private static final int ABASE_WWW_TIMEOUT = 2;
    private static final int ABASE_WWW_UNKNOWNHOST = 3;
    private static final int ABASE_WWW_UNSUPPORTEDURL = 4;
    private static final int CHUNK = 128000;
    private static final int INIT = 0;
    private static final int PAUSE = 2;
    private static final int PROCESSING = 1;
    private static final String TAG = "URLRequest";
    private long delegate;
    private long mDownloadDelegate;
    private String mFileMD5;
    private String mFilePath;
    private int mPart;
    private int mPartCount;
    private long mUploadDelegate;
    private String mUrlStr;
    private int timeout;
    private Map<String, String> mHeaders = new HashMap();
    private long mFileSize = 0;
    private long mFileCurrentSize = 0;
    private int mState = 0;

    public static native void nativeInit();

    public static native void nativeRemoveCacheData(long j);

    public static native void nativeResponse(int i, long j, int i2, String str, String str2, String str3, byte[] bArr, String[] strArr);

    public static native void nativeSaveUploadPart(long j, int i);

    public static native void nativeTaskBegan(long j, long j2);

    public static native void nativeTaskFinished(long j, int i, long j2);

    public static native void nativeTaskProgress(long j, long j2, long j3);

    public void setBody(byte[] bArr) {
    }

    public void response2cpp(URLResponse uRLResponse, int i) {
        XLog.i(TAG, "url[" + uRLResponse.URL + "]response2cpp with result :" + i);
        if (i != 0) {
            try {
                nativeResponse(i, this.delegate, 0, "", uRLResponse.URL, "", null, null);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : uRLResponse.headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && key != null) {
                arrayList.add(key);
                arrayList.add(value);
            }
        }
        try {
            nativeResponse(i, this.delegate, uRLResponse.status, uRLResponse.statusMsg, uRLResponse.URL, uRLResponse.version, uRLResponse.body, (String[]) arrayList.toArray(new String[0]));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void JNITaskBegan(long j, long j2) {
        try {
            nativeTaskBegan(j, j2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JNITaskProgress(long j, long j2, long j3) {
        try {
            nativeTaskProgress(j, j2, j3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JNITaskFinished(long j, int i, long j2) {
        try {
            nativeTaskFinished(j, i, j2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void JNISaveUploadPart(long j, int i) {
        try {
            nativeSaveUploadPart(j, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void JNIRemoveCacheData(long j) {
        try {
            nativeRemoveCacheData(j);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void init() {
        XLog.i(TAG, "URLRequest init");
        try {
            nativeInit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDelegate(long j) {
        this.delegate = j;
    }

    public void setDownloadDelegate(long j) {
        this.mDownloadDelegate = j;
    }

    public void setUploadDelegate(long j) {
        this.mUploadDelegate = j;
    }

    public void addHead(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public int initWithURL(String str, int i) {
        this.mUrlStr = str;
        this.timeout = i;
        return 0;
    }

    public void get(String str) {
        XLog.i(TAG, "URLRequest get" + str);
        this.mUrlStr = str;
        new Thread(new RequestTask()).start();
    }

    public void post(byte[] bArr) {
        new Thread(new RequestTask(bArr)).start();
    }

    public void uploadFile(String str, int i, int i2, int i3, String str2) {
        this.mFilePath = str;
        this.mFileSize = i;
        this.mPart = i3;
        this.mPartCount = i2;
        this.mFileMD5 = str2;
        if (this.mState == 1) {
            return;
        }
        new Thread(new UploadTask()).start();
    }

    public void downloadFile(String str) {
        this.mFilePath = str;
        if (this.mState == 1) {
            return;
        }
        new Thread(new DownloadTask()).start();
    }

    public void pause() {
        if (this.mState == 1) {
            this.mState = 2;
        }
    }

    public void cancel() {
        uninit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uninit() {
        this.mState = 0;
        this.mFileCurrentSize = 0L;
        this.mFileSize = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHeadersToConn(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            XLog.e(TAG, "urlConn is null!");
            return;
        }
        for (String str : this.mHeaders.keySet()) {
            httpURLConnection.setRequestProperty(str, this.mHeaders.get(str));
        }
    }

    /* loaded from: classes2.dex */
    class RequestTask implements Runnable {
        byte[] mBody;

        RequestTask() {
            this.mBody = null;
        }

        RequestTask(byte[] bArr) {
            this.mBody = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            URLResponse uRLResponse = new URLResponse();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(URLRequest.this.mUrlStr).openConnection();
                httpURLConnection.setReadTimeout(URLRequest.this.timeout);
                httpURLConnection.setConnectTimeout(URLRequest.this.timeout);
                URLRequest.this.addHeadersToConn(httpURLConnection);
                if (this.mBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(this.mBody);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } else {
                    httpURLConnection.setRequestMethod("GET");
                }
                httpURLConnection.connect();
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                if (headerFields == null || headerFields.entrySet() == null) {
                    XLog.e(URLRequest.TAG, "headerFields == null || headerFields.entrySet() == null");
                    return;
                }
                for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    StringBuilder sb = new StringBuilder();
                    if (value != null) {
                        Iterator<String> it = value.iterator();
                        while (it.hasNext()) {
                            sb.append(it.next());
                        }
                    }
                    if (key == null) {
                        uRLResponse.version = sb.toString().split("\\ ")[0];
                    } else {
                        uRLResponse.headers.put(key, sb.toString());
                    }
                }
                try {
                    uRLResponse.status = httpURLConnection.getResponseCode();
                } catch (IOException e) {
                    e.printStackTrace();
                    uRLResponse.status = 0;
                }
                try {
                    uRLResponse.statusMsg = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    uRLResponse.statusMsg = "No Status Message!";
                }
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[6144];
                    while (true) {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    byteArrayOutputStream.flush();
                                    byteArrayOutputStream.close();
                                    uRLResponse.body = byteArrayOutputStream.toByteArray();
                                    URLRequest.this.response2cpp(uRLResponse, 0);
                                    return;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    URLRequest.this.response2cpp(uRLResponse, 6);
                                    return;
                                }
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            URLRequest.this.response2cpp(uRLResponse, 6);
                            return;
                        }
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                    URLRequest.this.response2cpp(uRLResponse, 6);
                }
            } catch (SecurityException e6) {
                XLog.e(URLRequest.TAG, "SecurityException error=" + e6.toString());
                URLRequest.this.response2cpp(uRLResponse, 7);
            } catch (SocketTimeoutException unused) {
                XLog.e(URLRequest.TAG, "SocketTimeoutException");
                URLRequest.this.response2cpp(uRLResponse, 2);
            } catch (UnknownHostException unused2) {
                XLog.e(URLRequest.TAG, "UnknownHost");
                URLRequest.this.response2cpp(uRLResponse, 3);
            } catch (IOException e7) {
                XLog.e(URLRequest.TAG, "IOException");
                e7.printStackTrace();
                URLRequest.this.response2cpp(uRLResponse, 6);
            } catch (Exception e8) {
                XLog.e(URLRequest.TAG, "Exception error=" + e8.toString());
                URLRequest.this.response2cpp(uRLResponse, 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    class UploadTask implements Runnable {
        UploadTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            URLRequest.this.UploadProc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x047c  */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void UploadProc() {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.abase.URLRequest.UploadProc():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initDownload(HttpURLConnection httpURLConnection) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                if (httpURLConnection == null) {
                    XLog.e(TAG, "urlConn is null");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(null);
                    return false;
                }
                this.mFileCurrentSize = 0L;
                File file = new File(this.mFilePath);
                if (!file.exists() && !file.createNewFile()) {
                    XLog.e(TAG, "createNewFile failed");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(null);
                    return false;
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                try {
                    this.mFileSize = httpURLConnection.getContentLength();
                    if (this.mFileSize == -1) {
                        XLog.i(TAG, "get fileSize Fail");
                        randomAccessFile2.close();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        FileUtils.closeQuietly(randomAccessFile2);
                        return false;
                    }
                    XLog.i(TAG, "fileSize" + this.mFileSize);
                    randomAccessFile2.setLength(this.mFileSize);
                    JNITaskBegan(this.mDownloadDelegate, this.mFileSize);
                    randomAccessFile2.close();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile2);
                    return true;
                } catch (SocketTimeoutException unused) {
                    randomAccessFile = randomAccessFile2;
                    XLog.e(TAG, "SocketTimeoutException");
                    JNITaskFinished(this.mDownloadDelegate, 2, this.mFileSize);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile);
                    return false;
                } catch (UnknownHostException unused2) {
                    randomAccessFile = randomAccessFile2;
                    XLog.e(TAG, "UnknownHost");
                    JNITaskFinished(this.mDownloadDelegate, 3, this.mFileSize);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile);
                    return false;
                } catch (Exception e) {
                    e = e;
                    randomAccessFile = randomAccessFile2;
                    JNITaskFinished(this.mDownloadDelegate, 1, this.mFileSize);
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SocketTimeoutException unused3) {
        } catch (UnknownHostException unused4) {
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* loaded from: classes2.dex */
    class DownloadTask implements Runnable {
        DownloadTask() {
        }

        /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x01ee A[Catch: Exception -> 0x01ea, TryCatch #7 {Exception -> 0x01ea, blocks: (B:131:0x01e6, B:122:0x01ee, B:124:0x01f3), top: B:130:0x01e6 }] */
        /* JADX WARN: Removed duplicated region for block: B:124:0x01f3 A[Catch: Exception -> 0x01ea, TRY_LEAVE, TryCatch #7 {Exception -> 0x01ea, blocks: (B:131:0x01e6, B:122:0x01ee, B:124:0x01f3), top: B:130:0x01e6 }] */
        /* JADX WARN: Removed duplicated region for block: B:130:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01a4 A[Catch: Exception -> 0x01a0, TryCatch #14 {Exception -> 0x01a0, blocks: (B:76:0x019c, B:65:0x01a4, B:67:0x01a9), top: B:75:0x019c }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01a9 A[Catch: Exception -> 0x01a0, TRY_LEAVE, TryCatch #14 {Exception -> 0x01a0, blocks: (B:76:0x019c, B:65:0x01a4, B:67:0x01a9), top: B:75:0x019c }] */
        /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01d6 A[Catch: Exception -> 0x01d2, TryCatch #13 {Exception -> 0x01d2, blocks: (B:92:0x01ce, B:81:0x01d6, B:83:0x01db), top: B:91:0x01ce }] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01db A[Catch: Exception -> 0x01d2, TRY_LEAVE, TryCatch #13 {Exception -> 0x01d2, blocks: (B:92:0x01ce, B:81:0x01d6, B:83:0x01db), top: B:91:0x01ce }] */
        /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0172 A[Catch: Exception -> 0x016e, TryCatch #1 {Exception -> 0x016e, blocks: (B:108:0x016a, B:97:0x0172, B:99:0x0177), top: B:107:0x016a }] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0177 A[Catch: Exception -> 0x016e, TRY_LEAVE, TryCatch #1 {Exception -> 0x016e, blocks: (B:108:0x016a, B:97:0x0172, B:99:0x0177), top: B:107:0x016a }] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 508
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.abase.URLRequest.DownloadTask.run():void");
        }
    }
}
