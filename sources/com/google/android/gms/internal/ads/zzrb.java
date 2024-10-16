package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzrb {
    public static final zzrb zzbkw = new zzrb(new zzra[0]);

    /* renamed from: a, reason: collision with root package name */
    private final zzra[] f3717a;
    private int b;
    public final int length;

    public zzrb(zzra... zzraVarArr) {
        this.f3717a = zzraVarArr;
        this.length = zzraVarArr.length;
    }

    public final zzra zzbg(int i) {
        return this.f3717a[i];
    }

    public final int zza(zzra zzraVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.f3717a[i] == zzraVar) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.b == 0) {
            this.b = Arrays.hashCode(this.f3717a);
        }
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzrb zzrbVar = (zzrb) obj;
        return this.length == zzrbVar.length && Arrays.equals(this.f3717a, zzrbVar.f3717a);
    }
}
