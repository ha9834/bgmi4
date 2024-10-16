package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;

/* loaded from: classes2.dex */
public final class zzfk implements Parcelable.Creator<zzfj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfj createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ChangeEvent changeEvent = null;
        CompletionEvent completionEvent = null;
        com.google.android.gms.drive.events.zzo zzoVar = null;
        com.google.android.gms.drive.events.zzb zzbVar = null;
        com.google.android.gms.drive.events.zzv zzvVar = null;
        com.google.android.gms.drive.events.zzr zzrVar = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) SafeParcelReader.createParcelable(parcel, readHeader, ChangeEvent.CREATOR);
                    break;
                case 4:
                case 8:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) SafeParcelReader.createParcelable(parcel, readHeader, CompletionEvent.CREATOR);
                    break;
                case 6:
                    zzoVar = (com.google.android.gms.drive.events.zzo) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.drive.events.zzo.CREATOR);
                    break;
                case 7:
                    zzbVar = (com.google.android.gms.drive.events.zzb) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.drive.events.zzb.CREATOR);
                    break;
                case 9:
                    zzvVar = (com.google.android.gms.drive.events.zzv) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.drive.events.zzv.CREATOR);
                    break;
                case 10:
                    zzrVar = (com.google.android.gms.drive.events.zzr) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.drive.events.zzr.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzfj(i, changeEvent, completionEvent, zzoVar, zzbVar, zzvVar, zzrVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfj[] newArray(int i) {
        return new zzfj[i];
    }
}
