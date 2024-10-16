package com.tencent.grobot.lite.presenter.transport.json;

import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.model.req.ReqInfo;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsonReqSender {
    static final int MAX_RUNNING_THREAD = 2;
    private static final String TAG = "Presenter.JsonReqSender";
    private Future<?> future;

    /* loaded from: classes2.dex */
    public interface TransportListener {
        void onJsonFail(int i, int i2, String str, JSONObject jSONObject, ReqInfo reqInfo, JSONObject jSONObject2);

        void onJsonSuccess(int i, JSONObject jSONObject, ReqInfo reqInfo);
    }

    public void onDestroy() {
    }

    public int send(ReqInfo reqInfo, JSONObject jSONObject, TransportListener transportListener) {
        int i = SeqGenerator.get();
        JsonPackageProcessor jsonPackageProcessor = new JsonPackageProcessor(i, reqInfo, jSONObject, transportListener);
        TLog.d(TAG, "send, seq:" + i);
        this.future = ThreadManager.get().postToNetThread(jsonPackageProcessor);
        return i;
    }

    public boolean cancel() {
        Future<?> future = this.future;
        if (future == null || future.isDone()) {
            return false;
        }
        return this.future.cancel(true);
    }

    /* loaded from: classes2.dex */
    public static class SeqGenerator {
        private static AtomicInteger SEQ = new AtomicInteger(1);

        public static int get() {
            return SEQ.getAndIncrement();
        }
    }
}
