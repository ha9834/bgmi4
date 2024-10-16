package com.tencent.grobot.lite.presenter.business.engine;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.AnswerModelConverter;
import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.local.AnswerItemInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.model.req.CommonReportReqInfo;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.model.req.EventReportInfo;
import com.tencent.grobot.lite.model.req.GetPackageReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.LogicCallback;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LogicEngine extends BaseEngine<LogicCallback> {
    public static int GFIT_REGET = 300707;
    public static int GIFT_FAIL = 300706;

    public int addEvaluate(String str, int i, EvaluateItemInfo evaluateItemInfo, boolean z) {
        try {
            EvaluateReqInfo evaluateReqInfo = new EvaluateReqInfo();
            evaluateReqInfo.rating = i;
            evaluateReqInfo.certificate = str;
            evaluateReqInfo.evaluateType = evaluateItemInfo.evaluateType;
            evaluateReqInfo.evaluateValue = String.valueOf(evaluateItemInfo.evaluateValue);
            evaluateReqInfo.evaluateContent = evaluateItemInfo.reqText;
            evaluateReqInfo.selectContent = evaluateItemInfo.selectText;
            evaluateReqInfo.evaluateId = evaluateItemInfo.evaluateId;
            evaluateReqInfo.iconType = evaluateItemInfo.iconType;
            evaluateReqInfo.answerKey = evaluateItemInfo.answerKey;
            evaluateReqInfo.firstClickText = evaluateItemInfo.fistClickText;
            evaluateReqInfo.secondClickText = evaluateItemInfo.secondClickText;
            if (z) {
                evaluateReqInfo.commitText = evaluateItemInfo.commitText;
            }
            JSONObject jsonObject = evaluateReqInfo.getJsonObject();
            jsonObject.put("certificate", evaluateReqInfo.certificate);
            jsonObject.put("evaluate_type", evaluateReqInfo.evaluateType);
            jsonObject.put("evaluate_value", evaluateReqInfo.evaluateValue);
            jsonObject.put("evaluate_content", evaluateReqInfo.evaluateContent);
            jsonObject.put("evaluate_id", evaluateReqInfo.evaluateId);
            return sendJsonRequest(evaluateReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int reportEvent(String str, String str2, String str3, String str4) {
        try {
            EventReportInfo eventReportInfo = new EventReportInfo();
            eventReportInfo.certificate = str;
            eventReportInfo.eventId = str2;
            eventReportInfo.eventType = str3;
            eventReportInfo.ext = str4;
            JSONObject jsonObject = eventReportInfo.getJsonObject();
            jsonObject.put("event_id", eventReportInfo.eventId);
            jsonObject.put("event_type", eventReportInfo.eventType);
            jsonObject.put("ext", eventReportInfo.ext);
            return sendJsonRequest(eventReportInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int reportCommon(String str, ArrayList<String> arrayList) {
        try {
            CommonReportReqInfo commonReportReqInfo = new CommonReportReqInfo();
            commonReportReqInfo.certificate = str;
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    jSONArray.put(new JSONObject(next));
                }
            }
            commonReportReqInfo.metricLogs = jSONArray;
            TLog.d("report", "content = " + commonReportReqInfo.metricLogs.toString());
            return sendJsonRequest(commonReportReqInfo, commonReportReqInfo.getJsonObject());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getGiftPackage(String str, String str2, String str3, String str4, String str5) {
        try {
            GetPackageReqInfo getPackageReqInfo = new GetPackageReqInfo();
            getPackageReqInfo.certificate = str;
            getPackageReqInfo.groupId = str2;
            getPackageReqInfo.amsId = str3;
            getPackageReqInfo.packageName = str4;
            getPackageReqInfo.answerId = str5;
            JSONObject jsonObject = getPackageReqInfo.getJsonObject();
            jsonObject.put(FirebaseAnalytics.Param.GROUP_ID, getPackageReqInfo.groupId);
            jsonObject.put("ams_id", getPackageReqInfo.amsId);
            jsonObject.put("package_name", getPackageReqInfo.packageName);
            jsonObject.put("answer_id", getPackageReqInfo.answerId);
            return sendJsonRequest(getPackageReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine, com.tencent.grobot.lite.presenter.transport.json.JsonReqSender.TransportListener
    public void onJsonFail(int i, int i2, String str, JSONObject jSONObject, ReqInfo reqInfo, JSONObject jSONObject2) {
        handleJsonFail(i, i2, str, jSONObject, reqInfo);
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        if (jSONObject != null) {
            notifyDataChanged(new CallbackHelper.Caller<LogicCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.LogicEngine.1
                @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                public void call(LogicCallback logicCallback) {
                    AnswerInfo answerInfo;
                    AnswerItemInfo converAnswerItemInfo;
                    ReqInfo reqInfo2 = reqInfo;
                    if (reqInfo2 != null) {
                        if (reqInfo2 instanceof EvaluateReqInfo) {
                            logicCallback.onAddEvaluate(i, 0, "", jSONObject, (EvaluateReqInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof EventReportInfo) {
                            logicCallback.onReportEvent(i, 0, "", (EventReportInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof GetPackageReqInfo) {
                            JSONObject jSONObject2 = jSONObject;
                            if (jSONObject2 == null || (converAnswerItemInfo = AnswerModelConverter.converAnswerItemInfo(jSONObject2.optJSONObject("result"), "", false)) == null) {
                                answerInfo = null;
                            } else {
                                AnswerInfo answerInfo2 = new AnswerInfo();
                                answerInfo2.answerList = new ArrayList<>();
                                answerInfo2.answerList.add(converAnswerItemInfo);
                                answerInfo = answerInfo2;
                            }
                            logicCallback.onGetPackage(i, 0, "", answerInfo, (GetPackageReqInfo) reqInfo);
                        }
                    }
                }
            });
        } else {
            handleJsonFail(i, getErrorCode(reqInfo), "resObj is null", null, reqInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, final int i2, final String str, final JSONObject jSONObject, final ReqInfo reqInfo) {
        TLog.d("Presenter.Engine", "handleFail seq:" + i + ",resultCode:" + i2 + ",msg:" + str);
        notifyDataChanged(new CallbackHelper.Caller<LogicCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.LogicEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(LogicCallback logicCallback) {
                JSONObject jSONObject2;
                AnswerItemInfo converAnswerItemInfo;
                ReqInfo reqInfo2 = reqInfo;
                if (reqInfo2 != null) {
                    if (reqInfo2 instanceof EvaluateReqInfo) {
                        logicCallback.onAddEvaluate(i, i2, str, null, (EvaluateReqInfo) reqInfo2);
                        return;
                    }
                    if (reqInfo2 instanceof EventReportInfo) {
                        logicCallback.onReportEvent(i, i2, str, (EventReportInfo) reqInfo2);
                        return;
                    }
                    if (reqInfo2 instanceof GetPackageReqInfo) {
                        if ((i2 == LogicEngine.GIFT_FAIL || i2 == LogicEngine.GFIT_REGET) && (jSONObject2 = jSONObject) != null && (converAnswerItemInfo = AnswerModelConverter.converAnswerItemInfo(jSONObject2.optJSONObject("result"), "", false)) != null) {
                            AnswerInfo answerInfo = new AnswerInfo();
                            answerInfo.answerList = new ArrayList<>();
                            answerInfo.answerList.add(converAnswerItemInfo);
                            logicCallback.onGetPackage(i, i2, "", answerInfo, (GetPackageReqInfo) reqInfo);
                            return;
                        }
                        logicCallback.onGetPackage(i, i2, str, null, (GetPackageReqInfo) reqInfo);
                    }
                }
            }
        });
    }

    private int getErrorCode(ReqInfo reqInfo) {
        return (reqInfo == null || !(reqInfo instanceof EvaluateReqInfo)) ? PresenterCode.Code_Engine_UNKNOWN_Error : PresenterCode.Code_Engine_Add_Evaluate_Error;
    }
}
