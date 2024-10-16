package kotlin.coroutines;

import kotlin.coroutines.e;
import kotlin.coroutines.e.b;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public abstract class b<B extends e.b, E extends B> implements e.c<E> {

    /* renamed from: a, reason: collision with root package name */
    private final e.c<?> f6951a;
    private final kotlin.jvm.a.b<e.b, E> b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.e$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.a.b<? super kotlin.coroutines.e$b, ? extends E extends B>, kotlin.jvm.a.b<kotlin.coroutines.e$b, E extends B>, java.lang.Object] */
    public b(e.c<B> cVar, kotlin.jvm.a.b<? super e.b, ? extends E> bVar) {
        h.b(cVar, "baseKey");
        h.b(bVar, "safeCast");
        this.b = bVar;
        this.f6951a = cVar instanceof b ? (e.c<B>) ((b) cVar).f6951a : cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/e$b;)TE; */
    public final e.b a(e.b bVar) {
        h.b(bVar, "element");
        return (e.b) this.b.a(bVar);
    }

    public final boolean a(e.c<?> cVar) {
        h.b(cVar, "key");
        return cVar == this || this.f6951a == cVar;
    }
}
