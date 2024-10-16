package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;

/* loaded from: classes3.dex */
public abstract class q<T> extends kotlinx.coroutines.scheduling.h {

    /* renamed from: a, reason: collision with root package name */
    public int f7025a;

    public void a(Object obj, Throwable th) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T b(Object obj) {
        return obj;
    }

    public abstract kotlin.coroutines.c<T> b();

    public abstract Object e();

    public Throwable c(Object obj) {
        if (!(obj instanceof d)) {
            obj = null;
        }
        d dVar = (d) obj;
        if (dVar != null) {
            return dVar.f6996a;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object e;
        Object e2;
        Object e3;
        CancellationException cancellationException;
        if (n.a()) {
            if (!(this.f7025a != -1)) {
                throw new AssertionError();
            }
        }
        kotlinx.coroutines.scheduling.i iVar = this.g;
        z zVar = null;
        Throwable th = (Throwable) null;
        try {
            kotlin.coroutines.c<T> b = b();
            if (b == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            }
            kotlinx.coroutines.internal.b bVar = (kotlinx.coroutines.internal.b) b;
            kotlin.coroutines.c<T> cVar = bVar.e;
            kotlin.coroutines.e a2 = cVar.a();
            Object e4 = e();
            Object a3 = kotlinx.coroutines.internal.q.a(a2, bVar.c);
            try {
                Throwable c = c(e4);
                if (c == null && r.a(this.f7025a)) {
                    zVar = (z) a2.get(z.f7039a);
                }
                if (zVar != null && !zVar.a()) {
                    CancellationException b2 = zVar.b();
                    a(e4, b2);
                    Result.a aVar = Result.f6935a;
                    if (n.b() && (cVar instanceof kotlin.coroutines.jvm.internal.a)) {
                        cancellationException = kotlinx.coroutines.internal.l.a(b2, (kotlin.coroutines.jvm.internal.a) cVar);
                        cVar.a(Result.e(kotlin.h.a(cancellationException)));
                    }
                    cancellationException = b2;
                    cVar.a(Result.e(kotlin.h.a(cancellationException)));
                } else if (c != null) {
                    Result.a aVar2 = Result.f6935a;
                    cVar.a(Result.e(kotlin.h.a(c)));
                } else {
                    T b3 = b(e4);
                    Result.a aVar3 = Result.f6935a;
                    cVar.a(Result.e(b3));
                }
                kotlin.k kVar = kotlin.k.f6974a;
                try {
                    Result.a aVar4 = Result.f6935a;
                    q<T> qVar = this;
                    iVar.a();
                    e3 = Result.e(kotlin.k.f6974a);
                } catch (Throwable th2) {
                    Result.a aVar5 = Result.f6935a;
                    e3 = Result.e(kotlin.h.a(th2));
                }
                a(th, Result.c(e3));
            } finally {
                kotlinx.coroutines.internal.q.b(a2, a3);
            }
        } catch (Throwable th3) {
            try {
                Result.a aVar6 = Result.f6935a;
                q<T> qVar2 = this;
                iVar.a();
                e = Result.e(kotlin.k.f6974a);
            } catch (Throwable th4) {
                Result.a aVar7 = Result.f6935a;
                e = Result.e(kotlin.h.a(th4));
            }
            a(th, Result.c(e));
            throw th3;
        }
    }

    public final void a(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.a.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.h.a((Object) th);
        k.a(b().a(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }
}
