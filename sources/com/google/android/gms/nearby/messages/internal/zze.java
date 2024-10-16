package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.nearby.messages.Distance;
import com.tencent.abase.utils.ConstantUtils;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class zze extends zzbgl implements Distance {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    private int f5033a;
    private int b;
    private double c;

    public zze(int i, double d) {
        this(1, 1, Double.NaN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(int i, int i2, double d) {
        this.f5033a = i;
        this.b = i2;
        this.c = d;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public final int compareTo(Distance distance) {
        if (Double.isNaN(getMeters()) && Double.isNaN(distance.getMeters())) {
            return 0;
        }
        return Double.compare(getMeters(), distance.getMeters());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return getAccuracy() == zzeVar.getAccuracy() && compareTo((Distance) zzeVar) == 0;
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final int getAccuracy() {
        return this.b;
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final double getMeters() {
        return this.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getAccuracy()), Double.valueOf(getMeters())});
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = Double.valueOf(this.c);
        objArr[1] = this.b != 1 ? ConstantUtils.NET_UNKNOWN : "LOW";
        return String.format(locale, "(%.1fm, %s)", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f5033a);
        zzbgo.zzc(parcel, 2, this.b);
        zzbgo.zza(parcel, 3, this.c);
        zzbgo.zzai(parcel, zze);
    }
}
