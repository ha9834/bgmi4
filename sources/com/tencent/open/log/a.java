package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class a extends Tracer implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private b f6387a;
    private FileWriter b;
    private FileWriter c;
    private File d;
    private File e;
    private char[] f;
    private volatile f g;
    private volatile f h;
    private volatile f i;
    private volatile f j;
    private volatile boolean k;
    private HandlerThread l;
    private Handler m;

    public a(b bVar) {
        this(c.b, true, g.f6393a, bVar);
    }

    public a(int i, boolean z, g gVar, b bVar) {
        super(i, z, gVar);
        this.k = false;
        a(bVar);
        this.g = new f();
        this.h = new f();
        this.i = this.g;
        this.j = this.h;
        this.f = new char[bVar.d()];
        this.l = new HandlerThread(bVar.c(), bVar.f());
        HandlerThread handlerThread = this.l;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.l.isAlive() || this.l.getLooper() == null) {
            return;
        }
        this.m = new Handler(this.l.getLooper(), this);
    }

    public void a() {
        if (this.m.hasMessages(1024)) {
            this.m.removeMessages(1024);
        }
        this.m.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        i();
        this.l.quit();
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().a(i, thread, j, str, str2, th));
    }

    private void a(String str) {
        this.i.a(str);
        if (this.i.a() >= c().d()) {
            a();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void f() {
        if (Thread.currentThread() == this.l && !this.k) {
            this.k = true;
            j();
            try {
                try {
                    this.j.a(g(), this.f);
                } catch (IOException e) {
                    SLog.e("FileTracer", "flushBuffer exception", e);
                }
                this.k = false;
            } finally {
                this.j.b();
            }
        }
    }

    private Writer[] g() {
        File[] a2 = c().a();
        if (a2 != null && a2.length >= 2) {
            File file = a2[0];
            if ((file != null && !file.equals(this.d)) || (this.b == null && file != null)) {
                this.d = file;
                h();
                try {
                    this.b = new FileWriter(this.d, true);
                } catch (IOException unused) {
                    this.b = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = a2[1];
            if ((file2 != null && !file2.equals(this.e)) || (this.c == null && file2 != null)) {
                this.e = file2;
                i();
                try {
                    this.c = new FileWriter(this.e, true);
                } catch (IOException unused2) {
                    this.c = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                }
                a(file2);
            }
        }
        return new Writer[]{this.b, this.c};
    }

    private void a(File file) {
        File[] listFiles;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (listFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (b(file2)) {
                String name = file2.getName();
                if (b.a(System.currentTimeMillis() - (Tencent.USE_ONE_HOUR ? 3600000L : 259200000L)).compareTo(name.substring(32, 43)) > 0) {
                    SLog.d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    private boolean b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.d("FileTracer", "name=" + name);
        return !TextUtils.isEmpty(name) && name.length() == 47 && name.startsWith("com.tencent.mobileqq_connectSdk.") && name.endsWith(LogUtils.LOG_EXT);
    }

    private void h() {
        try {
            if (this.b != null) {
                this.b.flush();
                this.b.close();
            }
        } catch (IOException e) {
            SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e);
        }
    }

    private void i() {
        try {
            if (this.c != null) {
                this.c.flush();
                this.c.close();
            }
        } catch (IOException e) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.i == this.g) {
                this.i = this.h;
                this.j = this.g;
            } else {
                this.i = this.g;
                this.j = this.h;
            }
        }
    }

    public b c() {
        return this.f6387a;
    }

    public void a(b bVar) {
        this.f6387a = bVar;
    }
}
