package com.tencent.grobot.lite.model.req;

import com.facebook.appevents.UserDataStore;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.imsdk.android.login.migrate.MigrateWebConsts;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class RecommendsReqInfo extends ReqInfo {
    private static final String TAG = "RecommendsReqInfo";
    public String appid;
    public String country;
    public String gameVersion;
    public String gameid;
    public String language;
    public String openid;
    public String source;
    public String timeZone;
    public String version;

    @Override // com.tencent.grobot.lite.model.req.ReqInfo
    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.appid);
            jSONObject.put("openid", this.openid);
            jSONObject.put(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_GAME_ID, this.gameid);
            jSONObject.put("source", this.source);
            jSONObject.put("game_version", this.gameVersion);
            jSONObject.put("version", this.version);
            jSONObject.put(UserDataStore.COUNTRY, this.country);
            jSONObject.put("language", this.language);
            jSONObject.put("time_zone", this.timeZone);
        } catch (JSONException e) {
            TLog.d(TAG, "getJsonObject, ex=" + e);
        }
        return jSONObject;
    }
}
