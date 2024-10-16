package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzcvo implements zzcva<zzcvn> {

    /* renamed from: a, reason: collision with root package name */
    private final zzawi f3462a;
    private final Context b;
    private final ScheduledExecutorService c;
    private final Executor d;

    public zzcvo(zzawi zzawiVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.f3462a = zzawiVar;
        this.b = context;
        this.c = scheduledExecutorService;
        this.d = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvn> zzalm() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoz)).booleanValue()) {
            final zzbbr zzbbrVar = new zzbbr();
            final zzbbh<AdvertisingIdClient.Info> zzag = this.f3462a.zzag(this.b);
            zzag.zza(new Runnable(this, zzag, zzbbrVar) { // from class: com.google.android.gms.internal.ads.zo

                /* renamed from: a, reason: collision with root package name */
                private final zzcvo f2668a;
                private final zzbbh b;
                private final zzbbr c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2668a = this;
                    this.b = zzag;
                    this.c = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2668a.a(this.b, this.c);
                }
            }, this.d);
            this.c.schedule(new Runnable(zzag) { // from class: com.google.android.gms.internal.ads.zp

                /* renamed from: a, reason: collision with root package name */
                private final zzbbh f2669a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2669a = zzag;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2669a.cancel(true);
                }
            }, ((Long) zzyt.zzpe().zzd(zzacu.zzcpa)).longValue(), TimeUnit.MILLISECONDS);
            return zzbbrVar;
        }
        return zzbar.zzd(new Exception("Did not ad Ad ID into query param."));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void a(zzbbh zzbbhVar, zzbbr zzbbrVar) {
        String str;
        try {
            AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzbbhVar.get();
            if (info == null || !TextUtils.isEmpty(info.getId())) {
                str = null;
            } else {
                zzyt.zzpa();
                str = zzazt.zzbf(this.b);
            }
            zzbbrVar.set(new zzcvn(info, this.b, str));
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
            zzyt.zzpa();
            zzbbrVar.set(new zzcvn(null, this.b, zzazt.zzbf(this.b)));
        }
    }
}
