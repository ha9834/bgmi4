package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.nearby.connection.PayloadCallback;

/* loaded from: classes.dex */
final class p extends zzcsr {

    /* renamed from: a, reason: collision with root package name */
    private final zzci<PayloadCallback> f4649a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(zzci<PayloadCallback> zzciVar) {
        this.f4649a = (zzci) zzbq.checkNotNull(zzciVar);
    }

    @Override // com.google.android.gms.internal.zzcsq
    public final void zza(zzctp zzctpVar) {
        this.f4649a.zza(new q(this, zzctpVar));
    }

    @Override // com.google.android.gms.internal.zzcsq
    public final void zza(zzctr zzctrVar) {
        this.f4649a.zza(new r(this, zzctrVar));
    }
}
