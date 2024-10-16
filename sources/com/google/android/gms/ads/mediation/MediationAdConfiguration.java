package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;

    /* renamed from: a, reason: collision with root package name */
    private final String f1165a;
    private final Bundle b;
    private final Bundle c;
    private final Context d;
    private final boolean e;
    private final Location f;
    private final int g;
    private final int h;
    private final String i;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, @Nullable String str2) {
        this.f1165a = str;
        this.b = bundle;
        this.c = bundle2;
        this.d = context;
        this.e = z;
        this.f = location;
        this.g = i;
        this.h = i2;
        this.i = str2;
    }

    public String getBidResponse() {
        return this.f1165a;
    }

    public Bundle getServerParameters() {
        return this.b;
    }

    public Bundle getMediationExtras() {
        return this.c;
    }

    public Context getContext() {
        return this.d;
    }

    public Location getLocation() {
        return this.f;
    }

    public int taggedForChildDirectedTreatment() {
        return this.g;
    }

    public boolean isTestRequest() {
        return this.e;
    }

    public int taggedForUnderAgeTreatment() {
        return this.h;
    }

    @Nullable
    public String getMaxAdContentRating() {
        return this.i;
    }
}
