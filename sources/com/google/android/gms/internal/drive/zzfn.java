package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnListEntriesResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzfn extends com.google.android.gms.drive.zzu {
    public static final Parcelable.Creator<zzfn> CREATOR = new zzfo();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    final DataHolder f3971a;

    @SafeParcelable.Field(id = 3)
    final boolean b;

    @SafeParcelable.Constructor
    public zzfn(@SafeParcelable.Param(id = 2) DataHolder dataHolder, @SafeParcelable.Param(id = 3) boolean z) {
        this.f3971a = dataHolder;
        this.b = z;
    }

    @Override // com.google.android.gms.drive.zzu
    protected final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f3971a, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DataHolder zzal() {
        return this.f3971a;
    }
}
