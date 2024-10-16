package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxn extends zzdrr<zzxn> {
    private Integer c = null;
    public String zzcfd = null;
    private Integer d = null;
    private zzwx e = null;
    private zzxo f = null;
    public long[] zzcfh = zzdry.zzhoc;
    public zzxl zzcfi = null;
    private zzxm g = null;
    private zzwt.zzg h = null;
    public zzxj zzcfl = null;
    public zzwt.zzi zzcfm = null;
    public zzwt.zzv zzcfn = null;

    public zzxn() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        String str = this.zzcfd;
        if (str != null) {
            zzdrpVar.zzf(10, str);
        }
        long[] jArr = this.zzcfh;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.zzcfh;
                if (i >= jArr2.length) {
                    break;
                }
                long j = jArr2[i];
                zzdrpVar.zzw(14, 0);
                zzdrpVar.zzfv(j);
                i++;
            }
        }
        zzxl zzxlVar = this.zzcfi;
        if (zzxlVar != null) {
            zzdrpVar.zza(15, zzxlVar);
        }
        zzxj zzxjVar = this.zzcfl;
        if (zzxjVar != null) {
            zzdrpVar.zza(18, zzxjVar);
        }
        zzwt.zzi zziVar = this.zzcfm;
        if (zziVar != null) {
            zzdrpVar.zze(19, zziVar);
        }
        zzwt.zzv zzvVar = this.zzcfn;
        if (zzvVar != null) {
            zzdrpVar.zze(20, zzvVar);
        }
        super.zza(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int a() {
        long[] jArr;
        int a2 = super.a();
        String str = this.zzcfd;
        if (str != null) {
            a2 += zzdrp.zzg(10, str);
        }
        long[] jArr2 = this.zzcfh;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                jArr = this.zzcfh;
                if (i >= jArr.length) {
                    break;
                }
                i2 += zzdrp.zzfw(jArr[i]);
                i++;
            }
            a2 = a2 + i2 + (jArr.length * 1);
        }
        zzxl zzxlVar = this.zzcfi;
        if (zzxlVar != null) {
            a2 += zzdrp.zzb(15, zzxlVar);
        }
        zzxj zzxjVar = this.zzcfl;
        if (zzxjVar != null) {
            a2 += zzdrp.zzb(18, zzxjVar);
        }
        zzwt.zzi zziVar = this.zzcfm;
        if (zziVar != null) {
            a2 += zzdni.zzc(19, zziVar);
        }
        zzwt.zzv zzvVar = this.zzcfn;
        return zzvVar != null ? a2 + zzdni.zzc(20, zzvVar) : a2;
    }
}
