package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zza implements Parcelable.Creator<VideoCapabilities> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VideoCapabilities[] newArray(int i) {
        return new VideoCapabilities[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VideoCapabilities createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean[] zArr = null;
        boolean[] zArr2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 2:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    zArr = SafeParcelReader.createBooleanArray(parcel, readHeader);
                    break;
                case 5:
                    zArr2 = SafeParcelReader.createBooleanArray(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new VideoCapabilities(z, z2, z3, zArr, zArr2);
    }
}
