package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcop extends zzbgl {
    public static final Parcelable.Creator<zzcop> CREATOR = new zzcoq();

    /* renamed from: a, reason: collision with root package name */
    private zzcst f4681a;
    private zzcsa b;
    private String c;
    private byte[] d;
    private zzcsq e;

    private zzcop() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.google.android.gms.internal.zzcst] */
    @com.google.android.gms.common.internal.Hide
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcop(android.os.IBinder r9, android.os.IBinder r10, java.lang.String r11, byte[] r12, android.os.IBinder r13) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L5
            r3 = r0
            goto L1a
        L5:
            java.lang.String r1 = "com.google.android.gms.nearby.internal.connection.IResultListener"
            android.os.IInterface r1 = r9.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.zzcst
            if (r2 == 0) goto L14
            r9 = r1
            com.google.android.gms.internal.zzcst r9 = (com.google.android.gms.internal.zzcst) r9
            r3 = r9
            goto L1a
        L14:
            com.google.android.gms.internal.zzcsv r1 = new com.google.android.gms.internal.zzcsv
            r1.<init>(r9)
            r3 = r1
        L1a:
            if (r10 != 0) goto L1e
            r4 = r0
            goto L31
        L1e:
            java.lang.String r9 = "com.google.android.gms.nearby.internal.connection.IConnectionEventListener"
            android.os.IInterface r9 = r10.queryLocalInterface(r9)
            boolean r1 = r9 instanceof com.google.android.gms.internal.zzcsa
            if (r1 == 0) goto L2b
            com.google.android.gms.internal.zzcsa r9 = (com.google.android.gms.internal.zzcsa) r9
            goto L30
        L2b:
            com.google.android.gms.internal.zzcsc r9 = new com.google.android.gms.internal.zzcsc
            r9.<init>(r10)
        L30:
            r4 = r9
        L31:
            if (r13 != 0) goto L35
        L33:
            r7 = r0
            goto L49
        L35:
            java.lang.String r9 = "com.google.android.gms.nearby.internal.connection.IPayloadListener"
            android.os.IInterface r9 = r13.queryLocalInterface(r9)
            boolean r10 = r9 instanceof com.google.android.gms.internal.zzcsq
            if (r10 == 0) goto L43
            r0 = r9
            com.google.android.gms.internal.zzcsq r0 = (com.google.android.gms.internal.zzcsq) r0
            goto L33
        L43:
            com.google.android.gms.internal.zzcss r0 = new com.google.android.gms.internal.zzcss
            r0.<init>(r13)
            goto L33
        L49:
            r2 = r8
            r5 = r11
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcop.<init>(android.os.IBinder, android.os.IBinder, java.lang.String, byte[], android.os.IBinder):void");
    }

    private zzcop(zzcst zzcstVar, zzcsa zzcsaVar, String str, byte[] bArr, zzcsq zzcsqVar) {
        this.f4681a = zzcstVar;
        this.b = zzcsaVar;
        this.c = str;
        this.d = bArr;
        this.e = zzcsqVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcop) {
            zzcop zzcopVar = (zzcop) obj;
            if (zzbg.equal(this.f4681a, zzcopVar.f4681a) && zzbg.equal(this.b, zzcopVar.b) && zzbg.equal(this.c, zzcopVar.c) && Arrays.equals(this.d, zzcopVar.d) && zzbg.equal(this.e, zzcopVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4681a, this.b, this.c, Integer.valueOf(Arrays.hashCode(this.d)), this.e});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzcst zzcstVar = this.f4681a;
        zzbgo.zza(parcel, 1, zzcstVar == null ? null : zzcstVar.asBinder(), false);
        zzcsa zzcsaVar = this.b;
        zzbgo.zza(parcel, 2, zzcsaVar == null ? null : zzcsaVar.asBinder(), false);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 4, this.d, false);
        zzcsq zzcsqVar = this.e;
        zzbgo.zza(parcel, 5, zzcsqVar != null ? zzcsqVar.asBinder() : null, false);
        zzbgo.zzai(parcel, zze);
    }
}
