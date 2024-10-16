package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.y;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f7148a = !n.class.desiredAssertionStatus();

    @Nullable
    private Runnable d;

    @Nullable
    private ExecutorService e;
    private int b = 64;
    private int c = 5;
    private final Deque<y.a> f = new ArrayDeque();
    private final Deque<y.a> g = new ArrayDeque();
    private final Deque<y> h = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.e == null) {
            this.e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp Dispatcher", false));
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(y.a aVar) {
        synchronized (this) {
            this.f.add(aVar);
        }
        c();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean c() {
        int i;
        boolean z;
        if (!f7148a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<y.a> it = this.f.iterator();
            while (it.hasNext()) {
                y.a next = it.next();
                if (this.g.size() >= this.b) {
                    break;
                }
                if (c(next) < this.c) {
                    it.remove();
                    arrayList.add(next);
                    this.g.add(next);
                }
            }
            z = b() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((y.a) arrayList.get(i)).a(a());
        }
        return z;
    }

    private int c(y.a aVar) {
        int i = 0;
        for (y.a aVar2 : this.g) {
            if (!aVar2.b().e && aVar2.a().equals(aVar.a())) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(y yVar) {
        this.h.add(yVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(y.a aVar) {
        a(this.g, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(y yVar) {
        a(this.h, yVar);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.d;
        }
        if (c() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized int b() {
        return this.g.size() + this.h.size();
    }
}
