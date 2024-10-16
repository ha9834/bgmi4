package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzia implements zzio {

    /* renamed from: a, reason: collision with root package name */
    private final int f3653a;
    private final int[] b;
    private final long[] c;
    private final long[] d;
    private final long[] e;

    public zzia(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f3653a = iArr.length;
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final boolean zzfc() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final long zzdq(long j) {
        return this.c[zzkq.zza(this.e, j, true, true)];
    }
}
