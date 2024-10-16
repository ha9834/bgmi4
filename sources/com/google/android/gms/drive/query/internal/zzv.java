package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

@SafeParcelable.Class(creator = "NotFilterCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzv extends zza {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final FilterHolder f1574a;

    public zzv(Filter filter) {
        this(new FilterHolder(filter));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param(id = 1) FilterHolder filterHolder) {
        this.f1574a = filterHolder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f1574a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.drive.query.Filter
    public final <T> T zza(zzj<T> zzjVar) {
        return (T) zzjVar.zza(this.f1574a.getFilter().zza(zzjVar));
    }
}
