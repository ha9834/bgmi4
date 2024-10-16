package com.shieldtunnel.svpn.common.intf;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonWriter;
import com.helpshift.util.ErrorReportProvider;
import com.shieldtunnel.svpn.common.a;
import com.shieldtunnel.svpn.common.c;
import com.shieldtunnel.svpn.common.k.e;

/* loaded from: classes2.dex */
public class UserInfo implements Parcelable, a {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() { // from class: com.shieldtunnel.svpn.common.intf.UserInfo.1
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

    private static String readFromParcel(Parcel parcel) {
        if (-1 == parcel.readInt()) {
            return null;
        }
        return parcel.readString();
    }

    private static void writeToParcel(Parcel parcel, String str) {
        if (str == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(str);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        return c.a(this.userId, userInfo.userId) && c.a(this.token, userInfo.token) && c.a(this.appId, userInfo.appId);
    }

    public String getAppId() {
        return this.appId;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    @Override // com.shieldtunnel.svpn.common.a
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        com.shieldtunnel.svpn.common.k.c.a(jsonWriter, "userId", this.userId);
        com.shieldtunnel.svpn.common.k.c.a(jsonWriter, "token", this.token);
        com.shieldtunnel.svpn.common.k.c.a(jsonWriter, ErrorReportProvider.KEY_APP_ID, this.appId);
        jsonWriter.endObject();
    }

    public String toString() {
        return String.format("[UserInfo: %s, %s, %s]", e.a((Object) this.userId), e.a((Object) this.token), e.a((Object) this.appId));
    }

    public UserInfo(String str, String str2, String str3) {
        this.userId = str;
        this.token = str2;
        this.appId = str3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, this.userId);
        writeToParcel(parcel, this.token);
        writeToParcel(parcel, this.appId);
    }

    private UserInfo(Parcel parcel) {
        this.userId = readFromParcel(parcel);
        this.token = readFromParcel(parcel);
        this.appId = readFromParcel(parcel);
    }
}
