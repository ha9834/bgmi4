package com.ihoc.mgpa.k;

import com.ihoc.mgpa.MgpaCallback;
import com.ihoc.mgpa.a.e;
import com.ihoc.mgpa.a.g;
import com.ihoc.mgpa.g.o;
import com.ihoc.mgpa.i.f;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.n.p;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f5656a;
    private String b = g.NO_SET.a();

    private c() {
    }

    public static c a() {
        if (f5656a == null) {
            synchronized (c.class) {
                if (f5656a == null) {
                    f5656a = new c();
                }
            }
        }
        return f5656a;
    }

    public void a(int i, String str) {
        if (f.la() && i == e.SCENE.a()) {
            m.a("TransceiverHelper: sceneID: %s , lastSceneID: %s ", str, this.b);
            if (str.equals(g.MAIN_UI.a()) && !this.b.equals(g.MAIN_UI.a())) {
                d.a().b();
            } else if (!str.equals(g.MAIN_UI.a()) && this.b.equals(g.MAIN_UI.a())) {
                d.a().c();
            }
            this.b = str;
        }
    }

    public void a(MgpaCallback mgpaCallback) {
        d.a().a(mgpaCallback);
    }

    public void a(String str, a aVar) {
        if (f.la()) {
            d.a().a(str, aVar);
        }
    }

    public void a(String str, String str2) {
        if (f.la()) {
            if (!str.equals("Transceiver") || str2 == null) {
                if (!str.equals("LocalTransceiver") || str2 == null) {
                    return;
                }
                d.a().a(str2);
                return;
            }
            if (str2.equals("start")) {
                d.a().b();
                return;
            }
            if (str2.equals("stop")) {
                d.a().c();
            } else if (str2.equals("init")) {
                b();
            } else if (str2.equals("preInit")) {
                c();
            }
        }
    }

    public void a(HashMap<String, String> hashMap) {
        if (f.la() && hashMap != null && hashMap.containsKey(e.SCENE.b())) {
            a(e.SCENE.a(), hashMap.get(e.SCENE.b()));
        }
    }

    public void b() {
        if (!f.la()) {
            m.c("TransceiverHelper: Transceiver func is not open. ", new Object[0]);
            return;
        }
        if (p.b(f.q())) {
            m.d("TransceiverHelper: openID is null, you should set openid first!", new Object[0]);
            return;
        }
        String a2 = f.a();
        if (p.b(a2)) {
            a2 = com.ihoc.mgpa.n.a.c();
        }
        d.a().a(f.q(), a2, com.ihoc.mgpa.g.g.a(), com.ihoc.mgpa.n.a.a());
    }

    public void c() {
        if (!o.b().b.m) {
            m.c("TransceiverHelper: preTransceiver func is not open. ", new Object[0]);
            return;
        }
        String a2 = com.ihoc.mgpa.n.o.a("TGPAOID", null);
        if (a2 == null) {
            m.d("TransceiverHelper: openID is null, try to use xid.!", new Object[0]);
            a2 = com.ihoc.mgpa.n.o.a("XID", null);
            if (a2 == null) {
                m.d("TransceiverHelper: xid is null, do not preInit Transceiver!", new Object[0]);
                return;
            }
        }
        d.a().a(a2, com.ihoc.mgpa.g.g.a(), com.ihoc.mgpa.n.a.a());
    }
}
