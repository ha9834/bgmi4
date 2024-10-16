package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.TransferPreferences;

@SafeParcelable.Class(creator = "ParcelableTransferPreferencesCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzgi extends AbstractSafeParcelable implements TransferPreferences {
    public static final Parcelable.Creator<zzgi> CREATOR = new zzgj();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final int f3982a;

    @SafeParcelable.Field(id = 3)
    private final int b;

    @SafeParcelable.Field(id = 4)
    private final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzgi(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) boolean z) {
        this.f3982a = i;
        this.b = i2;
        this.c = z;
    }

    @Override // com.google.android.gms.drive.TransferPreferences
    public final int getBatteryUsagePreference() {
        return this.b;
    }

    @Override // com.google.android.gms.drive.TransferPreferences
    public final int getNetworkPreference() {
        return this.f3982a;
    }

    @Override // com.google.android.gms.drive.TransferPreferences
    public final boolean isRoamingAllowed() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f3982a);
        SafeParcelWriter.writeInt(parcel, 3, this.b);
        SafeParcelWriter.writeBoolean(parcel, 4, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
