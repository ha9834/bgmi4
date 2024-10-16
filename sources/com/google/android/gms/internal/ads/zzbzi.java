package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbzi extends zzaes implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcab {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f3138a;
    private final Map<String, WeakReference<View>> b = new HashMap();
    private final Map<String, WeakReference<View>> c = new HashMap();
    private final Map<String, WeakReference<View>> d = new HashMap();

    @GuardedBy("this")
    private zzbyn e;
    private zzua f;

    public zzbzi(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzk.zzmd();
        zzbbz.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzk.zzmd();
        zzbbz.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.f3138a = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.b.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.d.putAll(this.b);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.c.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.d.putAll(this.c);
        this.f = new zzua(view.getContext(), view);
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    @Nullable
    public final FrameLayout zzair() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final synchronized void unregisterNativeAd() {
        if (this.e != null) {
            this.e.zzb(this);
            this.e = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzbyn)) {
            zzawz.zzep("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.e != null) {
            this.e.zzb(this);
        }
        if (((zzbyn) unwrap).zzahs()) {
            this.e = (zzbyn) unwrap;
            this.e.zza(this);
            this.e.zzy(zzafi());
            return;
        }
        zzawz.zzen("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    @Nullable
    public final View zzafi() {
        return this.f3138a.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final zzua zzais() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized void zza(String str, View view, boolean z) {
        if (view == null) {
            this.d.remove(str);
            this.b.remove(str);
            this.c.remove(str);
            return;
        }
        this.d.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
            this.b.put(str, new WeakReference<>(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> zzait() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> zzaiu() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzaiv() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized View zzfp(String str) {
        WeakReference<View> weakReference = this.d.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized String zzaiw() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.e != null) {
            this.e.zza(view, motionEvent, zzafi());
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.e != null) {
            this.e.zza(view, zzafi(), zzait(), zzaiu(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.e != null) {
            this.e.zzb(zzafi(), zzait(), zzaiu(), zzbyn.zzx(zzafi()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.e != null) {
            this.e.zzb(zzafi(), zzait(), zzaiu(), zzbyn.zzx(zzafi()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        if (this.e != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzawz.zzep("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.e.setClickConfirmingView((View) unwrap);
        }
    }
}
