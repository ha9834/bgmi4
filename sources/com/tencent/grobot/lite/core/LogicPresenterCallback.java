package com.tencent.grobot.lite.core;

import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.req.CommonReportReqInfo;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.model.req.EventReportInfo;
import com.tencent.grobot.lite.model.req.GetPackageReqInfo;

/* loaded from: classes2.dex */
public interface LogicPresenterCallback extends IServiceCallback {
    void onCommonReportResult(int i, String str, CommonReportReqInfo commonReportReqInfo);

    void onEvaluateResult(int i, String str, EvaluateReqInfo evaluateReqInfo);

    void onGetPackageResult(int i, String str, AnswerInfo answerInfo, GetPackageReqInfo getPackageReqInfo);

    void onReportEventResult(int i, String str, EventReportInfo eventReportInfo);
}
