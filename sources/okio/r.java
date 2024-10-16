package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class r {
    public static final r c = new r() { // from class: okio.r.1
        @Override // okio.r
        public r a(long j) {
            return this;
        }

        @Override // okio.r
        public r a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // okio.r
        public void g() throws IOException {
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private boolean f7192a;
    private long b;
    private long d;

    public r a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.d = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long i_() {
        return this.d;
    }

    public boolean g_() {
        return this.f7192a;
    }

    public long d() {
        if (!this.f7192a) {
            throw new IllegalStateException("No deadline");
        }
        return this.b;
    }

    public r a(long j) {
        this.f7192a = true;
        this.b = j;
        return this;
    }

    public r h_() {
        this.d = 0L;
        return this;
    }

    public r f() {
        this.f7192a = false;
        return this;
    }

    public void g() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f7192a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
