package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class p {
    public static final boolean a(String str, boolean z) {
        String a2 = n.a(str);
        return a2 != null ? Boolean.parseBoolean(a2) : z;
    }

    public static /* synthetic */ int a(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return n.a(str, i, i2, i3);
    }

    public static final int a(String str, int i, int i2, int i3) {
        return (int) n.a(str, i, i2, i3);
    }

    public static final long a(String str, long j, long j2, long j3) {
        String a2 = n.a(str);
        if (a2 == null) {
            return j;
        }
        Long b = kotlin.text.l.b(a2);
        if (b == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + a2 + '\'').toString());
        }
        long longValue = b.longValue();
        if (j2 <= longValue && j3 >= longValue) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
    }
}
