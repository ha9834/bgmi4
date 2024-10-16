package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class zzrd implements zzrm {

    /* renamed from: a, reason: collision with root package name */
    private final zzra f3718a;
    private final int b;
    private final int[] c;
    private final zzlh[] d;
    private final long[] e;
    private int f;

    public zzrd(zzra zzraVar, int... iArr) {
        int i = 0;
        zzsk.checkState(iArr.length > 0);
        this.f3718a = (zzra) zzsk.checkNotNull(zzraVar);
        this.b = iArr.length;
        this.d = new zzlh[this.b];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = zzraVar.zzbf(iArr[i2]);
        }
        Arrays.sort(this.d, new anr());
        this.c = new int[this.b];
        while (true) {
            int i3 = this.b;
            if (i < i3) {
                this.c[i] = zzraVar.zzh(this.d[i]);
                i++;
            } else {
                this.e = new long[i3];
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final zzra zzjr() {
        return this.f3718a;
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final int length() {
        return this.c.length;
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final zzlh zzbf(int i) {
        return this.d[i];
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final int zzbh(int i) {
        return this.c[0];
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = (System.identityHashCode(this.f3718a) * 31) + Arrays.hashCode(this.c);
        }
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzrd zzrdVar = (zzrd) obj;
        return this.f3718a == zzrdVar.f3718a && Arrays.equals(this.c, zzrdVar.c);
    }
}
