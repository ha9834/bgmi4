package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzcgn {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3248a;
    private final zzbbl b;
    private final zzchv c;
    private final zzdte<zzcig> d;

    public zzcgn(zzbbl zzbblVar, zzbbl zzbblVar2, zzchv zzchvVar, zzdte<zzcig> zzdteVar) {
        this.f3248a = zzbblVar;
        this.b = zzbblVar2;
        this.c = zzchvVar;
        this.d = zzdteVar;
    }

    public final zzbbh<InputStream> zzc(final zzarx zzarxVar) {
        final zzbbh<InputStream> zzf;
        String str = zzarxVar.packageName;
        zzk.zzlg();
        if (zzaxi.zzec(str)) {
            zzf = zzbar.zzd(new zzcie(0));
        } else {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvo)).booleanValue()) {
                zzf = zzbar.zza(this.f3248a.submit(new Callable(this, zzarxVar) { // from class: com.google.android.gms.internal.ads.tb

                    /* renamed from: a, reason: collision with root package name */
                    private final zzcgn f2509a;
                    private final zzarx b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2509a = this;
                        this.b = zzarxVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f2509a.a(this.b);
                    }
                }), ExecutionException.class, tc.f2510a, this.b);
            } else {
                zzf = this.c.zzf(zzarxVar);
            }
        }
        zzbbh<InputStream> zza = zzbar.zza(zzf, zzcie.class, new zzbal(this, zzarxVar) { // from class: com.google.android.gms.internal.ads.td

            /* renamed from: a, reason: collision with root package name */
            private final zzcgn f2511a;
            private final zzarx b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2511a = this;
                this.b = zzarxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2511a.a(this.b, (zzcie) obj);
            }
        }, this.b);
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcvo)).booleanValue()) {
            zza.zza(new Runnable(zzf) { // from class: com.google.android.gms.internal.ads.te

                /* renamed from: a, reason: collision with root package name */
                private final zzbbh f2512a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2512a = zzf;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2512a.cancel(true);
                }
            }, zzbbm.zzeaf);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(zzarx zzarxVar, zzcie zzcieVar) throws Exception {
        return this.d.get().zzh(zzarxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream a(zzarx zzarxVar) throws Exception {
        return this.c.zzf(zzarxVar).get(((Integer) zzyt.zzpe().zzd(zzacu.zzcvn)).intValue(), TimeUnit.SECONDS);
    }
}
