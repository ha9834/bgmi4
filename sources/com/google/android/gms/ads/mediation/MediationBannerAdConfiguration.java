package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class MediationBannerAdConfiguration extends MediationAdConfiguration {

    /* renamed from: a, reason: collision with root package name */
    private final AdSize f1167a;

    public MediationBannerAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, String str2, @Nullable AdSize adSize) {
        super(context, str, bundle, bundle2, z, location, i, i2, str2);
        this.f1167a = adSize;
    }

    public AdSize getAdSize() {
        return this.f1167a;
    }
}
