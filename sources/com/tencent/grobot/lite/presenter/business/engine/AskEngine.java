package com.tencent.grobot.lite.presenter.business.engine;

import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.AnswerModelConverter;
import com.tencent.grobot.lite.model.req.AskReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.EngineCallback;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AskEngine extends BaseEngine<EngineCallback> {
    private static String certificate;

    public int sendAskJsonReq(String str, String str2, String str3, int i) {
        int i2;
        AskReqInfo askReqInfo = new AskReqInfo();
        if (str == null) {
            str = "";
        }
        askReqInfo.questionid = str;
        if (str2 == null) {
            str2 = "";
        }
        askReqInfo.question = str2;
        if (str3 == null) {
            str3 = "";
        }
        askReqInfo.certificate = str3;
        askReqInfo.robot_type = String.valueOf(i);
        JSONObject jsonObject = askReqInfo.getJsonObject();
        try {
            jsonObject.put("questionid", askReqInfo.questionid);
            jsonObject.put("question", askReqInfo.question);
            jsonObject.put("certificate", askReqInfo.certificate);
            jsonObject.put("robot_type", askReqInfo.robot_type);
            i2 = sendJsonRequest(askReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = -1;
        }
        TLog.d("Presenter.Engine", "sendAskReq,send, seq:" + i2 + ",questionId:" + askReqInfo.questionid + ",question:" + askReqInfo.question + ",certificate:" + askReqInfo.certificate);
        return i2;
    }

    public String getCertificate() {
        return certificate;
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                handleJsonFail(i, PresenterCode.Code_Engine_Ask_Error, "ask response invalid!", null, reqInfo);
                return;
            } else {
                certificate = optJSONObject.optString("certificate");
                notifyDataChanged(new CallbackHelper.Caller<EngineCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.AskEngine.1
                    @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                    public void call(EngineCallback engineCallback) {
                        ReqInfo reqInfo2 = reqInfo;
                        engineCallback.onLoadSucceed(i, AnswerModelConverter.convertAnswer(jSONObject), false, (reqInfo2 == null || !(reqInfo2 instanceof AskReqInfo)) ? null : (AskReqInfo) reqInfo2);
                    }
                });
                return;
            }
        }
        handleJsonFail(i, PresenterCode.Code_Engine_Ask_Error, "ask response invalid!", null, reqInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, final int i2, final String str, JSONObject jSONObject, final ReqInfo reqInfo) {
        TLog.d("Presenter.Engine", "handleFail seq:" + i + ",resultCode:" + i2 + ",msg:" + str);
        notifyDataChanged(new CallbackHelper.Caller<EngineCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.AskEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(EngineCallback engineCallback) {
                ReqInfo reqInfo2 = reqInfo;
                engineCallback.onLoadFail(i, i2, str, (reqInfo2 == null || !(reqInfo2 instanceof AskReqInfo)) ? null : (AskReqInfo) reqInfo2);
            }
        });
    }
}
