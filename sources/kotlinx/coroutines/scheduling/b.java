package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.p;

/* loaded from: classes3.dex */
public final class b extends c {
    public static final b b;
    private static final kotlinx.coroutines.i e;

    @Override // kotlinx.coroutines.scheduling.c, kotlinx.coroutines.i
    public String toString() {
        return "Dispatchers.Default";
    }

    static {
        int a2;
        b bVar = new b();
        b = bVar;
        a2 = p.a("kotlinx.coroutines.io.parallelism", kotlin.d.d.c(64, n.a()), 0, 0, 12, (Object) null);
        e = new e(bVar, a2, "Dispatchers.IO", 1);
    }

    private b() {
        super(0, 0, null, 7, null);
    }

    public final kotlinx.coroutines.i a() {
        return e;
    }

    @Override // kotlinx.coroutines.scheduling.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }
}
