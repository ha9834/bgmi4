package a;

import okhttp3.ab;
import okhttp3.ac;
import okhttp3.s;

/* loaded from: classes.dex */
public final class l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final ab f47a;
    private final T b;
    private final ac c;

    public static <T> l<T> a(T t, ab abVar) {
        if (abVar == null) {
            throw new NullPointerException("rawResponse == null");
        }
        if (!abVar.c()) {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        return new l<>(abVar, t, null);
    }

    public static <T> l<T> a(ac acVar, ab abVar) {
        if (acVar == null) {
            throw new NullPointerException("body == null");
        }
        if (abVar == null) {
            throw new NullPointerException("rawResponse == null");
        }
        if (abVar.c()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new l<>(abVar, null, acVar);
    }

    private l(ab abVar, T t, ac acVar) {
        this.f47a = abVar;
        this.b = t;
        this.c = acVar;
    }

    public int a() {
        return this.f47a.b();
    }

    public s b() {
        return this.f47a.f();
    }

    public boolean c() {
        return this.f47a.c();
    }

    public T d() {
        return this.b;
    }

    public ac e() {
        return this.c;
    }
}
