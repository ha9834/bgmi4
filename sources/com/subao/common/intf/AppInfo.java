package com.subao.common.intf;

import android.os.Parcel;
import android.os.Parcelable;
import com.subao.common.e;

/* loaded from: classes2.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new Parcelable.Creator<AppInfo>() { // from class: com.subao.common.intf.AppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfo[] newArray(int i) {
            return new AppInfo[i];
        }
    };
    private final String packageName;
    private final int uid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AppInfo(int i, String str) {
        this.uid = i;
        this.packageName = str;
    }

    private AppInfo(Parcel parcel) {
        this.uid = parcel.readInt();
        this.packageName = parcel.readInt() < 0 ? null : parcel.readString();
    }

    public int getUid() {
        return this.uid;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) obj;
        return this.uid == appInfo.uid && e.a(this.packageName, appInfo.packageName);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uid);
        if (this.packageName == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(this.packageName);
        }
    }
}
