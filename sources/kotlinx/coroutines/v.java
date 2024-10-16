package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.u;

/* loaded from: classes3.dex */
public abstract class v extends t {
    protected abstract Thread a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        Thread a2 = a();
        if (Thread.currentThread() != a2) {
            af a3 = ag.a();
            if (a3 != null) {
                a3.a(a2);
            } else {
                LockSupport.unpark(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(long j, u.a aVar) {
        if (n.a()) {
            if (!(this != p.b)) {
                throw new AssertionError();
            }
        }
        p.b.a(j, aVar);
    }
}
