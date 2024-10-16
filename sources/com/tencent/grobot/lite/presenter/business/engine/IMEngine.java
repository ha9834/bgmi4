package com.tencent.grobot.lite.presenter.business.engine;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.req.CloseIMReqInfo;
import com.tencent.grobot.lite.model.req.CreateIMReqInfo;
import com.tencent.grobot.lite.model.req.IMReqInfo;
import com.tencent.grobot.lite.model.req.PullIMMsgReqInfo;
import com.tencent.grobot.lite.model.req.PushIMMsgReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.IMCallback;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IMEngine extends BaseEngine<IMCallback> {
    public int createIM(String str, String str2) {
        try {
            CreateIMReqInfo createIMReqInfo = new CreateIMReqInfo();
            buildReqInfo(createIMReqInfo, 0);
            createIMReqInfo.certificate = str;
            createIMReqInfo.tagId = str2;
            JSONObject jsonObject = createIMReqInfo.getJsonObject();
            jsonObject.put("tagid", str2);
            return sendJsonRequest(createIMReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int pushIMMsg(String str, int i, String str2, String str3) {
        try {
            PushIMMsgReqInfo pushIMMsgReqInfo = new PushIMMsgReqInfo();
            buildReqInfo(pushIMMsgReqInfo, 1);
            pushIMMsgReqInfo.certificate = str;
            pushIMMsgReqInfo.sessionId = str3;
            pushIMMsgReqInfo.msgType = i;
            pushIMMsgReqInfo.content = str2;
            pushIMMsgReqInfo.sessionId = str3;
            JSONObject jsonObject = pushIMMsgReqInfo.getJsonObject();
            jsonObject.put(FirebaseAnalytics.Param.CONTENT, str2);
            jsonObject.put("msg_type", i);
            jsonObject.put("im_session_id", str3);
            return sendJsonRequest(pushIMMsgReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int pullIMMsg(String str) {
        try {
            PullIMMsgReqInfo pullIMMsgReqInfo = new PullIMMsgReqInfo();
            buildReqInfo(pullIMMsgReqInfo, 2);
            pullIMMsgReqInfo.certificate = str;
            return sendJsonRequest(pullIMMsgReqInfo, pullIMMsgReqInfo.getJsonObject());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int closeIM(String str, String str2) {
        try {
            CloseIMReqInfo closeIMReqInfo = new CloseIMReqInfo();
            closeIMReqInfo.sessionId = str2;
            closeIMReqInfo.certificate = str;
            buildReqInfo(closeIMReqInfo, 3);
            JSONObject jsonObject = closeIMReqInfo.getJsonObject();
            jsonObject.put("im_session_id", str2);
            return sendJsonRequest(closeIMReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void buildReqInfo(IMReqInfo iMReqInfo, int i) {
        iMReqInfo.type = i;
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        if (jSONObject != null) {
            notifyDataChanged(new CallbackHelper.Caller<IMCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.IMEngine.1
                @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                public void call(IMCallback iMCallback) {
                    ReqInfo reqInfo2 = reqInfo;
                    if (reqInfo2 == null || !(reqInfo2 instanceof IMReqInfo)) {
                        return;
                    }
                    IMReqInfo iMReqInfo = (IMReqInfo) reqInfo2;
                    switch (((IMReqInfo) reqInfo2).type) {
                        case 0:
                            iMCallback.onCreateIMResult(i, 0, "", jSONObject, iMReqInfo);
                            return;
                        case 1:
                            iMCallback.onPushIMMsgResult(i, 0, "", jSONObject, iMReqInfo);
                            return;
                        case 2:
                            iMCallback.onPullIMMsgResult(i, 0, "", jSONObject, iMReqInfo);
                            return;
                        case 3:
                            iMCallback.onCloseIMResult(i, 0, "", jSONObject, iMReqInfo);
                            return;
                        default:
                            return;
                    }
                }
            });
        } else {
            handleJsonFail(i, getErrorCode(reqInfo), "resObj is null", null, reqInfo);
        }
    }

    private int getErrorCode(ReqInfo reqInfo) {
        if (reqInfo == null || !(reqInfo instanceof IMReqInfo)) {
            return PresenterCode.Code_Engine_UNKNOWN_Error;
        }
        switch (((IMReqInfo) reqInfo).type) {
            case 0:
                return PresenterCode.Code_Engine_Create_Im_Error;
            case 1:
                return PresenterCode.Code_Engine_Push_Im_Msg_Error;
            case 2:
                return PresenterCode.Code_Engine_Pull_Im_Msg_Error;
            case 3:
                return PresenterCode.Code_Engine_Close_Im_Error;
            default:
                return PresenterCode.Code_Engine_UNKNOWN_Error;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, final int i2, final String str, JSONObject jSONObject, final ReqInfo reqInfo) {
        TLog.d("Presenter.Engine", "handleFail seq:" + i + ",resultCode:" + i2 + ",msg:" + str);
        notifyDataChanged(new CallbackHelper.Caller<IMCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.IMEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(IMCallback iMCallback) {
                ReqInfo reqInfo2 = reqInfo;
                if (reqInfo2 instanceof IMReqInfo) {
                    IMReqInfo iMReqInfo = (IMReqInfo) reqInfo2;
                    switch (((IMReqInfo) reqInfo2).type) {
                        case 0:
                            iMCallback.onCreateIMResult(i, i2, str, null, iMReqInfo);
                            return;
                        case 1:
                            iMCallback.onPushIMMsgResult(i, i2, str, null, iMReqInfo);
                            return;
                        case 2:
                            iMCallback.onPullIMMsgResult(i, i2, str, null, iMReqInfo);
                            return;
                        case 3:
                            iMCallback.onCloseIMResult(i, i2, str, null, iMReqInfo);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
