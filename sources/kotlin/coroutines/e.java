package kotlin.coroutines;

import kotlin.coroutines.e;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public interface e {

    /* loaded from: classes3.dex */
    public interface c<E extends b> {
    }

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(c<E> cVar);

    e minusKey(c<?> cVar);

    e plus(e eVar);

    /* loaded from: classes3.dex */
    public static final class a {
        public static e a(e eVar, e eVar2) {
            h.b(eVar2, "context");
            return eVar2 == EmptyCoroutineContext.f6950a ? eVar : (e) eVar2.fold(eVar, new m<e, b, e>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                @Override // kotlin.jvm.a.m
                public final e a(e eVar3, e.b bVar) {
                    CombinedContext combinedContext;
                    h.b(eVar3, "acc");
                    h.b(bVar, "element");
                    e minusKey = eVar3.minusKey(bVar.getKey());
                    if (minusKey == EmptyCoroutineContext.f6950a) {
                        return bVar;
                    }
                    d dVar = (d) minusKey.get(d.f6952a);
                    if (dVar == null) {
                        combinedContext = new CombinedContext(minusKey, bVar);
                    } else {
                        e minusKey2 = minusKey.minusKey(d.f6952a);
                        combinedContext = minusKey2 == EmptyCoroutineContext.f6950a ? new CombinedContext(bVar, dVar) : new CombinedContext(new CombinedContext(minusKey2, bVar), dVar);
                    }
                    return combinedContext;
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public interface b extends e {
        @Override // kotlin.coroutines.e
        <E extends b> E get(c<E> cVar);

        c<?> getKey();

        /* loaded from: classes3.dex */
        public static final class a {
            public static e a(b bVar, e eVar) {
                h.b(eVar, "context");
                return a.a(bVar, eVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E a(b bVar, c<E> cVar) {
                h.b(cVar, "key");
                if (!h.a(bVar.getKey(), cVar)) {
                    return null;
                }
                if (bVar != 0) {
                    return bVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type E");
            }

            public static <R> R a(b bVar, R r, m<? super R, ? super b, ? extends R> mVar) {
                h.b(mVar, "operation");
                return mVar.a(r, bVar);
            }

            public static e b(b bVar, c<?> cVar) {
                h.b(cVar, "key");
                boolean a2 = h.a(bVar.getKey(), cVar);
                Object obj = bVar;
                if (a2) {
                    obj = EmptyCoroutineContext.f6950a;
                }
                return (e) obj;
            }
        }
    }
}
