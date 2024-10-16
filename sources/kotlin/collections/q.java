package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class q extends p {
    public static final <T> boolean a(Collection<? super T> collection, Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(collection, "$this$addAll");
        kotlin.jvm.internal.h.b(iterable, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }
}
