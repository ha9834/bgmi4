package com.google.android.gms.ads.mediation.rtb;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public interface SignalCallbacks {
    void onFailure(String str);

    void onSuccess(String str);
}
