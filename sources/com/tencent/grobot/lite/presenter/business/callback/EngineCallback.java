package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface EngineCallback extends ActionCallback {
    void onInitLoadSucceed(int i, AnswerInfo answerInfo, boolean z, String str, String str2, JSONObject jSONObject, String str3, ReqInfo reqInfo);

    void onLoadFail(int i, int i2, String str, ReqInfo reqInfo);

    void onLoadSucceed(int i, AnswerInfo answerInfo, boolean z, ReqInfo reqInfo);
}
