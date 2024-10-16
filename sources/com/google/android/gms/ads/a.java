package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzxr;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    protected final zzabb f1131a;

    public a(Context context, int i) {
        super(context);
        this.f1131a = new zzabb(this, i);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1131a = new zzabb(this, attributeSet, false, i);
    }

    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f1131a = new zzabb(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.f1131a.destroy();
    }

    public AdListener getAdListener() {
        return this.f1131a.getAdListener();
    }

    public AdSize getAdSize() {
        return this.f1131a.getAdSize();
    }

    public String getAdUnitId() {
        return this.f1131a.getAdUnitId();
    }

    public void loadAd(AdRequest adRequest) {
        this.f1131a.zza(adRequest.zzde());
    }

    public void pause() {
        this.f1131a.pause();
    }

    public void resume() {
        this.f1131a.resume();
    }

    public boolean isLoading() {
        return this.f1131a.isLoading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        this.f1131a.setAdListener(adListener);
        if (adListener == 0) {
            this.f1131a.zza((zzxr) null);
            this.f1131a.setAppEventListener(null);
            return;
        }
        if (adListener instanceof zzxr) {
            this.f1131a.zza((zzxr) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.f1131a.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f1131a.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.f1131a.setAdUnitId(str);
    }

    public String getMediationAdapterClassName() {
        return this.f1131a.getMediationAdapterClassName();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzbad.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
