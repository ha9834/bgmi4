package kotlinx.coroutines;

/* loaded from: classes3.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name */
    public static final ae f6990a = new ae();
    private static final ThreadLocal<t> b = new ThreadLocal<>();

    private ae() {
    }

    public final t a() {
        t tVar = b.get();
        if (tVar != null) {
            return tVar;
        }
        t a2 = w.a();
        b.set(a2);
        return a2;
    }

    public final void b() {
        b.set(null);
    }

    public final void a(t tVar) {
        b.set(tVar);
    }
}
