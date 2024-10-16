package kotlin;

import kotlin.Result;

/* loaded from: classes3.dex */
public final class h {
    public static final Object a(Throwable th) {
        kotlin.jvm.internal.h.b(th, "exception");
        return new Result.Failure(th);
    }
}
