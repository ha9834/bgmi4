package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;

@TargetApi(16)
/* loaded from: classes.dex */
public class zzaxt extends zzaxo {
    public zzaxt() {
        super();
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }
}
