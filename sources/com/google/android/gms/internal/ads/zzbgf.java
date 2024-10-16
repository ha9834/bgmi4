package com.google.android.gms.internal.ads;

@zzard
/* loaded from: classes2.dex */
public final class zzbgf extends zzbft {
    public zzbgf(zzbdf zzbdfVar) {
        super(zzbdfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void abort() {
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean zzex(String str) {
        zzbdf zzbdfVar = this.c.get();
        if (zzbdfVar != null) {
            zzbdfVar.zza(a(str), this);
        }
        zzawz.zzep("VideoStreamNoopCache is doing nothing.");
        zza(str, a(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
