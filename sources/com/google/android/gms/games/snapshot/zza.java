package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.Contents;

/* loaded from: classes.dex */
public final class zza implements Parcelable.Creator<SnapshotContentsEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SnapshotContentsEntity[] newArray(int i) {
        return new SnapshotContentsEntity[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SnapshotContentsEntity createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Contents contents = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) == 1) {
                contents = (Contents) SafeParcelReader.createParcelable(parcel, readHeader, Contents.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SnapshotContentsEntity(contents);
    }
}
