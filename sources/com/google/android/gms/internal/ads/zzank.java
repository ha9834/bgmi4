package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzank implements MediationAdRequest {

    /* renamed from: a, reason: collision with root package name */
    private final Date f2762a;
    private final int b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final boolean g;
    private final int h;
    private final String i;

    public zzank(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.f2762a = date;
        this.b = i;
        this.c = set;
        this.e = location;
        this.d = z;
        this.f = i2;
        this.g = z2;
        this.h = i3;
        this.i = str;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.f2762a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.d;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.f;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.g;
    }
}
