package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements i {

    /* renamed from: a, reason: collision with root package name */
    private final e f780a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(e eVar) {
        this.f780a = eVar;
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        this.f780a.a(kVar, event, false, null);
        this.f780a.a(kVar, event, true, null);
    }
}
