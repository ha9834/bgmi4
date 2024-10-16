package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "ServerSideVerificationOptionsParcelCreator")
/* loaded from: classes.dex */
public final class zzaum extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaum> CREATOR = new zzaun();

    @SafeParcelable.Field(id = 1)
    public final String zzdqs;

    @SafeParcelable.Field(id = 2)
    public final String zzdqt;

    public zzaum(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    @SafeParcelable.Constructor
    public zzaum(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zzdqs = str;
        this.zzdqt = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdqs, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdqt, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
