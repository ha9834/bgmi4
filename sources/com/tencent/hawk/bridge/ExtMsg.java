package com.tencent.hawk.bridge;

import com.google.android.gms.games.Notifications;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class ExtMsg {
    private static HashMap<String, Integer> extKeyMap = null;
    private static int ext_idx = 102;
    private static boolean isHawkEnabled;

    public static void initExtMsg() {
        extKeyMap = new HashMap<>();
        isHawkEnabled = true;
    }

    public static synchronized void cleanIdxMap() {
        synchronized (ExtMsg.class) {
            if (extKeyMap != null) {
                HawkNative.postMsgExt(100, 0, 0, 0, null);
                HawkLogger.d("put fence, clean index map");
                extKeyMap.clear();
            }
        }
    }

    public static boolean checkEnv() {
        return isHawkEnabled && extKeyMap != null;
    }

    private static int assignIdx(int i, String str) {
        if (extKeyMap.containsKey(str)) {
            HawkLogger.d("[FETCH_KEY]: " + str + " " + i);
            return extKeyMap.get(str).intValue();
        }
        HawkLogger.d("[PUT_KEY]: " + str + " " + i);
        ext_idx = ext_idx + 1;
        extKeyMap.put(str, Integer.valueOf(ext_idx));
        HawkNative.postMsgExt(101, 0, i, ext_idx, str);
        return ext_idx;
    }

    public static synchronized void putKVI(String str, int i) {
        synchronized (ExtMsg.class) {
            if (checkEnv()) {
                if (str != null && str.length() != 0) {
                    HawkNative.postMsgExt(assignIdx(1, str), 0, 1, i, null);
                }
            }
        }
    }

    public static synchronized void putKVS(String str, String str2) {
        synchronized (ExtMsg.class) {
            if (checkEnv()) {
                if (str != null && str.length() != 0) {
                    if (str2 != null && str2.length() != 0) {
                        if (str.length() > 128) {
                            HawkLogger.e("key length too large,truncate");
                            str = str.substring(0, Notifications.NOTIFICATION_TYPES_ALL);
                        }
                        if (str2.length() > 128) {
                            HawkLogger.e("value length too large,truncate");
                            str2 = str2.substring(0, Notifications.NOTIFICATION_TYPES_ALL);
                        }
                        HawkNative.postMsgExt(assignIdx(2, str), 0, 2, 0, str2);
                    }
                }
            }
        }
    }

    public static synchronized void putKVD(String str, double d) {
        synchronized (ExtMsg.class) {
            if (checkEnv()) {
                if (str != null && str.length() != 0) {
                    if (str.length() > 64) {
                        HawkLogger.e("key length too large");
                        str = str.substring(0, 63);
                    }
                    long j = (long) (d * 100.0d);
                    int assignIdx = assignIdx(4, str);
                    HawkNative.postMsgExt(assignIdx, 0, 8, (int) (j >> 32), null);
                    HawkNative.postMsgExt(assignIdx, 0, 16, (int) (j & (-1)), null);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void putKVArrI(String str, int[] iArr) {
        synchronized (ExtMsg.class) {
            if (checkEnv()) {
                if (str == null) {
                    HawkLogger.e("putKVArrI, key is null ");
                    return;
                }
                if (iArr == null) {
                    HawkLogger.e("putKVArrI, array is null ");
                    return;
                }
                if (iArr.length >= 64) {
                    HawkLogger.e("putKVArrI, too large size :" + iArr.length);
                    return;
                }
                if (str.length() > 128) {
                    HawkLogger.e("key length too large");
                    return;
                }
                int assignIdx = assignIdx(32, str);
                int length = iArr.length;
                int length2 = iArr.length;
                int i = 0;
                int i2 = 1;
                while (i < length2) {
                    int i3 = i2 + 1;
                    HawkNative.postMsgExt(assignIdx, i2 | (length << 8), 1, iArr[i], null);
                    i++;
                    i2 = i3;
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void putKVArrS(String str, JArrS jArrS) {
        synchronized (ExtMsg.class) {
            if (checkEnv()) {
                if (jArrS.getContent() == null) {
                    return;
                }
                if (jArrS.getContent().length >= 64) {
                    return;
                }
                int assignIdx = assignIdx(64, str);
                int length = jArrS.getContent().length;
                int i = 1;
                for (String str2 : jArrS.getContent()) {
                    if (str2.length() > 128) {
                        HawkLogger.e("temp length too large,truncat");
                        HawkNative.postMsgExt(assignIdx, (length << 8) | i, 2, 0, str2.substring(0, 126));
                    } else {
                        HawkNative.postMsgExt(assignIdx, (length << 8) | i, 2, 0, str2);
                    }
                    i++;
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void putKVArrD(String str, double[] dArr) {
        synchronized (ExtMsg.class) {
            if (checkEnv()) {
                if (dArr == null) {
                    HawkLogger.e("putKVArrD, jarray is null ");
                    return;
                }
                if (dArr.length >= 64) {
                    HawkLogger.e("putKVArrD, too large size  " + dArr.length);
                    return;
                }
                int assignIdx = assignIdx(128, str);
                int length = dArr.length;
                int i = 1;
                for (double d : dArr) {
                    long j = (long) (d * 100.0d);
                    int i2 = (length << 8) | i;
                    HawkNative.postMsgExt(assignIdx, i2, 8, (int) (j >> 32), null);
                    HawkNative.postMsgExt(assignIdx, i2, 16, (int) (j & (-1)), null);
                    i++;
                }
            }
        }
    }

    public static synchronized void fence() {
        synchronized (ExtMsg.class) {
            HawkNative.postMsgExt(100, 0, 0, 0, null);
        }
    }
}
