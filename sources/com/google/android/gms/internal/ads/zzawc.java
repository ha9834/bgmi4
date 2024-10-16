package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
/* loaded from: classes.dex */
public final class zzawc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawc> CREATOR = new zzawd();

    @SafeParcelable.Field(id = 2)
    public final String zzbsu;

    @SafeParcelable.Field(id = 1)
    public final String zzchk;

    @SafeParcelable.Field(id = 3)
    public final zzyd zzdsu;

    @SafeParcelable.Constructor
    public zzawc(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) zzyd zzydVar) {
        this.zzchk = str;
        this.zzbsu = str2;
        this.zzdsu = zzydVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzchk, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbsu, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdsu, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
