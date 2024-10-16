package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzard
/* loaded from: classes2.dex */
final class hu extends hv implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<ViewTreeObserver.OnScrollChangedListener> f2226a;

    public hu(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f2226a = new WeakReference<>(onScrollChangedListener);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.f2226a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            b();
        }
    }

    @Override // com.google.android.gms.internal.ads.hv
    protected final void a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    @Override // com.google.android.gms.internal.ads.hv
    protected final void b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }
}
