package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements i {

    /* renamed from: a, reason: collision with root package name */
    private final d f765a;
    private final i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(d dVar, i iVar) {
        this.f765a = dVar;
        this.b = iVar;
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.f765a.a(kVar);
                break;
            case ON_START:
                this.f765a.b(kVar);
                break;
            case ON_RESUME:
                this.f765a.c(kVar);
                break;
            case ON_PAUSE:
                this.f765a.d(kVar);
                break;
            case ON_STOP:
                this.f765a.e(kVar);
                break;
            case ON_DESTROY:
                this.f765a.f(kVar);
                break;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.a(kVar, event);
        }
    }
}
