package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g extends f {
    public static final <T> List<T> a(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$asList");
        List<T> a2 = i.a(tArr);
        kotlin.jvm.internal.h.a((Object) a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }

    public static /* synthetic */ Object[] a(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return d.a(objArr, objArr2, i, i2, i3);
    }

    public static final <T> T[] a(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        kotlin.jvm.internal.h.b(tArr, "$this$copyInto");
        kotlin.jvm.internal.h.b(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static final <T> void a(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.h.b(tArr, "$this$sortWith");
        kotlin.jvm.internal.h.b(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
