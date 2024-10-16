package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.ac;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f7014a = true;

    public static final ac a(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, mainDispatcherFactory.hintOnError());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ k a(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = (Throwable) null;
        }
        if ((i & 2) != 0) {
            str = (String) null;
        }
        return a(th, str);
    }

    private static final k a(Throwable th, String str) {
        if (f7014a) {
            return new k(th, str);
        }
        if (th != null) {
            throw th;
        }
        a();
        throw new KotlinNothingValueException();
    }

    public static final Void a() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
