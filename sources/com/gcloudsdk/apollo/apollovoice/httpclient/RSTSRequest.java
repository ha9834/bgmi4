package com.gcloudsdk.apollo.apollovoice.httpclient;

import com.amazonaws.services.s3.Headers;
import com.gcloudsdk.apollo.ApolloVoiceLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class RSTSRequest {
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
    private boolean mInit = false;
    private long mDelegate = 0;
    private int mHttpCnt = 0;
    ExecutorService mFixedThreadPool = null;

    public static native void response(long j, int i, String str, int i2, int i3, byte[] bArr);

    static /* synthetic */ int access$006(RSTSRequest rSTSRequest) {
        int i = rSTSRequest.mHttpCnt - 1;
        rSTSRequest.mHttpCnt = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RSTSHTTPTask {
        public String mContent;
        public int mEnd;
        public int mSeq;
        public String mSession;
        public int mTimeout;
        public String mToken;
        public String mUrl;

        public RSTSHTTPTask(String str, String str2, String str3, String str4, int i, int i2, int i3) {
            this.mSession = str;
            this.mUrl = str2;
            this.mToken = str3;
            this.mContent = str4;
            this.mSeq = i;
            this.mEnd = i2;
            this.mTimeout = i3;
        }
    }

    public void setDelegate(long j) {
        this.mHttpCnt = 0;
        this.mDelegate = j;
        this.mFixedThreadPool = Executors.newFixedThreadPool(8);
        this.mInit = true;
    }

    public int addTask(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        if (!this.mInit) {
            return -1;
        }
        if (this.mHttpCnt > 1600) {
            ApolloVoiceLog.LogE("too many https task waiting...");
            return -1;
        }
        RSTSHTTPTask rSTSHTTPTask = new RSTSHTTPTask(str, str2, str3, str4, i, i2, i3);
        this.mHttpCnt++;
        this.mFixedThreadPool.submit(new RunTask(rSTSHTTPTask));
        return 0;
    }

    /* loaded from: classes.dex */
    class RunTask implements Runnable {
        private RSTSHTTPTask mTask;

        public RunTask(RSTSHTTPTask rSTSHTTPTask) {
            this.mTask = rSTSHTTPTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            dealTask();
        }

        private void dealTask() {
            URL url;
            HttpURLConnection httpURLConnection;
            ByteArrayOutputStream byteArrayOutputStream;
            int i;
            ApolloVoiceLog.LogI("rsts http begin, seq=" + this.mTask.mSeq);
            try {
                url = new URL(this.mTask.mUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                url = null;
            }
            if (url == null) {
                ApolloVoiceLog.LogE("reqConnURL");
                byteArrayOutputStream = null;
                i = 4;
            } else {
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    httpURLConnection = null;
                }
                ApolloVoiceLog.LogI("After open Connection With URL: " + this.mTask.mUrl);
                if (httpURLConnection == null) {
                    ApolloVoiceLog.LogI("urlConn == null");
                    byteArrayOutputStream = null;
                    i = 3;
                } else {
                    try {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty(Headers.CONNECTION, "keep-alive");
                        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                        httpURLConnection.setRequestProperty("Authorization", this.mTask.mToken);
                        httpURLConnection.setReadTimeout(this.mTask.mTimeout);
                        httpURLConnection.setConnectTimeout(this.mTask.mTimeout);
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                try {
                                    bufferedOutputStream.write(this.mTask.mContent.getBytes("UTF-8"));
                                    bufferedOutputStream.flush();
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                    try {
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        byte[] bArr = new byte[1500];
                                        while (true) {
                                            try {
                                                try {
                                                    int read = bufferedInputStream.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    } else {
                                                        byteArrayOutputStream.write(bArr, 0, read);
                                                    }
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception e5) {
                                                        e5.printStackTrace();
                                                    }
                                                    try {
                                                        bufferedInputStream.close();
                                                    } catch (Exception e6) {
                                                        e6.printStackTrace();
                                                    }
                                                    if (httpURLConnection != null) {
                                                        try {
                                                            httpURLConnection.disconnect();
                                                        } catch (Exception e7) {
                                                            e7.printStackTrace();
                                                        }
                                                    }
                                                    i = 6;
                                                }
                                            } catch (Throwable th) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception e8) {
                                                    e8.printStackTrace();
                                                }
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (Exception e9) {
                                                    e9.printStackTrace();
                                                }
                                                if (httpURLConnection != null) {
                                                    try {
                                                        httpURLConnection.disconnect();
                                                        throw th;
                                                    } catch (Exception e10) {
                                                        e10.printStackTrace();
                                                        throw th;
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                        byteArrayOutputStream.flush();
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e11) {
                                            e11.printStackTrace();
                                        }
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e12) {
                                            e12.printStackTrace();
                                        }
                                        if (httpURLConnection != null) {
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Exception e13) {
                                                e13.printStackTrace();
                                            }
                                        }
                                        i = 0;
                                    } catch (IOException e14) {
                                        e14.printStackTrace();
                                        byteArrayOutputStream = null;
                                        i = 1;
                                    }
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e16) {
                                        e16.printStackTrace();
                                    }
                                    byteArrayOutputStream = null;
                                    i = 7;
                                }
                            } catch (Throwable th2) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                                throw th2;
                            }
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            byteArrayOutputStream = null;
                            i = 9;
                        }
                    } catch (ProtocolException e19) {
                        e19.printStackTrace();
                        byteArrayOutputStream = null;
                        i = 10;
                    }
                }
            }
            RSTSRequest.access$006(RSTSRequest.this);
            RSTSRequest.response(RSTSRequest.this.mDelegate, i, this.mTask.mSession, this.mTask.mSeq, this.mTask.mEnd, byteArrayOutputStream != null ? byteArrayOutputStream.toByteArray() : null);
        }
    }
}
