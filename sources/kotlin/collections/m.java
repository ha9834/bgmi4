package kotlin.collections;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m extends l {
    public static final <T> int a(Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.h.b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
