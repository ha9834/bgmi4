package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class bw implements zzfw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bv f5096a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.f5096a = bvVar;
    }

    @Override // com.google.android.gms.tagmanager.zzfw
    public final void zza(am amVar) {
        this.f5096a.a(amVar.a());
    }

    @Override // com.google.android.gms.tagmanager.zzfw
    public final void zzb(am amVar) {
        this.f5096a.a(amVar.a());
        long a2 = amVar.a();
        StringBuilder sb = new StringBuilder(57);
        sb.append("Permanent failure dispatching hitId: ");
        sb.append(a2);
        zzdi.zzab(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.zzfw
    public final void zzc(am amVar) {
        Clock clock;
        Clock clock2;
        long b = amVar.b();
        if (b == 0) {
            bv bvVar = this.f5096a;
            long a2 = amVar.a();
            clock2 = this.f5096a.h;
            bvVar.a(a2, clock2.currentTimeMillis());
            return;
        }
        long j = b + 14400000;
        clock = this.f5096a.h;
        if (j < clock.currentTimeMillis()) {
            this.f5096a.a(amVar.a());
            long a3 = amVar.a();
            StringBuilder sb = new StringBuilder(47);
            sb.append("Giving up on failed hitId: ");
            sb.append(a3);
            zzdi.zzab(sb.toString());
        }
    }
}
