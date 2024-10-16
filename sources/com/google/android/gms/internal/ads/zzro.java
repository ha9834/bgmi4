package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzro {

    /* renamed from: a, reason: collision with root package name */
    private final zzrm[] f3723a;
    private int b;
    public final int length;

    public zzro(zzrm... zzrmVarArr) {
        this.f3723a = zzrmVarArr;
        this.length = zzrmVarArr.length;
    }

    public final zzrm zzbi(int i) {
        return this.f3723a[i];
    }

    public final zzrm[] zzjs() {
        return (zzrm[]) this.f3723a.clone();
    }

    public final int hashCode() {
        if (this.b == 0) {
            this.b = Arrays.hashCode(this.f3723a) + 527;
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
        return Arrays.equals(this.f3723a, ((zzro) obj).f3723a);
    }
}
