package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
/* loaded from: classes2.dex */
public final class zzaic extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaic> CREATOR = new zzaid();

    @SafeParcelable.Field(id = 4)
    public final byte[] data;

    @SafeParcelable.Field(id = 3)
    public final int statusCode;

    @SafeParcelable.Field(id = 7)
    public final boolean zzac;

    @SafeParcelable.Field(id = 8)
    public final long zzad;

    @SafeParcelable.Field(id = 5)
    public final String[] zzdat;

    @SafeParcelable.Field(id = 6)
    public final String[] zzdau;

    @SafeParcelable.Field(id = 1)
    public final boolean zzdav;

    @SafeParcelable.Field(id = 2)
    public final String zzdaw;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzaic(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) String[] strArr, @SafeParcelable.Param(id = 6) String[] strArr2, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 8) long j) {
        this.zzdav = z;
        this.zzdaw = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzdat = strArr;
        this.zzdau = strArr2;
        this.zzac = z2;
        this.zzad = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdav);
        SafeParcelWriter.writeString(parcel, 2, this.zzdaw, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzdat, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzdau, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzac);
        SafeParcelWriter.writeLong(parcel, 8, this.zzad);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
