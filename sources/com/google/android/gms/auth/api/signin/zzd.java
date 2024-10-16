package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<SignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = "";
        String str2 = "";
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 4) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else {
                switch (fieldId) {
                    case 7:
                        googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.createParcelable(parcel, readHeader, GoogleSignInAccount.CREATOR);
                        break;
                    case 8:
                        str2 = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        break;
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SignInAccount(str, googleSignInAccount, str2);
    }
}
