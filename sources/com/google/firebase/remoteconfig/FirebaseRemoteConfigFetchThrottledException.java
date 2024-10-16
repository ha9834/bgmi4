package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigFetchException {
    private final long zzjp;

    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this("Fetch was throttled.", j);
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j) {
        super(str);
        this.zzjp = j;
    }

    public long getThrottleEndTimeMillis() {
        return this.zzjp;
    }
}
