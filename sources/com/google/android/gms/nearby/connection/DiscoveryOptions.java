package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class DiscoveryOptions extends zzbgl {
    public static final Parcelable.Creator<DiscoveryOptions> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    private Strategy f4969a;

    @Hide
    private boolean b;

    @Hide
    private boolean c;

    @Hide
    private boolean d;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final DiscoveryOptions f4970a = new DiscoveryOptions();

        public Builder() {
        }

        public Builder(DiscoveryOptions discoveryOptions) {
            this.f4970a.f4969a = discoveryOptions.f4969a;
            this.f4970a.b = discoveryOptions.b;
            this.f4970a.c = discoveryOptions.c;
            this.f4970a.d = discoveryOptions.d;
        }

        public final DiscoveryOptions build() {
            return this.f4970a;
        }

        public final Builder setStrategy(Strategy strategy) {
            this.f4970a.f4969a = strategy;
            return this;
        }
    }

    private DiscoveryOptions() {
        this.b = false;
        this.c = true;
        this.d = true;
    }

    @Deprecated
    public DiscoveryOptions(Strategy strategy) {
        this.b = false;
        this.c = true;
        this.d = true;
        this.f4969a = strategy;
    }

    @Hide
    public DiscoveryOptions(Strategy strategy, boolean z, boolean z2, boolean z3) {
        this.b = false;
        this.c = true;
        this.d = true;
        this.f4969a = strategy;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            if (zzbg.equal(this.f4969a, discoveryOptions.f4969a) && zzbg.equal(Boolean.valueOf(this.b), Boolean.valueOf(discoveryOptions.b)) && zzbg.equal(Boolean.valueOf(this.c), Boolean.valueOf(discoveryOptions.c)) && zzbg.equal(Boolean.valueOf(this.d), Boolean.valueOf(discoveryOptions.d))) {
                return true;
            }
        }
        return false;
    }

    public final Strategy getStrategy() {
        return this.f4969a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4969a, Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, getStrategy(), i, false);
        zzbgo.zza(parcel, 2, this.b);
        zzbgo.zza(parcel, 3, this.c);
        zzbgo.zza(parcel, 4, this.d);
        zzbgo.zzai(parcel, zze);
    }
}
