package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class u extends zzcsx {

    /* renamed from: a, reason: collision with root package name */
    private final zzn<Connections.StartAdvertisingResult> f4674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(zzn<Connections.StartAdvertisingResult> zznVar) {
        this.f4674a = (zzn) zzbq.checkNotNull(zznVar);
    }

    @Override // com.google.android.gms.internal.zzcsw
    public final void zza(zzctt zzcttVar) {
        Status b = zzcov.b(zzcttVar.getStatusCode());
        if (b.isSuccess()) {
            this.f4674a.setResult(new t(b, zzcttVar.getLocalEndpointName()));
        } else {
            this.f4674a.zzu(b);
        }
    }
}
