package com.tencent.ieg.gpc.globalization.base.social;

import com.tencent.ieg.gpc.globalization.utils.GGLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum GGShareState {
    UPLOADING,
    SNS_SHARING,
    COMPLETED,
    CANCELED,
    FAILED,
    UNKNOWN;

    private static final Map<String, GGShareState> map = new HashMap();

    static {
        for (GGShareState gGShareState : values()) {
            map.put(gGShareState.toString(), gGShareState);
        }
    }

    public static GGShareState getState(String str) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        GGLog.e("TransferState", "Unknown state " + str + " transfer will be have state set to UNKNOWN.");
        return UNKNOWN;
    }
}
