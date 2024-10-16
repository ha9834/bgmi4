package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
/* loaded from: classes.dex */
public final class zzaiy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiy> CREATOR = new zzaiz();

    @SafeParcelable.Field(id = 1)
    public final int zzdbe;

    @SafeParcelable.Constructor
    public zzaiy(@SafeParcelable.Param(id = 1) int i) {
        this.zzdbe = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdbe);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
