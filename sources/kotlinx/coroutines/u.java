package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public abstract class u extends v {
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_queue");
    private static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean k() {
        return this._isCompleted;
    }

    private final void c(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.t
    public boolean c() {
        kotlinx.coroutines.internal.m mVar;
        if (!g()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.b()) {
            return false;
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof kotlinx.coroutines.internal.h) {
            return ((kotlinx.coroutines.internal.h) obj).a();
        }
        mVar = x.b;
        return obj == mVar;
    }

    @Override // kotlinx.coroutines.t
    protected long d() {
        a c;
        kotlinx.coroutines.internal.m mVar;
        if (super.d() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.h)) {
                mVar = x.b;
                return obj == mVar ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.h) obj).a()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar == null || (c = bVar.c()) == null) {
            return Long.MAX_VALUE;
        }
        long j = c.f7036a;
        af a2 = ag.a();
        return kotlin.d.d.a(j - (a2 != null ? a2.a() : System.nanoTime()), 0L);
    }

    @Override // kotlinx.coroutines.t
    protected void h() {
        ae.f6990a.b();
        c(true);
        m();
        do {
        } while (b() <= 0);
        n();
    }

    @Override // kotlinx.coroutines.t
    public long b() {
        a aVar;
        if (e()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.b()) {
            af a2 = ag.a();
            long a3 = a2 != null ? a2.a() : System.nanoTime();
            do {
                b bVar2 = bVar;
                synchronized (bVar2) {
                    a e = bVar2.e();
                    if (e != null) {
                        a aVar2 = e;
                        aVar = aVar2.a(a3) ? b(aVar2) : false ? bVar2.a(0) : null;
                    }
                }
            } while (aVar != null);
        }
        Runnable l = l();
        if (l != null) {
            l.run();
            return 0L;
        }
        return d();
    }

    @Override // kotlinx.coroutines.i
    public final void a(kotlin.coroutines.e eVar, Runnable runnable) {
        a(runnable);
    }

    public final void a(Runnable runnable) {
        if (b(runnable)) {
            j();
        } else {
            p.b.a(runnable);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void m() {
        kotlinx.coroutines.internal.m mVar;
        kotlinx.coroutines.internal.m mVar2;
        if (n.a() && !k()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
                mVar = x.b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, mVar)) {
                    return;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.h)) {
                mVar2 = x.b;
                if (obj == mVar2) {
                    return;
                }
                kotlinx.coroutines.internal.h hVar = new kotlinx.coroutines.internal.h(8, true);
                if (obj != null) {
                    hVar.a((kotlinx.coroutines.internal.h) obj);
                    if (b.compareAndSet(this, obj, hVar)) {
                        return;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else {
                ((kotlinx.coroutines.internal.h) obj).c();
                return;
            }
        }
    }

    public final void a(long j, a aVar) {
        switch (c(j, aVar)) {
            case 0:
                if (a(aVar)) {
                    j();
                    return;
                }
                return;
            case 1:
                b(j, aVar);
                return;
            case 2:
                return;
            default:
                throw new IllegalStateException("unexpected result".toString());
        }
    }

    private final boolean a(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar != null ? bVar.c() : null) == aVar;
    }

    private final int c(long j, a aVar) {
        if (k()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            u uVar = this;
            d.compareAndSet(uVar, null, new b(j));
            Object obj = uVar._delayed;
            kotlin.jvm.internal.h.a(obj);
            bVar = (b) obj;
        }
        return aVar.a(j, bVar, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        this._queue = null;
        this._delayed = null;
    }

    private final void n() {
        a d2;
        af a2 = ag.a();
        long a3 = a2 != null ? a2.a() : System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            if (bVar == null || (d2 = bVar.d()) == null) {
                return;
            } else {
                b(a3, d2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class a implements Comparable<a>, Runnable, kotlinx.coroutines.internal.s {

        /* renamed from: a, reason: collision with root package name */
        public long f7036a;
        private Object b;
        private int c;

        @Override // kotlinx.coroutines.internal.s
        public kotlinx.coroutines.internal.r<?> a() {
            Object obj = this.b;
            if (!(obj instanceof kotlinx.coroutines.internal.r)) {
                obj = null;
            }
            return (kotlinx.coroutines.internal.r) obj;
        }

        @Override // kotlinx.coroutines.internal.s
        public void a(kotlinx.coroutines.internal.r<?> rVar) {
            kotlinx.coroutines.internal.m mVar;
            Object obj = this.b;
            mVar = x.f7038a;
            if (!(obj != mVar)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.b = rVar;
        }

        @Override // kotlinx.coroutines.internal.s
        public void a(int i) {
            this.c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            long j = this.f7036a - aVar.f7036a;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final boolean a(long j) {
            return j - this.f7036a >= 0;
        }

        public final synchronized int a(long j, b bVar, u uVar) {
            kotlinx.coroutines.internal.m mVar;
            Object obj = this.b;
            mVar = x.f7038a;
            if (obj == mVar) {
                return 2;
            }
            b bVar2 = bVar;
            a aVar = this;
            synchronized (bVar2) {
                a e = bVar2.e();
                if (uVar.k()) {
                    return 1;
                }
                if (e == null) {
                    bVar.f7037a = j;
                } else {
                    long j2 = e.f7036a;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - bVar.f7037a > 0) {
                        bVar.f7037a = j;
                    }
                }
                if (this.f7036a - bVar.f7037a < 0) {
                    this.f7036a = bVar.f7037a;
                }
                bVar2.a((b) aVar);
                return 0;
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.f7036a + ']';
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends kotlinx.coroutines.internal.r<a> {

        /* renamed from: a, reason: collision with root package name */
        public long f7037a;

        public b(long j) {
            this.f7037a = j;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean b(Runnable runnable) {
        kotlinx.coroutines.internal.m mVar;
        while (true) {
            Object obj = this._queue;
            if (k()) {
                return false;
            }
            if (obj == null) {
                if (b.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.h)) {
                mVar = x.b;
                if (obj == mVar) {
                    return false;
                }
                kotlinx.coroutines.internal.h hVar = new kotlinx.coroutines.internal.h(8, true);
                if (obj != null) {
                    hVar.a((kotlinx.coroutines.internal.h) obj);
                    hVar.a((kotlinx.coroutines.internal.h) runnable);
                    if (b.compareAndSet(this, obj, hVar)) {
                        return true;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else if (obj != null) {
                kotlinx.coroutines.internal.h hVar2 = (kotlinx.coroutines.internal.h) obj;
                switch (hVar2.a((kotlinx.coroutines.internal.h) runnable)) {
                    case 0:
                        return true;
                    case 1:
                        b.compareAndSet(this, obj, hVar2.e());
                        break;
                    case 2:
                        return false;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Runnable l() {
        kotlinx.coroutines.internal.m mVar;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.h)) {
                mVar = x.b;
                if (obj == mVar) {
                    return null;
                }
                if (b.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else if (obj != null) {
                kotlinx.coroutines.internal.h hVar = (kotlinx.coroutines.internal.h) obj;
                Object d2 = hVar.d();
                if (d2 != kotlinx.coroutines.internal.h.f7011a) {
                    return (Runnable) d2;
                }
                b.compareAndSet(this, obj, hVar.e());
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
            }
        }
    }
}
