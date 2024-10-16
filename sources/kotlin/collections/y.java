package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class y extends x {
    public static final int a(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> a(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.h.b(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.a(), pair.b());
        kotlin.jvm.internal.h.a((Object) singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> a(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.h.b(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.h.a((Object) singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
