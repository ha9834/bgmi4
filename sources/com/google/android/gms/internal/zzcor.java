package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcor extends zzbgl {
    public static final Parcelable.Creator<zzcor> CREATOR = new zzcos();

    /* renamed from: a, reason: collision with root package name */
    private zzcst f4682a;
    private long b;

    private zzcor() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @com.google.android.gms.common.internal.Hide
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcor(android.os.IBinder r3, long r4) {
        /*
            r2 = this;
            if (r3 != 0) goto L4
            r3 = 0
            goto L18
        L4:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IResultListener"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.zzcst
            if (r1 == 0) goto L12
            r3 = r0
            com.google.android.gms.internal.zzcst r3 = (com.google.android.gms.internal.zzcst) r3
            goto L18
        L12:
            com.google.android.gms.internal.zzcsv r0 = new com.google.android.gms.internal.zzcsv
            r0.<init>(r3)
            r3 = r0
        L18:
            r2.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcor.<init>(android.os.IBinder, long):void");
    }

    private zzcor(zzcst zzcstVar, long j) {
        this.f4682a = zzcstVar;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcor) {
            zzcor zzcorVar = (zzcor) obj;
            if (zzbg.equal(this.f4682a, zzcorVar.f4682a) && zzbg.equal(Long.valueOf(this.b), Long.valueOf(zzcorVar.b))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4682a, Long.valueOf(this.b)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzcst zzcstVar = this.f4682a;
        zzbgo.zza(parcel, 1, zzcstVar == null ? null : zzcstVar.asBinder(), false);
        zzbgo.zza(parcel, 2, this.b);
        zzbgo.zzai(parcel, zze);
    }
}
