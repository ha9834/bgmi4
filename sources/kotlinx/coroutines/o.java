package kotlinx.coroutines;

import kotlin.Result;

/* loaded from: classes3.dex */
public final class o {
    public static final String a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String a(kotlin.coroutines.c<?> cVar) {
        Object e;
        if (cVar instanceof kotlinx.coroutines.internal.b) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.f6935a;
            e = Result.e(cVar + '@' + a((Object) cVar));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f6935a;
            e = Result.e(kotlin.h.a(th));
        }
        if (Result.c(e) != null) {
            e = cVar.getClass().getName() + '@' + a((Object) cVar);
        }
        return (String) e;
    }

    public static final String b(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
