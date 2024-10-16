package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public enum zzdrn {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdmr.zzhcr),
    ENUM(null),
    MESSAGE(null);

    private final Object zzhiq;

    zzdrn(Object obj) {
        this.zzhiq = obj;
    }
}
