package com.subao.common.intf;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonWriter;
import com.helpshift.util.ErrorReportProvider;
import com.subao.common.c;
import com.subao.common.e;
import com.subao.common.n.g;
import com.subao.common.n.h;

/* loaded from: classes2.dex */
public class UserInfo implements Parcelable, c {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() { // from class: com.subao.common.intf.UserInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    };
    private final String appId;
    private final String token;
    private final String userId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserInfo(String str, String str2, String str3) {
        this.userId = str;
        this.token = str2;
        this.appId = str3;
    }

    private UserInfo(Parcel parcel) {
        this.userId = readFromParcel(parcel);
        this.token = readFromParcel(parcel);
        this.appId = readFromParcel(parcel);
    }

    private static void writeToParcel(Parcel parcel, String str) {
        if (str == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(str);
        }
    }

    private static String readFromParcel(Parcel parcel) {
        if (-1 == parcel.readInt()) {
            return null;
        }
        return parcel.readString();
    }

    public String getUserId() {
        return this.userId;
    }

    public String getToken() {
        return this.token;
    }

    public String getAppId() {
        return this.appId;
    }

    public String toString() {
        return String.format("[UserInfo: %s, %s, %s]", h.a((Object) this.userId), h.a((Object) this.token), h.a((Object) this.appId));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        return e.a(this.userId, userInfo.userId) && e.a(this.token, userInfo.token) && e.a(this.appId, userInfo.appId);
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        g.a(jsonWriter, "userId", this.userId);
        g.a(jsonWriter, "token", this.token);
        g.a(jsonWriter, ErrorReportProvider.KEY_APP_ID, this.appId);
        jsonWriter.endObject();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, this.userId);
        writeToParcel(parcel, this.token);
        writeToParcel(parcel, this.appId);
    }
}
