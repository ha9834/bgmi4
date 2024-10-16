package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public class g<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7010a = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_cur");
    private volatile Object _cur;

    public g(boolean z) {
        this._cur = new h(8, z);
    }

    public final int a() {
        return ((h) this._cur).b();
    }

    public final void b() {
        while (true) {
            h hVar = (h) this._cur;
            if (hVar.c()) {
                return;
            } else {
                f7010a.compareAndSet(this, hVar, hVar.e());
            }
        }
    }

    public final boolean a(E e) {
        while (true) {
            h hVar = (h) this._cur;
            switch (hVar.a((h) e)) {
                case 0:
                    return true;
                case 1:
                    f7010a.compareAndSet(this, hVar, hVar.e());
                    break;
                case 2:
                    return false;
            }
        }
    }

    public final E c() {
        while (true) {
            h hVar = (h) this._cur;
            E e = (E) hVar.d();
            if (e != h.f7011a) {
                return e;
            }
            f7010a.compareAndSet(this, hVar, hVar.e());
        }
    }
}
