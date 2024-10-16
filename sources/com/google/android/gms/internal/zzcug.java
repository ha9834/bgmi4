package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcug extends zzbgl {
    public static final Parcelable.Creator<zzcug> CREATOR = new zzcuh();

    /* renamed from: a, reason: collision with root package name */
    private zzcst f4701a;
    private zzcsa b;
    private zzcsg c;
    private String d;
    private String e;
    private byte[] f;
    private zzcsd g;

    private zzcug() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.zzcst] */
    @com.google.android.gms.common.internal.Hide
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcug(android.os.IBinder r15, android.os.IBinder r16, android.os.IBinder r17, java.lang.String r18, java.lang.String r19, byte[] r20, android.os.IBinder r21) {
        /*
            r14 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r21
            r4 = 0
            if (r0 != 0) goto Lc
            r7 = r4
            goto L21
        Lc:
            java.lang.String r5 = "com.google.android.gms.nearby.internal.connection.IResultListener"
            android.os.IInterface r5 = r15.queryLocalInterface(r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.zzcst
            if (r6 == 0) goto L1b
            r0 = r5
            com.google.android.gms.internal.zzcst r0 = (com.google.android.gms.internal.zzcst) r0
            r7 = r0
            goto L21
        L1b:
            com.google.android.gms.internal.zzcsv r5 = new com.google.android.gms.internal.zzcsv
            r5.<init>(r15)
            r7 = r5
        L21:
            if (r1 != 0) goto L25
            r8 = r4
            goto L38
        L25:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IConnectionEventListener"
            android.os.IInterface r0 = r1.queryLocalInterface(r0)
            boolean r5 = r0 instanceof com.google.android.gms.internal.zzcsa
            if (r5 == 0) goto L32
            com.google.android.gms.internal.zzcsa r0 = (com.google.android.gms.internal.zzcsa) r0
            goto L37
        L32:
            com.google.android.gms.internal.zzcsc r0 = new com.google.android.gms.internal.zzcsc
            r0.<init>(r1)
        L37:
            r8 = r0
        L38:
            if (r2 != 0) goto L3c
            r9 = r4
            goto L4f
        L3c:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IConnectionResponseListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.zzcsg
            if (r1 == 0) goto L49
            com.google.android.gms.internal.zzcsg r0 = (com.google.android.gms.internal.zzcsg) r0
            goto L4e
        L49:
            com.google.android.gms.internal.zzcsi r0 = new com.google.android.gms.internal.zzcsi
            r0.<init>(r2)
        L4e:
            r9 = r0
        L4f:
            if (r3 != 0) goto L53
        L51:
            r13 = r4
            goto L67
        L53:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.zzcsd
            if (r1 == 0) goto L61
            r4 = r0
            com.google.android.gms.internal.zzcsd r4 = (com.google.android.gms.internal.zzcsd) r4
            goto L51
        L61:
            com.google.android.gms.internal.zzcsf r4 = new com.google.android.gms.internal.zzcsf
            r4.<init>(r3)
            goto L51
        L67:
            r6 = r14
            r10 = r18
            r11 = r19
            r12 = r20
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcug.<init>(android.os.IBinder, android.os.IBinder, android.os.IBinder, java.lang.String, java.lang.String, byte[], android.os.IBinder):void");
    }

    private zzcug(zzcst zzcstVar, zzcsa zzcsaVar, zzcsg zzcsgVar, String str, String str2, byte[] bArr, zzcsd zzcsdVar) {
        this.f4701a = zzcstVar;
        this.b = zzcsaVar;
        this.c = zzcsgVar;
        this.d = str;
        this.e = str2;
        this.f = bArr;
        this.g = zzcsdVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcug) {
            zzcug zzcugVar = (zzcug) obj;
            if (zzbg.equal(this.f4701a, zzcugVar.f4701a) && zzbg.equal(this.b, zzcugVar.b) && zzbg.equal(this.c, zzcugVar.c) && zzbg.equal(this.d, zzcugVar.d) && zzbg.equal(this.e, zzcugVar.e) && Arrays.equals(this.f, zzcugVar.f) && zzbg.equal(this.g, zzcugVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4701a, this.b, this.c, this.d, this.e, Integer.valueOf(Arrays.hashCode(this.f)), this.g});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzcst zzcstVar = this.f4701a;
        zzbgo.zza(parcel, 1, zzcstVar == null ? null : zzcstVar.asBinder(), false);
        zzcsa zzcsaVar = this.b;
        zzbgo.zza(parcel, 2, zzcsaVar == null ? null : zzcsaVar.asBinder(), false);
        zzcsg zzcsgVar = this.c;
        zzbgo.zza(parcel, 3, zzcsgVar == null ? null : zzcsgVar.asBinder(), false);
        zzbgo.zza(parcel, 4, this.d, false);
        zzbgo.zza(parcel, 5, this.e, false);
        zzbgo.zza(parcel, 6, this.f, false);
        zzcsd zzcsdVar = this.g;
        zzbgo.zza(parcel, 7, zzcsdVar != null ? zzcsdVar.asBinder() : null, false);
        zzbgo.zzai(parcel, zze);
    }
}
