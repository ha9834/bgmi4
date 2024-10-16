package com.tencent.grobot.lite.presenter.business.engine;

import com.facebook.appevents.UserDataStore;
import com.intlgame.webview.WebViewManager;
import com.tencent.connect.common.Constants;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GameParameters;
import com.tencent.grobot.lite.common.Const;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.AnswerModelConverter;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.req.InitReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.EngineCallback;
import com.tencent.imsdk.android.login.migrate.MigrateWebConsts;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class InitEngine extends BaseEngine<EngineCallback> {
    private static String certificate;

    public int initJsonRequest(boolean z, boolean z2) {
        int i = -1;
        try {
            GameParameters gameParam = GRobotApplication.getInstance().getGameParam();
            InitReqInfo initReqInfo = new InitReqInfo();
            initReqInfo.language = gameParam != null ? gameParam.language : "en";
            initReqInfo.time_zone = gameParam != null ? gameParam.timeZone : "";
            initReqInfo.appid = gameParam != null ? gameParam.appid : "";
            initReqInfo.areaid = gameParam != null ? String.valueOf(gameParam.areaId) : "";
            initReqInfo.area_name = gameParam != null ? String.valueOf(gameParam.areaName) : "";
            initReqInfo.systemid = gameParam != null ? String.valueOf(gameParam.systemId) : "";
            initReqInfo.platid = gameParam != null ? String.valueOf(gameParam.platId) : "";
            initReqInfo.partitionid = gameParam != null ? gameParam.partitionId : "";
            initReqInfo.roleid = gameParam != null ? gameParam.roleId : "";
            initReqInfo.rolename = gameParam != null ? gameParam.roleName : "";
            initReqInfo.regionid = gameParam != null ? String.valueOf(gameParam.regionId) : "";
            initReqInfo.regionname = gameParam != null ? String.valueOf(gameParam.regionName) : "";
            initReqInfo.gameversion = gameParam != null ? String.valueOf(gameParam.gameVersion) : "";
            initReqInfo.country = gameParam != null ? String.valueOf(gameParam.country) : "";
            initReqInfo.ip = gameParam != null ? String.valueOf(gameParam.ip) : "";
            initReqInfo.mobiletype = SystemUtils.getPhoneBrand();
            initReqInfo.mobilemodel = SystemUtils.getPhoneModel();
            initReqInfo.mobilesystem = "android";
            initReqInfo.networktype = SystemUtils.getNetworkType();
            initReqInfo.source = gameParam != null ? gameParam.source : "";
            initReqInfo.sdkversion = Const.getSDKVersion();
            initReqInfo.gameid = gameParam != null ? gameParam.gameId : "";
            initReqInfo.ticket = gameParam != null ? gameParam.ticket : "";
            initReqInfo.openid = gameParam != null ? gameParam.openid : "";
            initReqInfo.channel = gameParam != null ? gameParam.channel : "1";
            initReqInfo.sign = gameParam != null ? gameParam.sign : "";
            initReqInfo.signStr = gameParam != null ? gameParam.signStr : "";
            initReqInfo.question = gameParam != null ? gameParam.question : "";
            initReqInfo.questionid = gameParam != null ? gameParam.questionid : "";
            initReqInfo.appId = gameParam != null ? gameParam.appId : "";
            initReqInfo.openId = gameParam != null ? gameParam.openId : "";
            initReqInfo.os = gameParam != null ? gameParam.os : 1;
            initReqInfo.itopGameId = gameParam != null ? gameParam.itopGameId : "";
            initReqInfo.channelId = gameParam != null ? gameParam.channelId : 0;
            initReqInfo.token = gameParam != null ? gameParam.token : "";
            initReqInfo.env = gameParam != null ? gameParam.env : 0;
            initReqInfo.timestamp = gameParam != null ? gameParam.timestamp : 0L;
            initReqInfo.sig = gameParam != null ? gameParam.sig : "";
            initReqInfo.isIMStatus = z;
            initReqInfo.pureInit = z2;
            JSONObject jsonObject = initReqInfo.getJsonObject();
            JSONObject jSONObject = new JSONObject();
            jsonObject.put("itopParam", jSONObject);
            jSONObject.put("os", initReqInfo.os);
            jSONObject.put("itopGameId", initReqInfo.itopGameId);
            jSONObject.put("channelId", initReqInfo.channelId);
            jSONObject.put("timestamp", initReqInfo.timestamp);
            jSONObject.put("sig", initReqInfo.sig);
            jSONObject.put("openId", initReqInfo.openId);
            jSONObject.put("token", initReqInfo.token);
            jsonObject.put("appid", initReqInfo.appid);
            jsonObject.put("openid", initReqInfo.openid);
            jsonObject.put(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_GAME_ID, initReqInfo.gameid);
            jsonObject.put("areaid", initReqInfo.areaid);
            jsonObject.put("area_name", initReqInfo.area_name);
            jsonObject.put("systemid", initReqInfo.systemid);
            jsonObject.put(Constants.PLATID, initReqInfo.platid);
            jsonObject.put("partitionid", initReqInfo.partitionid);
            jsonObject.put("roleid", initReqInfo.roleid);
            jsonObject.put("role_name", initReqInfo.rolename);
            jsonObject.put("regionid", initReqInfo.regionid);
            jsonObject.put("region", initReqInfo.regionname);
            jsonObject.put("source", initReqInfo.source);
            jsonObject.put(WebViewManager.KEY_JS_CHANNEL, initReqInfo.channel);
            jsonObject.put(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, initReqInfo.sdkversion);
            jsonObject.put("game_version", initReqInfo.gameversion);
            jsonObject.put(UserDataStore.COUNTRY, initReqInfo.country);
            jsonObject.put("language", initReqInfo.language);
            jsonObject.put("time_zone", initReqInfo.time_zone);
            jsonObject.put("ip", initReqInfo.ip);
            jsonObject.put("mobile_type", initReqInfo.mobiletype);
            jsonObject.put("mobile_model", initReqInfo.mobilemodel);
            jsonObject.put("mobile_system", initReqInfo.mobilesystem);
            if (!GRobotApplication.getInstance().isHms()) {
                jsonObject.put("network_type", initReqInfo.networktype);
            }
            jsonObject.put(EvaluateInfo.TYPE_TICKET, initReqInfo.ticket);
            jsonObject.put("sign", initReqInfo.sign);
            jsonObject.put("sign_text", initReqInfo.signStr);
            jsonObject.put("question", initReqInfo.question);
            jsonObject.put("questionid", initReqInfo.questionid);
            jsonObject.put("performance", GRobotApplication.getInstance().getGameParam().performace);
            jsonObject.put("business_id", gameParam != null ? gameParam.businessId : 1000);
            jsonObject.put("ext", GRobotApplication.getInstance().getGameParamString());
            i = sendJsonRequest(initReqInfo, jsonObject);
            TLog.d("Presenter.Engine", "initRequest seq:" + i + ", gameId:" + initReqInfo.gameid + ",source:" + initReqInfo.source + ",systemId:" + initReqInfo.systemid + ",platId:" + initReqInfo.platid + ",areaId:" + initReqInfo.areaid + ",partitionId:" + initReqInfo.partitionid + ",roleId:" + initReqInfo.roleid + ",regionId:" + initReqInfo.regionid);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public String getCertificate() {
        return certificate;
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine, com.tencent.grobot.lite.presenter.transport.json.JsonReqSender.TransportListener
    public void onJsonFail(int i, int i2, String str, JSONObject jSONObject, ReqInfo reqInfo, JSONObject jSONObject2) {
        handleJsonFail(i, i2, str, jSONObject, reqInfo);
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        try {
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                certificate = optJSONObject.optString("certificate");
                TLog.d("Presenter.Engine", "handleSuccess seq:" + i + ",loadCache:false,certificate:" + certificate);
                final String optString = optJSONObject.optString("mode_type");
                final String optString2 = optJSONObject.optString("im_status");
                final JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isShowLoading", optJSONObject.optBoolean("is_loading_showing", false));
                jSONObject2.put("imLimitNum", optJSONObject.optInt("im_limit_num"));
                jSONObject2.put("longTextLimitNum", optJSONObject.optInt("long_text_limit_num"));
                jSONObject2.put("setId", optJSONObject.optInt("set_id"));
                jSONObject2.put("robotType", optJSONObject.optInt("robot_type"));
                jSONObject2.put("unreadMsgNum", optJSONObject.optInt("unread_msg_num"));
                notifyDataChanged(new CallbackHelper.Caller<EngineCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.InitEngine.1
                    @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                    public void call(EngineCallback engineCallback) {
                        ReqInfo reqInfo2 = reqInfo;
                        engineCallback.onInitLoadSucceed(i, AnswerModelConverter.convertAnswer(jSONObject), false, optString, optString2, jSONObject2, jSONObject.toString(), reqInfo2 instanceof InitReqInfo ? (InitReqInfo) reqInfo2 : null);
                    }
                });
            } else {
                handleJsonFail(i, PresenterCode.Code_Engine_Init_Error, "response is empty", null, reqInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            handleJsonFail(i, PresenterCode.Code_Engine_Init_Error, "response is empty", null, reqInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, final int i2, final String str, JSONObject jSONObject, final ReqInfo reqInfo) {
        TLog.d("Presenter.Engine", "handleFail seq:" + i + ",resultCode:" + i2 + ",msg:" + str);
        notifyDataChanged(new CallbackHelper.Caller<EngineCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.InitEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(EngineCallback engineCallback) {
                ReqInfo reqInfo2 = reqInfo;
                engineCallback.onLoadFail(i, i2, str, (reqInfo2 == null || !(reqInfo2 instanceof InitReqInfo)) ? null : (InitReqInfo) reqInfo2);
            }
        });
    }
}
