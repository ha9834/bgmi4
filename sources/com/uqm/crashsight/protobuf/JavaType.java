package com.uqm.crashsight.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public enum JavaType {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(ByteString.class, ByteString.class, ByteString.f6635a),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> k;

    JavaType(Class cls, Class cls2, Object obj) {
        this.k = cls2;
    }

    public final Class<?> a() {
        return this.k;
    }
}
