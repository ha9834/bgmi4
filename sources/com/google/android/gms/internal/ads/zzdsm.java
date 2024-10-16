package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrz;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsm extends zzdrr<zzdsm> {
    private zzdrz.zzb.zzd.C0098zzb c = null;
    public zzdsl[] zzhsq = zzdsl.zzbaz();
    private byte[] d = null;
    private byte[] e = null;
    private Integer f = null;

    public zzdsm() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        zzdsl[] zzdslVarArr = this.zzhsq;
        if (zzdslVarArr != null && zzdslVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzdsl[] zzdslVarArr2 = this.zzhsq;
                if (i >= zzdslVarArr2.length) {
                    break;
                }
                zzdsl zzdslVar = zzdslVarArr2[i];
                if (zzdslVar != null) {
                    zzdrpVar.zza(2, zzdslVar);
                }
                i++;
            }
        }
        super.zza(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int a() {
        int a2 = super.a();
        zzdsl[] zzdslVarArr = this.zzhsq;
        if (zzdslVarArr != null && zzdslVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzdsl[] zzdslVarArr2 = this.zzhsq;
                if (i >= zzdslVarArr2.length) {
                    break;
                }
                zzdsl zzdslVar = zzdslVarArr2[i];
                if (zzdslVar != null) {
                    a2 += zzdrp.zzb(2, zzdslVar);
                }
                i++;
            }
        }
        return a2;
    }
}
