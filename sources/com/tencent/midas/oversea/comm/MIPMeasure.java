package com.tencent.midas.oversea.comm;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class MIPMeasure {
    public static final String TAG = "MIPMeasure";
    private ExecutorService executorService;
    private ArrayList<String> ipList;
    private ArrayList<String> usableIPList;
    private String highestSpeedIP = "";
    private float highestSpeed = 0.0f;
    private int callbackCount = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface MeasureCallback {
        void onMeasureFinish(String str, boolean z, float f);
    }

    static /* synthetic */ int access$304(MIPMeasure mIPMeasure) {
        int i = mIPMeasure.callbackCount + 1;
        mIPMeasure.callbackCount = i;
        return i;
    }

    public MIPMeasure(ArrayList<String> arrayList) {
        this.executorService = null;
        this.ipList = null;
        this.usableIPList = null;
        if (!GlobalData.singleton().ipMeasureSwitch || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.ipList = new ArrayList<>(arrayList.size());
        this.ipList.addAll(arrayList);
        this.usableIPList = new ArrayList<>();
        this.executorService = Executors.newFixedThreadPool(this.ipList.size());
    }

    public void measure(final MeasureCallback measureCallback) {
        MeasureCallback measureCallback2 = new MeasureCallback() { // from class: com.tencent.midas.oversea.comm.MIPMeasure.1
            @Override // com.tencent.midas.oversea.comm.MIPMeasure.MeasureCallback
            public void onMeasureFinish(String str, boolean z, float f) {
                APLog.i(MIPMeasure.TAG, "ip: " + str + ";isUsable: " + z + ";speed: " + f);
                if (z) {
                    MIPMeasure.this.usableIPList.add(str);
                    if (f > MIPMeasure.this.highestSpeed) {
                        MIPMeasure.this.highestSpeed = f;
                        MIPMeasure.this.highestSpeedIP = str;
                    }
                }
                MeasureCallback measureCallback3 = measureCallback;
                if (measureCallback3 != null) {
                    measureCallback3.onMeasureFinish(str, z, f);
                }
                if (MIPMeasure.access$304(MIPMeasure.this) != MIPMeasure.this.ipList.size() || MIPMeasure.this.executorService == null) {
                    return;
                }
                MIPMeasure.this.executorService.shutdown();
                MIPMeasure.this.executorService = null;
                APLog.i(MIPMeasure.TAG, "Shutdown and destroy executorService");
            }
        };
        ArrayList<String> arrayList = this.ipList;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.ipList.size(); i++) {
            measure(this.ipList.get(i), measureCallback2);
        }
    }

    public void measure(String str, MeasureCallback measureCallback) {
        ExecutorService executorService;
        if (TextUtils.isEmpty(str) || (executorService = this.executorService) == null) {
            return;
        }
        executorService.execute(new MeasureRunnable(str, measureCallback));
    }

    public String getHighestSpeedIP() {
        APLog.i(TAG, "HighestSpeedIP: " + this.highestSpeedIP + " HighestSpeed: " + this.highestSpeed);
        return this.highestSpeedIP;
    }

    public synchronized ArrayList<String> getUsableIPList() {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.usableIPList != null && !this.usableIPList.isEmpty()) {
            arrayList.addAll(this.usableIPList);
        }
        return arrayList;
    }

    public void release() {
        ArrayList<String> arrayList = this.ipList;
        if (arrayList != null) {
            arrayList.clear();
            this.ipList = null;
        }
        ArrayList<String> arrayList2 = this.usableIPList;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.usableIPList = null;
        }
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdown();
            this.executorService = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MeasureRunnable implements Runnable {
        private MeasureCallback callback;
        private String ip;

        public MeasureRunnable(String str, MeasureCallback measureCallback) {
            this.ip = str;
            this.callback = measureCallback;
        }

        private String createUrlStr(String str) {
            return "http://" + str + "/http_monitor.html";
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r10 = this;
                long r0 = java.lang.System.currentTimeMillis()
                r2 = 0
                r3 = 0
                r4 = 0
                java.net.URL r5 = new java.net.URL     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                java.lang.String r6 = r10.ip     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                java.lang.String r6 = r10.createUrlStr(r6)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                r5.<init>(r6)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                java.net.URLConnection r5 = r5.openConnection()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                r6 = 9000(0x2328, float:1.2612E-41)
                r5.setConnectTimeout(r6)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                r5.setReadTimeout(r6)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                r5.setUseCaches(r4)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                r6 = 200(0xc8, float:2.8E-43)
                int r7 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                if (r6 != r7) goto L62
                r6 = 1024(0x400, float:1.435E-42)
                byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                java.io.InputStream r5 = r5.getInputStream()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5e
                r7.<init>()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5e
                r3 = 0
            L39:
                int r8 = r5.read(r6)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
                if (r8 <= 0) goto L44
                r7.write(r6, r4, r8)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
                int r3 = r3 + r8
                goto L39
            L44:
                long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
                long r8 = r8 - r0
                float r0 = (float) r3     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
                float r1 = (float) r8     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
                float r0 = r0 / r1
                com.tencent.midas.oversea.comm.MIPMeasure$MeasureCallback r1 = r10.callback     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
                java.lang.String r3 = r10.ip     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
                r6 = 1
                r1.onMeasureFinish(r3, r6, r0)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
                r3 = r5
                goto L6a
            L56:
                r0 = move-exception
                goto L5c
            L58:
                r0 = move-exception
                goto L60
            L5a:
                r0 = move-exception
                r7 = r3
            L5c:
                r3 = r5
                goto L9f
            L5e:
                r0 = move-exception
                r7 = r3
            L60:
                r3 = r5
                goto L7f
            L62:
                com.tencent.midas.oversea.comm.MIPMeasure$MeasureCallback r0 = r10.callback     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                java.lang.String r1 = r10.ip     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                r0.onMeasureFinish(r1, r4, r2)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7d
                r7 = r3
            L6a:
                if (r3 == 0) goto L74
                r3.close()     // Catch: java.io.IOException -> L70
                goto L74
            L70:
                r0 = move-exception
                r0.printStackTrace()
            L74:
                if (r7 == 0) goto L9d
                r7.close()     // Catch: java.io.IOException -> L99
                goto L9d
            L7a:
                r0 = move-exception
                r7 = r3
                goto L9f
            L7d:
                r0 = move-exception
                r7 = r3
            L7f:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L9e
                com.tencent.midas.oversea.comm.MIPMeasure$MeasureCallback r0 = r10.callback     // Catch: java.lang.Throwable -> L9e
                java.lang.String r1 = r10.ip     // Catch: java.lang.Throwable -> L9e
                r0.onMeasureFinish(r1, r4, r2)     // Catch: java.lang.Throwable -> L9e
                if (r3 == 0) goto L93
                r3.close()     // Catch: java.io.IOException -> L8f
                goto L93
            L8f:
                r0 = move-exception
                r0.printStackTrace()
            L93:
                if (r7 == 0) goto L9d
                r7.close()     // Catch: java.io.IOException -> L99
                goto L9d
            L99:
                r0 = move-exception
                r0.printStackTrace()
            L9d:
                return
            L9e:
                r0 = move-exception
            L9f:
                if (r3 == 0) goto La9
                r3.close()     // Catch: java.io.IOException -> La5
                goto La9
            La5:
                r1 = move-exception
                r1.printStackTrace()
            La9:
                if (r7 == 0) goto Lb3
                r7.close()     // Catch: java.io.IOException -> Laf
                goto Lb3
            Laf:
                r1 = move-exception
                r1.printStackTrace()
            Lb3:
                throw r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.oversea.comm.MIPMeasure.MeasureRunnable.run():void");
        }
    }
}
