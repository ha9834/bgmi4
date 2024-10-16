package kotlin.d;

import kotlin.collections.v;

/* loaded from: classes3.dex */
public class a implements Iterable<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final C0228a f6957a = new C0228a(null);
    private final int b;
    private final int c;
    private final int d;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.b = i;
        this.c = kotlin.b.c.a(i, i2, i3);
        this.d = i3;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    @Override // java.lang.Iterable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public v iterator() {
        return new b(this.b, this.c, this.d);
    }

    public boolean e() {
        if (this.d > 0) {
            if (this.b > this.c) {
                return true;
            }
        } else if (this.b < this.c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!e() || !((a) obj).e()) {
                a aVar = (a) obj;
                if (this.b != aVar.b || this.c != aVar.c || this.d != aVar.d) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (((this.b * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.d > 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append("..");
            sb.append(this.c);
            sb.append(" step ");
            i = this.d;
        } else {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append(" downTo ");
            sb.append(this.c);
            sb.append(" step ");
            i = -this.d;
        }
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: kotlin.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0228a {
        private C0228a() {
        }

        public /* synthetic */ C0228a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final a a(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
