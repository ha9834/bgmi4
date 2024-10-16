package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzu implements Parcelable.Creator<zzr.zzb> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzb createFromParcel(Parcel parcel) {
        int i;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        zzr.zzb.zza zzaVar = null;
        zzr.zzb.C0112zzb c0112zzb = null;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    i = 1;
                    break;
                case 2:
                    zzaVar = (zzr.zzb.zza) SafeParcelReader.createParcelable(parcel, readHeader, zzr.zzb.zza.CREATOR);
                    i = 2;
                    break;
                case 3:
                    c0112zzb = (zzr.zzb.C0112zzb) SafeParcelReader.createParcelable(parcel, readHeader, zzr.zzb.C0112zzb.CREATOR);
                    i = 3;
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    i = 4;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    continue;
            }
            hashSet.add(Integer.valueOf(i));
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzr.zzb(hashSet, i2, zzaVar, c0112zzb, i3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(validateObjectHeader);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzb[] newArray(int i) {
        return new zzr.zzb[i];
    }
}
