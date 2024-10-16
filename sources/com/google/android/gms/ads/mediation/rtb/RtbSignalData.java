package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class RtbSignalData {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1178a;
    private final MediationConfiguration b;
    private final Bundle c;

    @Nullable
    private final AdSize d;

    public RtbSignalData(Context context, MediationConfiguration mediationConfiguration, Bundle bundle, @Nullable AdSize adSize) {
        this.f1178a = context;
        this.b = mediationConfiguration;
        this.c = bundle;
        this.d = adSize;
    }

    public Context getContext() {
        return this.f1178a;
    }

    public MediationConfiguration getConfiguration() {
        return this.b;
    }

    public Bundle getNetworkExtras() {
        return this.c;
    }

    @Nullable
    public AdSize getAdSize() {
        return this.d;
    }
}
