package com.google.android.gms.internal.gtm;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public enum zzul {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzps.zzavx),
    ENUM(null),
    MESSAGE(null);

    private final Object zzbbx;

    zzul(Object obj) {
        this.zzbbx = obj;
    }
}
