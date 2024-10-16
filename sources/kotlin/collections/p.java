package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class p extends o {
    public static final <T> void a(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.h.b(list, "$this$sortWith");
        kotlin.jvm.internal.h.b(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
