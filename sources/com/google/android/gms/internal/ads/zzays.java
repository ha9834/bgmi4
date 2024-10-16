package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* loaded from: classes2.dex */
public final class zzays {

    /* renamed from: a, reason: collision with root package name */
    private final double f2831a;
    private final double b;
    public final int count;
    public final String name;
    public final double zzdxd;

    public zzays(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.b = d;
        this.f2831a = d2;
        this.zzdxd = d3;
        this.count = i;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.name).add("minBound", Double.valueOf(this.b)).add("maxBound", Double.valueOf(this.f2831a)).add("percent", Double.valueOf(this.zzdxd)).add("count", Integer.valueOf(this.count)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzays)) {
            return false;
        }
        zzays zzaysVar = (zzays) obj;
        return Objects.equal(this.name, zzaysVar.name) && this.f2831a == zzaysVar.f2831a && this.b == zzaysVar.b && this.count == zzaysVar.count && Double.compare(this.zzdxd, zzaysVar.zzdxd) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.f2831a), Double.valueOf(this.b), Double.valueOf(this.zzdxd), Integer.valueOf(this.count));
    }
}
