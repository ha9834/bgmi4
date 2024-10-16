package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.model.req.EventReportInfo;
import com.tencent.grobot.lite.model.req.GetPackageReqInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface LogicCallback extends ActionCallback {
    void onAddEvaluate(int i, int i2, String str, JSONObject jSONObject, EvaluateReqInfo evaluateReqInfo);

    void onGetPackage(int i, int i2, String str, AnswerInfo answerInfo, GetPackageReqInfo getPackageReqInfo);

    void onReportEvent(int i, int i2, String str, EventReportInfo eventReportInfo);
}
