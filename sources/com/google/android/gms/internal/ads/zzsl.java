package com.google.android.gms.internal.ads;

import android.util.Pair;

/* loaded from: classes2.dex */
public final class zzsl {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3731a = {0, 0, 0, 1};
    private static final int[] b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> zzf(byte[] bArr) {
        zzss zzssVar = new zzss(bArr);
        int a2 = a(zzssVar);
        int b2 = b(zzssVar);
        int zzbn = zzssVar.zzbn(4);
        if (a2 == 5 || a2 == 29) {
            b2 = b(zzssVar);
            if (a(zzssVar) == 22) {
                zzbn = zzssVar.zzbn(4);
            }
        }
        int i = c[zzbn];
        zzsk.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(b2), Integer.valueOf(i));
    }

    public static byte[] zza(byte[] bArr, int i, int i2) {
        byte[] bArr2 = f3731a;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, f3731a.length, i2);
        return bArr3;
    }

    private static int a(zzss zzssVar) {
        int zzbn = zzssVar.zzbn(5);
        return zzbn == 31 ? zzssVar.zzbn(6) + 32 : zzbn;
    }

    private static int b(zzss zzssVar) {
        int zzbn = zzssVar.zzbn(4);
        if (zzbn == 15) {
            return zzssVar.zzbn(24);
        }
        zzsk.checkArgument(zzbn < 13);
        return b[zzbn];
    }
}
