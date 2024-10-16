package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.y;

/* loaded from: classes3.dex */
final class e extends y implements Executor, i {
    private static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");
    private final c f;
    private final int g;
    private final String h;
    private final int i;
    private final ConcurrentLinkedQueue<Runnable> b = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    @Override // kotlinx.coroutines.scheduling.i
    public int b() {
        return this.i;
    }

    public e(c cVar, int i, String str, int i2) {
        this.f = cVar;
        this.g = i;
        this.h = str;
        this.i = i2;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        a(runnable, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.i
    public void a(kotlin.coroutines.e eVar, Runnable runnable) {
        a(runnable, false);
    }

    private final void a(Runnable runnable, boolean z) {
        while (e.incrementAndGet(this) > this.g) {
            this.b.add(runnable);
            if (e.decrementAndGet(this) >= this.g || (runnable = this.b.poll()) == null) {
                return;
            }
        }
        this.f.a(runnable, this, z);
    }

    @Override // kotlinx.coroutines.i
    public String toString() {
        String str = this.h;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f + ']';
    }

    @Override // kotlinx.coroutines.scheduling.i
    public void a() {
        Runnable poll = this.b.poll();
        if (poll != null) {
            this.f.a(poll, this, true);
            return;
        }
        e.decrementAndGet(this);
        Runnable poll2 = this.b.poll();
        if (poll2 != null) {
            a(poll2, true);
        }
    }
}
