package kotlinx.coroutines;

/* loaded from: classes3.dex */
public abstract class t extends i {
    private long b;
    private boolean d;
    private kotlinx.coroutines.internal.a<q<?>> e;

    private final long c(boolean z) {
        return z ? 4294967296L : 1L;
    }

    protected void h() {
    }

    public long b() {
        return !e() ? Long.MAX_VALUE : 0L;
    }

    protected boolean c() {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long d() {
        kotlinx.coroutines.internal.a<q<?>> aVar = this.e;
        return (aVar == null || aVar.a()) ? Long.MAX_VALUE : 0L;
    }

    public final boolean e() {
        q<?> b;
        kotlinx.coroutines.internal.a<q<?>> aVar = this.e;
        if (aVar == null || (b = aVar.b()) == null) {
            return false;
        }
        b.run();
        return true;
    }

    public final void a(q<?> qVar) {
        kotlinx.coroutines.internal.a<q<?>> aVar = this.e;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.e = aVar;
        }
        aVar.a(qVar);
    }

    public final boolean f() {
        return this.b >= c(true);
    }

    public final boolean g() {
        kotlinx.coroutines.internal.a<q<?>> aVar = this.e;
        if (aVar != null) {
            return aVar.a();
        }
        return true;
    }

    public static /* synthetic */ void a(t tVar, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        tVar.a(z);
    }

    public final void a(boolean z) {
        this.b += c(z);
        if (z) {
            return;
        }
        this.d = true;
    }

    public final void b(boolean z) {
        this.b -= c(z);
        if (this.b > 0) {
            return;
        }
        if (n.a()) {
            if (!(this.b == 0)) {
                throw new AssertionError();
            }
        }
        if (this.d) {
            h();
        }
    }
}
