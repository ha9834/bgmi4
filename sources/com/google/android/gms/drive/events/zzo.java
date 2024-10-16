package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "QueryResultEventParcelableCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzo extends com.google.android.gms.drive.zzu implements DriveEvent {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final DataHolder f1545a;

    @SafeParcelable.Field(id = 3)
    private final boolean b;

    @SafeParcelable.Field(id = 4)
    private final int c;

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 2) DataHolder dataHolder, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) int i) {
        this.f1545a = dataHolder;
        this.b = z;
        this.c = i;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 3;
    }

    @Override // com.google.android.gms.drive.zzu
    public final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f1545a, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.b);
        SafeParcelWriter.writeInt(parcel, 4, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zzaa() {
        return this.c;
    }

    public final DataHolder zzy() {
        return this.f1545a;
    }

    public final boolean zzz() {
        return this.b;
    }
}
