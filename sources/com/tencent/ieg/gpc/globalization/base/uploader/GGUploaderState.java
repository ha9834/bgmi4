package com.tencent.ieg.gpc.globalization.base.uploader;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum GGUploaderState {
    WAITING,
    IN_PROGRESS,
    PAUSED,
    RESUMED_WAITING,
    COMPLETED,
    CANCELED,
    FAILED,
    WAITING_FOR_NETWORK,
    PART_COMPLETED,
    PENDING_CANCEL,
    PENDING_PAUSE,
    PENDING_NETWORK_DISCONNECT,
    UPLOAD_TIMEOUT,
    UNKNOWN;

    private static final Map<String, GGUploaderState> map = new HashMap();

    static {
        for (GGUploaderState gGUploaderState : values()) {
            map.put(gGUploaderState.toString(), gGUploaderState);
        }
    }

    public static GGUploaderState getState(String str) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        Log.e("TransferState", "Unknown state " + str + " transfer will be have state set to UNKNOWN.");
        return UNKNOWN;
    }
}
