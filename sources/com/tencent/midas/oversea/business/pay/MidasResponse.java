package com.tencent.midas.oversea.business.pay;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.CocosPayHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MidasResponse {
    private String appExtends;
    private String extra;
    boolean needShowSuccess;
    private int resultCode;
    private String resultMsg;

    public MidasResponse(int i) {
        this.resultMsg = "";
        this.extra = "";
        this.appExtends = "";
        this.needShowSuccess = true;
        this.resultCode = i;
    }

    public MidasResponse(int i, String str) {
        this.resultMsg = "";
        this.extra = "";
        this.appExtends = "";
        this.needShowSuccess = true;
        this.resultCode = i;
        this.resultMsg = str;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public String getAPPExtends() {
        return this.appExtends;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setAppExtends(String str) {
        this.appExtends = str;
    }

    public void setExtra(JSONObject jSONObject) {
        this.extra = jSONObject.toString();
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CocosPayHelper.RES_CODE, this.resultCode);
            jSONObject.put(CocosPayHelper.RES_MSG, this.resultMsg);
            if (!TextUtils.isEmpty(this.extra)) {
                jSONObject.put("extra", this.extra);
            }
            if (!TextUtils.isEmpty(this.appExtends)) {
                jSONObject.put("appExtends", this.appExtends);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            APLog.d("MidasResponse", "toString() exception|" + e.getMessage());
            return "";
        }
    }
}
