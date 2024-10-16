package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.zzcvf;
import com.google.android.gms.nearby.messages.PublishCallback;

/* loaded from: classes2.dex */
final class ag extends zzv {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcvf<PublishCallback> f5000a = new ah();
    private final com.google.android.gms.common.api.internal.zzci<PublishCallback> b;

    public ag(com.google.android.gms.common.api.internal.zzci<PublishCallback> zzciVar) {
        this.b = zzciVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzu
    public final void onExpired() {
        this.b.zza(f5000a);
    }
}
