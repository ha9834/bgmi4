package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Object f777a;
    private final b.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f777a = obj;
        this.b = b.f782a.b(this.f777a.getClass());
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        this.b.a(kVar, event, this.f777a);
    }
}
