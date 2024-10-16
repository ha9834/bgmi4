package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(19)
/* loaded from: classes.dex */
public class zzaxu extends zzaxs {
    @Override // com.google.android.gms.internal.ads.zzaxs, com.google.android.gms.internal.ads.zzaxo
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final ViewGroup.LayoutParams zzwg() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
