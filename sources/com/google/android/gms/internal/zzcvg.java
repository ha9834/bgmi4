package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.internal.zzy;

/* loaded from: classes.dex */
public final class zzcvg extends zzy {

    /* renamed from: a, reason: collision with root package name */
    private final zzci<StatusCallback> f4711a;

    public zzcvg(zzci<StatusCallback> zzciVar) {
        this.f4711a = zzciVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzx
    public final void onPermissionChanged(boolean z) {
        this.f4711a.zza(new bq(this, z));
    }
}
