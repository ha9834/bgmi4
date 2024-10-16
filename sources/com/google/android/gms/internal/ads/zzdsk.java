package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsk extends zzdrr<zzdsk> {
    public String zzdrr = null;

    public zzdsk() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        String str = this.zzdrr;
        if (str != null) {
            zzdrpVar.zzf(1, str);
        }
        super.zza(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int a() {
        int a2 = super.a();
        String str = this.zzdrr;
        return str != null ? a2 + zzdrp.zzg(1, str) : a2;
    }
}
