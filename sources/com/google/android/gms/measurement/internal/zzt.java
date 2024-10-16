package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzt implements Parcelable.Creator<zzq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzq[] newArray(int i) {
        return new zzq[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzq createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        zzjn zzjnVar = null;
        String str3 = null;
        zzai zzaiVar = null;
        zzai zzaiVar2 = null;
        zzai zzaiVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    zzjnVar = (zzjn) SafeParcelReader.createParcelable(parcel, readHeader, zzjn.CREATOR);
                    break;
                case 5:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    zzaiVar = (zzai) SafeParcelReader.createParcelable(parcel, readHeader, zzai.CREATOR);
                    break;
                case 9:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 10:
                    zzaiVar2 = (zzai) SafeParcelReader.createParcelable(parcel, readHeader, zzai.CREATOR);
                    break;
                case 11:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    zzaiVar3 = (zzai) SafeParcelReader.createParcelable(parcel, readHeader, zzai.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzq(str, str2, zzjnVar, j, z, str3, zzaiVar, j2, zzaiVar2, j3, zzaiVar3);
    }
}
