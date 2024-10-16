package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcui extends zzbgl {
    public static final Parcelable.Creator<zzcui> CREATOR = new zzcuj();

    /* renamed from: a, reason: collision with root package name */
    private zzcst f4702a;
    private String[] b;
    private zzcub c;
    private boolean d;

    private zzcui() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @com.google.android.gms.common.internal.Hide
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcui(android.os.IBinder r3, java.lang.String[] r4, com.google.android.gms.internal.zzcub r5, boolean r6) {
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
            r2.<init>(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcui.<init>(android.os.IBinder, java.lang.String[], com.google.android.gms.internal.zzcub, boolean):void");
    }

    private zzcui(zzcst zzcstVar, String[] strArr, zzcub zzcubVar, boolean z) {
        this.f4702a = zzcstVar;
        this.b = strArr;
        this.c = zzcubVar;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcui) {
            zzcui zzcuiVar = (zzcui) obj;
            if (zzbg.equal(this.f4702a, zzcuiVar.f4702a) && Arrays.equals(this.b, zzcuiVar.b) && zzbg.equal(this.c, zzcuiVar.c) && zzbg.equal(Boolean.valueOf(this.d), Boolean.valueOf(zzcuiVar.d))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4702a, Integer.valueOf(Arrays.hashCode(this.b)), this.c, Boolean.valueOf(this.d)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzcst zzcstVar = this.f4702a;
        zzbgo.zza(parcel, 1, zzcstVar == null ? null : zzcstVar.asBinder(), false);
        zzbgo.zza(parcel, 2, this.b, false);
        zzbgo.zza(parcel, 3, this.c, i, false);
        zzbgo.zza(parcel, 4, this.d);
        zzbgo.zzai(parcel, zze);
    }
}
