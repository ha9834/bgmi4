package kotlin.coroutines;

import kotlin.coroutines.e;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public interface d extends e.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6952a = b.f6953a;

    /* loaded from: classes3.dex */
    public static final class b implements e.c<d> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f6953a = new b();

        private b() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public static <E extends e.b> E a(d dVar, e.c<E> cVar) {
            h.b(cVar, "key");
            if (cVar instanceof kotlin.coroutines.b) {
                kotlin.coroutines.b bVar = (kotlin.coroutines.b) cVar;
                if (!bVar.a(dVar.getKey())) {
                    return null;
                }
                E e = (E) bVar.a(dVar);
                if (e instanceof e.b) {
                    return e;
                }
                return null;
            }
            if (d.f6952a != cVar) {
                return null;
            }
            if (dVar != null) {
                return dVar;
            }
            throw new NullPointerException("null cannot be cast to non-null type E");
        }

        public static e b(d dVar, e.c<?> cVar) {
            h.b(cVar, "key");
            if (cVar instanceof kotlin.coroutines.b) {
                kotlin.coroutines.b bVar = (kotlin.coroutines.b) cVar;
                boolean a2 = bVar.a(dVar.getKey());
                Object obj = dVar;
                if (a2) {
                    e.b a3 = bVar.a(dVar);
                    obj = dVar;
                    if (a3 != null) {
                        obj = EmptyCoroutineContext.f6950a;
                    }
                }
                return (e) obj;
            }
            Object obj2 = dVar;
            if (d.f6952a == cVar) {
                obj2 = EmptyCoroutineContext.f6950a;
            }
            return (e) obj2;
        }
    }
}
