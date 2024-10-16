package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ad extends ac {
    public static final <T> Set<T> a() {
        return EmptySet.f6941a;
    }

    public static final <T> HashSet<T> a(T... tArr) {
        kotlin.jvm.internal.h.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return (HashSet) d.a((Object[]) tArr, new HashSet(w.a(tArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> a(Set<? extends T> set) {
        kotlin.jvm.internal.h.b(set, "$this$optimizeReadOnlySet");
        switch (set.size()) {
            case 0:
                return ab.a();
            case 1:
                return ab.a(set.iterator().next());
            default:
                return set;
        }
    }
}
