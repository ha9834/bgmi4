package kotlin.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f extends e {
    public static final long a(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final long b(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final int c(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final a a(int i, int i2) {
        return a.f6957a.a(i, i2, -1);
    }

    public static final c b(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return c.b.a();
        }
        return new c(i, i2 - 1);
    }

    public static final int a(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }
}
