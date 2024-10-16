package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxj extends zzdrr<zzxj> {
    public Integer zzcee = null;
    private zzwx c = null;
    private zzwt.zzb d = null;
    public zzxk zzceh = null;
    private zzwt.zza[] e = new zzwt.zza[0];
    private zzwt.zzc f = null;
    private zzwt.zzj g = null;
    private zzwt.zzh h = null;
    private zzwt.zze i = null;
    private zzwt.zzf j = null;
    private zzxp[] k = zzxp.zzos();

    public zzxj() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        Integer num = this.zzcee;
        if (num != null) {
            zzdrpVar.zzx(7, num.intValue());
        }
        zzxk zzxkVar = this.zzceh;
        if (zzxkVar != null) {
            zzdrpVar.zza(10, zzxkVar);
        }
        zzwt.zza[] zzaVarArr = this.e;
        int i = 0;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzwt.zza[] zzaVarArr2 = this.e;
                if (i2 >= zzaVarArr2.length) {
                    break;
                }
                zzwt.zza zzaVar = zzaVarArr2[i2];
                if (zzaVar != null) {
                    zzdrpVar.zze(11, zzaVar);
                }
                i2++;
            }
        }
        zzxp[] zzxpVarArr = this.k;
        if (zzxpVarArr != null && zzxpVarArr.length > 0) {
            while (true) {
                zzxp[] zzxpVarArr2 = this.k;
                if (i >= zzxpVarArr2.length) {
                    break;
                }
                zzxp zzxpVar = zzxpVarArr2[i];
                if (zzxpVar != null) {
                    zzdrpVar.zza(17, zzxpVar);
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
        Integer num = this.zzcee;
        if (num != null) {
            a2 += zzdrp.zzab(7, num.intValue());
        }
        zzxk zzxkVar = this.zzceh;
        if (zzxkVar != null) {
            a2 += zzdrp.zzb(10, zzxkVar);
        }
        zzwt.zza[] zzaVarArr = this.e;
        int i = 0;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i2 = a2;
            int i3 = 0;
            while (true) {
                zzwt.zza[] zzaVarArr2 = this.e;
                if (i3 >= zzaVarArr2.length) {
                    break;
                }
                zzwt.zza zzaVar = zzaVarArr2[i3];
                if (zzaVar != null) {
                    i2 += zzdni.zzc(11, zzaVar);
                }
                i3++;
            }
            a2 = i2;
        }
        zzxp[] zzxpVarArr = this.k;
        if (zzxpVarArr != null && zzxpVarArr.length > 0) {
            while (true) {
                zzxp[] zzxpVarArr2 = this.k;
                if (i >= zzxpVarArr2.length) {
                    break;
                }
                zzxp zzxpVar = zzxpVarArr2[i];
                if (zzxpVar != null) {
                    a2 += zzdrp.zzb(17, zzxpVar);
                }
                i++;
            }
        }
        return a2;
    }
}
