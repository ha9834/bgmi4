package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcuk extends zzbgl {
    public static final Parcelable.Creator<zzcuk> CREATOR = new zzcul();

    /* renamed from: a, reason: collision with root package name */
    private zzcsw f4703a;
    private zzcrx b;
    private String c;
    private String d;
    private long e;
    private AdvertisingOptions f;
    private zzcsd g;

    private zzcuk() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.zzcsw] */
    @com.google.android.gms.common.internal.Hide
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcuk(android.os.IBinder r15, android.os.IBinder r16, java.lang.String r17, java.lang.String r18, long r19, com.google.android.gms.nearby.connection.AdvertisingOptions r21, android.os.IBinder r22) {
        /*
            r14 = this;
            r0 = r15
            r1 = r16
            r2 = r22
            r3 = 0
            if (r0 != 0) goto La
            r6 = r3
            goto L1f
        La:
            java.lang.String r4 = "com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener"
            android.os.IInterface r4 = r15.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.zzcsw
            if (r5 == 0) goto L19
            r0 = r4
            com.google.android.gms.internal.zzcsw r0 = (com.google.android.gms.internal.zzcsw) r0
            r6 = r0
            goto L1f
        L19:
            com.google.android.gms.internal.zzcsy r4 = new com.google.android.gms.internal.zzcsy
            r4.<init>(r15)
            r6 = r4
        L1f:
            if (r1 != 0) goto L23
            r7 = r3
            goto L36
        L23:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IAdvertisingCallback"
            android.os.IInterface r0 = r1.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.android.gms.internal.zzcrx
            if (r4 == 0) goto L30
            com.google.android.gms.internal.zzcrx r0 = (com.google.android.gms.internal.zzcrx) r0
            goto L35
        L30:
            com.google.android.gms.internal.zzcrz r0 = new com.google.android.gms.internal.zzcrz
            r0.<init>(r1)
        L35:
            r7 = r0
        L36:
            if (r2 != 0) goto L3a
        L38:
            r13 = r3
            goto L4e
        L3a:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.zzcsd
            if (r1 == 0) goto L48
            r3 = r0
            com.google.android.gms.internal.zzcsd r3 = (com.google.android.gms.internal.zzcsd) r3
            goto L38
        L48:
            com.google.android.gms.internal.zzcsf r3 = new com.google.android.gms.internal.zzcsf
            r3.<init>(r2)
            goto L38
        L4e:
            r5 = r14
            r8 = r17
            r9 = r18
            r10 = r19
            r12 = r21
            r5.<init>(r6, r7, r8, r9, r10, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcuk.<init>(android.os.IBinder, android.os.IBinder, java.lang.String, java.lang.String, long, com.google.android.gms.nearby.connection.AdvertisingOptions, android.os.IBinder):void");
    }

    private zzcuk(zzcsw zzcswVar, zzcrx zzcrxVar, String str, String str2, long j, AdvertisingOptions advertisingOptions, zzcsd zzcsdVar) {
        this.f4703a = zzcswVar;
        this.b = zzcrxVar;
        this.c = str;
        this.d = str2;
        this.e = j;
        this.f = advertisingOptions;
        this.g = zzcsdVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcuk) {
            zzcuk zzcukVar = (zzcuk) obj;
            if (zzbg.equal(this.f4703a, zzcukVar.f4703a) && zzbg.equal(this.b, zzcukVar.b) && zzbg.equal(this.c, zzcukVar.c) && zzbg.equal(this.d, zzcukVar.d) && zzbg.equal(Long.valueOf(this.e), Long.valueOf(zzcukVar.e)) && zzbg.equal(this.f, zzcukVar.f) && zzbg.equal(this.g, zzcukVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4703a, this.b, this.c, this.d, Long.valueOf(this.e), this.f, this.g});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzcsw zzcswVar = this.f4703a;
        zzbgo.zza(parcel, 1, zzcswVar == null ? null : zzcswVar.asBinder(), false);
        zzcrx zzcrxVar = this.b;
        zzbgo.zza(parcel, 2, zzcrxVar == null ? null : zzcrxVar.asBinder(), false);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 4, this.d, false);
        zzbgo.zza(parcel, 5, this.e);
        zzbgo.zza(parcel, 6, this.f, i, false);
        zzcsd zzcsdVar = this.g;
        zzbgo.zza(parcel, 7, zzcsdVar != null ? zzcsdVar.asBinder() : null, false);
        zzbgo.zzai(parcel, zze);
    }
}
