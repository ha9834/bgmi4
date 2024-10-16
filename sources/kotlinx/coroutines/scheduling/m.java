package kotlinx.coroutines.scheduling;

import com.google.android.gms.games.Notifications;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.n;

/* loaded from: classes3.dex */
public final class m {
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");
    private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");
    private static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");
    private static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<h> f7035a = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    public final int a() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int b() {
        return this.lastScheduledTask != null ? a() + 1 : a();
    }

    public final h c() {
        h hVar = (h) b.getAndSet(this, null);
        return hVar != null ? hVar : d();
    }

    public static /* synthetic */ h a(m mVar, h hVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return mVar.a(hVar, z);
    }

    public final h a(h hVar, boolean z) {
        if (z) {
            return a(hVar);
        }
        h hVar2 = (h) b.getAndSet(this, hVar);
        if (hVar2 != null) {
            return a(hVar2);
        }
        return null;
    }

    public final long a(m mVar) {
        if (n.a()) {
            if (!(a() == 0)) {
                throw new AssertionError();
            }
        }
        h d2 = mVar.d();
        if (d2 != null) {
            h a2 = a(this, d2, false, 2, null);
            if (!n.a()) {
                return -1L;
            }
            if (a2 == null) {
                return -1L;
            }
            throw new AssertionError();
        }
        return a(mVar, false);
    }

    public final long b(m mVar) {
        if (n.a()) {
            if (!(a() == 0)) {
                throw new AssertionError();
            }
        }
        int i = mVar.producerIndex;
        AtomicReferenceArray<h> atomicReferenceArray = mVar.f7035a;
        for (int i2 = mVar.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & Notifications.NOTIFICATION_TYPES_ALL;
            if (mVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = atomicReferenceArray.get(i3);
            if (hVar != null) {
                if ((hVar.g.b() == 1) && atomicReferenceArray.compareAndSet(i3, hVar, null)) {
                    e.decrementAndGet(mVar);
                    a(this, hVar, false, 2, null);
                    return -1L;
                }
            }
        }
        return a(mVar, true);
    }

    public final void a(d dVar) {
        h hVar = (h) b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (b(dVar));
    }

    private final long a(m mVar, boolean z) {
        h hVar;
        do {
            hVar = (h) mVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z) {
                if (!(hVar.g.b() == 1)) {
                    return -2L;
                }
            }
            long a2 = k.f.a() - hVar.f;
            if (a2 < k.f7034a) {
                return k.f7034a - a2;
            }
        } while (!b.compareAndSet(mVar, hVar, null));
        a(this, hVar, false, 2, null);
        return -1L;
    }

    private final boolean b(d dVar) {
        h d2 = d();
        if (d2 == null) {
            return false;
        }
        dVar.a(d2);
        return true;
    }

    private final h d() {
        h andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & Notifications.NOTIFICATION_TYPES_ALL;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.f7035a.getAndSet(i2, null)) != null) {
                b(andSet);
                return andSet;
            }
        }
    }

    private final h a(h hVar) {
        if (hVar.g.b() == 1) {
            e.incrementAndGet(this);
        }
        if (a() == 127) {
            return hVar;
        }
        int i = this.producerIndex & Notifications.NOTIFICATION_TYPES_ALL;
        while (this.f7035a.get(i) != null) {
            Thread.yield();
        }
        this.f7035a.lazySet(i, hVar);
        c.incrementAndGet(this);
        return null;
    }

    private final void b(h hVar) {
        if (hVar != null) {
            if (hVar.g.b() == 1) {
                int decrementAndGet = e.decrementAndGet(this);
                if (n.a()) {
                    if (!(decrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }
}
