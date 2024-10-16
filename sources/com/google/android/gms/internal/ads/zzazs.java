package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzazs {

    /* renamed from: a, reason: collision with root package name */
    private final View f2844a;
    private Activity b;
    private boolean c;
    private boolean d;
    private boolean e;
    private ViewTreeObserver.OnGlobalLayoutListener f;
    private ViewTreeObserver.OnScrollChangedListener g = null;

    public zzazs(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.b = activity;
        this.f2844a = view;
        this.f = onGlobalLayoutListener;
    }

    public final void zzh(Activity activity) {
        this.b = activity;
    }

    public final void zzwt() {
        this.e = true;
        if (this.d) {
            a();
        }
    }

    public final void zzwu() {
        this.e = false;
        b();
    }

    public final void onAttachedToWindow() {
        this.d = true;
        if (this.e) {
            a();
        }
    }

    public final void onDetachedFromWindow() {
        this.d = false;
        b();
    }

    private final void a() {
        ViewTreeObserver a2;
        if (this.c) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f;
        if (onGlobalLayoutListener != null) {
            Activity activity = this.b;
            if (activity != null && (a2 = a(activity)) != null) {
                a2.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            zzk.zzmd();
            zzbbz.zza(this.f2844a, this.f);
        }
        this.c = true;
    }

    private final void b() {
        ViewTreeObserver a2;
        Activity activity = this.b;
        if (activity != null && this.c) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f;
            if (onGlobalLayoutListener != null && (a2 = a(activity)) != null) {
                zzk.zzli().zza(a2, onGlobalLayoutListener);
            }
            this.c = false;
        }
    }

    private static ViewTreeObserver a(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
}
