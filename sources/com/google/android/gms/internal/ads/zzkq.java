package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzkq {
    public static final int SDK_INT = Build.VERSION.SDK_INT;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f3674a = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
    private static final Pattern b = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    public static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static ExecutorService zzax(String str) {
        return Executors.newSingleThreadExecutor(new akt(str));
    }

    public static int zzb(int i, int i2) {
        return ((i2 + 0) - 1) / i2;
    }

    public static int zza(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        }
        return z2 ? Math.max(0, binarySearch) : binarySearch;
    }

    public static int zzb(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        return binarySearch < 0 ? binarySearch ^ (-1) : binarySearch;
    }

    public static long zza(long j, long j2, long j3) {
        if (j3 >= 1000000 && j3 % 1000000 == 0) {
            return j / (j3 / 1000000);
        }
        if (j3 < 1000000 && 1000000 % j3 == 0) {
            return j * (1000000 / j3);
        }
        double d = j3;
        Double.isNaN(d);
        double d2 = j;
        Double.isNaN(d2);
        return (long) (d2 * (1000000.0d / d));
    }

    public static void zza(long[] jArr, long j, long j2) {
        int i = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
            return;
        }
        if (j2 < 1000000 && 1000000 % j2 == 0) {
            long j4 = 1000000 / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j4;
                i++;
            }
            return;
        }
        double d = j2;
        Double.isNaN(d);
        double d2 = 1000000.0d / d;
        while (i < jArr.length) {
            double d3 = jArr[i];
            Double.isNaN(d3);
            jArr[i] = (long) (d3 * d2);
            i++;
        }
    }

    public static int zzay(String str) {
        int length = str.length();
        zzkh.checkArgument(length <= 4);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i << 8) | str.charAt(i2);
        }
        return i;
    }
}
