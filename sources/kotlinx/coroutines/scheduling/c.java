package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.p;
import kotlinx.coroutines.y;

/* loaded from: classes3.dex */
public class c extends y {
    private CoroutineScheduler b;
    private final int e;
    private final int f;
    private final long g;
    private final String h;

    public c(int i, int i2, long j, String str) {
        this.e = i;
        this.f = i2;
        this.g = j;
        this.h = str;
        this.b = a();
    }

    public /* synthetic */ c(int i, int i2, String str, int i3, kotlin.jvm.internal.f fVar) {
        this((i3 & 1) != 0 ? k.c : i, (i3 & 2) != 0 ? k.d : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public c(int i, int i2, String str) {
        this(i, i2, k.e, str);
    }

    @Override // kotlinx.coroutines.i
    public void a(kotlin.coroutines.e eVar, Runnable runnable) {
        try {
            CoroutineScheduler.a(this.b, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            p.b.a(eVar, runnable);
        }
    }

    public void close() {
        this.b.close();
    }

    @Override // kotlinx.coroutines.i
    public String toString() {
        return super.toString() + "[scheduler = " + this.b + ']';
    }

    public final void a(Runnable runnable, i iVar, boolean z) {
        try {
            this.b.a(runnable, iVar, z);
        } catch (RejectedExecutionException unused) {
            p.b.a(this.b.a(runnable, iVar));
        }
    }

    private final CoroutineScheduler a() {
        return new CoroutineScheduler(this.e, this.f, this.g, this.h);
    }
}
