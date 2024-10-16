package kotlinx.coroutines.scheduling;

import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.random.Random;
import kotlinx.coroutines.af;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* loaded from: classes3.dex */
public final class CoroutineScheduler implements Closeable, Executor {
    private volatile int _isTerminated;

    /* renamed from: a, reason: collision with root package name */
    public final d f7027a;
    public final d b;
    public final AtomicReferenceArray<b> c;
    volatile long controlState;
    public final int e;
    public final int f;
    public final long g;
    public final String h;
    private volatile long parkedWorkersStack;
    public static final a j = new a(null);
    public static final kotlinx.coroutines.internal.m i = new kotlinx.coroutines.internal.m("NOT_IN_STACK");
    private static final AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    static final AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    private static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* loaded from: classes3.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        this.e = i2;
        this.f = i3;
        this.g = j2;
        this.h = str;
        if (!(this.e >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + this.e + " should be at least 1").toString());
        }
        if (!(this.f >= this.e)) {
            throw new IllegalArgumentException(("Max pool size " + this.f + " should be greater than or equals to core pool size " + this.e).toString());
        }
        if (!(this.f <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + this.f + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(this.g > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + this.g + " must be positive").toString());
        }
        this.f7027a = new d();
        this.b = new d();
        this.parkedWorkersStack = 0L;
        this.c = new AtomicReferenceArray<>(this.f + 1);
        this.controlState = this.e << 42;
        this._isTerminated = 0;
    }

    public final boolean a(b bVar) {
        long j2;
        long j3;
        int a2;
        if (bVar.b() != i) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (2097152 + j2) & (-2097152);
            a2 = bVar.a();
            if (n.a()) {
                if (!(a2 != 0)) {
                    throw new AssertionError();
                }
            }
            bVar.a(this.c.get(i2));
        } while (!k.compareAndSet(this, j2, a2 | j3));
        return true;
    }

    private final int b(b bVar) {
        Object b2 = bVar.b();
        while (b2 != i) {
            if (b2 == null) {
                return 0;
            }
            b bVar2 = (b) b2;
            int a2 = bVar2.a();
            if (a2 != 0) {
                return a2;
            }
            b2 = bVar2.b();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d() {
        return (int) (this.controlState & 2097151);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._isTerminated;
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        a(this, runnable, null, false, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(LogUtils.LOG_FUSE_TIME);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
    
        if (r9 != null) goto L36;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.l
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r0 = r8.g()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r3 = r8.c
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lbc
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L60
            r3 = 1
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r4 = r8.c
            java.lang.Object r4 = r4.get(r3)
            kotlin.jvm.internal.h.a(r4)
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.b) r4
            if (r4 == r0) goto L5b
        L2a:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L3a
            r6 = r4
            java.lang.Thread r6 = (java.lang.Thread) r6
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r4.join(r9)
            goto L2a
        L3a:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r4.b
            boolean r7 = kotlinx.coroutines.n.a()
            if (r7 == 0) goto L54
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L48
            r6 = 1
            goto L49
        L48:
            r6 = 0
        L49:
            if (r6 == 0) goto L4c
            goto L54
        L4c:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L54:
            kotlinx.coroutines.scheduling.m r4 = r4.f7029a
            kotlinx.coroutines.scheduling.d r6 = r8.b
            r4.a(r6)
        L5b:
            if (r3 == r5) goto L60
            int r3 = r3 + 1
            goto L1d
        L60:
            kotlinx.coroutines.scheduling.d r9 = r8.b
            r9.b()
            kotlinx.coroutines.scheduling.d r9 = r8.f7027a
            r9.b()
        L6a:
            if (r0 == 0) goto L73
            kotlinx.coroutines.scheduling.h r9 = r0.a(r2)
            if (r9 == 0) goto L73
            goto L7b
        L73:
            kotlinx.coroutines.scheduling.d r9 = r8.f7027a
            java.lang.Object r9 = r9.c()
            kotlinx.coroutines.scheduling.h r9 = (kotlinx.coroutines.scheduling.h) r9
        L7b:
            if (r9 == 0) goto L7e
            goto L86
        L7e:
            kotlinx.coroutines.scheduling.d r9 = r8.b
            java.lang.Object r9 = r9.c()
            kotlinx.coroutines.scheduling.h r9 = (kotlinx.coroutines.scheduling.h) r9
        L86:
            if (r9 == 0) goto L8c
            r8.a(r9)
            goto L6a
        L8c:
            if (r0 == 0) goto L93
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.a(r9)
        L93:
            boolean r9 = kotlinx.coroutines.n.a()
            if (r9 == 0) goto Lb5
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r9 = r8.e
            if (r10 != r9) goto Laa
            r1 = 1
        Laa:
            if (r1 == 0) goto Lad
            goto Lb5
        Lad:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        Lb5:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        Lbc:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.a(long):void");
    }

    public static /* synthetic */ void a(CoroutineScheduler coroutineScheduler, Runnable runnable, i iVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            iVar = g.f7032a;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.a(runnable, iVar, z);
    }

    public final void a(Runnable runnable, i iVar, boolean z) {
        af a2 = ag.a();
        if (a2 != null) {
            a2.b();
        }
        h a3 = a(runnable, iVar);
        b g = g();
        h a4 = a(g, a3, z);
        if (a4 != null && !b(a4)) {
            throw new RejectedExecutionException(this.h + " was terminated");
        }
        boolean z2 = z && g != null;
        if (a3.g.b() != 0) {
            a(z2);
        } else {
            if (z2) {
                return;
            }
            b();
        }
    }

    public final h a(Runnable runnable, i iVar) {
        long a2 = k.f.a();
        if (runnable instanceof h) {
            h hVar = (h) runnable;
            hVar.f = a2;
            hVar.g = iVar;
            return hVar;
        }
        return new j(runnable, a2, iVar);
    }

    public final void b() {
        if (e() || a(this, 0L, 1, null)) {
            return;
        }
        e();
    }

    static /* synthetic */ boolean a(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.b(j2);
    }

    private final boolean b(long j2) {
        if (kotlin.d.d.c(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.e) {
            int f = f();
            if (f == 1 && this.e > 1) {
                f();
            }
            if (f > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean e() {
        b c;
        do {
            c = c();
            if (c == null) {
                return false;
            }
        } while (!b.c.compareAndSet(c, -1, 0));
        LockSupport.unpark(c);
        return true;
    }

    private final int f() {
        synchronized (this.c) {
            if (a()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int c = kotlin.d.d.c(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (c >= this.e) {
                return 0;
            }
            if (i2 >= this.f) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i3 > 0 && this.c.get(i3) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            b bVar = new b(this, i3);
            this.c.set(i3, bVar);
            if (!(i3 == ((int) (2097151 & d.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            bVar.start();
            return c + 1;
        }
    }

    private final h a(b bVar, h hVar, boolean z) {
        if (bVar == null || bVar.b == WorkerState.TERMINATED) {
            return hVar;
        }
        if (hVar.g.b() == 0 && bVar.b == WorkerState.BLOCKING) {
            return hVar;
        }
        bVar.d = true;
        return bVar.f7029a.a(hVar, z);
    }

    private final b g() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof b)) {
            currentThread = null;
        }
        b bVar = (b) currentThread;
        if (bVar == null || !kotlin.jvm.internal.h.a(CoroutineScheduler.this, this)) {
            return null;
        }
        return bVar;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.c.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < length; i7++) {
            b bVar = this.c.get(i7);
            if (bVar != null) {
                int b2 = bVar.f7029a.b();
                switch (bVar.b) {
                    case PARKING:
                        i4++;
                        break;
                    case BLOCKING:
                        i3++;
                        arrayList.add(String.valueOf(b2) + "b");
                        break;
                    case CPU_ACQUIRED:
                        i2++;
                        arrayList.add(String.valueOf(b2) + IR.path.DOCS_IMSDK_CHANNEL);
                        break;
                    case DORMANT:
                        i5++;
                        if (b2 > 0) {
                            arrayList.add(String.valueOf(b2) + com.nostra13.universalimageloader.core.d.f5744a);
                            break;
                        } else {
                            break;
                        }
                    case TERMINATED:
                        i6++;
                        break;
                }
            }
        }
        long j2 = this.controlState;
        return this.h + '@' + o.a(this) + "[Pool Size {core = " + this.e + ", max = " + this.f + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f7027a.a() + ", global blocking queue size = " + this.b.a() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.e - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(h hVar) {
        af a2;
        try {
            try {
                hVar.run();
                a2 = ag.a();
                if (a2 == null) {
                    return;
                }
            } catch (Throwable th) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                a2 = ag.a();
                if (a2 == null) {
                    return;
                }
            }
            a2.c();
        } catch (Throwable th2) {
            af a3 = ag.a();
            if (a3 != null) {
                a3.c();
            }
            throw th2;
        }
    }

    /* loaded from: classes3.dex */
    public final class b extends Thread {
        static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");

        /* renamed from: a, reason: collision with root package name */
        public final m f7029a;
        public WorkerState b;
        public boolean d;
        private long f;
        private long g;
        private int h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile int workerCtl;

        private b() {
            setDaemon(true);
            this.f7029a = new m();
            this.b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.i;
            this.h = Random.f6975a.b();
        }

        public final int a() {
            return this.indexInArray;
        }

        public final void a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.h);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public b(CoroutineScheduler coroutineScheduler, int i) {
            this();
            a(i);
        }

        public final void a(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final Object b() {
            return this.nextParkedWorker;
        }

        private final boolean c() {
            boolean z;
            if (this.b == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            while (true) {
                long j = coroutineScheduler.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    z = false;
                    break;
                }
                if (CoroutineScheduler.d.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            this.b = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final boolean a(WorkerState workerState) {
            WorkerState workerState2 = this.b;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.d.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.b = workerState;
            }
            return z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d();
        }

        private final void d() {
            boolean z = false;
            while (!CoroutineScheduler.this.a() && this.b != WorkerState.TERMINATED) {
                h a2 = a(this.d);
                if (a2 != null) {
                    this.g = 0L;
                    a(a2);
                    z = false;
                } else {
                    this.d = false;
                    if (this.g == 0) {
                        e();
                    } else if (z) {
                        a(WorkerState.PARKING);
                        Thread.interrupted();
                        LockSupport.parkNanos(this.g);
                        this.g = 0L;
                        z = false;
                    } else {
                        z = true;
                    }
                }
            }
            a(WorkerState.TERMINATED);
        }

        private final void e() {
            if (!f()) {
                CoroutineScheduler.this.a(this);
                return;
            }
            if (n.a()) {
                if (!(this.f7029a.b() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (f() && !CoroutineScheduler.this.a() && this.b != WorkerState.TERMINATED) {
                a(WorkerState.PARKING);
                Thread.interrupted();
                g();
            }
        }

        private final boolean f() {
            return this.nextParkedWorker != CoroutineScheduler.i;
        }

        private final void c(int i) {
            if (i != 0 && a(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.b();
            }
        }

        private final void d(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.d.addAndGet(CoroutineScheduler.this, -2097152L);
            WorkerState workerState = this.b;
            if (workerState != WorkerState.TERMINATED) {
                if (n.a()) {
                    if (!(workerState == WorkerState.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.b = WorkerState.DORMANT;
            }
        }

        public final int b(int i) {
            int i2 = this.h;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.h = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        private final void g() {
            if (this.f == 0) {
                this.f = System.nanoTime() + CoroutineScheduler.this.g;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.g);
            if (System.nanoTime() - this.f >= 0) {
                this.f = 0L;
                h();
            }
        }

        private final void h() {
            synchronized (CoroutineScheduler.this.c) {
                if (CoroutineScheduler.this.a()) {
                    return;
                }
                if (CoroutineScheduler.this.d() <= CoroutineScheduler.this.e) {
                    return;
                }
                if (c.compareAndSet(this, -1, 1)) {
                    int i = this.indexInArray;
                    a(0);
                    CoroutineScheduler.this.a(this, i, 0);
                    int andDecrement = (int) (CoroutineScheduler.d.getAndDecrement(CoroutineScheduler.this) & 2097151);
                    if (andDecrement != i) {
                        b bVar = CoroutineScheduler.this.c.get(andDecrement);
                        kotlin.jvm.internal.h.a(bVar);
                        b bVar2 = bVar;
                        CoroutineScheduler.this.c.set(i, bVar2);
                        bVar2.a(i);
                        CoroutineScheduler.this.a(bVar2, andDecrement, i);
                    }
                    CoroutineScheduler.this.c.set(andDecrement, null);
                    kotlin.k kVar = kotlin.k.f6974a;
                    this.b = WorkerState.TERMINATED;
                }
            }
        }

        private final void e(int i) {
            this.f = 0L;
            if (this.b == WorkerState.PARKING) {
                if (n.a()) {
                    if (!(i == 1)) {
                        throw new AssertionError();
                    }
                }
                this.b = WorkerState.BLOCKING;
            }
        }

        public final h a(boolean z) {
            h c2;
            if (c()) {
                return b(z);
            }
            if (z) {
                c2 = this.f7029a.c();
                if (c2 == null) {
                    c2 = CoroutineScheduler.this.b.c();
                }
            } else {
                c2 = CoroutineScheduler.this.b.c();
            }
            return c2 != null ? c2 : c(true);
        }

        private final h b(boolean z) {
            h i;
            h i2;
            if (z) {
                boolean z2 = b(CoroutineScheduler.this.e * 2) == 0;
                if (z2 && (i2 = i()) != null) {
                    return i2;
                }
                h c2 = this.f7029a.c();
                if (c2 != null) {
                    return c2;
                }
                if (!z2 && (i = i()) != null) {
                    return i;
                }
            } else {
                h i3 = i();
                if (i3 != null) {
                    return i3;
                }
            }
            return c(false);
        }

        private final h i() {
            if (b(2) == 0) {
                h c2 = CoroutineScheduler.this.f7027a.c();
                return c2 != null ? c2 : CoroutineScheduler.this.b.c();
            }
            h c3 = CoroutineScheduler.this.b.c();
            return c3 != null ? c3 : CoroutineScheduler.this.f7027a.c();
        }

        private final h c(boolean z) {
            long a2;
            if (n.a()) {
                if (!(this.f7029a.b() == 0)) {
                    throw new AssertionError();
                }
            }
            int d = CoroutineScheduler.this.d();
            if (d < 2) {
                return null;
            }
            int b = b(d);
            long j = Long.MAX_VALUE;
            for (int i = 0; i < d; i++) {
                b++;
                if (b > d) {
                    b = 1;
                }
                b bVar = CoroutineScheduler.this.c.get(b);
                if (bVar != null && bVar != this) {
                    if (n.a()) {
                        if (!(this.f7029a.b() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        a2 = this.f7029a.b(bVar.f7029a);
                    } else {
                        a2 = this.f7029a.a(bVar.f7029a);
                    }
                    if (a2 == -1) {
                        return this.f7029a.c();
                    }
                    if (a2 > 0) {
                        j = Math.min(j, a2);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.g = j;
            return null;
        }

        private final void a(h hVar) {
            int b = hVar.g.b();
            e(b);
            c(b);
            CoroutineScheduler.this.a(hVar);
            d(b);
        }
    }

    private final boolean b(h hVar) {
        if (hVar.g.b() == 1) {
            return this.b.a(hVar);
        }
        return this.f7027a.a(hVar);
    }

    public final void a(b bVar, int i2, int i3) {
        int i4;
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i5 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i5 == i2) {
                i4 = i3 == 0 ? b(bVar) : i3;
            } else {
                i4 = i5;
            }
            if (i4 >= 0 && k.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    private final b c() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            b bVar = this.c.get((int) (2097151 & j2));
            if (bVar == null) {
                return null;
            }
            long j3 = (2097152 + j2) & (-2097152);
            int b2 = b(bVar);
            if (b2 >= 0 && k.compareAndSet(this, j2, b2 | j3)) {
                bVar.a(i);
                return bVar;
            }
        }
    }

    private final void a(boolean z) {
        long addAndGet = d.addAndGet(this, 2097152L);
        if (z || e() || b(addAndGet)) {
            return;
        }
        e();
    }
}
