package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
final class f implements DeferredLifecycleHelper.a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DeferredLifecycleHelper f1592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f1592a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final int a() {
        return 4;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.f1592a.f1582a;
        lifecycleDelegate2.onStart();
    }
}
