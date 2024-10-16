package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class wt implements zzbsn {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbr f2596a;
    private final /* synthetic */ zzcjy b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public wt(zzcoe zzcoeVar, zzbbr zzbbrVar, zzcjy zzcjyVar) {
        this.f2596a = zzbbrVar;
        this.b = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final synchronized void onAdFailedToLoad(int i) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvj)).booleanValue()) {
            i = 3;
        }
        zzbbr zzbbrVar = this.f2596a;
        String str = this.b.zzfis;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("adapter ");
        sb.append(str);
        sb.append(" failed to load");
        zzbbrVar.setException(new zzcmw(sb.toString(), i));
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final synchronized void onAdLoaded() {
        this.f2596a.set(null);
    }
}
