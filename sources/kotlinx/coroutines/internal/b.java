package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ae;

/* loaded from: classes3.dex */
public final class b<T> extends kotlinx.coroutines.q<T> implements kotlin.coroutines.c<T>, kotlin.coroutines.jvm.internal.a {
    private static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    public Object b;
    public final Object c;
    public final kotlinx.coroutines.i d;
    public final kotlin.coroutines.c<T> e;
    private final kotlin.coroutines.jvm.internal.a h;

    @Override // kotlin.coroutines.c
    public kotlin.coroutines.e a() {
        return this.e.a();
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public StackTraceElement d() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public kotlin.coroutines.jvm.internal.a c() {
        return this.h;
    }

    @Override // kotlinx.coroutines.q
    public Object e() {
        m mVar;
        m mVar2;
        Object obj = this.b;
        if (kotlinx.coroutines.n.a()) {
            mVar2 = c.b;
            if (!(obj != mVar2)) {
                throw new AssertionError();
            }
        }
        mVar = c.b;
        this.b = mVar;
        return obj;
    }

    @Override // kotlinx.coroutines.q
    public kotlin.coroutines.c<T> b() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.c
    public void a(Object obj) {
        kotlin.coroutines.e a2;
        Object a3;
        kotlin.coroutines.e a4 = this.e.a();
        Object a5 = kotlinx.coroutines.f.a(obj, null, 1, null);
        if (this.d.a(a4)) {
            this.b = a5;
            this.f7025a = 0;
            this.d.a(a4, this);
            return;
        }
        kotlinx.coroutines.n.a();
        kotlinx.coroutines.t a6 = ae.f6990a.a();
        if (a6.f()) {
            this.b = a5;
            this.f7025a = 0;
            a6.a(this);
            return;
        }
        b<T> bVar = this;
        a6.a(true);
        try {
            try {
                a2 = a();
                a3 = q.a(a2, this.c);
            } catch (Throwable th) {
                bVar.a(th, (Throwable) null);
            }
            try {
                this.e.a(obj);
                kotlin.k kVar = kotlin.k.f6974a;
                do {
                } while (a6.e());
            } finally {
                q.b(a2, a3);
            }
        } finally {
            a6.b(true);
        }
    }

    @Override // kotlinx.coroutines.q
    public void a(Object obj, Throwable th) {
        if (obj instanceof kotlinx.coroutines.e) {
            ((kotlinx.coroutines.e) obj).b.a(th);
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.d + ", " + kotlinx.coroutines.o.a((kotlin.coroutines.c<?>) this.e) + ']';
    }
}
