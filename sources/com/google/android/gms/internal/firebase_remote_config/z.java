package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes2.dex */
final class z extends aa {

    /* renamed from: a, reason: collision with root package name */
    static final z f4112a = new z();

    private z() {
        super("CharMatcher.none()");
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzdj
    public final boolean zzb(char c) {
        return false;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzdj
    public final int zza(CharSequence charSequence, int i) {
        zzdt.zza(i, charSequence.length(), FirebaseAnalytics.Param.INDEX);
        return -1;
    }
}
