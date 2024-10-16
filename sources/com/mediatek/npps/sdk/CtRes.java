package com.mediatek.npps.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CtRes implements Parcelable {
    public static final Parcelable.Creator<CtRes> CREATOR = new Parcelable.Creator<CtRes>() { // from class: com.mediatek.npps.sdk.CtRes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CtRes createFromParcel(Parcel parcel) {
            return new CtRes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CtRes[] newArray(int i) {
            return new CtRes[i];
        }
    };
    private static final String TAG = "CertResponse";
    public int mCustId;
    public int mError;
    public byte[] mRnd;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CtRes(int i, byte[] bArr, int i2) {
        this.mError = i;
        this.mRnd = (byte[]) bArr.clone();
        this.mCustId = i2;
    }

    private CtRes(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.mError = parcel.readInt();
        this.mRnd = parcel.createByteArray();
        this.mCustId = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mError);
        parcel.writeByteArray(this.mRnd);
        parcel.writeInt(this.mCustId);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TAG);
        sb.append(": mError:");
        sb.append(this.mError);
        sb.append(",rnd:");
        if (this.mRnd != null) {
            int i = 0;
            while (true) {
                byte[] bArr = this.mRnd;
                if (i >= bArr.length) {
                    break;
                }
                sb.append((int) bArr[i]);
                i++;
            }
        }
        sb.append(",mCustId:");
        sb.append(this.mCustId);
        return sb.toString();
    }
}
