package kotlinx.coroutines;

import kotlin.coroutines.e;

/* loaded from: classes3.dex */
public interface ad<S> extends e.b {

    /* loaded from: classes3.dex */
    public static final class a {
        public static <S, R> R a(ad<S> adVar, R r, kotlin.jvm.a.m<? super R, ? super e.b, ? extends R> mVar) {
            return (R) e.b.a.a(adVar, r, mVar);
        }

        public static <S, E extends e.b> E a(ad<S> adVar, e.c<E> cVar) {
            return (E) e.b.a.a(adVar, cVar);
        }

        public static <S> kotlin.coroutines.e a(ad<S> adVar, kotlin.coroutines.e eVar) {
            return e.b.a.a(adVar, eVar);
        }

        public static <S> kotlin.coroutines.e b(ad<S> adVar, e.c<?> cVar) {
            return e.b.a.b(adVar, cVar);
        }
    }

    void a(kotlin.coroutines.e eVar, S s);

    S b(kotlin.coroutines.e eVar);
}
