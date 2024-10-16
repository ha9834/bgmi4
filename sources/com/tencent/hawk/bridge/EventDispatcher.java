package com.tencent.hawk.bridge;

/* loaded from: classes2.dex */
public class EventDispatcher {
    public static synchronized void dispatchEvent(int i, String str) {
        synchronized (EventDispatcher.class) {
            HawkNative.postEvent(i, str);
        }
    }
}
