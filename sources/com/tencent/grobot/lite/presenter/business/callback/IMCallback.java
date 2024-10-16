package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.model.req.IMReqInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface IMCallback extends ActionCallback {
    void onCloseIMResult(int i, int i2, String str, JSONObject jSONObject, IMReqInfo iMReqInfo);

    void onCreateIMResult(int i, int i2, String str, JSONObject jSONObject, IMReqInfo iMReqInfo);

    void onPullIMMsgResult(int i, int i2, String str, JSONObject jSONObject, IMReqInfo iMReqInfo);

    void onPushIMMsgResult(int i, int i2, String str, JSONObject jSONObject, IMReqInfo iMReqInfo);
}
