package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzw implements Parcelable.Creator<zzr.zzb.C0112zzb> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzb.C0112zzb createFromParcel(Parcel parcel) {
        int i;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    i = 1;
                    break;
                case 2:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    i = 2;
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    i = 3;
                    break;
                case 4:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    i = 4;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    continue;
            }
            hashSet.add(Integer.valueOf(i));
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzr.zzb.C0112zzb(hashSet, i2, i3, str, i4);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(validateObjectHeader);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzb.C0112zzb[] newArray(int i) {
        return new zzr.zzb.C0112zzb[i];
    }
}
