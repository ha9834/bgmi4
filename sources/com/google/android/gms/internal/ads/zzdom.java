package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public enum zzdom {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdmr.class, zzdmr.class, zzdmr.zzhcr),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> zzhio;
    private final Class<?> zzhip;
    private final Object zzhiq;

    zzdom(Class cls, Class cls2, Object obj) {
        this.zzhio = cls;
        this.zzhip = cls2;
        this.zzhiq = obj;
    }

    public final Class<?> zzayl() {
        return this.zzhip;
    }
}
