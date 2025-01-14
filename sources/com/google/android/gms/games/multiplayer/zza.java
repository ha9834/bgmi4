package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<InvitationEntity> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public InvitationEntity createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        GameEntity gameEntity = null;
        String str = null;
        ParticipantEntity participantEntity = null;
        ArrayList arrayList = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    gameEntity = (GameEntity) SafeParcelReader.createParcelable(parcel, readHeader, GameEntity.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) SafeParcelReader.createParcelable(parcel, readHeader, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new InvitationEntity(gameEntity, str, j, i, participantEntity, arrayList, i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public /* synthetic */ InvitationEntity[] newArray(int i) {
        return new InvitationEntity[i];
    }
}
