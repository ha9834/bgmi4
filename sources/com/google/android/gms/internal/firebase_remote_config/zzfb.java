package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/* loaded from: classes2.dex */
public final class zzfb {

    /* renamed from: a, reason: collision with root package name */
    private long f4168a;
    private int b;
    private FirebaseRemoteConfigSettings c;

    private zzfb() {
    }

    public final zzfb zze(long j) {
        this.f4168a = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfb a(int i) {
        this.b = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfb a(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.c = firebaseRemoteConfigSettings;
        return this;
    }

    public final zzez zzde() {
        return new zzez(this.f4168a, this.b, this.c);
    }
}
