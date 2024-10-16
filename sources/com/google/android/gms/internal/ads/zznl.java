package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zznl implements zznu {

    /* renamed from: a, reason: collision with root package name */
    private final int f3693a;
    private final int[] b;
    private final long[] c;
    private final long[] d;
    private final long[] e;
    private final long f;

    public zznl(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        this.f3693a = iArr.length;
        int i = this.f3693a;
        if (i > 0) {
            this.f = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.f = 0L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final boolean zzfc() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final long getDurationUs() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final long zzdq(long j) {
        return this.c[zzsy.zza(this.e, j, true, true)];
    }
}
