package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.e;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class EmptyCoroutineContext implements Serializable, e {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyCoroutineContext f6950a = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    @Override // kotlin.coroutines.e
    public <R> R fold(R r, m<? super R, ? super e.b, ? extends R> mVar) {
        h.b(mVar, "operation");
        return r;
    }

    @Override // kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        h.b(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.e
    public e plus(e eVar) {
        h.b(eVar, "context");
        return eVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return f6950a;
    }

    @Override // kotlin.coroutines.e
    public e minusKey(e.c<?> cVar) {
        h.b(cVar, "key");
        return this;
    }
}
