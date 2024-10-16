package kotlin.collections;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes3.dex */
class ac {
    public static final <T> Set<T> a(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.h.a((Object) singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
