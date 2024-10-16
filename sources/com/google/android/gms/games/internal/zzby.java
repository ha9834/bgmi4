package com.google.android.gms.games.internal;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zzby implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    private zze f1697a;
    private zzca b;
    private WeakReference<View> c;
    private boolean d = false;

    public static zzby zza(zze zzeVar, int i) {
        return new zzby(zzeVar, i);
    }

    private zzby(zze zzeVar, int i) {
        this.f1697a = zzeVar;
        this.b = new zzca(i);
    }

    public final void setGravity(int i) {
        this.b.gravity = i;
    }

    public final Bundle zzco() {
        return this.b.zzcs();
    }

    public final IBinder zzcp() {
        return this.b.zzju;
    }

    public final zzca zzcq() {
        return this.b;
    }

    @TargetApi(16)
    public final void zzb(View view) {
        this.f1697a.i();
        WeakReference<View> weakReference = this.c;
        if (weakReference != null) {
            View view2 = weakReference.get();
            Context context = this.f1697a.getContext();
            if (view2 == null && (context instanceof Activity)) {
                view2 = ((Activity) context).getWindow().getDecorView();
            }
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (PlatformVersion.isAtLeastJellyBean()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
        this.c = null;
        Context context2 = this.f1697a.getContext();
        if (view == null && (context2 instanceof Activity)) {
            Activity activity = (Activity) context2;
            view = activity.findViewById(R.id.content);
            if (view == null) {
                view = activity.getWindow().getDecorView();
            }
            zzbd.w("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if (view != null) {
            a(view);
            this.c = new WeakReference<>(view);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            return;
        }
        zzbd.e("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }

    public final void zzcr() {
        if (this.b.zzju != null) {
            this.f1697a.a(this.b.zzju, this.b.zzcs());
            this.d = false;
        } else {
            this.d = true;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        a(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f1697a.i();
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        WeakReference<View> weakReference = this.c;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        a(view);
    }

    @TargetApi(17)
    private final void a(View view) {
        Display display;
        int i = -1;
        if (PlatformVersion.isAtLeastJellyBeanMR1() && (display = view.getDisplay()) != null) {
            i = display.getDisplayId();
        }
        IBinder windowToken = view.getWindowToken();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        zzca zzcaVar = this.b;
        zzcaVar.zzjy = i;
        zzcaVar.zzju = windowToken;
        zzcaVar.left = iArr[0];
        zzcaVar.top = iArr[1];
        zzcaVar.right = iArr[0] + width;
        zzcaVar.bottom = iArr[1] + height;
        if (this.d) {
            zzcr();
        }
    }
}
