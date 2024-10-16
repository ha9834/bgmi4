package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzpy implements zzqx {

    /* renamed from: a, reason: collision with root package name */
    private final zzqx[] f3710a;

    public zzpy(zzqx[] zzqxVarArr) {
        this.f3710a = zzqxVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzqx
    public final long zzix() {
        long j = Long.MAX_VALUE;
        for (zzqx zzqxVar : this.f3710a) {
            long zzix = zzqxVar.zzix();
            if (zzix != Long.MIN_VALUE) {
                j = Math.min(j, zzix);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzqx
    public final boolean zzel(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzix = zzix();
            if (zzix == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzqx zzqxVar : this.f3710a) {
                if (zzqxVar.zzix() == zzix) {
                    z |= zzqxVar.zzel(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
