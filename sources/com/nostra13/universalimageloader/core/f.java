package com.nostra13.universalimageloader.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    final e f5753a;
    private Executor b;
    private Executor c;
    private final Map<Integer, String> e = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReentrantLock> f = new WeakHashMap();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final Object j = new Object();
    private Executor d = a.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f5753a = eVar;
        this.b = eVar.g;
        this.c = eVar.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.d.execute(new Runnable() { // from class: com.nostra13.universalimageloader.core.f.1
            @Override // java.lang.Runnable
            public void run() {
                File a2 = f.this.f5753a.o.a(loadAndDisplayImageTask.a());
                boolean z = a2 != null && a2.exists();
                f.this.e();
                if (z) {
                    f.this.c.execute(loadAndDisplayImageTask);
                } else {
                    f.this.b.execute(loadAndDisplayImageTask);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        e();
        this.c.execute(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.f5753a.i && ((ExecutorService) this.b).isShutdown()) {
            this.b = f();
        }
        if (this.f5753a.j || !((ExecutorService) this.c).isShutdown()) {
            return;
        }
        this.c = f();
    }

    private Executor f() {
        return a.a(this.f5753a.k, this.f5753a.l, this.f5753a.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(com.nostra13.universalimageloader.core.c.a aVar) {
        return this.e.get(Integer.valueOf(aVar.f()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.nostra13.universalimageloader.core.c.a aVar, String str) {
        this.e.put(Integer.valueOf(aVar.f()), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.nostra13.universalimageloader.core.c.a aVar) {
        this.e.remove(Integer.valueOf(aVar.f()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        this.d.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReentrantLock a(String str) {
        ReentrantLock reentrantLock = this.f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f.put(str, reentrantLock2);
        return reentrantLock2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicBoolean a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object b() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.h.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.i.get();
    }
}
