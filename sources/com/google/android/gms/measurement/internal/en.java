package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class en implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f4836a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(zzgp zzgpVar, long j) {
        this.b = zzgpVar;
        this.f4836a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgp zzgpVar = this.b;
        long j = this.f4836a;
        zzgpVar.zzo();
        zzgpVar.zzm();
        zzgpVar.j();
        zzgpVar.zzab().zzgr().zzao("Resetting analytics data (FE)");
        zzgpVar.zzv().c();
        if (zzgpVar.zzad().g(zzgpVar.zzr().c())) {
            zzgpVar.zzac().h.set(j);
        }
        boolean isEnabled = zzgpVar.v.isEnabled();
        if (!zzgpVar.zzad().zzbp()) {
            zzgpVar.zzac().d(!isEnabled);
        }
        zzgpVar.zzs().d();
        zzgpVar.b = !isEnabled;
        this.b.zzs().zza(new AtomicReference<>());
    }
}
