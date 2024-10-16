package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzapk implements Parcelable.Creator<zzapj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzapj[] newArray(int i) {
        return new zzapj[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzapj createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzapj(i, i2, i3);
    }
}
