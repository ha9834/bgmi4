package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class sm implements zzaqc {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcdp f2493a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sm(zzcdp zzcdpVar) {
        this.f2493a = zzcdpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final void zzc(int i, int i2, int i3, int i4) {
        zzbse zzbseVar;
        zzbseVar = this.f2493a.b;
        zzbseVar.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final void zztc() {
        zzbse zzbseVar;
        zzbseVar = this.f2493a.b;
        zzbseVar.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final void zztd() {
        zzbtl zzbtlVar;
        zzbtlVar = this.f2493a.m;
        zzbtlVar.zzafq();
    }
}
