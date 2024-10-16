package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class nc implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbmg f2364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nc(zzbmg zzbmgVar) {
        this.f2364a = zzbmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        boolean a2;
        zzbmn zzbmnVar;
        Executor executor;
        a2 = this.f2364a.a((Map<String, String>) map);
        if (a2) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvs)).booleanValue()) {
                executor = this.f2364a.c;
                executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.nd

                    /* renamed from: a, reason: collision with root package name */
                    private final nc f2365a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2365a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbmn zzbmnVar2;
                        zzbmnVar2 = this.f2365a.f2364a.d;
                        zzbmnVar2.zzaff();
                    }
                });
            } else {
                zzbmnVar = this.f2364a.d;
                zzbmnVar.zzaff();
            }
        }
    }
}
