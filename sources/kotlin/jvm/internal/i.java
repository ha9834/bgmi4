package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f6971a;
    private final String b;

    public i(Class<?> cls, String str) {
        h.b(cls, "jClass");
        h.b(str, "moduleName");
        this.f6971a = cls;
        this.b = str;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> a() {
        return this.f6971a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && h.a(a(), ((i) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
