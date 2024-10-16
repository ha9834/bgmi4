package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.zzcvf;
import com.google.android.gms.nearby.messages.PublishCallback;

/* loaded from: classes2.dex */
class s extends zzv {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcvf<PublishCallback> f5018a = new t();
    private final com.google.android.gms.common.api.internal.zzci<PublishCallback> b;

    public s(com.google.android.gms.common.api.internal.zzci<PublishCallback> zzciVar) {
        this.b = zzciVar;
    }

    public void onExpired() {
        com.google.android.gms.common.api.internal.zzci<PublishCallback> zzciVar = this.b;
        if (zzciVar != null) {
            zzciVar.zza(f5018a);
        }
    }
}
