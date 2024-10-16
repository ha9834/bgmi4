package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;

/* loaded from: classes2.dex */
public class TbsLogReport {

    /* renamed from: a, reason: collision with root package name */
    private static TbsLogReport f6466a;
    private Handler b;
    private boolean c = false;

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
    }

    /* loaded from: classes2.dex */
    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5),
        TYPE_SDK_REPORT_INFO(6);


        /* renamed from: a, reason: collision with root package name */
        int f6468a;

        EventType(int i) {
            this.f6468a = i;
        }
    }

    private TbsLogReport(Context context) {
        this.b = null;
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper()) { // from class: com.tencent.smtt.sdk.TbsLogReport.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
            }
        };
    }

    public static TbsLogReport getInstance(Context context) {
        if (f6466a == null) {
            synchronized (TbsLogReport.class) {
                if (f6466a == null) {
                    f6466a = new TbsLogReport(context);
                }
            }
        }
        return f6466a;
    }

    /* loaded from: classes2.dex */
    public static class TbsLogInfo implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        int f6469a;
        private long b;
        private String c;
        private String d;
        private int e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private long l;
        private long m;
        private int n;
        private String o;
        private String p;
        private long q;

        private TbsLogInfo() {
        }

        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException unused) {
                return this;
            }
        }

        public void resetArgs() {
            this.b = 0L;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 2;
            this.i = "unknown";
            this.j = 0;
            this.k = 2;
            this.l = 0L;
            this.m = 0L;
            this.n = 1;
            this.f6469a = 0;
            this.o = null;
            this.p = null;
            this.q = 0L;
        }

        public void setEventTime(long j) {
            this.b = j;
        }

        public void setErrorCode(int i) {
            if (i != 100 && i != 110 && i != 120 && i != 111 && i < 400) {
                TbsLog.i("upload", "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                TbsLog.i("upload", "you are not in wifi, downloading stoped", true);
            }
            this.f6469a = i;
        }

        public void setFailDetail(String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.p = str;
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.p = stackTraceString;
        }

        public void setDownloadSize(long j) {
            this.q += j;
        }
    }

    public TbsLogInfo tbsLogInfo() {
        return new TbsLogInfo();
    }

    public void setInstallErrorCode(int i, String str) {
        setInstallErrorCode(i, str, EventType.TYPE_INSTALL);
    }

    public void setInstallErrorCode(int i, String str, EventType eventType) {
        if (i != 200 && i != 220 && i != 221) {
            TbsLog.i("upload", "error occured in installation, errorCode:" + i, true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i, tbsLogInfo, eventType);
    }

    private void a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.k.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
    }

    public void setInstallErrorCode(int i, Throwable th) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        a(i, tbsLogInfo, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i, String str) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
        Log.d("TbsLogReport", "setLoadErrorCode(" + i + "," + str + ")");
    }

    public void setLoadErrorCode(int i, Throwable th) {
        String str = "NULL";
        if (th != null) {
            String str2 = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str2.length() > 1024) {
                str2 = str2.substring(0, 1024);
            }
            str = str2;
        }
        setLoadErrorCode(i, str);
    }

    public void dailyReport() {
        this.b.sendEmptyMessage(601);
    }

    public void setShouldUploadEventReport(boolean z) {
        this.c = z;
    }

    public boolean getShouldUploadEventReport() {
        return this.c;
    }
}
