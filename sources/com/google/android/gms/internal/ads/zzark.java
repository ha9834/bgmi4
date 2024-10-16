package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
/* loaded from: classes.dex */
public final class zzark extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzark> CREATOR = new zzarl();

    @SafeParcelable.Field(id = 2)
    public final boolean zzdom;

    @SafeParcelable.Field(id = 3)
    public final List<String> zzdon;

    public zzark() {
        this(false, Collections.emptyList());
    }

    @SafeParcelable.Constructor
    public zzark(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) List<String> list) {
        this.zzdom = z;
        this.zzdon = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdom);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdon, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
