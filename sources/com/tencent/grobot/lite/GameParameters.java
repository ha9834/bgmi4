package com.tencent.grobot.lite;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.UserDataStore;
import com.helpshift.util.ErrorReportProvider;
import com.intlgame.webview.WebViewManager;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ToolUtils;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GameParameters implements Parcelable {
    public static final Parcelable.Creator<GameParameters> CREATOR = new Parcelable.Creator<GameParameters>() { // from class: com.tencent.grobot.lite.GameParameters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameParameters createFromParcel(Parcel parcel) {
            return new GameParameters(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameParameters[] newArray(int i) {
            return new GameParameters[i];
        }
    };
    public static final String SOURCE_GUSET = "m_guest";
    public static final String SOURCE_MOBILE = "mobile";
    public static final String SOURCE_SETTING = "m_setting";
    private static final String TAG = "GameParameters";
    public String appId;
    public String appid;
    public String areaId;
    public String areaName;
    public int businessId;
    public String channel;
    public int channelId;
    public String country;
    public int debug;
    public int debugLog;
    public String enterName;
    public int env;
    public String gameId;
    public String gameVersion;
    public String googleApiKey;
    public String headerUrl;
    public int hms;
    public String ip;
    public int isLite;
    public String itopGameId;
    public String itopSigKey;
    public String language;
    public String openId;
    public String openid;
    public int os;
    public String partitionId;
    public int performace;
    public String platId;
    public String question;
    public String questionid;
    public String regionId;
    public String regionName;
    public String roleId;
    public String roleName;
    public String sig;
    public String sign;
    public String signStr;
    public String source;
    public int systemId;
    public String ticket;
    public String timeZone;
    public long timestamp;
    public String token;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GameParameters(Context context, String str) {
        this.os = 1;
        this.itopGameId = "";
        this.channelId = 0;
        this.timestamp = 0L;
        this.sig = "";
        this.token = "";
        this.env = 0;
        this.appId = "";
        this.openId = "";
        this.itopSigKey = "";
        this.language = "";
        this.timeZone = "";
        this.enterName = "";
        this.gameVersion = "";
        this.gameId = BuildConfig.ID_GAME;
        this.areaId = "";
        this.areaName = "";
        this.roleId = "";
        this.roleName = "";
        this.regionId = "";
        this.regionName = "";
        this.country = "";
        this.ip = "";
        this.ticket = "";
        this.sign = "";
        this.signStr = "";
        this.channel = "";
        this.appid = "";
        this.openid = "";
        this.source = SOURCE_MOBILE;
        this.systemId = 2;
        this.partitionId = "";
        this.debug = 0;
        this.debugLog = 0;
        this.isLite = 1;
        this.performace = 0;
        this.googleApiKey = "";
        this.hms = 0;
        this.question = "";
        this.questionid = "";
        this.headerUrl = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("language")) {
                this.language = jSONObject.getString("language");
            } else if (context != null) {
                Locale locale = context.getResources().getConfiguration().locale;
                String language = locale.getLanguage();
                if ("zh".equals(language)) {
                    String country = locale.getCountry();
                    if ("CN".equals(country)) {
                        this.language = language;
                    } else {
                        if (!"HK".equals(country) && !"TW".equals(country)) {
                            this.language = language + "-TW";
                        }
                        this.language = language + "-" + country;
                    }
                } else if ("in".equals(language)) {
                    this.language = "id";
                } else {
                    this.language = language;
                }
            }
            this.timeZone = TimeZone.getDefault().getID();
            if (!jSONObject.isNull("enterName")) {
                this.enterName = jSONObject.getString("enterName");
                if (this.enterName.equals("guest")) {
                    this.source = SOURCE_GUSET;
                } else if (this.enterName.equals("setting")) {
                    this.source = SOURCE_SETTING;
                } else if (this.enterName.equals(SOURCE_MOBILE)) {
                    this.source = SOURCE_MOBILE;
                }
            }
            if (!jSONObject.isNull("source")) {
                this.source = jSONObject.getString("source");
            }
            if (!jSONObject.isNull("gameId")) {
                this.gameId = jSONObject.getString("gameId");
            }
            if (!jSONObject.isNull("gameVersion")) {
                this.gameVersion = jSONObject.getString("gameVersion");
            }
            if (!jSONObject.isNull("areaId")) {
                this.areaId = jSONObject.getString("areaId");
            }
            if (!jSONObject.isNull("areaName")) {
                this.areaName = jSONObject.getString("areaName");
            }
            if (!jSONObject.isNull("roleId")) {
                this.roleId = jSONObject.getString("roleId");
            }
            if (!jSONObject.isNull("roleName")) {
                this.roleName = jSONObject.getString("roleName");
            }
            if (!jSONObject.isNull("regionId")) {
                this.regionId = jSONObject.getString("regionId");
            }
            if (!jSONObject.isNull("regionName")) {
                this.regionName = jSONObject.getString("regionName");
            }
            if (!jSONObject.isNull(UserDataStore.COUNTRY)) {
                this.country = jSONObject.getString(UserDataStore.COUNTRY);
            }
            if (!jSONObject.isNull("ip")) {
                this.ip = jSONObject.getString("ip");
            }
            if (!jSONObject.isNull("sTicket")) {
                this.ticket = jSONObject.getString("sTicket");
            } else if (!jSONObject.isNull(EvaluateInfo.TYPE_TICKET)) {
                this.ticket = jSONObject.getString(EvaluateInfo.TYPE_TICKET);
            }
            if (!jSONObject.isNull(WebViewManager.KEY_JS_CHANNEL)) {
                this.channel = jSONObject.getString(WebViewManager.KEY_JS_CHANNEL);
            }
            if (!jSONObject.isNull("platId")) {
                this.platId = jSONObject.getString("platId");
            }
            if (!jSONObject.isNull("partitionId")) {
                this.partitionId = jSONObject.getString("partitionId");
            }
            if (!jSONObject.isNull("sign")) {
                this.sign = jSONObject.getString("sign");
            }
            if (!jSONObject.isNull("signStr")) {
                this.signStr = jSONObject.getString("signStr");
            }
            if (!jSONObject.isNull(ErrorReportProvider.KEY_APP_ID)) {
                this.appid = jSONObject.getString(ErrorReportProvider.KEY_APP_ID);
            }
            if (!jSONObject.isNull("openId")) {
                this.openid = jSONObject.getString("openId");
            }
            if (!jSONObject.isNull("debug")) {
                this.debug = jSONObject.getInt("debug");
            }
            if (!jSONObject.isNull("debugLog")) {
                this.debugLog = jSONObject.getInt("debugLog");
            }
            if (!jSONObject.isNull("isLite")) {
                this.isLite = jSONObject.getInt("isLite");
            }
            if (!jSONObject.isNull("deviceType")) {
                this.performace = jSONObject.optInt("deviceType", 0);
            }
            if (!jSONObject.isNull("hms")) {
                this.hms = jSONObject.optInt("hms", 0);
            }
            this.businessId = jSONObject.optInt("businessId", 1000);
            if (!jSONObject.isNull("question")) {
                this.question = jSONObject.optString("question", "");
            }
            if (!jSONObject.isNull("questionid")) {
                this.questionid = jSONObject.optString("questionid", "");
            }
            if (!jSONObject.isNull("headerUrl")) {
                this.headerUrl = jSONObject.optString("headerUrl", "");
            }
            if (!jSONObject.isNull("os")) {
                this.os = jSONObject.getInt("os");
            }
            if (!jSONObject.isNull("itopGameId")) {
                this.itopGameId = jSONObject.optString("itopGameId", "");
            }
            if (!jSONObject.isNull("itopChannelId")) {
                this.channelId = jSONObject.getInt("itopChannelId");
            }
            if (!jSONObject.isNull("itopToken")) {
                this.token = jSONObject.optString("itopToken", "");
            }
            if (!jSONObject.isNull("env")) {
                this.env = jSONObject.getInt("env");
            }
            if (!jSONObject.isNull(ErrorReportProvider.KEY_APP_ID)) {
                this.appId = jSONObject.optString(ErrorReportProvider.KEY_APP_ID, "");
            }
            if (!jSONObject.isNull("itopOpenId")) {
                this.openId = jSONObject.optString("openId", "");
            }
            if (!jSONObject.isNull("itopSigKey")) {
                this.itopSigKey = jSONObject.optString("itopSigKey", "");
            }
            this.timestamp = System.currentTimeMillis() / 1000;
            this.sig = ToolUtils.getMD5("/v2/auth/verify_login?channelid=" + this.channelId + "&gameid=" + this.itopGameId + "&os=1&source=0&ts=" + this.timestamp + "&version={\"openid\":\"" + this.openId + "\",\"token\":\"" + this.token + "\"}" + this.itopSigKey);
        } catch (Exception e) {
            TLog.e(TAG, "parse parameter failed," + e.getMessage());
        }
    }

    private GameParameters(Parcel parcel) {
        this.os = 1;
        this.itopGameId = "";
        this.channelId = 0;
        this.timestamp = 0L;
        this.sig = "";
        this.token = "";
        this.env = 0;
        this.appId = "";
        this.openId = "";
        this.itopSigKey = "";
        this.language = "";
        this.timeZone = "";
        this.enterName = "";
        this.gameVersion = "";
        this.gameId = BuildConfig.ID_GAME;
        this.areaId = "";
        this.areaName = "";
        this.roleId = "";
        this.roleName = "";
        this.regionId = "";
        this.regionName = "";
        this.country = "";
        this.ip = "";
        this.ticket = "";
        this.sign = "";
        this.signStr = "";
        this.channel = "";
        this.appid = "";
        this.openid = "";
        this.source = SOURCE_MOBILE;
        this.systemId = 2;
        this.partitionId = "";
        this.debug = 0;
        this.debugLog = 0;
        this.isLite = 1;
        this.performace = 0;
        this.googleApiKey = "";
        this.hms = 0;
        this.question = "";
        this.questionid = "";
        this.headerUrl = "";
        this.language = parcel.readString();
        this.timeZone = parcel.readString();
        this.enterName = parcel.readString();
        this.gameVersion = parcel.readString();
        this.gameId = parcel.readString();
        this.areaId = parcel.readString();
        this.areaName = parcel.readString();
        this.roleId = parcel.readString();
        this.roleName = parcel.readString();
        this.regionId = parcel.readString();
        this.regionName = parcel.readString();
        this.country = parcel.readString();
        this.ip = parcel.readString();
        this.ticket = parcel.readString();
        this.sign = parcel.readString();
        this.signStr = parcel.readString();
        this.channel = parcel.readString();
        this.appid = parcel.readString();
        this.openid = parcel.readString();
        this.source = parcel.readString();
        this.systemId = parcel.readInt();
        this.platId = parcel.readString();
        this.partitionId = parcel.readString();
        this.debug = parcel.readInt();
        this.debugLog = parcel.readInt();
        this.isLite = parcel.readInt();
        this.performace = parcel.readInt();
        this.googleApiKey = parcel.readString();
        this.hms = parcel.readInt();
        this.businessId = parcel.readInt();
        this.question = parcel.readString();
        this.questionid = parcel.readString();
        this.headerUrl = parcel.readString();
        this.os = parcel.readInt();
        this.itopGameId = parcel.readString();
        this.channelId = parcel.readInt();
        this.timestamp = parcel.readLong();
        this.sig = parcel.readString();
        this.token = parcel.readString();
        this.env = parcel.readInt();
        this.appId = parcel.readString();
        this.openId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.language);
        parcel.writeString(this.timeZone);
        parcel.writeString(this.enterName);
        parcel.writeString(this.gameVersion);
        parcel.writeString(this.gameId);
        parcel.writeString(this.areaId);
        parcel.writeString(this.areaName);
        parcel.writeString(this.roleId);
        parcel.writeString(this.roleName);
        parcel.writeString(this.regionId);
        parcel.writeString(this.regionName);
        parcel.writeString(this.country);
        parcel.writeString(this.ip);
        parcel.writeString(this.ticket);
        parcel.writeString(this.sign);
        parcel.writeString(this.signStr);
        parcel.writeString(this.channel);
        parcel.writeString(this.appid);
        parcel.writeString(this.openid);
        parcel.writeString(this.source);
        parcel.writeInt(this.systemId);
        parcel.writeString(this.platId);
        parcel.writeString(this.partitionId);
        parcel.writeInt(this.debug);
        parcel.writeInt(this.debugLog);
        parcel.writeInt(this.isLite);
        parcel.writeInt(this.performace);
        parcel.writeString(this.googleApiKey);
        parcel.writeInt(this.hms);
        parcel.writeInt(this.businessId);
        parcel.writeString(this.question);
        parcel.writeString(this.questionid);
        parcel.writeString(this.headerUrl);
        parcel.writeInt(this.os);
        parcel.writeString(this.itopGameId);
        parcel.writeInt(this.channelId);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.sig);
        parcel.writeString(this.token);
        parcel.writeInt(this.env);
        parcel.writeString(this.appId);
        parcel.writeString(this.openId);
    }

    public String toString() {
        return "GameParameters{language='" + this.language + "', timeZone='" + this.timeZone + "', enterName='" + this.enterName + "', gameVersion='" + this.gameVersion + "', gameId='" + this.gameId + "', areaId='" + this.areaId + "', areaName='" + this.areaName + "', roleId='" + this.roleId + "', roleName='" + this.roleName + "', regionId='" + this.regionId + "', regionName='" + this.regionName + "', country='" + this.country + "', ip='" + this.ip + "', ticket='" + this.ticket + "', sign='" + this.sign + "', signStr='" + this.signStr + "', channel='" + this.channel + "', appid='" + this.appid + "', openid='" + this.openid + "', source='" + this.source + "', systemId=" + this.systemId + ", platId='" + this.platId + "', partitionId='" + this.partitionId + "', debug=" + this.debug + ", debugLog=" + this.debugLog + ", isLite=" + this.isLite + ", performace=" + this.performace + ", googleApiKey='" + this.googleApiKey + "', hms=" + this.hms + ", businessId=" + this.businessId + ", question='" + this.question + "', questionid='" + this.questionid + "', headerUrl='" + this.headerUrl + "', os='" + this.os + "', itopGameId='" + this.itopGameId + "', channelId='" + this.channelId + "', timestamp='" + this.timestamp + "', sig='" + this.sig + "', token='" + this.token + "', env='" + this.env + "', appId='" + this.appId + "', openId='" + this.openId + "'}";
    }
}
