package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzati implements Parcelable.Creator<zzath> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzath[] newArray(int i) {
        return new zzath[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzath createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzxz zzxzVar = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzxzVar = (zzxz) SafeParcelReader.createParcelable(parcel, readHeader, zzxz.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzath(zzxzVar, str);
    }
}
