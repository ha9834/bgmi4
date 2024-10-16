package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.tencent.abase.utils.ConstantUtils;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class Strategy extends zzbgl {

    /* renamed from: a, reason: collision with root package name */
    private final int f4976a;
    private final int b;

    @Hide
    public static final Parcelable.Creator<Strategy> CREATOR = new zzj();
    public static final Strategy P2P_CLUSTER = new Strategy(1, 3);
    public static final Strategy P2P_STAR = new Strategy(1, 2);
    public static final Strategy P2P_POINT_TO_POINT = new Strategy(1, 1);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Hide
    public Strategy(int i, int i2) {
        this.f4976a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.f4976a == strategy.f4976a && this.b == strategy.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4976a), Integer.valueOf(this.b)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        objArr[0] = P2P_CLUSTER.equals(this) ? "P2P_CLUSTER" : P2P_STAR.equals(this) ? "P2P_STAR" : P2P_POINT_TO_POINT.equals(this) ? "P2P_POINT_TO_POINT" : ConstantUtils.NET_UNKNOWN;
        objArr[1] = Integer.valueOf(this.f4976a);
        objArr[2] = Integer.valueOf(this.b);
        return String.format(locale, "Strategy(%s){connectionType=%d, topology=%d}", objArr);
    }

    @Hide
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 3, this.f4976a);
        zzbgo.zzc(parcel, 4, this.b);
        zzbgo.zzai(parcel, zze);
    }
}
