package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.o;

/* loaded from: classes3.dex */
public final class j extends h {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f7033a;

    public j(Runnable runnable, long j, i iVar) {
        super(j, iVar);
        this.f7033a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7033a.run();
        } finally {
            this.g.a();
        }
    }

    public String toString() {
        return "Task[" + o.b(this.f7033a) + '@' + o.a(this.f7033a) + ", " + this.f + ", " + this.g + ']';
    }
}
