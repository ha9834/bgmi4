package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxk extends zzdrr<zzxk> {
    public String zzcep = null;
    private zzwt.zza[] c = new zzwt.zza[0];
    private zzwx d = null;
    private zzwx e = null;
    private zzwx f = null;

    public zzxk() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        String str = this.zzcep;
        if (str != null) {
            zzdrpVar.zzf(1, str);
        }
        zzwt.zza[] zzaVarArr = this.c;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzwt.zza[] zzaVarArr2 = this.c;
                if (i >= zzaVarArr2.length) {
                    break;
                }
                zzwt.zza zzaVar = zzaVarArr2[i];
                if (zzaVar != null) {
                    zzdrpVar.zze(2, zzaVar);
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
        String str = this.zzcep;
        if (str != null) {
            a2 += zzdrp.zzg(1, str);
        }
        zzwt.zza[] zzaVarArr = this.c;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzwt.zza[] zzaVarArr2 = this.c;
                if (i >= zzaVarArr2.length) {
                    break;
                }
                zzwt.zza zzaVar = zzaVarArr2[i];
                if (zzaVar != null) {
                    a2 += zzdni.zzc(2, zzaVar);
                }
                i++;
            }
        }
        return a2;
    }
}
