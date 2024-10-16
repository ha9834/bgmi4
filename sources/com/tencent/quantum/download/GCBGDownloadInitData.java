package com.tencent.quantum.download;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class GCBGDownloadInitData implements Parcelable {
    public static final Parcelable.Creator<GCBGDownloadInitData> CREATOR = new Parcelable.Creator<GCBGDownloadInitData>() { // from class: com.tencent.quantum.download.GCBGDownloadInitData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GCBGDownloadInitData createFromParcel(Parcel parcel) {
            return new GCBGDownloadInitData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GCBGDownloadInitData[] newArray(int i) {
            return new GCBGDownloadInitData[i];
        }
    };
    private String mCompleteText;
    private String mDownloadDetail;
    private String mErrorText;
    private long mProgressSize;
    private String mProgressTextFormat;
    private long mTotalSize;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GCBGDownloadInitData(Parcel parcel) {
        this.mTotalSize = parcel.readLong();
        this.mProgressSize = parcel.readLong();
        this.mDownloadDetail = parcel.readString();
        this.mProgressTextFormat = parcel.readString();
        this.mCompleteText = parcel.readString();
        this.mErrorText = parcel.readString();
    }

    public GCBGDownloadInitData(long j, long j2, String str, String str2, String str3, String str4) {
        this.mTotalSize = j2;
        this.mProgressSize = j;
        this.mDownloadDetail = str;
        this.mProgressTextFormat = str2;
        this.mCompleteText = str3;
        this.mErrorText = str4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mTotalSize);
        parcel.writeLong(this.mProgressSize);
        parcel.writeString(this.mDownloadDetail);
        parcel.writeString(this.mProgressTextFormat);
        parcel.writeString(this.mCompleteText);
        parcel.writeString(this.mErrorText);
    }

    public long getmTotalSize() {
        return this.mTotalSize;
    }

    public long getmProgressSize() {
        return this.mProgressSize;
    }

    public long setmProgressSize(long j) {
        this.mProgressSize = j;
        return j;
    }

    public String getmDownloadDetail() {
        return this.mDownloadDetail;
    }

    public String getmProgressTextFormat() {
        return this.mProgressTextFormat;
    }

    public String getmCompleteText() {
        return this.mCompleteText;
    }

    public String getmErrorText() {
        return this.mErrorText;
    }
}
