package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class amu {

    /* renamed from: a, reason: collision with root package name */
    public final int f1977a;
    public final long[] b;
    public final int[] c;
    public final int d;
    public final long[] e;
    public final int[] f;

    public amu(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        zzsk.checkArgument(iArr.length == jArr2.length);
        zzsk.checkArgument(jArr.length == jArr2.length);
        zzsk.checkArgument(iArr2.length == jArr2.length);
        this.b = jArr;
        this.c = iArr;
        this.d = i;
        this.e = jArr2;
        this.f = iArr2;
        this.f1977a = jArr.length;
    }

    public final int a(long j) {
        for (int zza = zzsy.zza(this.e, j, true, false); zza >= 0; zza--) {
            if ((this.f[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int b(long j) {
        for (int zzb = zzsy.zzb(this.e, j, true, false); zzb < this.e.length; zzb++) {
            if ((this.f[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
