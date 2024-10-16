package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;

@zzard
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbgh extends zzbgl {
    private final String d;

    public zzbgh(zzbdf zzbdfVar, String str) {
        super(zzbdfVar);
        this.d = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgl
    protected final int a() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgl
    protected final zzhn b(String str) {
        zzjp zzjtVar = new zzjt(this.f2870a, this.b);
        return new zzig(Uri.parse(str), ((Boolean) zzyt.zzpe().zzd(zzacu.zzctr)).booleanValue() ? new zzbeh(this.f2870a, zzjtVar, new zzbei(this) { // from class: com.google.android.gms.internal.ads.kq

            /* renamed from: a, reason: collision with root package name */
            private final zzbgh f2298a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2298a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbei
            public final void zzd(boolean z, long j) {
                this.f2298a.a(z, j);
            }
        }) : zzjtVar, "video/webm".equals(this.d) ? new zzjg() : new zziv(), 2, ((Integer) zzyt.zzpe().zzd(zzacu.zzclw)).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(final boolean z, final long j) {
        final zzbdf zzbdfVar = this.c.get();
        if (zzbdfVar != null) {
            zzbbm.zzeae.execute(new Runnable(zzbdfVar, z, j) { // from class: com.google.android.gms.internal.ads.kr

                /* renamed from: a, reason: collision with root package name */
                private final zzbdf f2299a;
                private final boolean b;
                private final long c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2299a = zzbdfVar;
                    this.b = z;
                    this.c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2299a.zza(this.b, this.c);
                }
            });
        }
    }
}
