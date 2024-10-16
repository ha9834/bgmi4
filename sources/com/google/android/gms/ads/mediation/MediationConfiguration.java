package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

/* loaded from: classes.dex */
public class MediationConfiguration {

    /* renamed from: a, reason: collision with root package name */
    private final AdFormat f1168a;
    private final Bundle b;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.f1168a = adFormat;
        this.b = bundle;
    }

    public AdFormat getFormat() {
        return this.f1168a;
    }

    public Bundle getServerParameters() {
        return this.b;
    }
}
