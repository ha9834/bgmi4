package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class jh implements zzgh {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbdq f2263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jh(zzbdq zzbdqVar) {
        this.f2263a = zzbdqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void zzdo() {
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void zza(boolean z, int i) {
        int i2;
        i2 = this.f2263a.r;
        if (i2 != i) {
            this.f2263a.r = i;
            switch (i) {
                case 4:
                    this.f2263a.j();
                    return;
                case 5:
                    this.f2263a.k();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void zza(zzgd zzgdVar) {
        this.f2263a.b("PlayerError", zzgdVar.getMessage());
    }
}
