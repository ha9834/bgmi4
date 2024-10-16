package com.amazonaws.mobileconnectors.s3.transferutility;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public enum TransferState {
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
    UNKNOWN;

    private static final Log LOGGER;
    private static final Map<String, TransferState> MAP = new HashMap();

    static {
        for (TransferState transferState : values()) {
            MAP.put(transferState.toString(), transferState);
        }
        LOGGER = LogFactory.getLog(TransferState.class);
    }

    public static TransferState getState(String str) {
        if (MAP.containsKey(str)) {
            return MAP.get(str);
        }
        LOGGER.error("Unknown state " + str + " transfer will be have state set to UNKNOWN.");
        return UNKNOWN;
    }
}
