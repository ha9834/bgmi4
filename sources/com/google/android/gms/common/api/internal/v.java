package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends zabr {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<zaaw> f1377a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zaaw zaawVar) {
        this.f1377a = new WeakReference<>(zaawVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zas() {
        zaaw zaawVar = this.f1377a.get();
        if (zaawVar == null) {
            return;
        }
        zaawVar.f();
    }
}
