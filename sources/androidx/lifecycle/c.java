package androidx.lifecycle;

import java.util.Queue;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f785a;
    private boolean b;
    private boolean c;
    private final Queue<Runnable> d;

    public final void a() {
        this.f785a = true;
    }

    public final void b() {
        if (this.f785a) {
            if (!(!this.b)) {
                throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
            }
            this.f785a = false;
            d();
        }
    }

    public final void c() {
        this.b = true;
        d();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d() {
        if (this.c) {
            return;
        }
        try {
            this.c = true;
            while ((!this.d.isEmpty()) && e()) {
                Runnable poll = this.d.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.c = false;
        }
    }

    public final boolean e() {
        return this.b || !this.f785a;
    }
}
