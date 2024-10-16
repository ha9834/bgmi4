package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static int f6514a = 0;
    static boolean b = false;
    private static c e = null;
    private static int h = 0;
    private static int i = 3;
    private static String k;
    private p c = null;
    private p d = null;
    private boolean f = false;
    private boolean g = false;
    private File j = null;

    private c() {
    }

    public static c a(boolean z) {
        if (e == null && z) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c();
                }
            }
        }
        return e;
    }

    public synchronized void a(Context context, boolean z, boolean z2, i iVar) {
    }

    public p a() {
        if (this.f) {
            return this.c;
        }
        return null;
    }

    public boolean b() {
        return this.f;
    }

    public static int c() {
        return h;
    }

    public String d() {
        return (this.c == null || QbSdk.f6432a) ? "system webview get nothing..." : "x5 webview get noting";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        TbsLog.d("SDKEngine", "getTbsNeedReboot");
        if (b) {
            if (k == null) {
                return false;
            }
            int g = g();
            if (g == 0) {
                a(1);
            } else {
                int i2 = g + 1;
                if (i2 > i) {
                    return false;
                }
                a(i2);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(boolean z) {
        b = z;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        k = str;
    }

    private int g() {
        TbsLog.d("SDKEngine", "getCountProp");
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file = new File(this.j, "count.prop");
                if (!file.exists()) {
                    return 0;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    int intValue = Integer.valueOf(properties.getProperty(k, "1")).intValue();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return intValue;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(int i2) {
        TbsLog.d("SDKEngine", "setCountProp i = " + i2);
        String valueOf = String.valueOf(i2);
        Properties properties = new Properties();
        properties.setProperty(k, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.j, "count.prop")), (String) null);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
