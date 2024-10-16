package com.google.android.gms.internal.firebase_remote_config;

import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;

/* loaded from: classes2.dex */
public final class zzfa implements FirebaseRemoteConfigValue {

    /* renamed from: a, reason: collision with root package name */
    private final String f4167a;
    private final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfa(String str, int i) {
        this.f4167a = str;
        this.b = i;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public final long asLong() {
        if (this.b == 0) {
            return 0L;
        }
        String trim = asString().trim();
        try {
            return Long.valueOf(trim).longValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", trim, Constants.LONG), e);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public final double asDouble() {
        if (this.b == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        String trim = asString().trim();
        try {
            return Double.valueOf(trim).doubleValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", trim, "double"), e);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public final String asString() {
        if (this.b == 0) {
            return "";
        }
        String str = this.f4167a;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public final byte[] asByteArray() {
        if (this.b == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        return this.f4167a.getBytes(zzes.zzlf);
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public final boolean asBoolean() throws IllegalArgumentException {
        if (this.b == 0) {
            return false;
        }
        String trim = asString().trim();
        if (zzes.f4163a.matcher(trim).matches()) {
            return true;
        }
        if (zzes.b.matcher(trim).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", trim, "boolean"));
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public final int getSource() {
        return this.b;
    }
}
