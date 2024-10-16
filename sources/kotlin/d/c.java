package kotlin.d;

/* loaded from: classes3.dex */
public final class c extends kotlin.d.a {
    public static final a b = new a(null);
    private static final c c = new c(1, 0);

    public c(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer f() {
        return Integer.valueOf(a());
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    @Override // kotlin.d.a
    public boolean e() {
        return a() > b();
    }

    @Override // kotlin.d.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!e() || !((c) obj).e()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.d.a
    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.d.a
    public String toString() {
        return a() + ".." + b();
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final c a() {
            return c.c;
        }
    }
}
