package com.tencent.imsdk.android.base.stat;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class IMSDKStatUserAttribute {
    public boolean active;
    public String androidID;
    public String appPackageName;
    public String appVersion;
    public String channel;
    public String channelId;
    public String currency;
    public String email;
    public String gender;
    public String imei;
    public String userId;
    public String userName;

    public IMSDKStatUserAttribute(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.gender = builder.gender;
        this.email = builder.email;
        this.channel = builder.channel;
        this.channelId = builder.channelId;
        this.appVersion = builder.appVersion;
        this.appPackageName = builder.appPackageName;
        this.imei = builder.imei;
        this.androidID = builder.androidID;
        this.currency = builder.currency;
        this.active = builder.active;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public boolean active;
        public String androidID;
        public String appPackageName;
        public String appVersion;
        public String channel;
        public String channelId;
        public String currency;
        public String email;
        public String gender;
        public String imei;
        public String userId;
        public String userName;

        public Builder setActive(boolean z) {
            this.active = z;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setUserName(String str) {
            this.userName = str;
            return this;
        }

        public Builder setGender(String str) {
            this.gender = str;
            return this;
        }

        public Builder setEmail(String str) {
            this.email = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setChannelId(String str) {
            this.channelId = str;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setAppPackageName(String str) {
            this.appPackageName = str;
            return this;
        }

        public Builder setImei(String str) {
            this.imei = str;
            return this;
        }

        public Builder setAndroidID(String str) {
            this.androidID = str;
            return this;
        }

        public Builder setCurrency(String str) {
            this.currency = str;
            return this;
        }

        public IMSDKStatUserAttribute create() {
            return new IMSDKStatUserAttribute(this);
        }
    }
}
