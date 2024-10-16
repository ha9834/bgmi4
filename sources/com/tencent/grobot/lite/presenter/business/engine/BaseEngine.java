package com.tencent.grobot.lite.presenter.business.engine;

import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.business.callback.ActionCallback;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.transport.json.JsonReqSender;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class BaseEngine<T extends ActionCallback> implements JsonReqSender.TransportListener {
    protected static final String TAG = "Presenter.Engine";
    public static boolean sReInit;
    protected JsonReqSender jsonReqSender;
    protected final InvalidCertDelegate delegate = new InvalidCertDelegate(this);
    protected CallbackHelper<T> mCallbacks = new CallbackHelper<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void handleJsonFail(int i, int i2, String str, JSONObject jSONObject, ReqInfo reqInfo);

    protected abstract void handleJsonSuccess(int i, JSONObject jSONObject, ReqInfo reqInfo);

    public void register(T t, JsonReqSender jsonReqSender) {
        this.jsonReqSender = jsonReqSender;
        this.mCallbacks.register(t);
    }

    public void unregister(T t) {
        this.mCallbacks.unregister(t);
    }

    public void addCallback(T t) {
        this.mCallbacks.register(t);
    }

    public void removeCallback(T t) {
        this.mCallbacks.unregister(t);
    }

    public int sendJsonRequest(ReqInfo reqInfo, JSONObject jSONObject) {
        JsonReqSender jsonReqSender = this.jsonReqSender;
        if (jsonReqSender != null) {
            return jsonReqSender.send(reqInfo, jSONObject, this);
        }
        return -100;
    }

    protected boolean cancel(int i) {
        JsonReqSender jsonReqSender = this.jsonReqSender;
        if (jsonReqSender != null) {
            return jsonReqSender.cancel();
        }
        return false;
    }

    @Override // com.tencent.grobot.lite.presenter.transport.json.JsonReqSender.TransportListener
    public void onJsonSuccess(int i, JSONObject jSONObject, ReqInfo reqInfo) {
        handleJsonSuccess(i, jSONObject, reqInfo);
    }

    @Override // com.tencent.grobot.lite.presenter.transport.json.JsonReqSender.TransportListener
    public void onJsonFail(int i, int i2, String str, JSONObject jSONObject, ReqInfo reqInfo, JSONObject jSONObject2) {
        if (i2 == 300006) {
            this.delegate.handle(reqInfo, jSONObject2);
            sReInit = true;
        } else {
            handleJsonFail(i, i2, str, jSONObject, reqInfo);
        }
    }

    protected void notifyDataChangedInMainThread(final CallbackHelper.Caller<T> caller) {
        runOnUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.engine.BaseEngine.1
            @Override // java.lang.Runnable
            public void run() {
                BaseEngine.this.notifyDataChanged(caller);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataChanged(CallbackHelper.Caller<T> caller) {
        this.mCallbacks.broadcast(caller);
    }

    protected void runOnUiThread(Runnable runnable) {
        ThreadManager.get().postToUiThread(runnable);
    }
}
