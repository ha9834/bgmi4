package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcwj implements zzcva<zzcwi> {

    /* renamed from: a, reason: collision with root package name */
    private zzawe f3474a;
    private zzbbl b;
    private String c;

    public zzcwj(zzawe zzaweVar, zzbbl zzbblVar, String str) {
        this.f3474a = zzaweVar;
        this.b = zzbblVar;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwi> zzalm() {
        new zzbbr();
        final zzbbh<String> zzm = zzbar.zzm(null);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvx)).booleanValue()) {
            zzm = this.f3474a.zzdq(this.c);
        }
        final zzbbh<String> zzdr = this.f3474a.zzdr(this.c);
        return zzbar.zza(zzm, zzdr).zza(new Callable(zzm, zzdr) { // from class: com.google.android.gms.internal.ads.zx

            /* renamed from: a, reason: collision with root package name */
            private final zzbbh f2677a;
            private final zzbbh b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2677a = zzm;
                this.b = zzdr;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcwi((String) this.f2677a.get(), (String) this.b.get());
            }
        }, zzaxg.zzdvp);
    }
}
