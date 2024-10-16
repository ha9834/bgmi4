package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public abstract class BaseContinuationImpl implements Serializable, kotlin.coroutines.c<Object>, a {
    private final kotlin.coroutines.c<Object> completion;

    protected abstract Object b(Object obj);

    protected void b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.c
    public final void a(Object obj) {
        Object b;
        kotlin.coroutines.c cVar = this;
        while (true) {
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) cVar;
            d.a(baseContinuationImpl);
            kotlin.coroutines.c cVar2 = baseContinuationImpl.completion;
            h.a(cVar2);
            try {
                b = baseContinuationImpl.b(obj);
            } catch (Throwable th) {
                Result.a aVar = Result.f6935a;
                obj = Result.e(kotlin.h.a(th));
            }
            if (b == kotlin.coroutines.intrinsics.a.a()) {
                return;
            }
            Result.a aVar2 = Result.f6935a;
            obj = Result.e(b);
            baseContinuationImpl.b();
            if (cVar2 instanceof BaseContinuationImpl) {
                cVar = cVar2;
            } else {
                cVar2.a(obj);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Serializable d = d();
        if (d == null) {
            d = getClass().getName();
        }
        sb.append(d);
        return sb.toString();
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public a c() {
        kotlin.coroutines.c<Object> cVar = this.completion;
        if (!(cVar instanceof a)) {
            cVar = null;
        }
        return (a) cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public StackTraceElement d() {
        return c.a(this);
    }
}
