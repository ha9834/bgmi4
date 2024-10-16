package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;

@zzard
/* loaded from: classes2.dex */
public final class zzbbz {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new ht(view, onGlobalLayoutListener).a();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new hu(view, onScrollChangedListener).a();
    }
}
