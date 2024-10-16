package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsq extends zzdrr<zzdsq> {
    public String zzhte = null;
    public Long zzhtf = null;
    public Boolean zzhtg = null;

    public zzdsq() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        String str = this.zzhte;
        if (str != null) {
            zzdrpVar.zzf(1, str);
        }
        Long l = this.zzhtf;
        if (l != null) {
            long longValue = l.longValue();
            zzdrpVar.zzw(2, 0);
            zzdrpVar.zzfv(longValue);
        }
        Boolean bool = this.zzhtg;
        if (bool != null) {
            zzdrpVar.zzi(3, bool.booleanValue());
        }
        super.zza(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int a() {
        int a2 = super.a();
        String str = this.zzhte;
        if (str != null) {
            a2 += zzdrp.zzg(1, str);
        }
        Long l = this.zzhtf;
        if (l != null) {
            a2 += zzdrp.zzgd(2) + zzdrp.zzfw(l.longValue());
        }
        Boolean bool = this.zzhtg;
        if (bool == null) {
            return a2;
        }
        bool.booleanValue();
        return a2 + zzdrp.zzgd(3) + 1;
    }
}
