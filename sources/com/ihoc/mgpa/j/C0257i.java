package com.ihoc.mgpa.j;

/* renamed from: com.ihoc.mgpa.j.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0257i extends S {
    private static volatile C0257i m;

    private C0257i() {
    }

    public static C0257i g() {
        if (m == null) {
            synchronized (C0257i.class) {
                if (m == null) {
                    m = new C0257i();
                }
            }
        }
        return m;
    }

    @Override // com.ihoc.mgpa.j.S, com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        a(new C0255g(this));
    }

    @Override // com.ihoc.mgpa.j.S
    public void a(InterfaceC0250b interfaceC0250b) {
        Thread thread = this.h;
        if (thread != null && thread.isAlive()) {
            com.ihoc.mgpa.n.m.a("TGPA", "KogSocketClient: tgpa_kog_socket_connect thread is already created!");
        } else {
            this.h = new Thread(new RunnableC0256h(this, interfaceC0250b), "tgpa_kog_socket_connect");
            this.h.start();
        }
    }

    @Override // com.ihoc.mgpa.j.S, com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.KOGSOCKET;
    }

    @Override // com.ihoc.mgpa.j.S
    public String h() {
        return "resmon";
    }
}
