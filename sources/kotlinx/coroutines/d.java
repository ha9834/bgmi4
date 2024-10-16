package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes3.dex */
public class d {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(d.class, "_handled");
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f6996a;

    public d(Throwable th, boolean z) {
        this.f6996a = th;
        this._handled = z ? 1 : 0;
    }

    public /* synthetic */ d(Throwable th, boolean z, int i, kotlin.jvm.internal.f fVar) {
        this(th, (i & 2) != 0 ? false : z);
    }

    public String toString() {
        return o.b(this) + '[' + this.f6996a + ']';
    }
}
