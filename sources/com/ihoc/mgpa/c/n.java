package com.ihoc.mgpa.c;

import com.amazonaws.services.s3.internal.Constants;
import com.ihoc.mgpa.g.E;

/* loaded from: classes2.dex */
public final class n {
    public static String a() {
        E e = com.ihoc.mgpa.g.o.b().c.f5574a;
        if (com.ihoc.mgpa.i.f.r() == null && e != null) {
            String a2 = com.ihoc.mgpa.n.q.a(e.f5555a);
            if (com.ihoc.mgpa.n.p.b(a2)) {
                a2 = com.ihoc.mgpa.n.q.a("ro.build.version.release", Constants.NULL_VERSION_ID);
            }
            com.ihoc.mgpa.i.f.s(a2);
        }
        return com.ihoc.mgpa.i.f.r();
    }

    public static String b() {
        E e = com.ihoc.mgpa.g.o.b().c.f5574a;
        if (com.ihoc.mgpa.i.f.v() == null && e != null) {
            String a2 = com.ihoc.mgpa.n.q.a(e.b);
            if (com.ihoc.mgpa.n.p.b(a2)) {
                a2 = com.ihoc.mgpa.n.q.a("ro.build.display.id", Constants.NULL_VERSION_ID);
            }
            com.ihoc.mgpa.i.f.v(a2);
        }
        return com.ihoc.mgpa.i.f.v();
    }
}
