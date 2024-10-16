package com.ihoc.mgpa.c;

import android.os.Process;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static volatile q f5509a;
    private com.ihoc.mgpa.n.r b;
    private Pattern c;

    private q() {
        if (com.ihoc.mgpa.i.f.w() != null) {
            this.c = Pattern.compile(com.ihoc.mgpa.i.f.w());
            this.b = new p(this, Process.myPid(), com.ihoc.mgpa.g.o.b().c.r);
        }
    }

    public static q a() {
        if (f5509a == null) {
            synchronized (q.class) {
                if (f5509a == null) {
                    f5509a = new q();
                }
            }
        }
        return f5509a;
    }

    public void b() {
        com.ihoc.mgpa.n.r rVar = this.b;
        if (rVar != null) {
            rVar.a();
        }
    }
}
