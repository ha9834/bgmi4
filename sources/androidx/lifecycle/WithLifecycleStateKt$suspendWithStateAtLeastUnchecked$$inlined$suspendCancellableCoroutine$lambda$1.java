package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.google.android.gms.tagmanager.DataLayer;
import kotlin.Result;

/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 implements i {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.b f781a;
    final /* synthetic */ Lifecycle b;
    final /* synthetic */ Lifecycle.State c;
    final /* synthetic */ kotlin.jvm.a.a d;

    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        Object e;
        kotlin.jvm.internal.h.b(kVar, "source");
        kotlin.jvm.internal.h.b(event, DataLayer.EVENT_KEY);
        if (event == Lifecycle.Event.c(this.c)) {
            this.b.b(this);
            kotlinx.coroutines.b bVar = this.f781a;
            kotlin.jvm.a.a aVar = this.d;
            try {
                Result.a aVar2 = Result.f6935a;
                e = Result.e(aVar.b());
            } catch (Throwable th) {
                Result.a aVar3 = Result.f6935a;
                e = Result.e(kotlin.h.a(th));
            }
            bVar.a(e);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.b.b(this);
            kotlinx.coroutines.b bVar2 = this.f781a;
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            Result.a aVar4 = Result.f6935a;
            bVar2.a(Result.e(kotlin.h.a(lifecycleDestroyedException)));
        }
    }
}
