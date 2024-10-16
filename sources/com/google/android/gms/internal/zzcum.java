package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcum extends zzbgl {
    public static final Parcelable.Creator<zzcum> CREATOR = new zzcun();

    /* renamed from: a, reason: collision with root package name */
    private zzcst f4704a;
    private zzcsj b;
    private String c;
    private long d;
    private DiscoveryOptions e;
    private zzcsl f;

    private zzcum() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.zzcst] */
    @com.google.android.gms.common.internal.Hide
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcum(android.os.IBinder r14, android.os.IBinder r15, java.lang.String r16, long r17, com.google.android.gms.nearby.connection.DiscoveryOptions r19, android.os.IBinder r20) {
        /*
            r13 = this;
            r0 = r14
            r1 = r15
            r2 = r20
            r3 = 0
            if (r0 != 0) goto L9
            r6 = r3
            goto L1e
        L9:
            java.lang.String r4 = "com.google.android.gms.nearby.internal.connection.IResultListener"
            android.os.IInterface r4 = r14.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.zzcst
            if (r5 == 0) goto L18
            r0 = r4
            com.google.android.gms.internal.zzcst r0 = (com.google.android.gms.internal.zzcst) r0
            r6 = r0
            goto L1e
        L18:
            com.google.android.gms.internal.zzcsv r4 = new com.google.android.gms.internal.zzcsv
            r4.<init>(r14)
            r6 = r4
        L1e:
            if (r1 != 0) goto L22
            r7 = r3
            goto L35
        L22:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IDiscoveryCallback"
            android.os.IInterface r0 = r15.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.android.gms.internal.zzcsj
            if (r4 == 0) goto L2f
            com.google.android.gms.internal.zzcsj r0 = (com.google.android.gms.internal.zzcsj) r0
            goto L34
        L2f:
            com.google.android.gms.internal.zzcsk r0 = new com.google.android.gms.internal.zzcsk
            r0.<init>(r15)
        L34:
            r7 = r0
        L35:
            if (r2 != 0) goto L39
        L37:
            r12 = r3
            goto L4d
        L39:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IDiscoveryListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.zzcsl
            if (r1 == 0) goto L47
            r3 = r0
            com.google.android.gms.internal.zzcsl r3 = (com.google.android.gms.internal.zzcsl) r3
            goto L37
        L47:
            com.google.android.gms.internal.zzcsn r3 = new com.google.android.gms.internal.zzcsn
            r3.<init>(r2)
            goto L37
        L4d:
            r5 = r13
            r8 = r16
            r9 = r17
            r11 = r19
            r5.<init>(r6, r7, r8, r9, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcum.<init>(android.os.IBinder, android.os.IBinder, java.lang.String, long, com.google.android.gms.nearby.connection.DiscoveryOptions, android.os.IBinder):void");
    }

    private zzcum(zzcst zzcstVar, zzcsj zzcsjVar, String str, long j, DiscoveryOptions discoveryOptions, zzcsl zzcslVar) {
        this.f4704a = zzcstVar;
        this.b = zzcsjVar;
        this.c = str;
        this.d = j;
        this.e = discoveryOptions;
        this.f = zzcslVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcum) {
            zzcum zzcumVar = (zzcum) obj;
            if (zzbg.equal(this.f4704a, zzcumVar.f4704a) && zzbg.equal(this.b, zzcumVar.b) && zzbg.equal(this.c, zzcumVar.c) && zzbg.equal(Long.valueOf(this.d), Long.valueOf(zzcumVar.d)) && zzbg.equal(this.e, zzcumVar.e) && zzbg.equal(this.f, zzcumVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4704a, this.b, this.c, Long.valueOf(this.d), this.e, this.f});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzcst zzcstVar = this.f4704a;
        zzbgo.zza(parcel, 1, zzcstVar == null ? null : zzcstVar.asBinder(), false);
        zzcsj zzcsjVar = this.b;
        zzbgo.zza(parcel, 2, zzcsjVar == null ? null : zzcsjVar.asBinder(), false);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 4, this.d);
        zzbgo.zza(parcel, 5, this.e, i, false);
        zzcsl zzcslVar = this.f;
        zzbgo.zza(parcel, 6, zzcslVar != null ? zzcslVar.asBinder() : null, false);
        zzbgo.zzai(parcel, zze);
    }
}
