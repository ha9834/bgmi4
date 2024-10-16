package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/* loaded from: classes2.dex */
public final class zzez implements FirebaseRemoteConfigInfo {

    /* renamed from: a, reason: collision with root package name */
    private final long f4166a;
    private final int b;
    private final FirebaseRemoteConfigSettings c;

    private zzez(long j, int i, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f4166a = j;
        this.b = i;
        this.c = firebaseRemoteConfigSettings;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public final long getFetchTimeMillis() {
        return this.f4166a;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public final int getLastFetchStatus() {
        return this.b;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public final FirebaseRemoteConfigSettings getConfigSettings() {
        return this.c;
    }
}
