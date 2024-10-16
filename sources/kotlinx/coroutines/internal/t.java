package kotlinx.coroutines.internal;

/* loaded from: classes3.dex */
final class t {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f7020a;
    private int b;
    private final kotlin.coroutines.e c;

    public t(kotlin.coroutines.e eVar, int i) {
        this.c = eVar;
        this.f7020a = new Object[i];
    }

    public final kotlin.coroutines.e c() {
        return this.c;
    }

    public final void a(Object obj) {
        Object[] objArr = this.f7020a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
    }

    public final Object a() {
        Object[] objArr = this.f7020a;
        int i = this.b;
        this.b = i + 1;
        return objArr[i];
    }

    public final void b() {
        this.b = 0;
    }
}
