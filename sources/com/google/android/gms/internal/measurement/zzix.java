package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzix {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4579a = 11;
    private static final int b = 12;
    private static final int c = 16;
    private static final int d = 26;
    private static final int[] e = new int[0];
    private static final long[] f = new long[0];
    private static final float[] g = new float[0];
    private static final double[] h = new double[0];
    private static final boolean[] i = new boolean[0];
    private static final String[] j = new String[0];
    private static final byte[][] k = new byte[0];
    public static final byte[] zzaph = new byte[0];

    public static final int zzb(zzil zzilVar, int i2) throws IOException {
        int position = zzilVar.getPosition();
        zzilVar.zzau(i2);
        int i3 = 1;
        while (zzilVar.zzsg() == i2) {
            zzilVar.zzau(i2);
            i3++;
        }
        zzilVar.a(position, i2);
        return i3;
    }
}
