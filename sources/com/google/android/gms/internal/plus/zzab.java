package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzab implements Parcelable.Creator<zzr.zzg> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzg createFromParcel(Parcel parcel) {
        int i;
        int i2;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i3 = 0;
        String str = null;
        String str2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                switch (fieldId) {
                    case 3:
                        i5 = SafeParcelReader.readInt(parcel, readHeader);
                        i2 = 3;
                        break;
                    case 4:
                        str2 = SafeParcelReader.createString(parcel, readHeader);
                        i2 = 4;
                        break;
                    case 5:
                        str = SafeParcelReader.createString(parcel, readHeader);
                        i2 = 5;
                        break;
                    case 6:
                        i4 = SafeParcelReader.readInt(parcel, readHeader);
                        i2 = 6;
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        continue;
                }
                i = Integer.valueOf(i2);
            } else {
                i3 = SafeParcelReader.readInt(parcel, readHeader);
                i = 1;
            }
            hashSet.add(i);
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzr.zzg(hashSet, i3, str, i4, str2, i5);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(validateObjectHeader);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzg[] newArray(int i) {
        return new zzr.zzg[i];
    }
}
