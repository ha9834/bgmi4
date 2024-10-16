package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

@Deprecated
/* loaded from: classes.dex */
public class NativeAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f1138a;
    private final zzaem b;

    public NativeAdView(Context context) {
        super(context);
        this.f1138a = a(context);
        this.b = a();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1138a = a(context);
        this.b = a();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1138a = a(context);
        this.b = a();
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1138a = a(context);
        this.b = a();
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public AdChoicesView getAdChoicesView() {
        View a2 = a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (a2 instanceof AdChoicesView) {
            return (AdChoicesView) a2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, View view) {
        try {
            this.b.zzc(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(String str) {
        try {
            IObjectWrapper zzcf = this.b.zzcf(str);
            if (zzcf != null) {
                return (View) ObjectWrapper.unwrap(zzcf);
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.b.zze((IObjectWrapper) nativeAd.a());
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    public void destroy() {
        try {
            this.b.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("Unable to destroy native ad view", e);
        }
    }

    private final FrameLayout a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaem a() {
        Preconditions.checkNotNull(this.f1138a, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzyt.zzpb().zza(this.f1138a.getContext(), this, this.f1138a);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f1138a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f1138a == view) {
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f1138a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f1138a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaem zzaemVar = this.b;
        if (zzaemVar != null) {
            try {
                zzaemVar.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }
}
