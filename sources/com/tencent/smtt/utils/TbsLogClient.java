package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TbsLogClient {

    /* renamed from: a, reason: collision with root package name */
    static TbsLogClient f6537a = null;
    static File c = null;
    static String d = null;
    static byte[] e = null;
    private static boolean i = true;
    TextView b;
    private SimpleDateFormat f;
    private Context g;
    private StringBuffer h = new StringBuffer();

    public TbsLogClient(Context context) {
        this.f = null;
        this.g = null;
        try {
            this.g = context.getApplicationContext();
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception unused) {
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    private void a() {
        try {
            if (c == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String a2 = b.a(this.g, 6);
                    if (a2 == null) {
                        c = null;
                    } else {
                        c = new File(a2, "tbslog.txt");
                        d = LogFileUtils.createKey();
                        e = LogFileUtils.createHeaderText(c.getName(), d);
                    }
                } else {
                    c = null;
                }
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        }
    }

    public void writeLog(String str) {
        try {
            String format = this.f.format(Long.valueOf(System.currentTimeMillis()));
            StringBuffer stringBuffer = this.h;
            stringBuffer.append(format);
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || i) {
                writeLogToDisk();
            }
            if (this.h.length() > 524288) {
                this.h.delete(0, this.h.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            a();
            if (c != null) {
                LogFileUtils.writeDataToStorage(c, d, e, this.h.toString(), true);
                this.h.delete(0, this.h.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes2.dex */
    private class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f6538a;

        a(String str) {
            this.f6538a = null;
            this.f6538a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TbsLogClient.this.b != null) {
                TbsLogClient.this.b.append(this.f6538a + "\n");
            }
        }
    }

    public void showLog(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.post(new a(str));
        }
    }

    public void setLogView(TextView textView) {
        this.b = textView;
    }

    public static void setWriteLogJIT(boolean z) {
        i = z;
    }

    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    public void w(String str, String str2) {
        Log.w(str, str2);
    }

    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    public void v(String str, String str2) {
        Log.v(str, str2);
    }
}
