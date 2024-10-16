package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class k extends zzcsm {

    /* renamed from: a, reason: collision with root package name */
    private final zzci<EndpointDiscoveryCallback> f4469a;
    private final Set<String> b = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(zzci<EndpointDiscoveryCallback> zzciVar) {
        this.f4469a = (zzci) zzbq.checkNotNull(zzciVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a() {
        Iterator<String> it = this.b.iterator();
        while (it.hasNext()) {
            this.f4469a.zza(new n(this, it.next()));
        }
        this.b.clear();
    }

    @Override // com.google.android.gms.internal.zzcsl
    public final synchronized void zza(zzctl zzctlVar) {
        this.b.add(zzctlVar.zzbdi());
        this.f4469a.zza(new l(this, zzctlVar));
    }

    @Override // com.google.android.gms.internal.zzcsl
    public final synchronized void zza(zzctn zzctnVar) {
        this.b.remove(zzctnVar.zzbdi());
        this.f4469a.zza(new m(this, zzctnVar));
    }

    @Override // com.google.android.gms.internal.zzcsl
    public final void zza(zzctx zzctxVar) {
    }
}
