package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcbp {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f3166a;
    private final zzbmy b;
    private final zzbva c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbp(Executor executor, zzbmy zzbmyVar, zzbva zzbvaVar) {
        this.f3166a = executor;
        this.c = zzbvaVar;
        this.b = zzbmyVar;
    }

    public final void zzk(final zzbgz zzbgzVar) {
        if (zzbgzVar == null) {
            return;
        }
        this.c.zzq(zzbgzVar.getView());
        this.c.zza(new zzue(zzbgzVar) { // from class: com.google.android.gms.internal.ads.rm

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2468a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2468a = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzue
            public final void zza(zzud zzudVar) {
                this.f2468a.zzaai().zza(zzudVar.zzbtr.left, zzudVar.zzbtr.top, false);
            }
        }, this.f3166a);
        this.c.zza(new zzue(zzbgzVar) { // from class: com.google.android.gms.internal.ads.rn

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2469a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2469a = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzue
            public final void zza(zzud zzudVar) {
                zzbgz zzbgzVar2 = this.f2469a;
                HashMap hashMap = new HashMap();
                hashMap.put("isVisible", zzudVar.zzbtk ? "1" : "0");
                zzbgzVar2.zza("onAdVisibilityChanged", hashMap);
            }
        }, this.f3166a);
        this.c.zza(this.b, this.f3166a);
        this.b.zzg(zzbgzVar);
        zzbgzVar.zza("/trackActiveViewUnit", new zzaho(this) { // from class: com.google.android.gms.internal.ads.ro

            /* renamed from: a, reason: collision with root package name */
            private final zzcbp f2470a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2470a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void zza(Object obj, Map map) {
                this.f2470a.b((zzbgz) obj, map);
            }
        });
        zzbgzVar.zza("/untrackActiveViewUnit", new zzaho(this) { // from class: com.google.android.gms.internal.ads.rp

            /* renamed from: a, reason: collision with root package name */
            private final zzcbp f2471a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2471a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void zza(Object obj, Map map) {
                this.f2471a.a((zzbgz) obj, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        this.b.disable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzbgz zzbgzVar, Map map) {
        this.b.enable();
    }
}
