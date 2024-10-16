package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class le implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzavb f2312a;
    private final /* synthetic */ zzbha b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public le(zzbha zzbhaVar, zzavb zzavbVar) {
        this.b = zzbhaVar;
        this.f2312a = zzavbVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.b.a(view, this.f2312a, 10);
    }
}
