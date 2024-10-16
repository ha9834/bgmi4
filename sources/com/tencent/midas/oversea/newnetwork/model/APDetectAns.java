package com.tencent.midas.oversea.newnetwork.model;

import android.os.Message;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APDetectAns extends APMidasHttpAns {
    Message msg;

    public APDetectAns(IAPMidasHttpCallback iAPMidasHttpCallback) {
        super(iAPMidasHttpCallback);
        this.msg = new Message();
        this.msg.what = 5;
    }

    public Message getDetuctMsg() {
        return this.msg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleSuccess(Response response) {
        progressJson(response.responseBody);
        return super.handleSuccess(response);
    }

    private void progressJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("ret") == 0) {
                JSONArray jSONArray = jSONObject.getJSONArray("tasks");
                if (jSONArray != null && jSONArray.length() > 0) {
                    this.msg.what = 4;
                    this.msg.obj = jSONArray;
                } else {
                    this.msg.what = 5;
                }
            }
            APLog.d(getClass().getName(), jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleFailure(Response response) {
        return super.handleFailure(response);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleStop(Response response) {
        return super.handleStop(response);
    }
}
