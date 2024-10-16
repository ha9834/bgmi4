package com.gcloudsdk.apollo.apollovoice.httpclient;

/* loaded from: classes.dex */
class SRTTAPIHTTPTaskQueue {
    private static SRTTAPIHTTPTaskQueueImp taskQueue = new SRTTAPIHTTPTaskQueueImp();

    SRTTAPIHTTPTaskQueue() {
    }

    public static void init() {
        taskQueue.init();
    }

    public static void setAppInfo(String str, String str2) {
        taskQueue.setAppInfo(str, str2);
    }

    public static synchronized void addTask(int i, int i2, String str, byte[] bArr, int i3) {
        synchronized (SRTTAPIHTTPTaskQueue.class) {
            taskQueue.addTask(i, i2, str, bArr, i3);
        }
    }
}
