package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "ExceptionParcelCreator")
/* loaded from: classes2.dex */
public final class zzaym extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaym> CREATOR = new zzayo();

    @SafeParcelable.Field(id = 2)
    public final int errorCode;

    @SafeParcelable.Field(id = 1)
    public final String zzdwv;

    public static zzaym zza(Throwable th, int i) {
        return new zzaym(th.getMessage(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzaym(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i) {
        this.zzdwv = str == null ? "" : str;
        this.errorCode = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdwv, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
