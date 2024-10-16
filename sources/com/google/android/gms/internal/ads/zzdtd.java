package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzdtd {

    /* renamed from: a, reason: collision with root package name */
    private final double f3617a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double g;
    private final double h;
    private final double i;
    public static final zzdtd zzhuc = new zzdtd(1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final zzdtd j = new zzdtd(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, -1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final zzdtd k = new zzdtd(-1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, -1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final zzdtd l = new zzdtd(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, -1.0d, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);

    private zzdtd(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f3617a = d5;
        this.b = d6;
        this.c = d7;
        this.d = d;
        this.e = d2;
        this.f = d3;
        this.g = d4;
        this.h = d8;
        this.i = d9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzdtd zzdtdVar = (zzdtd) obj;
        return Double.compare(zzdtdVar.d, this.d) == 0 && Double.compare(zzdtdVar.e, this.e) == 0 && Double.compare(zzdtdVar.f, this.f) == 0 && Double.compare(zzdtdVar.g, this.g) == 0 && Double.compare(zzdtdVar.h, this.h) == 0 && Double.compare(zzdtdVar.i, this.i) == 0 && Double.compare(zzdtdVar.f3617a, this.f3617a) == 0 && Double.compare(zzdtdVar.b, this.b) == 0 && Double.compare(zzdtdVar.c, this.c) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f3617a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        int i = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.c);
        int i2 = (i * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.d);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.e);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.f);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.g);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.h);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.i);
        return (i7 * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zzhuc)) {
            return "Rotate 0°";
        }
        if (equals(j)) {
            return "Rotate 90°";
        }
        if (equals(k)) {
            return "Rotate 180°";
        }
        if (equals(l)) {
            return "Rotate 270°";
        }
        double d = this.f3617a;
        double d2 = this.b;
        double d3 = this.c;
        double d4 = this.d;
        double d5 = this.e;
        double d6 = this.f;
        double d7 = this.g;
        double d8 = this.h;
        double d9 = this.i;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d7);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }

    public static zzdtd zzp(ByteBuffer byteBuffer) {
        double zzd = zzbc.zzd(byteBuffer);
        double zzd2 = zzbc.zzd(byteBuffer);
        double zze = zzbc.zze(byteBuffer);
        return new zzdtd(zzd, zzd2, zzbc.zzd(byteBuffer), zzbc.zzd(byteBuffer), zze, zzbc.zze(byteBuffer), zzbc.zze(byteBuffer), zzbc.zzd(byteBuffer), zzbc.zzd(byteBuffer));
    }
}
