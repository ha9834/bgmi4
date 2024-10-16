package kotlinx.coroutines.internal;

/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f7005a = new Object[16];
    private int b;
    private int c;

    public final boolean a() {
        return this.b == this.c;
    }

    public final void a(T t) {
        Object[] objArr = this.f7005a;
        int i = this.c;
        objArr[i] = t;
        this.c = (objArr.length - 1) & (i + 1);
        if (this.c == this.b) {
            c();
        }
    }

    public final T b() {
        int i = this.b;
        if (i == this.c) {
            return null;
        }
        Object[] objArr = this.f7005a;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.b = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    private final void c() {
        Object[] objArr = this.f7005a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        kotlin.collections.d.a(objArr, objArr2, 0, this.b, 0, 10, null);
        Object[] objArr3 = this.f7005a;
        int length2 = objArr3.length;
        int i = this.b;
        kotlin.collections.d.a(objArr3, objArr2, length2 - i, 0, i, 4, null);
        this.f7005a = objArr2;
        this.b = 0;
        this.c = length;
    }
}
