package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.e;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes3.dex */
public interface z extends e.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f7039a = b.f7040a;

    void a(CancellationException cancellationException);

    boolean a();

    CancellationException b();

    /* loaded from: classes3.dex */
    public static final class b implements e.c<z> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f7040a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.f6987a;
        }

        private b() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ void a(z zVar, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = (CancellationException) null;
            }
            zVar.a(cancellationException);
        }
    }
}
