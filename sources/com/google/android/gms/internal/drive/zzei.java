package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.TransferPreferences;

@SafeParcelable.Class(creator = "FileUploadPreferencesImplCreator")
@SafeParcelable.Reserved({1})
@Deprecated
/* loaded from: classes2.dex */
public final class zzei extends AbstractSafeParcelable implements FileUploadPreferences {
    public static final Parcelable.Creator<zzei> CREATOR = new zzej();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private int f3959a;

    @SafeParcelable.Field(id = 3)
    private int b;

    @SafeParcelable.Field(id = 4)
    private boolean c;

    @SafeParcelable.Constructor
    public zzei(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) boolean z) {
        this.f3959a = i;
        this.b = i2;
        this.c = z;
    }

    public zzei(TransferPreferences transferPreferences) {
        this(transferPreferences.getNetworkPreference(), transferPreferences.getBatteryUsagePreference(), transferPreferences.isRoamingAllowed());
    }

    private static boolean a(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    private static boolean b(int i) {
        switch (i) {
            case 256:
            case 257:
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final int getBatteryUsagePreference() {
        if (b(this.b)) {
            return this.b;
        }
        return 0;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final int getNetworkTypePreference() {
        if (a(this.f3959a)) {
            return this.f3959a;
        }
        return 0;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final boolean isRoamingAllowed() {
        return this.c;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final void setBatteryUsagePreference(int i) {
        if (!b(i)) {
            throw new IllegalArgumentException("Invalid battery usage preference value.");
        }
        this.b = i;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final void setNetworkTypePreference(int i) {
        if (!a(i)) {
            throw new IllegalArgumentException("Invalid data connection preference value.");
        }
        this.f3959a = i;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final void setRoamingAllowed(boolean z) {
        this.c = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f3959a);
        SafeParcelWriter.writeInt(parcel, 3, this.b);
        SafeParcelWriter.writeBoolean(parcel, 4, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
