package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcfb implements zzbro, zzbsr, zzbtk {

    /* renamed from: a, reason: collision with root package name */
    private final zzcfi f3222a;
    private final String b = (String) zzyt.zzpe().zzd(zzacu.zzcmy);
    private final zzdae c;

    public zzcfb(zzcfi zzcfiVar, zzdae zzdaeVar) {
        this.f3222a = zzcfiVar;
        this.c = zzdaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        a(this.f3222a.zzqy());
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i) {
        a(this.f3222a.zzqy());
    }

    private final void a(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.b).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcmx)).booleanValue()) {
            this.c.zzed(uri);
        }
        zzawz.zzds(uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzb(zzarx zzarxVar) {
        this.f3222a.zzi(zzarxVar.zzdot);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zza(zzcxu zzcxuVar) {
        this.f3222a.zzb(zzcxuVar);
    }
}
