package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "MediationConfigurationParcelCreator")
/* loaded from: classes2.dex */
public final class zzaiw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiw> CREATOR = new zzaix();

    @SafeParcelable.Field(id = 2)
    public final Bundle extras;

    @SafeParcelable.Field(id = 1)
    public final String zzdbd;

    @SafeParcelable.Constructor
    public zzaiw(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zzdbd = str;
        this.extras = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdbd, false);
        SafeParcelWriter.writeBundle(parcel, 2, this.extras, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
