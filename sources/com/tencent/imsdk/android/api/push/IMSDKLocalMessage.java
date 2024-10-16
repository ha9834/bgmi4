package com.tencent.imsdk.android.api.push;

import com.tencent.imsdk.android.tools.json.JsonProp;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKLocalMessage extends JsonSerializable {

    @JsonProp("ActionContent")
    public String actionContent;

    @JsonProp("ActionType")
    public int actionType;

    @JsonProp("ApkDownloadUrl")
    public String apkDownloadUrl;

    @JsonProp("BuilderId")
    public long builderId;

    @JsonProp("Content")
    public String content;

    @JsonProp("FireTime")
    public long fireTime;

    @JsonProp("IconRes")
    public String iconRes;

    @JsonProp("IsRinging")
    public boolean isRinging;

    @JsonProp("IsVibrate")
    public boolean isVibrate;

    @JsonProp("Light")
    public int light;

    @JsonProp("RingRaw")
    public String ringRaw;

    @JsonProp("StyleId")
    public int styleId;

    @JsonProp("Title")
    public String title;

    @JsonProp("Type")
    public int type;

    private IMSDKLocalMessage() {
    }

    public IMSDKLocalMessage(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKLocalMessage(String str) throws JSONException {
        super(str);
    }

    private IMSDKLocalMessage(Builder builder) {
        this.type = builder.type;
        this.title = builder.title;
        this.content = builder.content;
        this.actionType = builder.actionType;
        this.actionContent = builder.actionContent;
        this.isRinging = builder.isRinging;
        this.ringRaw = builder.ringRaw;
        this.isVibrate = builder.isVibrate;
        this.light = builder.light;
        this.iconRes = builder.iconRes;
        this.apkDownloadUrl = builder.apkDownloadUrl;
        this.builderId = builder.builderId;
        this.styleId = builder.styleId;
        this.fireTime = builder.fireTimeMs;
    }

    public String toString() {
        return "IMLocalMessage{type=" + this.type + ", title='" + this.title + "', content='" + this.content + "', actionType=" + this.actionType + ", actionContent='" + this.actionContent + "', isRinging=" + this.isRinging + ", ringRaw='" + this.ringRaw + "', isVibrate=" + this.isVibrate + ", light=" + this.light + ", iconRes='" + this.iconRes + "', apkDownloadUrl='" + this.apkDownloadUrl + "', builderId=" + this.builderId + ", styleId=" + this.styleId + ", fireTime=" + this.fireTime + '}';
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private long builderId;
        private String content;
        private long fireTimeMs;
        private String ringRaw;
        private int styleId;
        private String title;
        private int type = 1;
        private int actionType = 1;
        private String actionContent = "";
        private boolean isRinging = true;
        private boolean isVibrate = true;
        private int light = 1;
        private String iconRes = "";
        private String apkDownloadUrl = "";

        public Builder setType(int i) {
            this.type = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setActionType(int i) {
            this.actionType = i;
            return this;
        }

        public Builder setActionContent(String str) {
            this.actionContent = str;
            return this;
        }

        public Builder setIsRinging(boolean z) {
            this.isRinging = z;
            return this;
        }

        public Builder setRingRaw(String str) {
            this.ringRaw = str;
            return this;
        }

        public Builder setIsVibrate(boolean z) {
            this.isVibrate = z;
            return this;
        }

        public Builder setLight(int i) {
            this.light = i;
            return this;
        }

        public Builder setIconRes(String str) {
            this.iconRes = str;
            return this;
        }

        public Builder setApkDownloadUrl(String str) {
            this.apkDownloadUrl = str;
            return this;
        }

        public Builder setBuilderId(long j) {
            this.builderId = j;
            return this;
        }

        public Builder setStyleId(int i) {
            this.styleId = i;
            return this;
        }

        public Builder setFireTimeMs(long j) {
            this.fireTimeMs = j;
            return this;
        }

        public IMSDKLocalMessage build() {
            return new IMSDKLocalMessage(this);
        }
    }
}
