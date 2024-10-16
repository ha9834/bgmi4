package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class lu implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzavb f2328a;
    private final /* synthetic */ zzbio b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lu(zzbio zzbioVar, zzavb zzavbVar) {
        this.b = zzbioVar;
        this.f2328a = zzavbVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.b.a(view, this.f2328a, 10);
    }
}
