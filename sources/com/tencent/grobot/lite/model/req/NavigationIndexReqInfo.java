package com.tencent.grobot.lite.model.req;

import android.text.TextUtils;
import com.tencent.grobot.lite.common.TLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class NavigationIndexReqInfo extends ReqInfo {
    private static final String TAG = "NavigationIndexReqInfo ";

    @Override // com.tencent.grobot.lite.model.req.ReqInfo
    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.certificate)) {
            try {
                jSONObject.put("certificate", this.certificate);
            } catch (JSONException e) {
                TLog.d(TAG, "getJsonObject failed, ex" + e);
            }
        }
        return jSONObject;
    }
}
