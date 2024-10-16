package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
/* loaded from: classes.dex */
public final class AdMobExtras implements NetworkExtras {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f1172a;

    public AdMobExtras(Bundle bundle) {
        this.f1172a = bundle != null ? new Bundle(bundle) : null;
    }

    public final Bundle getExtras() {
        return this.f1172a;
    }
}
