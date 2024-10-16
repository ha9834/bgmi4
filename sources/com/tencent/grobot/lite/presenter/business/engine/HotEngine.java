package com.tencent.grobot.lite.presenter.business.engine;

import com.facebook.appevents.UserDataStore;
import com.intlgame.webview.WebViewManager;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GameParameters;
import com.tencent.grobot.lite.model.AnswerModelConverter;
import com.tencent.grobot.lite.model.req.HotReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.HotCallback;
import com.tencent.imsdk.android.login.migrate.MigrateWebConsts;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HotEngine extends BaseEngine<HotCallback> {
    public int sendHotReq() {
        try {
            GameParameters gameParam = GRobotApplication.getInstance().getGameParam();
            HotReqInfo hotReqInfo = new HotReqInfo();
            hotReqInfo.appid = gameParam != null ? gameParam.appid : "";
            hotReqInfo.openid = gameParam != null ? gameParam.openid : "";
            hotReqInfo.gameid = gameParam != null ? gameParam.gameId : "";
            hotReqInfo.source = gameParam != null ? gameParam.source : "";
            hotReqInfo.channel = "1";
            hotReqInfo.country = "";
            hotReqInfo.language = gameParam != null ? gameParam.language : "en";
            hotReqInfo.time_zone = gameParam != null ? gameParam.timeZone : "";
            JSONObject jsonObject = hotReqInfo.getJsonObject();
            jsonObject.put("appid", hotReqInfo.appid);
            jsonObject.put("openid", hotReqInfo.openid);
            jsonObject.put(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_GAME_ID, hotReqInfo.gameid);
            jsonObject.put(WebViewManager.KEY_JS_CHANNEL, hotReqInfo.channel);
            jsonObject.put(UserDataStore.COUNTRY, hotReqInfo.country);
            jsonObject.put("language", hotReqInfo.language);
            jsonObject.put("time_zone", hotReqInfo.time_zone);
            jsonObject.put("source", hotReqInfo.source);
            return sendJsonRequest(hotReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        if (jSONObject != null) {
            try {
                notifyDataChanged(new CallbackHelper.Caller<HotCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.HotEngine.1
                    @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                    public void call(HotCallback hotCallback) {
                        ReqInfo reqInfo2 = reqInfo;
                        hotCallback.onGetHotResult(i, 0, "", AnswerModelConverter.convertHotTopicList(jSONObject), (reqInfo2 == null || !(reqInfo2 instanceof HotReqInfo)) ? null : (HotReqInfo) reqInfo2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                handleJsonFail(i, PresenterCode.Code_Engine_Hot_Error, "response is empty", null, reqInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, final int i2, final String str, JSONObject jSONObject, final ReqInfo reqInfo) {
        notifyDataChanged(new CallbackHelper.Caller<HotCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.HotEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(HotCallback hotCallback) {
                ReqInfo reqInfo2 = reqInfo;
                hotCallback.onGetHotResult(i, i2, str, null, (reqInfo2 == null || !(reqInfo2 instanceof HotReqInfo)) ? null : (HotReqInfo) reqInfo2);
            }
        });
    }
}
