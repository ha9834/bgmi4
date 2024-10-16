package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzarw implements Parcelable.Creator<zzaru> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaru[] newArray(int i) {
        return new zzaru[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaru createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel, readHeader, ParcelFileDescriptor.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzaru(parcelFileDescriptor);
    }
}
