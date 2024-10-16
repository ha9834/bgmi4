package com.ihoc.mgpa.predownload.a;

import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.predownload.a.a;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class b implements a.InterfaceC0139a {
    private final ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<a, Future<?>> c = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f5688a = Executors.newSingleThreadScheduledExecutor();

    @Override // com.ihoc.mgpa.predownload.a.a.InterfaceC0139a
    public void a(e eVar, int i, int i2) {
        if (i2 == 3 || i2 == -1) {
            m.a("TGPA_FileMoverExecutor", "FileMoveExecutor remove task of fromUri = " + eVar.b + "in state = " + i2);
            a remove = this.b.remove(eVar.b);
            if (remove != null) {
                this.c.remove(remove);
            }
        }
    }

    public boolean a() {
        return !this.b.isEmpty();
    }

    public boolean a(a aVar) {
        if (aVar == null || aVar.b() == null) {
            return false;
        }
        a aVar2 = this.b.get(aVar.b().b);
        if (aVar2 != null) {
            m.a("TGPA_FileMoverExecutor", "Find a already CopyTask fromUri = " + aVar.b().b + " state = " + aVar2.a());
            if (aVar.c() && !aVar2.c()) {
                aVar2.a(true);
            }
            if (aVar2.a() != 1 && aVar2.a() != 0 && aVar2.a() != 4) {
                if (aVar2.a() == 2) {
                    Future<?> future = this.c.get(aVar2);
                    if (future == null || future.isCancelled() || future.isDone()) {
                        m.a("TGPA_FileMoverExecutor", "A pausing task is reSubmit fromUri = " + aVar.b().b);
                        this.c.put(aVar2, this.f5688a.schedule(aVar2, 50L, TimeUnit.MILLISECONDS));
                    }
                }
            }
            return true;
        }
        m.a("TGPA_FileMoverExecutor", "submit a new CopyTask fromUri = " + aVar.b().b);
        this.b.put(aVar.b().b, aVar);
        aVar.a(this);
        this.c.put(aVar, this.f5688a.schedule(aVar, 50L, TimeUnit.MILLISECONDS));
        return true;
    }

    public void b() {
        Iterator<Map.Entry<String, a>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().d();
        }
    }

    public void c() {
        Iterator<Map.Entry<String, a>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value.a() == 2) {
                value.e();
                Future<?> future = this.c.get(value);
                if (future == null || future.isCancelled() || future.isDone()) {
                    m.a("TGPA_FileMoverExecutor", "[resume]: A pausing task is reSubmit fromUri = " + value.b().b);
                    this.c.put(value, this.f5688a.submit(value));
                }
            }
        }
    }
}
