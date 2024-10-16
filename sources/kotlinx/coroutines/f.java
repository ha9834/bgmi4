package kotlinx.coroutines;

import kotlin.Result;

/* loaded from: classes3.dex */
public final class f {
    public static /* synthetic */ Object a(Object obj, kotlin.jvm.a.b bVar, int i, Object obj2) {
        if ((i & 1) != 0) {
            bVar = (kotlin.jvm.a.b) null;
        }
        return a(obj, bVar);
    }

    public static final <T> Object a(Object obj, kotlin.jvm.a.b<? super Throwable, kotlin.k> bVar) {
        Throwable c = Result.c(obj);
        if (c == null) {
            return bVar != null ? new e(obj, bVar) : obj;
        }
        return new d(c, false, 2, null);
    }
}
