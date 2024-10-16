package com.tencent.quantum.mtr;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NetTrace implements TraceCallback {
    public static final String TAG = "NetTrace";
    private boolean isTracing = false;

    public native void onTraceCallback(int i, String str);

    public void startTrace(String str, int i, int i2) {
        Log.d(TAG, "startTrace:" + str);
        if (!this.isTracing) {
            this.isTracing = true;
            Thread thread = new Thread(new PingRunnable(str, i, i2, this));
            thread.setName("ping_runnable");
            thread.start();
            return;
        }
        Log.d(TAG, "Last trace is not finish. do nothing");
    }

    @Override // com.tencent.quantum.mtr.TraceCallback
    public void onFinishTraceCallback(Boolean bool, List<PingInfo> list) {
        this.isTracing = false;
        Log.d(TAG, "onFinishTraceCallback: " + list.toString());
        onTraceCallback(1, list.toString());
    }

    /* loaded from: classes.dex */
    public class PingRunnable implements Runnable {
        private int maxTTL;
        private int startTTL;
        private String targetHost;
        private TraceCallback traceCallback;
        private List<PingInfo> traceResult = new ArrayList();

        public PingRunnable(String str, int i, int i2, TraceCallback traceCallback) {
            this.targetHost = "";
            this.startTTL = 1;
            this.maxTTL = 1;
            this.targetHost = str;
            this.startTTL = i;
            this.maxTTL = i2;
            this.traceCallback = traceCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0190 A[Catch: Exception -> 0x019c, TRY_LEAVE, TryCatch #4 {Exception -> 0x019c, blocks: (B:38:0x018a, B:40:0x0190), top: B:37:0x018a }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01a3 A[Catch: Exception -> 0x01b0, TRY_LEAVE, TryCatch #1 {Exception -> 0x01b0, blocks: (B:43:0x019d, B:45:0x01a3), top: B:42:0x019d }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01b8 A[Catch: Exception -> 0x01c3, TRY_LEAVE, TryCatch #9 {Exception -> 0x01c3, blocks: (B:48:0x01b2, B:50:0x01b8), top: B:47:0x01b2 }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01ac  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0199  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0188  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 484
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.quantum.mtr.NetTrace.PingRunnable.run():void");
        }
    }
}
