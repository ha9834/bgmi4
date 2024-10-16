package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzuz {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4461a = 11;
    private static final int b = 12;
    private static final int c = 16;
    private static final int d = 26;
    public static final int[] zzbcw = new int[0];
    private static final long[] e = new long[0];
    private static final float[] f = new float[0];
    private static final double[] g = new double[0];
    private static final boolean[] h = new boolean[0];
    public static final String[] zzbhu = new String[0];
    private static final byte[][] i = new byte[0];
    public static final byte[] zzbhw = new byte[0];

    public static final int zzb(zzun zzunVar, int i2) throws IOException {
        int position = zzunVar.getPosition();
        zzunVar.zzao(i2);
        int i3 = 1;
        while (zzunVar.zzni() == i2) {
            zzunVar.zzao(i2);
            i3++;
        }
        zzunVar.a(position, i2);
        return i3;
    }
}
