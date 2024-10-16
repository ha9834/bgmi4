package com.tencent.grobot.lite.presenter.business.engine;

import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.model.req.QueryGBotLogReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.HistroyLogCallback;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HistoryLogEngine extends BaseEngine<HistroyLogCallback> {
    public static final int PAGE_SIZE = 10;

    public int getHistoryLog(String str, long j, long j2, int i) {
        try {
            QueryGBotLogReqInfo queryGBotLogReqInfo = new QueryGBotLogReqInfo();
            queryGBotLogReqInfo.start_time = j;
            queryGBotLogReqInfo.end_time = j2;
            queryGBotLogReqInfo.page = i;
            queryGBotLogReqInfo.size = 10;
            JSONObject jsonObject = queryGBotLogReqInfo.getJsonObject();
            jsonObject.put("msg_types", "");
            jsonObject.put("keyword", "");
            jsonObject.put("start_time", j);
            jsonObject.put("end_time", j2);
            jsonObject.put("page", i);
            jsonObject.put("size", 10);
            jsonObject.put("certificate", str);
            return sendJsonRequest(queryGBotLogReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        if (jSONObject != null) {
            notifyDataChanged(new CallbackHelper.Caller<HistroyLogCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.HistoryLogEngine.1
                @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                public void call(HistroyLogCallback histroyLogCallback) {
                    ReqInfo reqInfo2 = reqInfo;
                    histroyLogCallback.onGetHistoryLogResult(i, 0, "", jSONObject, (reqInfo2 == null || !(reqInfo2 instanceof QueryGBotLogReqInfo)) ? null : (QueryGBotLogReqInfo) reqInfo2);
                }
            });
        } else {
            handleJsonFail(i, getErrorCode(reqInfo), "resObj is null", null, reqInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, final int i2, final String str, JSONObject jSONObject, final ReqInfo reqInfo) {
        notifyDataChanged(new CallbackHelper.Caller<HistroyLogCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.HistoryLogEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(HistroyLogCallback histroyLogCallback) {
                ReqInfo reqInfo2 = reqInfo;
                histroyLogCallback.onGetHistoryLogResult(i, i2, str, null, (reqInfo2 == null || !(reqInfo2 instanceof QueryGBotLogReqInfo)) ? null : (QueryGBotLogReqInfo) reqInfo2);
            }
        });
    }

    private int getErrorCode(ReqInfo reqInfo) {
        return (reqInfo == null || !(reqInfo instanceof EvaluateReqInfo)) ? PresenterCode.Code_Engine_UNKNOWN_Error : PresenterCode.Code_Engine_Query_GBotLog_Error;
    }
}
