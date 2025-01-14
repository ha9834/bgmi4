package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
public enum zzbg {
    NONE,
    BATCH_BY_SESSION,
    BATCH_BY_TIME,
    BATCH_BY_BRUTE_FORCE,
    BATCH_BY_COUNT,
    BATCH_BY_SIZE;

    public static zzbg zzz(String str) {
        if ("BATCH_BY_SESSION".equalsIgnoreCase(str)) {
            return BATCH_BY_SESSION;
        }
        if ("BATCH_BY_TIME".equalsIgnoreCase(str)) {
            return BATCH_BY_TIME;
        }
        if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(str)) {
            return BATCH_BY_BRUTE_FORCE;
        }
        if ("BATCH_BY_COUNT".equalsIgnoreCase(str)) {
            return BATCH_BY_COUNT;
        }
        if ("BATCH_BY_SIZE".equalsIgnoreCase(str)) {
            return BATCH_BY_SIZE;
        }
        return NONE;
    }
}
