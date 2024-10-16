package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class d extends zzcse {

    /* renamed from: a, reason: collision with root package name */
    private final zzci<ConnectionLifecycleCallback> f3869a;
    private final Set<String> b = new HashSet();
    private final Set<String> c = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzci<ConnectionLifecycleCallback> zzciVar) {
        this.f3869a = (zzci) zzbq.checkNotNull(zzciVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a() {
        Iterator<String> it = this.b.iterator();
        while (it.hasNext()) {
            this.f3869a.zza(new i(this, it.next()));
        }
        this.b.clear();
        Iterator<String> it2 = this.c.iterator();
        while (it2.hasNext()) {
            this.f3869a.zza(new j(this, it2.next()));
        }
        this.c.clear();
    }

    @Override // com.google.android.gms.internal.zzcsd
    public final void zza(zzcsz zzcszVar) {
        this.f3869a.zza(new h(this, zzcszVar));
    }

    @Override // com.google.android.gms.internal.zzcsd
    public final synchronized void zza(zzctb zzctbVar) {
        this.b.add(zzctbVar.zzbde());
        this.f3869a.zza(new e(this, zzctbVar));
    }

    @Override // com.google.android.gms.internal.zzcsd
    public final synchronized void zza(zzcth zzcthVar) {
        this.b.remove(zzcthVar.zzbde());
        Status b = zzcov.b(zzcthVar.getStatusCode());
        if (b.isSuccess()) {
            this.c.add(zzcthVar.zzbde());
        }
        this.f3869a.zza(new f(this, zzcthVar, b));
    }

    @Override // com.google.android.gms.internal.zzcsd
    public final synchronized void zza(zzctj zzctjVar) {
        this.c.remove(zzctjVar.zzbde());
        this.f3869a.zza(new g(this, zzctjVar));
    }
}
