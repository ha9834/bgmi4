package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.zzcvf;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* loaded from: classes2.dex */
class u extends zzab {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcvf<SubscribeCallback> f5019a = new v();
    private final com.google.android.gms.common.api.internal.zzci<SubscribeCallback> b;

    public u(com.google.android.gms.common.api.internal.zzci<SubscribeCallback> zzciVar) {
        this.b = zzciVar;
    }

    public void onExpired() {
        com.google.android.gms.common.api.internal.zzci<SubscribeCallback> zzciVar = this.b;
        if (zzciVar != null) {
            zzciVar.zza(f5019a);
        }
    }
}
