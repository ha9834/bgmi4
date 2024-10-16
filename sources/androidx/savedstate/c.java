package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final d f913a;
    private final b b = new b();

    private c(d dVar) {
        this.f913a = dVar;
    }

    public b a() {
        return this.b;
    }

    public void a(Bundle bundle) {
        Lifecycle lifecycle = this.f913a.getLifecycle();
        if (lifecycle.a() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f913a));
        this.b.a(lifecycle, bundle);
    }

    public void b(Bundle bundle) {
        this.b.a(bundle);
    }

    public static c a(d dVar) {
        return new c(dVar);
    }
}
