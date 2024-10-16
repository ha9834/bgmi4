package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.zzcvf;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* loaded from: classes2.dex */
final class aj extends zzab {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcvf<SubscribeCallback> f5002a = new ak();
    private final com.google.android.gms.common.api.internal.zzci<SubscribeCallback> b;

    public aj(com.google.android.gms.common.api.internal.zzci<SubscribeCallback> zzciVar) {
        this.b = zzciVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzaa
    public final void onExpired() {
        this.b.zza(f5002a);
    }
}
