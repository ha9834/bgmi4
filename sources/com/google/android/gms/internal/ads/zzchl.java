package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzchl extends zzchj {
    private static final Pattern f = Pattern.compile("Received error HTTP response code: (.*)");

    /* renamed from: a, reason: collision with root package name */
    private final zzcgn f3262a;
    private final zzbbl b;
    private final zzcxv c;
    private final ScheduledExecutorService d;
    private final zzcji e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchl(zzbtg zzbtgVar, zzcxv zzcxvVar, zzcgn zzcgnVar, zzbbl zzbblVar, ScheduledExecutorService scheduledExecutorService, zzcji zzcjiVar) {
        super(zzbtgVar);
        this.c = zzcxvVar;
        this.f3262a = zzcgnVar;
        this.b = zzbblVar;
        this.d = scheduledExecutorService;
        this.e = zzcjiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzchj
    public final zzbbh<zzcxu> zze(zzarx zzarxVar) throws zzcgm {
        zzbbh<zzcxu> zza = zzbar.zza(this.f3262a.zzc(zzarxVar), new zzbal(this) { // from class: com.google.android.gms.internal.ads.tk

            /* renamed from: a, reason: collision with root package name */
            private final zzchl f2518a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2518a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2518a.a((InputStream) obj);
            }
        }, this.b);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvm)).booleanValue()) {
            zza = zzbar.zza(zzbar.zza(zza, ((Integer) zzyt.zzpe().zzd(zzacu.zzcvn)).intValue(), TimeUnit.SECONDS, this.d), TimeoutException.class, tl.f2519a, zzbbm.zzeaf);
        }
        zzbar.zza(zza, new tm(this), zzbbm.zzeaf);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(InputStream inputStream) throws Exception {
        return zzbar.zzm(new zzcxu(new zzcxr(this.c), zzcxs.zza(new InputStreamReader(inputStream))));
    }
}
