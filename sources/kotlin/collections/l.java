package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class l extends k {
    public static final <T> Collection<T> a(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$asCollection");
        return new c(tArr, false);
    }

    public static final <T> List<T> a() {
        return EmptyList.f6939a;
    }

    public static final <T> List<T> b(T... tArr) {
        kotlin.jvm.internal.h.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length > 0 ? d.a(tArr) : j.a();
    }

    public static final <T> ArrayList<T> c(T... tArr) {
        kotlin.jvm.internal.h.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new c(tArr, true));
    }

    public static final kotlin.d.c a(Collection<?> collection) {
        kotlin.jvm.internal.h.b(collection, "$this$indices");
        return new kotlin.d.c(0, collection.size() - 1);
    }

    public static final <T> int a(List<? extends T> list) {
        kotlin.jvm.internal.h.b(list, "$this$lastIndex");
        return list.size() - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> b(List<? extends T> list) {
        kotlin.jvm.internal.h.b(list, "$this$optimizeReadOnlyList");
        switch (list.size()) {
            case 0:
                return j.a();
            case 1:
                return j.a(list.get(0));
            default:
                return list;
        }
    }

    public static final void b() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
