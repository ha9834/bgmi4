package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.z;

/* loaded from: classes.dex */
final class LifecycleController$observer$1 implements i {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f770a;
    final /* synthetic */ kotlinx.coroutines.z b;

    @Override // androidx.lifecycle.i
    public final void a(k kVar, Lifecycle.Event event) {
        Lifecycle.State state;
        c cVar;
        c cVar2;
        kotlin.jvm.internal.h.b(kVar, "source");
        kotlin.jvm.internal.h.b(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = kVar.getLifecycle();
        kotlin.jvm.internal.h.a((Object) lifecycle, "source.lifecycle");
        if (lifecycle.a() == Lifecycle.State.DESTROYED) {
            g gVar = this.f770a;
            z.a.a(this.b, null, 1, null);
            gVar.a();
            return;
        }
        Lifecycle lifecycle2 = kVar.getLifecycle();
        kotlin.jvm.internal.h.a((Object) lifecycle2, "source.lifecycle");
        Lifecycle.State a2 = lifecycle2.a();
        state = this.f770a.c;
        if (a2.compareTo(state) < 0) {
            cVar2 = this.f770a.d;
            cVar2.a();
        } else {
            cVar = this.f770a.d;
            cVar.b();
        }
    }
}
