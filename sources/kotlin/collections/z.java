package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class z extends y {
    public static final <K, V> Map<K, V> a() {
        EmptyMap emptyMap = EmptyMap.f6940a;
        if (emptyMap != null) {
            return emptyMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static final <K, V> Map<K, V> a(Pair<? extends K, ? extends V>... pairArr) {
        kotlin.jvm.internal.h.b(pairArr, "pairs");
        return pairArr.length > 0 ? w.a(pairArr, new LinkedHashMap(w.a(pairArr.length))) : w.a();
    }

    public static final <K, V> Map<K, V> b(Pair<? extends K, ? extends V>... pairArr) {
        kotlin.jvm.internal.h.b(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(w.a(pairArr.length));
        w.a(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> c(Pair<? extends K, ? extends V>... pairArr) {
        kotlin.jvm.internal.h.b(pairArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(w.a(pairArr.length));
        w.a(hashMap, pairArr);
        return hashMap;
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        kotlin.jvm.internal.h.b(map, "$this$putAll");
        kotlin.jvm.internal.h.b(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.c(), pair.d());
        }
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.h.b(map, "$this$putAll");
        kotlin.jvm.internal.h.b(iterable, "pairs");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put(pair.c(), pair.d());
        }
    }

    public static final <K, V> Map<K, V> a(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$toMap");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            switch (collection.size()) {
                case 0:
                    return w.a();
                case 1:
                    return w.a(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
                default:
                    return w.a(iterable, new LinkedHashMap(w.a(collection.size())));
            }
        }
        return w.c(w.a(iterable, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        kotlin.jvm.internal.h.b(iterable, "$this$toMap");
        kotlin.jvm.internal.h.b(m, "destination");
        w.a(m, iterable);
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Pair<? extends K, ? extends V>[] pairArr, M m) {
        kotlin.jvm.internal.h.b(pairArr, "$this$toMap");
        kotlin.jvm.internal.h.b(m, "destination");
        w.a(m, pairArr);
        return m;
    }

    public static final <K, V> Map<K, V> b(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.h.b(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> c(Map<K, ? extends V> map) {
        kotlin.jvm.internal.h.b(map, "$this$optimizeReadOnlyMap");
        switch (map.size()) {
            case 0:
                return w.a();
            case 1:
                return w.a(map);
            default:
                return map;
        }
    }
}
