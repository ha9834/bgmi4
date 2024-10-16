package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class is implements zzgh {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<zzgh> f2247a;
    private final /* synthetic */ zzbdk b;

    private is(zzbdk zzbdkVar) {
        this.b = zzbdkVar;
        this.f2247a = new WeakReference<>(null);
    }

    public final void a(zzgh zzghVar) {
        this.f2247a = new WeakReference<>(zzghVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void zza(boolean z, int i) {
        zzgh zzghVar = this.f2247a.get();
        if (zzghVar != null) {
            zzghVar.zza(z, i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void zzdo() {
        zzgh zzghVar = this.f2247a.get();
        if (zzghVar != null) {
            zzghVar.zzdo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void zza(zzgd zzgdVar) {
        zzbdk.a(this.b, "PlayerError", zzgdVar.getMessage());
        zzgh zzghVar = this.f2247a.get();
        if (zzghVar != null) {
            zzghVar.zza(zzgdVar);
        }
    }
}
