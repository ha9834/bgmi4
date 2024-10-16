package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzawd implements Parcelable.Creator<zzawc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawc[] newArray(int i) {
        return new zzawc[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawc createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zzyd zzydVar = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    zzydVar = (zzyd) SafeParcelReader.createParcelable(parcel, readHeader, zzyd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzawc(str, str2, zzydVar);
    }
}
