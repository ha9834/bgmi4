package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzacd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzacd> CREATOR = new zzace();

    @SafeParcelable.Field(id = 2)
    public final boolean zzaax;

    @SafeParcelable.Field(id = 3)
    public final boolean zzaay;

    @SafeParcelable.Field(id = 4)
    public final boolean zzaaz;

    public zzacd(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @SafeParcelable.Constructor
    public zzacd(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.zzaax = z;
        this.zzaay = z2;
        this.zzaaz = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzaax);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzaay);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzaaz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
