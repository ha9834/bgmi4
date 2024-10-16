package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbk;

/* loaded from: classes2.dex */
final /* synthetic */ class ha {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f4901a;
    static final /* synthetic */ int[] b = new int[zzbk.zzc.zzb.values().length];

    static {
        try {
            b[zzbk.zzc.zzb.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[zzbk.zzc.zzb.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[zzbk.zzc.zzb.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[zzbk.zzc.zzb.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f4901a = new int[zzbk.zze.zza.values().length];
        try {
            f4901a[zzbk.zze.zza.REGEXP.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f4901a[zzbk.zze.zza.BEGINS_WITH.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f4901a[zzbk.zze.zza.ENDS_WITH.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f4901a[zzbk.zze.zza.PARTIAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f4901a[zzbk.zze.zza.EXACT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f4901a[zzbk.zze.zza.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
