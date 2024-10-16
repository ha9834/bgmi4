package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements androidx.lifecycle.y, androidx.savedstate.d {

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f698a;
    private final androidx.lifecycle.x b;
    private androidx.lifecycle.l c = null;
    private androidx.savedstate.c d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Fragment fragment, androidx.lifecycle.x xVar) {
        this.f698a = fragment;
        this.b = xVar;
    }

    @Override // androidx.lifecycle.y
    public androidx.lifecycle.x getViewModelStore() {
        a();
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.c == null) {
            this.c = new androidx.lifecycle.l(this);
            this.d = androidx.savedstate.c.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.c != null;
    }

    @Override // androidx.lifecycle.k
    public Lifecycle getLifecycle() {
        a();
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Lifecycle.State state) {
        this.c.b(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Lifecycle.Event event) {
        this.c.a(event);
    }

    @Override // androidx.savedstate.d
    public androidx.savedstate.b getSavedStateRegistry() {
        a();
        return this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        this.d.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        this.d.b(bundle);
    }
}
