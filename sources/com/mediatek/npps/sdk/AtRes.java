package com.mediatek.npps.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AtRes implements Parcelable {
    public static final Parcelable.Creator<AtRes> CREATOR = new Parcelable.Creator<AtRes>() { // from class: com.mediatek.npps.sdk.AtRes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AtRes createFromParcel(Parcel parcel) {
            return new AtRes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AtRes[] newArray(int i) {
            return new AtRes[i];
        }
    };
    private static final String TAG = "CertResponse";
    public int mCapMask;
    public byte[] mDevId;
    public int mError;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AtRes(int i, byte[] bArr, int i2) {
        this.mError = i;
        this.mDevId = (byte[]) bArr.clone();
        this.mCapMask = i2;
    }

    private AtRes(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.mError = parcel.readInt();
        this.mDevId = parcel.createByteArray();
        this.mCapMask = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mError);
        parcel.writeByteArray(this.mDevId);
        parcel.writeInt(this.mCapMask);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TAG);
        sb.append(": mError:");
        sb.append(this.mError);
        sb.append(",mDevId:");
        if (this.mDevId != null) {
            int i = 0;
            while (true) {
                byte[] bArr = this.mDevId;
                if (i >= bArr.length) {
                    break;
                }
                sb.append((int) bArr[i]);
                i++;
            }
        }
        sb.append(",mCapMask:");
        return sb.toString();
    }
}
