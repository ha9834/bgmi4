package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzakh {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2745a;
    private final Context b;
    private final String c;
    private final zzbai d;
    private zzayp<zzajw> e;
    private zzayp<zzajw> f;
    private zzala g;
    private int h;

    public zzakh(Context context, zzbai zzbaiVar, String str) {
        this.f2745a = new Object();
        this.h = 1;
        this.c = str;
        this.b = context.getApplicationContext();
        this.d = zzbaiVar;
        this.e = new zzakv();
        this.f = new zzakv();
    }

    public zzakh(Context context, zzbai zzbaiVar, String str, zzayp<zzajw> zzaypVar, zzayp<zzajw> zzaypVar2) {
        this(context, zzbaiVar, str);
        this.e = zzaypVar;
        this.f = zzaypVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzala a(final zzdh zzdhVar) {
        final zzala zzalaVar = new zzala(this.f);
        zzbbm.zzeae.execute(new Runnable(this, zzdhVar, zzalaVar) { // from class: com.google.android.gms.internal.ads.bi

            /* renamed from: a, reason: collision with root package name */
            private final zzakh f2073a;
            private final zzdh b;
            private final zzala c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2073a = this;
                this.b = zzdhVar;
                this.c = zzalaVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2073a.a(this.b, this.c);
            }
        });
        zzalaVar.zza(new bs(this, zzalaVar), new bt(this, zzalaVar));
        return zzalaVar;
    }

    public final zzakw zzb(zzdh zzdhVar) {
        synchronized (this.f2745a) {
            synchronized (this.f2745a) {
                if (this.g != null && this.h == 0) {
                    if (((Boolean) zzyt.zzpe().zzd(zzacu.zzclb)).booleanValue()) {
                        this.g.zza(new zzbbv(this) { // from class: com.google.android.gms.internal.ads.bj

                            /* renamed from: a, reason: collision with root package name */
                            private final zzakh f2074a;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f2074a = this;
                            }

                            @Override // com.google.android.gms.internal.ads.zzbbv
                            public final void zzh(Object obj) {
                                this.f2074a.a((zzajw) obj);
                            }
                        }, bk.f2075a);
                    }
                }
            }
            if (this.g != null && this.g.getStatus() != -1) {
                if (this.h == 0) {
                    return this.g.zzrx();
                }
                if (this.h == 1) {
                    this.h = 2;
                    a((zzdh) null);
                    return this.g.zzrx();
                }
                if (this.h == 2) {
                    return this.g.zzrx();
                }
                return this.g.zzrx();
            }
            this.h = 2;
            this.g = a((zzdh) null);
            return this.g.zzrx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzajw zzajwVar) {
        if (zzajwVar.isDestroyed()) {
            this.h = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdh zzdhVar, final zzala zzalaVar) {
        final zzajw zzajyVar;
        try {
            Context context = this.b;
            zzbai zzbaiVar = this.d;
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoj)).booleanValue()) {
                zzajyVar = new zzajj(context, zzbaiVar);
            } else {
                zzajyVar = new zzajy(context, zzbaiVar, zzdhVar, null);
            }
            zzajyVar.zza(new zzajx(this, zzalaVar, zzajyVar) { // from class: com.google.android.gms.internal.ads.bl

                /* renamed from: a, reason: collision with root package name */
                private final zzakh f2076a;
                private final zzala b;
                private final zzajw c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2076a = this;
                    this.b = zzalaVar;
                    this.c = zzajyVar;
                }

                @Override // com.google.android.gms.internal.ads.zzajx
                public final void zzrv() {
                    final zzakh zzakhVar = this.f2076a;
                    final zzala zzalaVar2 = this.b;
                    final zzajw zzajwVar = this.c;
                    zzaxi.zzdvv.postDelayed(new Runnable(zzakhVar, zzalaVar2, zzajwVar) { // from class: com.google.android.gms.internal.ads.bm

                        /* renamed from: a, reason: collision with root package name */
                        private final zzakh f2077a;
                        private final zzala b;
                        private final zzajw c;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2077a = zzakhVar;
                            this.b = zzalaVar2;
                            this.c = zzajwVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2077a.a(this.b, this.c);
                        }
                    }, bu.b);
                }
            });
            zzajyVar.zza("/jsLoaded", new bo(this, zzalaVar, zzajyVar));
            zzazk zzazkVar = new zzazk();
            bp bpVar = new bp(this, zzdhVar, zzajyVar, zzazkVar);
            zzazkVar.set(bpVar);
            zzajyVar.zza("/requestReload", bpVar);
            if (this.c.endsWith(".js")) {
                zzajyVar.zzcl(this.c);
            } else if (this.c.startsWith("<html>")) {
                zzajyVar.zzcm(this.c);
            } else {
                zzajyVar.zzcn(this.c);
            }
            zzaxi.zzdvv.postDelayed(new bq(this, zzalaVar, zzajyVar), bu.f2085a);
        } catch (Throwable th) {
            zzawz.zzc("Error creating webview.", th);
            zzk.zzlk().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzalaVar.reject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzala zzalaVar, zzajw zzajwVar) {
        synchronized (this.f2745a) {
            if (zzalaVar.getStatus() != -1 && zzalaVar.getStatus() != 1) {
                zzalaVar.reject();
                Executor executor = zzbbm.zzeae;
                zzajwVar.getClass();
                executor.execute(bn.a(zzajwVar));
                zzawz.zzds("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
