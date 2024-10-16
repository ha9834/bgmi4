package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class xj implements zzban<zzbnf> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzboc f2611a;
    private final /* synthetic */ zzcpt b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xj(zzcpt zzcptVar, zzboc zzbocVar) {
        this.b = zzcptVar;
        this.f2611a = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        zzbtb zzbtbVar;
        synchronized (this.b) {
            zzcpt.a(this.b, (zzbbh) null);
            this.f2611a.zzadb().onAdFailedToLoad(zzcgm.zze(th));
            zzbtbVar = this.b.g;
            zzbtbVar.zzdk(60);
            zzcya.zzc(th, "BannerAdManagerShim.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbnf zzbnfVar) {
        zzbnf zzbnfVar2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        zzbtb zzbtbVar;
        zzbnf zzbnfVar3;
        zzbnf zzbnfVar4 = zzbnfVar;
        synchronized (this.b) {
            zzcpt.a(this.b, (zzbbh) null);
            zzbnfVar2 = this.b.j;
            if (zzbnfVar2 != null) {
                zzbnfVar3 = this.b.j;
                zzbnfVar3.destroy();
            }
            this.b.j = zzbnfVar4;
            viewGroup = this.b.c;
            viewGroup.removeAllViews();
            viewGroup2 = this.b.c;
            viewGroup2.addView(zzbnfVar4.zzafi());
            zzbnfVar4.zzafl();
            zzbtbVar = this.b.g;
            zzbtbVar.zzdk(zzbnfVar4.zzafk());
        }
    }
}
