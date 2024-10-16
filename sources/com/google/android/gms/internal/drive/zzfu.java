package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.TransferPreferences;

@SafeParcelable.Class(creator = "OnPinnedDownloadPreferencesResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzfu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfu> CREATOR = new zzfv();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final zzgi f3975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzfu(@SafeParcelable.Param(id = 2) zzgi zzgiVar) {
        this.f3975a = zzgiVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f3975a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final TransferPreferences zzao() {
        return this.f3975a;
    }
}
