package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(18)
/* loaded from: classes.dex */
public class zzaxs extends zzaxr {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final int zzwf() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }
}
