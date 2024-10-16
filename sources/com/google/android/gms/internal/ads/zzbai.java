package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzbai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbai> CREATOR = new zzbaj();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 6)
    private boolean f2848a;

    @SafeParcelable.Field(id = 2)
    public String zzbsx;

    @SafeParcelable.Field(id = 3)
    public int zzdzc;

    @SafeParcelable.Field(id = 4)
    public int zzdzd;

    @SafeParcelable.Field(id = 5)
    public boolean zzdze;

    public zzbai(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzbai(int i, int i2, boolean z, boolean z2) {
        this(i, i2, true, false, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private zzbai(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L5
            java.lang.String r11 = "0"
            goto L7
        L5:
            java.lang.String r11 = "1"
        L7:
            java.lang.String r12 = java.lang.String.valueOf(r11)
            int r12 = r12.length()
            int r12 = r12 + 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r11)
            java.lang.String r2 = r0.toString()
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbai.<init>(int, int, boolean, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbai(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) boolean z2) {
        this.zzbsx = str;
        this.zzdzc = i;
        this.zzdzd = i2;
        this.zzdze = z;
        this.f2848a = z2;
    }

    public static zzbai zzxc() {
        return new zzbai(12451009, 12451009, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbsx, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzdzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdze);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f2848a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
