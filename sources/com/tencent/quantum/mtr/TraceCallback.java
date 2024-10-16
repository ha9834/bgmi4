package com.tencent.quantum.mtr;

import java.util.List;

/* loaded from: classes.dex */
public interface TraceCallback {
    void onFinishTraceCallback(Boolean bool, List<PingInfo> list);
}
