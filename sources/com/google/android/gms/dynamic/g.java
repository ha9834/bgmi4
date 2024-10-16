package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
final class g implements DeferredLifecycleHelper.a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DeferredLifecycleHelper f1593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f1593a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final int a() {
        return 5;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.f1593a.f1582a;
        lifecycleDelegate2.onResume();
    }
}
