package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.p;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final long f7034a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static l f;

    static {
        long a2;
        int a3;
        int a4;
        int a5;
        long a6;
        a2 = n.a("kotlinx.coroutines.scheduler.resolution.ns", 100000L, (r14 & 4) != 0 ? 1L : 0L, (r14 & 8) != 0 ? Long.MAX_VALUE : 0L);
        f7034a = a2;
        a3 = p.a("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
        b = a3;
        a4 = p.a("kotlinx.coroutines.scheduler.core.pool.size", kotlin.d.d.c(n.a(), 2), 1, 0, 8, (Object) null);
        c = a4;
        a5 = p.a("kotlinx.coroutines.scheduler.max.pool.size", kotlin.d.d.a(n.a() * 128, c, 2097150), 0, 2097150, 4, (Object) null);
        d = a5;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a6 = n.a("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, (r14 & 4) != 0 ? 1L : 0L, (r14 & 8) != 0 ? Long.MAX_VALUE : 0L);
        e = timeUnit.toNanos(a6);
        f = f.f7031a;
    }
}
