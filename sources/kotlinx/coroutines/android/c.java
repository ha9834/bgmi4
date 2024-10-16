package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.Result;
import kotlin.h;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6993a;

    public static final Handler a(Looper looper, boolean z) {
        if (!z || Build.VERSION.SDK_INT < 16) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    static {
        Object e;
        try {
            Result.a aVar = Result.f6935a;
            e = Result.e(new a(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f6935a;
            e = Result.e(h.a(th));
        }
        f6993a = (b) (Result.b(e) ? null : e);
    }
}
