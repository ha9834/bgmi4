package com.tencent.grobot.lite.youtube;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class YoutubeParams implements Parcelable {
    public static final Parcelable.Creator<YoutubeParams> CREATOR = new Parcelable.Creator<YoutubeParams>() { // from class: com.tencent.grobot.lite.youtube.YoutubeParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public YoutubeParams createFromParcel(Parcel parcel) {
            return new YoutubeParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public YoutubeParams[] newArray(int i) {
            return new YoutubeParams[i];
        }
    };
    public final String videoId;
    public final String videoName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public YoutubeParams(String str, String str2) {
        this.videoId = str;
        this.videoName = str2;
    }

    private YoutubeParams(Parcel parcel) {
        this.videoId = parcel.readString();
        this.videoName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.videoId);
        parcel.writeString(this.videoName);
    }

    public String toString() {
        return "YoutubeParams{videoId='" + this.videoId + "', videoName='" + this.videoName + "'}";
    }
}
