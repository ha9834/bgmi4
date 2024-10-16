package kotlinx.coroutines;

import kotlin.coroutines.e;

/* loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends e.b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6987a = a.f6988a;

    void handleException(kotlin.coroutines.e eVar, Throwable th);

    /* loaded from: classes3.dex */
    public static final class a implements e.c<CoroutineExceptionHandler> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f6988a = new a();

        private a() {
        }
    }
}
