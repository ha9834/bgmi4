package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "FullTextSearchFilterCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzl extends zza {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final String f1570a;

    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Param(id = 1) String str) {
        this.f1570a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f1570a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public final <F> F zza(zzj<F> zzjVar) {
        return zzjVar.zzg(this.f1570a);
    }
}
