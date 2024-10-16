package kotlinx.coroutines;

/* loaded from: classes3.dex */
public final class k {
    public static final void a(kotlin.coroutines.e eVar, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) eVar.get(CoroutineExceptionHandler.f6987a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(eVar, th);
            } else {
                j.a(eVar, th);
            }
        } catch (Throwable th2) {
            j.a(eVar, a(th, th2));
        }
    }

    public static final Throwable a(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.a.a(runtimeException, th);
        return runtimeException;
    }
}
