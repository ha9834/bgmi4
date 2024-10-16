package kotlin;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f {
    public static final <T> c<T> a(kotlin.jvm.a.a<? extends T> aVar) {
        kotlin.jvm.internal.h.b(aVar, "initializer");
        kotlin.jvm.internal.f fVar = null;
        return new SynchronizedLazyImpl(aVar, fVar, 2, fVar);
    }

    public static final <T> c<T> a(LazyThreadSafetyMode lazyThreadSafetyMode, kotlin.jvm.a.a<? extends T> aVar) {
        kotlin.jvm.internal.h.b(lazyThreadSafetyMode, "mode");
        kotlin.jvm.internal.h.b(aVar, "initializer");
        switch (e.f6959a[lazyThreadSafetyMode.ordinal()]) {
            case 1:
                kotlin.jvm.internal.f fVar = null;
                return new SynchronizedLazyImpl(aVar, fVar, 2, fVar);
            case 2:
                return new SafePublicationLazyImpl(aVar);
            case 3:
                return new UnsafeLazyImpl(aVar);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
