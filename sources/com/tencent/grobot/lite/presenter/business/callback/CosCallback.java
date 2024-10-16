package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.model.req.GetCosFederationTokenReqInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface CosCallback extends ActionCallback {
    void onGetCosFederatinTokenResult(int i, int i2, String str, JSONObject jSONObject, GetCosFederationTokenReqInfo getCosFederationTokenReqInfo);
}
