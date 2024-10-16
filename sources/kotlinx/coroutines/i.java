package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlin.coroutines.e;

/* loaded from: classes3.dex */
public abstract class i extends kotlin.coroutines.a implements kotlin.coroutines.d {
    public static final a c = new a(null);

    public abstract void a(kotlin.coroutines.e eVar, Runnable runnable);

    public boolean a(kotlin.coroutines.e eVar) {
        return true;
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e.b, kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        return (E) d.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e
    public kotlin.coroutines.e minusKey(e.c<?> cVar) {
        return d.a.b(this, cVar);
    }

    public i() {
        super(kotlin.coroutines.d.f6952a);
    }

    /* loaded from: classes3.dex */
    public static final class a extends kotlin.coroutines.b<kotlin.coroutines.d, i> {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
            super(kotlin.coroutines.d.f6952a, new kotlin.jvm.a.b<e.b, i>() { // from class: kotlinx.coroutines.CoroutineDispatcher$Key$1
                @Override // kotlin.jvm.a.b
                public final i a(e.b bVar) {
                    if (!(bVar instanceof i)) {
                        bVar = null;
                    }
                    return (i) bVar;
                }
            });
        }
    }

    public String toString() {
        return o.b(this) + '@' + o.a(this);
    }
}
