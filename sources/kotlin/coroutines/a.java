package kotlin.coroutines;

import kotlin.coroutines.e;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public abstract class a implements e.b {
    private final e.c<?> key;

    public a(e.c<?> cVar) {
        h.b(cVar, "key");
        this.key = cVar;
    }

    @Override // kotlin.coroutines.e
    public <R> R fold(R r, m<? super R, ? super e.b, ? extends R> mVar) {
        h.b(mVar, "operation");
        return (R) e.b.a.a(this, r, mVar);
    }

    @Override // kotlin.coroutines.e.b, kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        h.b(cVar, "key");
        return (E) e.b.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.e.b
    public e.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.e
    public e minusKey(e.c<?> cVar) {
        h.b(cVar, "key");
        return e.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.e
    public e plus(e eVar) {
        h.b(eVar, "context");
        return e.b.a.a(this, eVar);
    }
}
