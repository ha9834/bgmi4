package com.gcloudsdk.apollo.apollovoice.httpclient;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.util.Mimetypes;
import com.gcloudsdk.apollo.ApolloVoiceLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class SRTTAPIHTTPTaskQueueImp {
    public static final int RSTT_HTTP_ERR_FAIL = 1;
    public static final int RSTT_HTTP_ERR_SUCC = 0;
    public static final int RSTT_HTTP_ERR_getInputStream_IOException = 13;
    public static final int RSTT_HTTP_ERR_getInputStream_UnknownServiceException = 12;
    public static final int RSTT_HTTP_ERR_getOutputStream_IOException = 16;
    public static final int RSTT_HTTP_ERR_getResponseCode_IOException = 17;
    public static final int RSTT_HTTP_ERR_new_URL = 10;
    public static final int RSTT_HTTP_ERR_openConnection = 11;
    public static final int RSTT_HTTP_ERR_read_IOException = 14;
    public static final int RSTT_HTTP_ERR_write_IOException = 15;
    private static String apiAddr = "";
    private static String apiKey = "wxk158ztg8lli234j";
    private int session_seq;
    private LinkedList<SRTTAPIHTTPTask> taskQueue;
    private String timestampArg;
    private Thread workThread;

    public static native void callback(int i, String str, int i2, String str2, String str3, byte[] bArr, int i3);

    public void init() {
        this.session_seq = 0;
        this.taskQueue = new LinkedList<>();
        this.workThread = new Thread(new RequestTask(), "GVoiceRSTTRequest");
        this.workThread.start();
    }

    public void setAppInfo(String str, String str2) {
        apiKey = str;
        apiAddr = formatHttps(str2);
    }

    public synchronized void addTask(int i, int i2, String str, byte[] bArr, int i3) {
        SRTTAPIHTTPTask sRTTAPIHTTPTask = new SRTTAPIHTTPTask();
        sRTTAPIHTTPTask.type = i;
        sRTTAPIHTTPTask.body = bArr;
        sRTTAPIHTTPTask.key = str;
        sRTTAPIHTTPTask.method = i2;
        sRTTAPIHTTPTask.session = i3;
        sRTTAPIHTTPTask.seq = this.session_seq;
        this.taskQueue.offer(sRTTAPIHTTPTask);
        this.session_seq++;
    }

    public static String ExceptionToString(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            ApolloVoiceLog.LogE(stringWriter2);
            return stringWriter2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealStartTask(int i) {
        String str;
        String ExceptionToString;
        String str2;
        int i2;
        int i3;
        ApolloVoiceLog.LogI("dealStartTask");
        String str3 = "No error";
        String str4 = "";
        String str5 = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 200;
        try {
            String str6 = apiAddr + "?cmd=1&appid=" + apiKey;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str6).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("POST");
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }
                    httpURLConnection.setRequestProperty("Content-Type", Mimetypes.MIMETYPE_HTML);
                    httpURLConnection.setRequestProperty(Headers.CONNECTION, "keep-alive");
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    try {
                        i4 = httpURLConnection.getResponseCode();
                    } catch (IOException e2) {
                        str4 = ExceptionToString(e2);
                        str3 = "getResponseCode failed,IOException";
                    }
                    try {
                        String responseMessage = httpURLConnection.getResponseMessage();
                        if (responseMessage != null) {
                            str5 = responseMessage;
                        }
                    } catch (IOException e3) {
                        str4 = ExceptionToString(e3);
                        str3 = "getResponseMessage failed,IOException";
                    }
                    try {
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
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
                                        String ExceptionToString2 = ExceptionToString(e4);
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
                                        str = "InputStream read failed,IOException";
                                        ExceptionToString = ExceptionToString2;
                                        str2 = str5;
                                        i2 = i4;
                                        i3 = 14;
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
                            str = str3;
                            ExceptionToString = str4;
                            str2 = str5;
                            i2 = i4;
                            i3 = 0;
                        } catch (UnknownServiceException e14) {
                            str = "getInputStream failed,UnknownServiceException";
                            ExceptionToString = ExceptionToString(e14);
                            str2 = str5;
                            i2 = i4;
                            i3 = 12;
                        }
                    } catch (IOException e15) {
                        str = "getInputStream failed,IOException";
                        ExceptionToString = ExceptionToString(e15);
                        str2 = str5;
                        i2 = i4;
                        i3 = 13;
                    }
                } catch (IOException e16) {
                    str = "openConnection failed,IOException";
                    ExceptionToString = ExceptionToString(e16);
                    str2 = "";
                    i3 = 11;
                    i2 = 200;
                }
            } catch (MalformedURLException e17) {
                str = "new URL failed,MalformedURLException,url=" + str6;
                ExceptionToString = ExceptionToString(e17);
                str2 = "";
                i3 = 10;
                i2 = 200;
            }
        } catch (Exception e18) {
            str = "unknown exception";
            ExceptionToString = ExceptionToString(e18);
            str2 = str5;
            i2 = i4;
            i3 = 1;
        }
        callback(i3, str, i2, str2, ExceptionToString, byteArrayOutputStream.toByteArray(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public void dealStopTask(SRTTAPIHTTPTask sRTTAPIHTTPTask) {
        ?? r7;
        String ExceptionToString;
        String str;
        int i;
        int i2;
        ApolloVoiceLog.LogI("dealStopTask");
        String str2 = "No error";
        String str3 = "";
        String str4 = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 200;
        try {
            String str5 = apiAddr + "?platform=android&cmd=6&appid=" + apiKey + "&voice_id=" + sRTTAPIHTTPTask.key;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str5).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("POST");
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection.setRequestProperty(Headers.CONNECTION, "keep-alive");
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    r7 = 5000;
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    try {
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                bufferedOutputStream.write(sRTTAPIHTTPTask.body);
                                bufferedOutputStream.flush();
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                try {
                                    i3 = httpURLConnection.getResponseCode();
                                    try {
                                        String responseMessage = httpURLConnection.getResponseMessage();
                                        if (responseMessage != null) {
                                            str4 = responseMessage;
                                        }
                                    } catch (IOException e3) {
                                        str3 = ExceptionToString(e3);
                                        str2 = "getResponseMessage failed,IOException";
                                    }
                                    try {
                                        try {
                                            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
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
                                                        String ExceptionToString2 = ExceptionToString(e4);
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
                                                        r7 = "InputStream read failed,IOException";
                                                        ExceptionToString = ExceptionToString2;
                                                        str = str4;
                                                        i = i3;
                                                        i2 = 14;
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
                                            r7 = str2;
                                            ExceptionToString = str3;
                                            str = str4;
                                            i = i3;
                                            i2 = 0;
                                        } catch (UnknownServiceException e14) {
                                            r7 = "getInputStream failed,UnknownServiceException";
                                            ExceptionToString = ExceptionToString(e14);
                                            str = str4;
                                            i = i3;
                                            i2 = 12;
                                        }
                                    } catch (IOException e15) {
                                        r7 = "getInputStream failed,IOException";
                                        ExceptionToString = ExceptionToString(e15);
                                        str = str4;
                                        i = i3;
                                        i2 = 13;
                                    }
                                } catch (IOException e16) {
                                    r7 = "getResponseCode failed,IOException";
                                    ExceptionToString = ExceptionToString(e16);
                                    str = "";
                                    i2 = 17;
                                    i = 200;
                                }
                            } catch (IOException e17) {
                                String ExceptionToString3 = ExceptionToString(e17);
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                                r7 = "OutputStream write failed,IOException";
                                ExceptionToString = ExceptionToString3;
                                str = "";
                                i2 = 15;
                                i = 200;
                            }
                        } catch (IOException e19) {
                            r7 = "getOutputStream failed,IOException";
                            ExceptionToString = ExceptionToString(e19);
                            str = "";
                            i2 = 16;
                            i = 200;
                        }
                    } catch (Throwable th2) {
                        try {
                            r7.close();
                        } catch (IOException e20) {
                            e20.printStackTrace();
                        }
                        throw th2;
                    }
                } catch (IOException e21) {
                    r7 = "openConnection failed,IOException";
                    ExceptionToString = ExceptionToString(e21);
                    str = "";
                    i2 = 11;
                    i = 200;
                }
            } catch (MalformedURLException e22) {
                r7 = "new URL failed,MalformedURLException,url=" + str5;
                ExceptionToString = ExceptionToString(e22);
                str = "";
                i2 = 10;
                i = 200;
            }
        } catch (Exception e23) {
            r7 = "unknown exception";
            ExceptionToString = ExceptionToString(e23);
            str = str4;
            i = i3;
            i2 = 1;
        }
        callback(i2, r7, i, str, ExceptionToString, byteArrayOutputStream.toByteArray(), sRTTAPIHTTPTask.session);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealVoiceTask(SRTTAPIHTTPTask sRTTAPIHTTPTask) {
        String str;
        String ExceptionToString;
        String str2;
        int i;
        int i2;
        String str3 = "No error";
        String str4 = "";
        String str5 = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            String str6 = apiAddr + "?platform=android&cmd=6&appid=" + apiKey + "&voice_id=" + sRTTAPIHTTPTask.key;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str6).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("POST");
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection.setRequestProperty(Headers.CONNECTION, "keep-alive");
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        try {
                            try {
                                bufferedOutputStream.write(sRTTAPIHTTPTask.body);
                                bufferedOutputStream.flush();
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                try {
                                    int responseCode = httpURLConnection.getResponseCode();
                                    try {
                                        String responseMessage = httpURLConnection.getResponseMessage();
                                        if (responseMessage != null) {
                                            str5 = responseMessage;
                                        }
                                    } catch (IOException e3) {
                                        str4 = ExceptionToString(e3);
                                        str3 = "getResponseMessage failed,IOException";
                                    }
                                    try {
                                        try {
                                            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
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
                                                    } catch (Throwable th) {
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (Exception e4) {
                                                            e4.printStackTrace();
                                                        }
                                                        try {
                                                            bufferedInputStream.close();
                                                        } catch (Exception e5) {
                                                            e5.printStackTrace();
                                                        }
                                                        if (httpURLConnection != null) {
                                                            try {
                                                                httpURLConnection.disconnect();
                                                                throw th;
                                                            } catch (Exception e6) {
                                                                e6.printStackTrace();
                                                                throw th;
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                } catch (IOException e7) {
                                                    String ExceptionToString2 = ExceptionToString(e7);
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
                                                        } catch (Exception e10) {
                                                            e10.printStackTrace();
                                                        }
                                                    }
                                                    str = "InputStream read failed,IOException";
                                                    ExceptionToString = ExceptionToString2;
                                                    str2 = str5;
                                                    i = responseCode;
                                                    i2 = 14;
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
                                            str = str3;
                                            ExceptionToString = str4;
                                            str2 = str5;
                                            i = responseCode;
                                            i2 = 0;
                                        } catch (UnknownServiceException e14) {
                                            str = "getInputStream failed,UnknownServiceException";
                                            ExceptionToString = ExceptionToString(e14);
                                            str2 = str5;
                                            i = responseCode;
                                            i2 = 12;
                                        }
                                    } catch (IOException e15) {
                                        str = "getInputStream failed,IOException";
                                        ExceptionToString = ExceptionToString(e15);
                                        str2 = str5;
                                        i = responseCode;
                                        i2 = 13;
                                    }
                                } catch (IOException e16) {
                                    str = "getResponseCode failed,IOException";
                                    ExceptionToString = ExceptionToString(e16);
                                    str2 = "";
                                    i2 = 17;
                                    i = 200;
                                }
                            } catch (IOException e17) {
                                String ExceptionToString3 = ExceptionToString(e17);
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                                str = "OutputStream write failed,IOException";
                                ExceptionToString = ExceptionToString3;
                                str2 = "";
                                i2 = 15;
                                i = 200;
                            }
                        } catch (Throwable th2) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                            throw th2;
                        }
                    } catch (IOException e20) {
                        str = "getOutputStream failed,IOException";
                        ExceptionToString = ExceptionToString(e20);
                        str2 = "";
                        i2 = 16;
                        i = 200;
                    }
                } catch (IOException e21) {
                    str = "openConnection failed,IOException";
                    ExceptionToString = ExceptionToString(e21);
                    str2 = "";
                    i2 = 11;
                    i = 200;
                }
            } catch (MalformedURLException e22) {
                str = "new URL failed,MalformedURLException,url=" + str6;
                ExceptionToString = ExceptionToString(e22);
                str2 = "";
                i2 = 10;
                i = 200;
            }
        } catch (Exception e23) {
            str = "unknown exception";
            ExceptionToString = ExceptionToString(e23);
            str2 = str5;
            i = 200;
            i2 = 1;
        }
        callback(i2, str, i, str2, ExceptionToString, byteArrayOutputStream.toByteArray(), sRTTAPIHTTPTask.session);
    }

    private String formatHttps(String str) {
        if (str == null) {
            ApolloVoiceLog.LogI("URL is null");
            return str;
        }
        if (str.length() >= 5) {
            return str.startsWith("https:") ? str : "https".concat(str.substring(4));
        }
        ApolloVoiceLog.LogI("URL's length < 5");
        return str;
    }

    /* loaded from: classes.dex */
    class RequestTask implements Runnable {
        RequestTask() {
        }

        /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "block" is null
            	at jadx.core.dex.nodes.MethodNode.isPreExitBlock(MethodNode.java:398)
            	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:908)
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        /* JADX INFO: Infinite loop detected, blocks: 33, insns: 0 */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r3 = this;
            L0:
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp r0 = com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.this
                java.util.LinkedList r0 = com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.access$000(r0)
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L17
                r0 = 500(0x1f4, double:2.47E-321)
                java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L12
                goto L0
            L12:
                r0 = move-exception
                r0.printStackTrace()
                goto L0
            L17:
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp r0 = com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.this     // Catch: java.lang.Exception -> L53
                java.util.LinkedList r0 = com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.access$000(r0)     // Catch: java.lang.Exception -> L53
                java.lang.Object r0 = r0.remove()     // Catch: java.lang.Exception -> L53
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTask r0 = (com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTask) r0     // Catch: java.lang.Exception -> L53
                int r1 = r0.type
                switch(r1) {
                    case 1: goto L4b;
                    case 2: goto L45;
                    case 3: goto L3f;
                    default: goto L28;
                }
            L28:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unknown type: "
                r1.append(r2)
                int r0 = r0.type
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                com.gcloudsdk.apollo.ApolloVoiceLog.LogI(r0)
                goto L0
            L3f:
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp r1 = com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.this
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.access$300(r1, r0)
                goto L0
            L45:
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp r1 = com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.this
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.access$200(r1, r0)
                goto L0
            L4b:
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp r1 = com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.this
                int r0 = r0.session
                com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.access$100(r1, r0)
                goto L0
            L53:
                r0 = move-exception
                r0.printStackTrace()
                goto L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.apollovoice.httpclient.SRTTAPIHTTPTaskQueueImp.RequestTask.run():void");
        }
    }
}
