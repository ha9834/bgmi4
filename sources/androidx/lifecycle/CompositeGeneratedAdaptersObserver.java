package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements i {

    /* renamed from: a, reason: collision with root package name */
    private final e[] f764a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(e[] eVarArr) {
        this.f764a = eVarArr;
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        o oVar = new o();
        for (e eVar : this.f764a) {
            eVar.a(kVar, event, false, oVar);
        }
        for (e eVar2 : this.f764a) {
            eVar2.a(kVar, event, true, oVar);
        }
    }
}
