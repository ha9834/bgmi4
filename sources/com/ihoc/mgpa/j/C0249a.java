package com.ihoc.mgpa.j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ihoc.mgpa.j.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0249a implements InterfaceC0253e {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0253e f5637a;

    private void g() {
        com.ihoc.mgpa.f.H.b().b(com.ihoc.mgpa.a.e.SCENE.a(), com.ihoc.mgpa.a.g.START.a());
        if (com.ihoc.mgpa.n.p.a(com.ihoc.mgpa.g.o.b().c.q)) {
            return;
        }
        com.ihoc.mgpa.f.H.b().b(com.ihoc.mgpa.a.e.NET_LATENCY_OPT_SCENE.a(), com.ihoc.mgpa.g.o.b().c.q);
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        com.ihoc.mgpa.n.m.a("The base vendor proxy type is unkown, start to check next successor.", new Object[0]);
        c();
    }

    public void a(int i, String str) {
    }

    public void a(InterfaceC0253e interfaceC0253e) {
        this.f5637a = interfaceC0253e;
    }

    public void a(HashMap<String, String> hashMap) {
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.UNKOWN;
    }

    public void b(int i, String str) {
    }

    public void b(HashMap<String, String> hashMap) {
    }

    public void c() {
        if (z.c != A.UNKOWN) {
            com.ihoc.mgpa.n.m.c("check available vendor proxy success,. available type: " + z.c.a(), new Object[0]);
        } else {
            if (this.f5637a != null) {
                com.ihoc.mgpa.n.m.c("start to check next successor, vendor proxy type: " + this.f5637a.b(), new Object[0]);
                z.b = B.CheckNow;
                this.f5637a.a();
                return;
            }
            com.ihoc.mgpa.n.m.c("check available vendor proxy finished. no vendor proxy is available!", new Object[0]);
        }
        z.b = B.Finished;
        f();
    }

    public String d() {
        return "ERROR";
    }

    public boolean e() {
        return false;
    }

    public void f() {
        z.b = B.Finished;
        com.ihoc.mgpa.f.H.b().b(com.ihoc.mgpa.a.e.STRATEGY_CHECK.a(), "0");
        g();
        ConcurrentHashMap<Object, String> concurrentHashMap = com.ihoc.mgpa.i.f.g;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            com.ihoc.mgpa.n.m.a("no cache data need to resend.", new Object[0]);
            return;
        }
        HashMap<Object, String> hashMap = new HashMap<>();
        for (Map.Entry<Object, String> entry : com.ihoc.mgpa.i.f.g.entrySet()) {
            if (entry.getKey() instanceof Number) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            } else if (entry.getKey() instanceof String) {
                com.ihoc.mgpa.f.H.b().a(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            } else {
                com.ihoc.mgpa.n.m.b("cache data format is unkown.", new Object[0]);
            }
        }
        com.ihoc.mgpa.f.H.b().a(hashMap);
        com.ihoc.mgpa.i.f.g = null;
    }
}
