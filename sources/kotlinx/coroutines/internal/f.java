package kotlinx.coroutines.internal;

import kotlin.Result;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f7009a;

    static {
        Object e;
        try {
            Result.a aVar = Result.f6935a;
            e = Result.e(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f6935a;
            e = Result.e(kotlin.h.a(th));
        }
        f7009a = Result.a(e);
    }

    public static final boolean a() {
        return f7009a;
    }
}
