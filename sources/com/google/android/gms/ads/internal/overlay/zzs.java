package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawz;

@zzard
/* loaded from: classes.dex */
public final class zzs extends zzd {
    public zzs(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzd, com.google.android.gms.internal.ads.zzaqg
    public final void onCreate(Bundle bundle) {
        zzawz.zzds("AdOverlayParcel is null or does not contain valid overlay type.");
        this.d = 3;
        this.f1156a.finish();
    }
}
