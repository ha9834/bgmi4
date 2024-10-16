package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzyb implements Parcelable.Creator<zzxz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzxz[] newArray(int i) {
        return new zzxz[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzxz createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzaca zzacaVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        zzxt zzxtVar = null;
        String str5 = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 3:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 10:
                    zzacaVar = (zzaca) SafeParcelReader.createParcelable(parcel, readHeader, zzaca.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.createParcelable(parcel, readHeader, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 15:
                    arrayList2 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 16:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 17:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 18:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 19:
                    zzxtVar = (zzxt) SafeParcelReader.createParcelable(parcel, readHeader, zzxt.CREATOR);
                    break;
                case 20:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 21:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzxz(i, j, bundle, i2, arrayList, z, i3, z2, str, zzacaVar, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3, zzxtVar, i4, str5);
    }
}