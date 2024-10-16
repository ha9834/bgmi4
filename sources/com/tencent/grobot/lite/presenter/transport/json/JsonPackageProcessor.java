package com.tencent.grobot.lite.presenter.transport.json;

import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.core.NetworkCallback;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.network.NetworkService;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.config.ServerConfig;
import com.tencent.grobot.lite.presenter.transport.json.JsonReqSender;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsonPackageProcessor implements NetworkCallback, Callable<Integer> {
    private static final String TAG = "Presenter.JsonPackageProcessor";
    private JsonReqSender.TransportListener listener;
    private ReqInfo reqInfo;
    private JSONObject requestObj;
    private int seq;

    public JsonPackageProcessor(int i, ReqInfo reqInfo, JSONObject jSONObject, JsonReqSender.TransportListener transportListener) {
        this.seq = i;
        this.reqInfo = reqInfo;
        this.requestObj = jSONObject;
        this.listener = transportListener;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        TLog.d(TAG, "send, seq:" + this.seq);
        NetworkService networkService = (NetworkService) GRobotApplication.getInstance().getService(NetworkService.class);
        if (networkService == null) {
            JsonReqSender.TransportListener transportListener = this.listener;
            if (transportListener != null) {
                transportListener.onJsonFail(this.seq, -100, "error", null, this.reqInfo, this.requestObj);
            }
            return -1;
        }
        networkService.sendJsonRequest(this.seq, ServerConfig.getApiInterface(this.reqInfo), this.requestObj, this);
        return 0;
    }

    @Override // com.tencent.grobot.lite.core.IServiceCallback
    public void onResult(int i, String str, Object... objArr) {
        TLog.d(TAG, "send.callback, seq:" + this.seq + ",result:" + i + ",msg:" + str);
        if (i == 0) {
            try {
                JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                int optInt = jSONObject.optInt("err_code");
                if (optInt == 200) {
                    if (this.listener != null) {
                        this.listener.onJsonSuccess(this.seq, jSONObject, this.reqInfo);
                    }
                } else {
                    String optString = jSONObject.optString("err_msg");
                    if (this.listener != null) {
                        this.listener.onJsonFail(this.seq, optInt, optString, jSONObject, this.reqInfo, this.requestObj);
                    }
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                this.listener.onJsonFail(this.seq, PresenterCode.Code_Decoder_PkgRspBody_Error, "", null, this.reqInfo, this.requestObj);
                return;
            }
        }
        this.listener.onJsonFail(this.seq, i, "", null, this.reqInfo, this.requestObj);
    }
}
