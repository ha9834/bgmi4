package com.helpshift.common;

import com.helpshift.common.AutoRetryFailedEventDM;

/* loaded from: classes2.dex */
public interface AutoRetriableDM {
    void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType);
}
