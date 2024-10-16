package com.ihoc.mgpa.e.a;

import android.content.Context;
import android.os.SystemClock;
import com.ihoc.mgpa.n.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class c extends Thread {
    final Context d;

    /* renamed from: a, reason: collision with root package name */
    private final String f5513a = "TGPA_NonRichTapThread";
    final Object b = new Object();
    final Object c = new Object();
    boolean e = false;
    List<b> f = new ArrayList();

    public c(Context context) {
        this.d = context;
    }

    long a() {
        return SystemClock.elapsedRealtime();
    }

    public void a(b bVar) {
        synchronized (this.b) {
            bVar.d(bVar.c() + d.a(this.d).a(bVar.e()));
            bVar.f = 0L;
            synchronized (this.c) {
                if (this.f.size() > 0) {
                    m.a("TGPA_NonRichTapThread", "vibrating ,interrupt it");
                    this.f.get(0).g = false;
                }
                this.f.add(0, bVar);
            }
            try {
                this.b.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(b bVar) {
        synchronized (this.b) {
            synchronized (this.c) {
                if (this.f.isEmpty()) {
                    m.a("TGPA_NonRichTapThread", "vib list is empty,do nothing!!");
                    return;
                }
                int a2 = bVar.a();
                b bVar2 = this.f.get(0);
                if (bVar2.g) {
                    if (a2 != -1) {
                        bVar2.a(a2);
                    }
                    int c = bVar.c();
                    if (c != -1) {
                        int c2 = c - bVar2.c();
                        int f = bVar2.f() + c2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("updateParam interval:");
                        sb.append(c);
                        sb.append(" pre interval:");
                        sb.append(bVar2.c());
                        sb.append(" delta:");
                        sb.append(c2);
                        sb.append(" duration:");
                        sb.append(f);
                        m.a("TGPA_NonRichTapThread", sb.toString());
                        bVar2.c(c);
                        bVar2.d(f);
                    }
                    int b = bVar.b();
                    if (b != -1) {
                        bVar2.b(b);
                    }
                    try {
                        this.b.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean b() {
        synchronized (this.c) {
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                if (it.next().g) {
                    return true;
                }
            }
            return false;
        }
    }

    public void c() {
        this.e = true;
        synchronized (this.b) {
            try {
                synchronized (this.c) {
                    this.f.clear();
                    this.f = null;
                }
                this.b.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d() {
        synchronized (this.b) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (this.c) {
                if (this.f.isEmpty()) {
                    return;
                }
                b bVar = this.f.get(0);
                if (bVar.g) {
                    bVar.g = false;
                }
                this.b.notify();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        String str2;
        m.a("TGPA_NonRichTapThread", "non richTap thread start!!");
        while (!this.e) {
            if (this.f.isEmpty() || !b()) {
                synchronized (this.b) {
                    try {
                        synchronized (this.c) {
                            this.f.clear();
                        }
                        m.a("TGPA_NonRichTapThread", "nothing is in list,just wait!!");
                        this.b.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                long a2 = a();
                b bVar = this.f.get(0);
                if (bVar.g) {
                    long j = bVar.f;
                    if (j > a2) {
                        long j2 = j - a2;
                        synchronized (this.b) {
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append("go to sleep :");
                                sb.append(j2);
                                m.a("TGPA_NonRichTapThread", sb.toString());
                                this.b.wait(j2);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (bVar.i > bVar.d()) {
                            str = "TGPA_NonRichTapThread";
                            str2 = " looper finished,remove it!!";
                            m.a(str, str2);
                            bVar.g = false;
                        }
                    } else {
                        d.a(this.d).b(bVar.e(), bVar.d(), bVar.c(), bVar.a(), bVar.b());
                        bVar.i++;
                        m.a("TGPA_NonRichTapThread", " vib mHasVibNum:" + bVar.i);
                        if (bVar.i >= bVar.d()) {
                            str = "TGPA_NonRichTapThread";
                            str2 = " wake up vib looper is end ,remove it!!";
                            m.a(str, str2);
                            bVar.g = false;
                        } else {
                            bVar.f = a() + bVar.f();
                            m.a("TGPA_NonRichTapThread", " vib now:" + a() + " mWhen:" + bVar.f + " lastTime:" + bVar.f());
                        }
                    }
                }
            }
        }
        m.a("TGPA_NonRichTapThread", "non richTap thread quit!");
    }
}
