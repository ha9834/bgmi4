package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.model.req.QueryGBotLogReqInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface HistroyLogCallback extends ActionCallback {
    void onGetHistoryLogResult(int i, int i2, String str, JSONObject jSONObject, QueryGBotLogReqInfo queryGBotLogReqInfo);
}
