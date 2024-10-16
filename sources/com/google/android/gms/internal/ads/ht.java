package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

@zzard
/* loaded from: classes2.dex */
final class ht extends hv implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> f2225a;

    public ht(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f2225a = new WeakReference<>(onGlobalLayoutListener);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f2225a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            b();
        }
    }

    @Override // com.google.android.gms.internal.ads.hv
    protected final void a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    @Override // com.google.android.gms.internal.ads.hv
    protected final void b(ViewTreeObserver viewTreeObserver) {
        zzk.zzli().zza(viewTreeObserver, this);
    }
}
