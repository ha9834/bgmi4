package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcig extends zzarn {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3270a;
    private final Executor b;
    private final zzasm c;
    private final zzasl d;
    private final zzblp e;

    public zzcig(Context context, Executor executor, zzasm zzasmVar, zzblp zzblpVar, zzasl zzaslVar) {
        zzacu.initialize(context);
        this.f3270a = context;
        this.b = executor;
        this.c = zzasmVar;
        this.d = zzaslVar;
        this.e = zzblpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final zzari zza(zzarg zzargVar) throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zza(zzarg zzargVar, zzarp zzarpVar) throws RemoteException {
    }

    public final zzbbh<InputStream> zzh(zzarx zzarxVar) {
        zzalr zza = zzk.zzlt().zza(this.f3270a, zzbai.zzxc());
        final zzcvs zza2 = this.e.zza(zzarxVar);
        zzbal zzbalVar = new zzbal(zza2) { // from class: com.google.android.gms.internal.ads.tu

            /* renamed from: a, reason: collision with root package name */
            private final zzcvs f2528a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2528a = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2528a.zzadp().zzu(zzk.zzlg().zzd((Bundle) obj));
            }
        };
        zzczc zzczcVar = tv.f2529a;
        zzalj zza3 = zza.zza("AFMA_getAdDictionary", zzalo.zzddi, tw.f2530a);
        zzalj zza4 = zza.zza("google.afma.response.normalize", zzcir.zzfxv, zzalo.zzddj);
        zzciu zzciuVar = new zzciu(this.f3270a, zzarxVar.zzdld.zzbsx, this.c, zzarxVar.zzdmi);
        zzczt zzadr = zza2.zzadr();
        final zzcze zzane = zzadr.zza((zzczt) zzczs.GMS_SIGNALS, (zzbbh) zzbar.zzm(zzarxVar.zzdot)).zza(zzbalVar).zzb(zzczcVar).zzane();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvp)).booleanValue()) {
            return zzadr.zza((zzczt) zzczs.AD_REQUEST, (zzbbh) zzane).zza(zza.zza("google.afma.request.getAdResponse", zzalo.zzddi, zzalo.zzddi)).zzb(tx.f2531a).zzane();
        }
        final zzcze zzane2 = zzadr.zza((zzczt) zzczs.BUILD_URL, (zzbbh) zzane).zza(zza3).zzane();
        final zzcze zzane3 = zzadr.zza((zzczt) zzczs.HTTP, zzane2, zzane).zzc(new Callable(zzane, zzane2) { // from class: com.google.android.gms.internal.ads.ty

            /* renamed from: a, reason: collision with root package name */
            private final zzbbh f2532a;
            private final zzbbh b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2532a = zzane;
                this.b = zzane2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzciv((JSONObject) this.f2532a.get(), (zzasd) this.b.get());
            }
        }).zzb(zzciuVar).zzane();
        return zzadr.zza((zzczt) zzczs.PRE_PROCESS, zzane, zzane2, zzane3).zzc(new Callable(zzane3, zzane, zzane2) { // from class: com.google.android.gms.internal.ads.tz

            /* renamed from: a, reason: collision with root package name */
            private final zzbbh f2533a;
            private final zzbbh b;
            private final zzbbh c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2533a = zzane3;
                this.b = zzane;
                this.c = zzane2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcir((zzciw) this.f2533a.get(), (JSONObject) this.b.get(), (zzasd) this.c.get());
            }
        }).zza(zza4).zzane();
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zza(zzarx zzarxVar, zzarr zzarrVar) {
        zzbbh<InputStream> zzh = zzh(zzarxVar);
        a(zzh, zzarrVar);
        zzh.zza(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ua

            /* renamed from: a, reason: collision with root package name */
            private final zzcig f2534a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2534a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2534a.a();
            }
        }, this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zzb(zzarx zzarxVar, zzarr zzarrVar) {
        zzbbh<InputStream> zzane;
        zzalr zza = zzk.zzlt().zza(this.f3270a, zzbai.zzxc());
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcwd)).booleanValue()) {
            zzane = zzbar.zzd(new Exception("Signal collection disabled."));
        } else {
            zzcvs zza2 = this.e.zza(zzarxVar);
            final zzcvb<JSONObject> zzadq = this.e.zza(zzarxVar).zzadq();
            zzane = zza2.zzadr().zza((zzczt) zzczs.GET_SIGNALS, (zzbbh) zzbar.zzm(zzarxVar.zzdot)).zza(new zzbal(zzadq) { // from class: com.google.android.gms.internal.ads.ub

                /* renamed from: a, reason: collision with root package name */
                private final zzcvb f2535a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2535a = zzadq;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.f2535a.zzu(zzk.zzlg().zzd((Bundle) obj));
                }
            }).zzx(zzczs.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzalo.zzddi, zzalo.zzddj)).zzane();
        }
        a(zzane, zzarrVar);
    }

    private final void a(zzbbh<InputStream> zzbbhVar, zzarr zzarrVar) {
        zzbar.zza(zzbar.zza(zzbbhVar, new zzbal(this) { // from class: com.google.android.gms.internal.ads.uc

            /* renamed from: a, reason: collision with root package name */
            private final zzcig f2536a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2536a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.zzm(zzcyc.zze((InputStream) obj));
            }
        }, zzaxg.zzdvp), new ud(this, zzarrVar), zzbbm.zzeaf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        zzbao.zza(this.d.zztz(), "persistFlags");
    }
}
