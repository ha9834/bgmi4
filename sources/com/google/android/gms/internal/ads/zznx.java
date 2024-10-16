package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zznx {
    public final int zzazp = 1;
    public final byte[] zzazq;

    public zznx(int i, byte[] bArr) {
        this.zzazq = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zznx zznxVar = (zznx) obj;
        return this.zzazp == zznxVar.zzazp && Arrays.equals(this.zzazq, zznxVar.zzazq);
    }

    public final int hashCode() {
        return (this.zzazp * 31) + Arrays.hashCode(this.zzazq);
    }
}
