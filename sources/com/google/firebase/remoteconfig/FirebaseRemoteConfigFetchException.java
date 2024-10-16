package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigFetchException extends FirebaseRemoteConfigException {
    @Deprecated
    public FirebaseRemoteConfigFetchException() {
        super("There was a fetch error in the FRC SDK.");
    }

    public FirebaseRemoteConfigFetchException(String str) {
        super(str);
    }

    public FirebaseRemoteConfigFetchException(String str, Throwable th) {
        super(str, th);
    }
}
