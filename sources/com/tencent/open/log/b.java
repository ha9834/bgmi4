package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f6388a = d.C0212d.a("yy.MM.dd.HH");
    private File g;
    private String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = 4096;
    private long f = LogUtils.LOG_FUSE_TIME;
    private int h = 10;
    private String i = LogUtils.LOG_EXT;
    private long j = Long.MAX_VALUE;

    public b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        a(file);
        b(i);
        a(i2);
        c(i3);
        a(str);
        b(j);
        d(i4);
        b(str2);
        c(j2);
    }

    public File[] a() {
        return d(System.currentTimeMillis());
    }

    private File[] d(long j) {
        File file;
        File file2;
        File b = b();
        String c = c(a(j));
        try {
            file = new File(b, c);
        } catch (Throwable th) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
            file = b;
        }
        String b2 = l.b();
        if (!TextUtils.isEmpty(b2) || b2 != null) {
            try {
                File file3 = new File(b2, c.o);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                file2 = new File(file3, c);
            } catch (Exception e) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
            }
            return new File[]{file, file2};
        }
        file2 = null;
        return new File[]{file, file2};
    }

    public static String a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + LogUtils.LOG_EXT;
    }

    public File b() {
        File e = e();
        if (e != null) {
            e.mkdirs();
        }
        return e;
    }

    public String c() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public int d() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public void b(long j) {
        this.f = j;
    }

    public File e() {
        return this.g;
    }

    public void a(File file) {
        this.g = file;
    }

    public int f() {
        return this.h;
    }

    public void d(int i) {
        this.h = i;
    }

    public void b(String str) {
        this.i = str;
    }

    public void c(long j) {
        this.j = j;
    }
}
