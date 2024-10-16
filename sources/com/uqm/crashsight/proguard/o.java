package com.uqm.crashsight.proguard;

import android.content.Context;
import android.os.Process;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6624a = true;
    private static boolean b = true;
    private static SimpleDateFormat c = null;
    private static int d = 30720;
    private static StringBuilder e;
    private static StringBuilder f;
    private static boolean g;
    private static a h;
    private static String i;
    private static String j;
    private static Context k;
    private static String l;
    private static boolean m;
    private static boolean n;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    static {
        try {
            c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            m.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (o.class) {
            if (m || context == null || !f6624a) {
                return;
            }
            try {
                o = Executors.newSingleThreadExecutor();
                f = new StringBuilder(0);
                e = new StringBuilder(0);
                k = context;
                com.uqm.crashsight.crashreport.common.info.a a2 = com.uqm.crashsight.crashreport.common.info.a.a(context);
                i = a2.d;
                a2.getClass();
                j = "";
                l = k.getFilesDir().getPath() + "/crashSightlog_" + i + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + j + ".txt";
                p = Process.myPid();
            } catch (Throwable unused) {
            }
            m = true;
        }
    }

    public static void a(int i2) {
        synchronized (q) {
            d = i2;
            if (i2 < 0) {
                d = 0;
            } else if (i2 > 30720) {
                d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + q.b(th));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (o.class) {
            if (m && f6624a) {
                try {
                    o.execute(new Runnable() { // from class: com.uqm.crashsight.proguard.o.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            o.c(str, str2, str3);
                        }
                    });
                } catch (Exception e2) {
                    m.b(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, String str2, String str3) {
        synchronized (o.class) {
            if (b) {
                d(str, str2, str3);
            } else {
                e(str, str2, str3);
            }
        }
    }

    private static synchronized void d(String str, String str2, String str3) {
        synchronized (o.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f.append(a2);
                    if (f.length() >= d) {
                        f = f.delete(0, f.indexOf("\u0001\r\n") + 1);
                    }
                } catch (Throwable th) {
                    if (!m.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        synchronized (o.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f.append(a2);
                } catch (Throwable unused) {
                }
                if (f.length() <= d) {
                    return;
                }
                if (g) {
                    return;
                }
                g = true;
                if (h == null) {
                    h = new a(l);
                } else if (h.b == null || h.b.length() + f.length() > h.e) {
                    h.a();
                }
                if (h.a(f.toString())) {
                    f.setLength(0);
                    g = false;
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String date;
        e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = e;
        sb.append(date);
        sb.append(" ");
        sb.append(p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return e.toString();
    }

    public static byte[] a() {
        if (b) {
            if (f6624a) {
                return q.a((File) null, f.toString(), "crashsightlog.txt");
            }
            return null;
        }
        return b();
    }

    private static byte[] b() {
        if (!f6624a) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        synchronized (q) {
            if (h != null && h.f6626a && h.b != null && h.b.length() > 0) {
                sb.append(q.a(h.b, 30720, true));
            }
            if (f != null && f.length() > 0) {
                sb.append(f.toString());
            }
        }
        return q.a((File) null, sb.toString(), "crashsightlog.txt");
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6626a;
        private File b;
        private String c;
        private long d;
        private long e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.c = str;
            this.f6626a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                this.b = new File(this.c);
                if (this.b.exists() && !this.b.delete()) {
                    this.f6626a = false;
                    return false;
                }
                if (this.b.createNewFile()) {
                    return true;
                }
                this.f6626a = false;
                return false;
            } catch (Throwable th) {
                m.a(th);
                this.f6626a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f6626a) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(this.b, true);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.d += r10.length;
                this.f6626a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
    }
}
