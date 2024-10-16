package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.google.android.gms.tagmanager.DataLayer;

/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends h implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Lifecycle f771a;
    private final kotlin.coroutines.e b;

    public Lifecycle a() {
        return this.f771a;
    }

    public kotlin.coroutines.e b() {
        return this.b;
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        kotlin.jvm.internal.h.b(kVar, "source");
        kotlin.jvm.internal.h.b(event, DataLayer.EVENT_KEY);
        if (a().a().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            a().b(this);
            kotlinx.coroutines.ab.a(b(), null, 1, null);
        }
    }
}
