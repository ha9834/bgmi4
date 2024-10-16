package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzra {

    /* renamed from: a, reason: collision with root package name */
    private final zzlh[] f3716a;
    private int b;
    public final int length;

    public zzra(zzlh... zzlhVarArr) {
        zzsk.checkState(zzlhVarArr.length > 0);
        this.f3716a = zzlhVarArr;
        this.length = zzlhVarArr.length;
    }

    public final zzlh zzbf(int i) {
        return this.f3716a[i];
    }

    public final int zzh(zzlh zzlhVar) {
        int i = 0;
        while (true) {
            zzlh[] zzlhVarArr = this.f3716a;
            if (i >= zzlhVarArr.length) {
                return -1;
            }
            if (zzlhVar == zzlhVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final int hashCode() {
        if (this.b == 0) {
            this.b = Arrays.hashCode(this.f3716a) + 527;
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
        zzra zzraVar = (zzra) obj;
        return this.length == zzraVar.length && Arrays.equals(this.f3716a, zzraVar.f3716a);
    }
}
