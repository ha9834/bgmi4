package com.google.android.vending.expansion.downloader;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DownloadProgressInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadProgressInfo> CREATOR = new Parcelable.Creator<DownloadProgressInfo>() { // from class: com.google.android.vending.expansion.downloader.DownloadProgressInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadProgressInfo createFromParcel(Parcel parcel) {
            return new DownloadProgressInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadProgressInfo[] newArray(int i) {
            return new DownloadProgressInfo[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public long f5356a;
    public long b;
    public long c;
    public float d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f5356a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeFloat(this.d);
    }

    public DownloadProgressInfo(Parcel parcel) {
        this.f5356a = parcel.readLong();
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readFloat();
    }

    public DownloadProgressInfo(long j, long j2, long j3, float f) {
        this.f5356a = j;
        this.b = j2;
        this.c = j3;
        this.d = f;
    }
}
