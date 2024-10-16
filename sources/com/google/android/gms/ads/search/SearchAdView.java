package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbad;

@zzard
/* loaded from: classes.dex */
public final class SearchAdView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private final zzabb f1186a;

    public SearchAdView(Context context) {
        super(context);
        this.f1186a = new zzabb(this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1186a = new zzabb(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1186a = new zzabb(this, attributeSet, false);
    }

    public final void destroy() {
        this.f1186a.destroy();
    }

    public final AdListener getAdListener() {
        return this.f1186a.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.f1186a.getAdSize();
    }

    public final String getAdUnitId() {
        return this.f1186a.getAdUnitId();
    }

    public final void loadAd(SearchAdRequest searchAdRequest) {
        this.f1186a.zza(searchAdRequest.a());
    }

    public final void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (!AdSize.SEARCH.equals(getAdSize())) {
            throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
        }
        this.f1186a.zza(dynamicHeightSearchAdRequest.a());
    }

    public final void pause() {
        this.f1186a.pause();
    }

    public final void resume() {
        this.f1186a.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.f1186a.setAdListener(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.f1186a.setAdSizes(adSize);
    }

    public final void setAdUnitId(String str) {
        this.f1186a.setAdUnitId(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    protected final void onMeasure(int i, int i2) {
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
