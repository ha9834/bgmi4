package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcex implements zzczz {

    /* renamed from: a, reason: collision with root package name */
    private Map<zzczs, zzcez> f3219a;
    private zzwj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcex(zzwj zzwjVar, Map<zzczs, zzcez> map) {
        this.f3219a = map;
        this.b = zzwjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zza(zzczs zzczsVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zzb(zzczs zzczsVar, String str) {
        if (this.f3219a.containsKey(zzczsVar)) {
            this.b.zza(this.f3219a.get(zzczsVar).zzfuk);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zza(zzczs zzczsVar, String str, Throwable th) {
        if (this.f3219a.containsKey(zzczsVar)) {
            this.b.zza(this.f3219a.get(zzczsVar).zzfum);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zzc(zzczs zzczsVar, String str) {
        if (this.f3219a.containsKey(zzczsVar)) {
            this.b.zza(this.f3219a.get(zzczsVar).zzful);
        }
    }
}
