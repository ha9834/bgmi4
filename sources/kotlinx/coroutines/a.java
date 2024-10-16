package kotlinx.coroutines;

/* loaded from: classes3.dex */
public final class a extends u {
    private final Thread b;

    @Override // kotlinx.coroutines.v
    protected Thread a() {
        return this.b;
    }

    public a(Thread thread) {
        this.b = thread;
    }
}
