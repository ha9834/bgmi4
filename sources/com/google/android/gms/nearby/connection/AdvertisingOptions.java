package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AdvertisingOptions extends zzbgl {
    public static final Parcelable.Creator<AdvertisingOptions> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private Strategy f4962a;

    @Hide
    private boolean b;

    @Hide
    private boolean c;

    @Hide
    private boolean d;

    @Hide
    private boolean e;

    @Hide
    private byte[] f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final AdvertisingOptions f4963a = new AdvertisingOptions();

        public Builder() {
        }

        public Builder(AdvertisingOptions advertisingOptions) {
            this.f4963a.f4962a = advertisingOptions.f4962a;
            this.f4963a.b = advertisingOptions.b;
            this.f4963a.c = advertisingOptions.c;
            this.f4963a.d = advertisingOptions.d;
            this.f4963a.e = advertisingOptions.e;
            this.f4963a.f = advertisingOptions.f;
        }

        public final AdvertisingOptions build() {
            return this.f4963a;
        }

        public final Builder setStrategy(Strategy strategy) {
            this.f4963a.f4962a = strategy;
            return this;
        }
    }

    private AdvertisingOptions() {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
    }

    @Deprecated
    public AdvertisingOptions(Strategy strategy) {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f4962a = strategy;
    }

    @Hide
    public AdvertisingOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr) {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f4962a = strategy;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvertisingOptions) {
            AdvertisingOptions advertisingOptions = (AdvertisingOptions) obj;
            if (zzbg.equal(this.f4962a, advertisingOptions.f4962a) && zzbg.equal(Boolean.valueOf(this.b), Boolean.valueOf(advertisingOptions.b)) && zzbg.equal(Boolean.valueOf(this.c), Boolean.valueOf(advertisingOptions.c)) && zzbg.equal(Boolean.valueOf(this.d), Boolean.valueOf(advertisingOptions.d)) && zzbg.equal(Boolean.valueOf(this.e), Boolean.valueOf(advertisingOptions.e)) && Arrays.equals(this.f, advertisingOptions.f)) {
                return true;
            }
        }
        return false;
    }

    public final Strategy getStrategy() {
        return this.f4962a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4962a, Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), Integer.valueOf(Arrays.hashCode(this.f))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, getStrategy(), i, false);
        zzbgo.zza(parcel, 2, this.b);
        zzbgo.zza(parcel, 3, this.c);
        zzbgo.zza(parcel, 4, this.d);
        zzbgo.zza(parcel, 5, this.e);
        zzbgo.zza(parcel, 6, this.f, false);
        zzbgo.zzai(parcel, zze);
    }
}
