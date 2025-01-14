package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zza implements Parcelable.Creator<PlayerStatsEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlayerStatsEntity[] newArray(int i) {
        return new PlayerStatsEntity[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlayerStatsEntity createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    f = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 2:
                    f2 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    f3 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    f4 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 9:
                    f5 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 10:
                    f6 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 11:
                    f7 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PlayerStatsEntity(f, f2, i, i2, i3, f3, f4, bundle, f5, f6, f7);
    }
}
