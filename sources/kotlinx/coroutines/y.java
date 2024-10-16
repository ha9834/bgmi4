package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.e;

/* loaded from: classes3.dex */
public abstract class y extends i implements Closeable {
    public static final a d = new a(null);

    /* loaded from: classes3.dex */
    public static final class a extends kotlin.coroutines.b<i, y> {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
            super(i.c, new kotlin.jvm.a.b<e.b, y>() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher$Key$1
                @Override // kotlin.jvm.a.b
                public final y a(e.b bVar) {
                    if (!(bVar instanceof y)) {
                        bVar = null;
                    }
                    return (y) bVar;
                }
            });
        }
    }
}
