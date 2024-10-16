package androidx.constraintlayout.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class k {
    HashSet<k> h = new HashSet<>(2);
    int i = 0;

    public void a() {
    }

    public void a(k kVar) {
        this.h.add(kVar);
    }

    public void b() {
        this.i = 0;
        this.h.clear();
    }

    public void e() {
        this.i = 0;
        Iterator<k> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public void f() {
        this.i = 1;
        Iterator<k> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean g() {
        return this.i == 1;
    }
}
