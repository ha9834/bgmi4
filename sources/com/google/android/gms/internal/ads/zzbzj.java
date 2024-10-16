package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzbzj extends zzaen implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcab {
    public static final String[] zzfpm = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};

    /* renamed from: a, reason: collision with root package name */
    private final String f3139a;
    private FrameLayout c;
    private FrameLayout d;
    private zzbbl e;
    private View f;

    @GuardedBy("this")
    private zzbyn g;
    private zzua h;

    @GuardedBy("this")
    private Map<String, WeakReference<View>> b = new HashMap();
    private boolean i = false;

    public zzbzj(FrameLayout frameLayout, FrameLayout frameLayout2) {
        String str;
        this.c = frameLayout;
        this.d = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.f3139a = str;
        zzk.zzmd();
        zzbbz.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzk.zzmd();
        zzbbz.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.e = zzbbm.zzeag;
        this.h = new zzua(this.c.getContext(), this.c);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void zzc(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized void zza(String str, View view, boolean z) {
        if (this.i) {
            return;
        }
        if (view == null) {
            this.b.remove(str);
            return;
        }
        this.b.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
            view.setOnTouchListener(this);
            view.setClickable(true);
            view.setOnClickListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized IObjectWrapper zzcf(String str) {
        return ObjectWrapper.wrap(zzfp(str));
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized View zzfp(String str) {
        if (this.i) {
            return null;
        }
        WeakReference<View> weakReference = this.b.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.i) {
            return;
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzbyn)) {
            zzawz.zzep("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        if (this.g != null) {
            this.g.zzb(this);
        }
        b();
        this.g = (zzbyn) unwrap;
        this.g.zza(this);
        this.g.zzy(this.c);
    }

    private final synchronized void b() {
        this.e.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.qh

            /* renamed from: a, reason: collision with root package name */
            private final zzbzj f2437a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2437a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2437a.a();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void destroy() {
        if (this.i) {
            return;
        }
        if (this.g != null) {
            this.g.zzb(this);
            this.g = null;
        }
        this.b.clear();
        this.c.removeAllViews();
        this.d.removeAllViews();
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.h = null;
        this.i = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.g != null) {
            this.g.cancelUnconfirmedClick();
            this.g.zza(view, this.c, zzait(), zzaiu(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.g != null) {
            this.g.zza(view, motionEvent, this.c);
        }
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.g != null) {
            this.g.zzb(this.c, zzait(), zzaiu(), zzbyn.zzx(this.c));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.g != null) {
            this.g.zzb(this.c, zzait(), zzaiu(), zzbyn.zzx(this.c));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> zzait() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> zzaiu() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzaiv() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized String zzaiw() {
        return this.f3139a;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final FrameLayout zzair() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final zzua zzais() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        this.g.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final /* synthetic */ View zzafi() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        if (this.f == null) {
            this.f = new View(this.c.getContext());
            this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.c != this.f.getParent()) {
            this.c.addView(this.f);
        }
    }
}
