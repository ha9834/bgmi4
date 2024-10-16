package com.tencent.grobot.lite.presenter.business.engine;

import com.tencent.grobot.lite.model.req.GetCosFederationTokenReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.CosCallback;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GetCosFederationTokenEngine extends BaseEngine<CosCallback> {
    public int sendGetCosFederationTokenReq(String str) {
        try {
            GetCosFederationTokenReqInfo getCosFederationTokenReqInfo = new GetCosFederationTokenReqInfo();
            getCosFederationTokenReqInfo.certificate = str;
            return sendJsonRequest(getCosFederationTokenReqInfo, getCosFederationTokenReqInfo.getJsonObject());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private JSONObject getReqObj(GetCosFederationTokenReqInfo getCosFederationTokenReqInfo) {
        JSONObject jSONObject = new JSONObject();
        if (getCosFederationTokenReqInfo != null) {
            try {
                jSONObject.put("certificate", getCosFederationTokenReqInfo.certificate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        if (jSONObject != null) {
            try {
                notifyDataChanged(new CallbackHelper.Caller<CosCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.GetCosFederationTokenEngine.1
                    @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                    public void call(CosCallback cosCallback) {
                        ReqInfo reqInfo2 = reqInfo;
                        cosCallback.onGetCosFederatinTokenResult(i, 0, "", jSONObject, (reqInfo2 == null || !(reqInfo2 instanceof GetCosFederationTokenReqInfo)) ? null : (GetCosFederationTokenReqInfo) reqInfo2);
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
        notifyDataChanged(new CallbackHelper.Caller<CosCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.GetCosFederationTokenEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(CosCallback cosCallback) {
                ReqInfo reqInfo2 = reqInfo;
                cosCallback.onGetCosFederatinTokenResult(i, i2, str, null, (reqInfo2 == null || !(reqInfo2 instanceof GetCosFederationTokenReqInfo)) ? null : (GetCosFederationTokenReqInfo) reqInfo2);
            }
        });
    }
}
