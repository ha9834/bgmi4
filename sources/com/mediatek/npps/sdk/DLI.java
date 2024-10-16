package com.mediatek.npps.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DLI implements Parcelable {
    public static final Parcelable.Creator<DLI> CREATOR = new Parcelable.Creator<DLI>() { // from class: com.mediatek.npps.sdk.DLI.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DLI createFromParcel(Parcel parcel) {
            return new DLI(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DLI[] newArray(int i) {
            return new DLI[i];
        }
    };
    private String mDstIp;
    private int mDstPort;
    private int mProto;
    private String mSrcIp;
    private int mSrcPort;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSrcIp() {
        return this.mSrcIp;
    }

    public String getDstIp() {
        return this.mDstIp;
    }

    public int getSrcPort() {
        return this.mSrcPort;
    }

    public int getDstPort() {
        return this.mDstPort;
    }

    public int getProto() {
        return this.mProto;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSrcIp);
        parcel.writeString(this.mDstIp);
        parcel.writeInt(this.mSrcPort);
        parcel.writeInt(this.mDstPort);
        parcel.writeInt(this.mProto);
    }

    public void readFromParcel(Parcel parcel) {
        this.mSrcIp = parcel.readString();
        this.mDstIp = parcel.readString();
        this.mSrcPort = parcel.readInt();
        this.mDstPort = parcel.readInt();
        this.mProto = parcel.readInt();
    }

    public DLI(String str, String str2, int i, int i2, int i3) {
        this.mSrcIp = str;
        this.mDstIp = str2;
        this.mSrcPort = i;
        this.mDstPort = i2;
        this.mProto = i3;
    }

    private DLI(Parcel parcel) {
        this.mSrcIp = parcel.readString();
        this.mDstIp = parcel.readString();
        this.mSrcPort = parcel.readInt();
        this.mDstPort = parcel.readInt();
        this.mProto = parcel.readInt();
    }

    public String toString() {
        return "DupLinkInfo(" + this.mSrcIp + "," + this.mDstIp + "," + this.mSrcPort + "," + this.mDstPort + "," + this.mProto + ")";
    }
}
