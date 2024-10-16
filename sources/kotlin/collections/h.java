package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h extends g {
    public static final <T> boolean a(T[] tArr, T t) {
        kotlin.jvm.internal.h.b(tArr, "$this$contains");
        return d.b(tArr, t) >= 0;
    }

    public static final boolean a(int[] iArr, int i) {
        kotlin.jvm.internal.h.b(iArr, "$this$contains");
        return d.b(iArr, i) >= 0;
    }

    public static final <T> int b(T[] tArr, T t) {
        kotlin.jvm.internal.h.b(tArr, "$this$indexOf");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (kotlin.jvm.internal.h.a(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final int b(int[] iArr, int i) {
        kotlin.jvm.internal.h.b(iArr, "$this$indexOf");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final char a(char[] cArr) {
        kotlin.jvm.internal.h.b(cArr, "$this$single");
        switch (cArr.length) {
            case 0:
                throw new NoSuchElementException("Array is empty.");
            case 1:
                return cArr[0];
            default:
                throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final <T> T b(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] b(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.h.b(tArr, "$this$sortedArrayWith");
        kotlin.jvm.internal.h.b(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.h.a((Object) tArr2, "java.util.Arrays.copyOf(this, size)");
        d.a((Object[]) tArr2, (Comparator) comparator);
        return tArr2;
    }

    public static final <T> List<T> c(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.h.b(tArr, "$this$sortedWith");
        kotlin.jvm.internal.h.b(comparator, "comparator");
        return d.a(d.b((Object[]) tArr, (Comparator) comparator));
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c) {
        kotlin.jvm.internal.h.b(tArr, "$this$toCollection");
        kotlin.jvm.internal.h.b(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    public static final <T> List<T> c(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$toList");
        switch (tArr.length) {
            case 0:
                return j.a();
            case 1:
                return j.a(tArr[0]);
            default:
                return d.d(tArr);
        }
    }

    public static final <T> List<T> d(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$toMutableList");
        return new ArrayList(j.a((Object[]) tArr));
    }
}
