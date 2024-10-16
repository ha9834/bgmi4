package com.google.firebase.remoteconfig;

import com.google.firebase.FirebaseException;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigException extends FirebaseException {
    @Deprecated
    public FirebaseRemoteConfigException() {
        super("There was an error in the FRC SDK.");
    }

    public FirebaseRemoteConfigException(String str) {
        super(str);
    }

    public FirebaseRemoteConfigException(String str, Throwable th) {
        super(str, th);
    }
}
