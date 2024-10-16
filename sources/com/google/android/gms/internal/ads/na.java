package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class na implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbmg f2362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public na(zzbmg zzbmgVar) {
        this.f2362a = zzbmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        boolean a2;
        zzbmn zzbmnVar;
        Executor executor;
        a2 = this.f2362a.a((Map<String, String>) map);
        if (a2) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvs)).booleanValue()) {
                executor = this.f2362a.c;
                executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.nb

                    /* renamed from: a, reason: collision with root package name */
                    private final na f2363a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2363a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbmn zzbmnVar2;
                        zzbmnVar2 = this.f2363a.f2362a.d;
                        zzbmnVar2.zzafd();
                    }
                });
            } else {
                zzbmnVar = this.f2362a.d;
                zzbmnVar.zzafd();
            }
        }
    }
}
