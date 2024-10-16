package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.s;

/* loaded from: classes3.dex */
public class r<T extends s & Comparable<? super T>> {
    private volatile int _size = 0;

    /* renamed from: a, reason: collision with root package name */
    private T[] f7019a;

    public final int a() {
        return this._size;
    }

    private final void b(int i) {
        this._size = i;
    }

    public final boolean b() {
        return a() == 0;
    }

    public final T e() {
        T[] tArr = this.f7019a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final T a(int i) {
        if (kotlinx.coroutines.n.a()) {
            if (!(a() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f7019a;
        kotlin.jvm.internal.h.a(tArr);
        b(a() - 1);
        if (i < a()) {
            a(i, a());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                Object obj = tArr[i];
                kotlin.jvm.internal.h.a(obj);
                Object obj2 = tArr[i2];
                kotlin.jvm.internal.h.a(obj2);
                if (((Comparable) obj).compareTo(obj2) < 0) {
                    a(i, i2);
                    c(i2);
                }
            }
            d(i);
        }
        T t = (T) tArr[a()];
        kotlin.jvm.internal.h.a(t);
        if (kotlinx.coroutines.n.a()) {
            if (!(t.a() == this)) {
                throw new AssertionError();
            }
        }
        t.a((r) null);
        t.a(-1);
        tArr[a()] = (s) null;
        return t;
    }

    public final void a(T t) {
        if (kotlinx.coroutines.n.a()) {
            if (!(t.a() == null)) {
                throw new AssertionError();
            }
        }
        t.a(this);
        T[] f = f();
        int a2 = a();
        b(a2 + 1);
        f[a2] = t;
        t.a(a2);
        c(a2);
    }

    private final void c(int i) {
        while (i > 0) {
            T[] tArr = this.f7019a;
            kotlin.jvm.internal.h.a(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            kotlin.jvm.internal.h.a(t);
            T t2 = tArr[i];
            kotlin.jvm.internal.h.a(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            a(i, i2);
            i = i2;
        }
    }

    private final void d(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= a()) {
                return;
            }
            T[] tArr = this.f7019a;
            kotlin.jvm.internal.h.a(tArr);
            int i3 = i2 + 1;
            if (i3 < a()) {
                T t = tArr[i3];
                kotlin.jvm.internal.h.a(t);
                T t2 = tArr[i2];
                kotlin.jvm.internal.h.a(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            kotlin.jvm.internal.h.a(t3);
            T t4 = tArr[i2];
            kotlin.jvm.internal.h.a(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            a(i, i2);
            i = i2;
        }
    }

    private final T[] f() {
        T[] tArr = this.f7019a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new s[4];
            this.f7019a = tArr2;
            return tArr2;
        }
        if (a() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, a() * 2);
        kotlin.jvm.internal.h.a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((s[]) copyOf);
        this.f7019a = tArr3;
        return tArr3;
    }

    private final void a(int i, int i2) {
        T[] tArr = this.f7019a;
        kotlin.jvm.internal.h.a(tArr);
        T t = tArr[i2];
        kotlin.jvm.internal.h.a(t);
        T t2 = tArr[i];
        kotlin.jvm.internal.h.a(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.a(i);
        t2.a(i2);
    }

    public final T c() {
        T e;
        synchronized (this) {
            e = e();
        }
        return e;
    }

    public final T d() {
        T a2;
        synchronized (this) {
            a2 = a() > 0 ? a(0) : null;
        }
        return a2;
    }
}
