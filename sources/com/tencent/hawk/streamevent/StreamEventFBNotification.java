package com.tencent.hawk.streamevent;

import com.tencent.hawk.bridge.ActivityStatusChangedInterface;
import com.tencent.hawk.bridge.HawkLogger;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class StreamEventFBNotification implements ActivityStatusChangedInterface {
    private Semaphore mCommittingSemphore;
    private volatile boolean mIsSEFuncEnabled = false;

    @Override // com.tencent.hawk.bridge.ActivityStatusChangedInterface
    public void foreground() {
    }

    public StreamEventFBNotification(Semaphore semaphore) {
        this.mCommittingSemphore = semaphore;
    }

    public void enableStreamEvent() {
        this.mIsSEFuncEnabled = true;
    }

    @Override // com.tencent.hawk.bridge.ActivityStatusChangedInterface
    public void backgroud() {
        if (this.mIsSEFuncEnabled) {
            Semaphore semaphore = this.mCommittingSemphore;
            if (semaphore != null) {
                semaphore.release();
                return;
            }
            return;
        }
        HawkLogger.d("StreamEvent function not enabled");
    }
}
