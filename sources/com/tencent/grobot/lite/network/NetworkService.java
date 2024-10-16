package com.tencent.grobot.lite.network;

import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.core.IService;
import com.tencent.grobot.lite.core.IServiceCallback;
import com.tencent.grobot.lite.network.access.AccessRequest;
import com.tencent.grobot.lite.network.access.http.HttpConnectionStack;
import com.tencent.grobot.lite.network.access.http.NetCallback;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NetworkService implements IService {
    private static final String TAG = "Network.NetworkService";
    private final GRobotApplication app;
    private HttpConnectionStack httpConnection = null;

    @Override // com.tencent.grobot.lite.core.IService
    public void onDestroy() {
    }

    public NetworkService(GRobotApplication gRobotApplication) {
        this.app = gRobotApplication;
    }

    public int sendJsonRequest(int i, String str, JSONObject jSONObject, final IServiceCallback iServiceCallback) {
        if (this.httpConnection == null) {
            this.httpConnection = new HttpConnectionStack();
        }
        AccessRequest buildJsonRequest = buildJsonRequest(i, "", jSONObject);
        StringBuilder sb = new StringBuilder();
        sb.append("enqueue, seq:");
        sb.append(buildJsonRequest != null ? buildJsonRequest.getRequestId() : 0);
        sb.append(", url:");
        sb.append(str);
        TLog.d(TAG, sb.toString());
        if (this.httpConnection == null) {
            if (iServiceCallback != null) {
                iServiceCallback.onResult(ResultCode.Code_Connection_Invalid_Error, "", new Object[0]);
            } else {
                throw new IllegalArgumentException("not find callback, enqueue must set callback");
            }
        }
        this.httpConnection.enqueue(str, buildJsonRequest, new NetCallback() { // from class: com.tencent.grobot.lite.network.NetworkService.1
            @Override // com.tencent.grobot.lite.network.access.http.NetCallback
            public void onFinish(int i2, int i3, byte[] bArr) {
                TLog.d(NetworkService.TAG, "enqueue.callback, seq:" + i2 + ", errorCode:" + i3);
                IServiceCallback iServiceCallback2 = iServiceCallback;
                if (iServiceCallback2 != null) {
                    iServiceCallback2.onResult(i3, "", bArr);
                    return;
                }
                throw new IllegalArgumentException("not find callback, enqueue must set callback");
            }
        });
        return i;
    }

    public AccessRequest buildJsonRequest(int i, String str, JSONObject jSONObject) {
        return new AccessRequest.Builder().requestId(i).addHeader("Content-Type", "application/json").post(jSONObject.toString().getBytes()).build();
    }
}
