package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxl extends zzdrr<zzxl> {
    public String zzceu = null;
    private zzwt.zzn c = null;
    private Integer d = null;
    public zzxo zzcex = null;
    private Integer e = null;
    private zzwx f = null;
    private zzwx g = null;
    private zzwx h = null;

    public zzxl() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        String str = this.zzceu;
        if (str != null) {
            zzdrpVar.zzf(1, str);
        }
        zzxo zzxoVar = this.zzcex;
        if (zzxoVar != null) {
            zzdrpVar.zza(4, zzxoVar);
        }
        super.zza(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int a() {
        int a2 = super.a();
        String str = this.zzceu;
        if (str != null) {
            a2 += zzdrp.zzg(1, str);
        }
        zzxo zzxoVar = this.zzcex;
        return zzxoVar != null ? a2 + zzdrp.zzb(4, zzxoVar) : a2;
    }
}
