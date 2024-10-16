package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
final class c implements DeferredLifecycleHelper.a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Bundle f1589a;
    private final /* synthetic */ DeferredLifecycleHelper b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.b = deferredLifecycleHelper;
        this.f1589a = bundle;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final int a() {
        return 1;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.b.f1582a;
        lifecycleDelegate2.onCreate(this.f1589a);
    }
}
