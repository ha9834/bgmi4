package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrz;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsj extends zzdrr<zzdsj> {
    public Integer zzhrv = null;
    private zzdrz.zza.zzc c = null;
    public String url = null;
    public String zzhrx = null;
    private String d = null;
    public zzdsk zzhrz = null;
    public zzdsp[] zzhsa = zzdsp.zzbba();
    public String zzhsb = null;
    public zzdso zzhsc = null;
    private Boolean e = null;
    private String[] f = zzdry.zzhog;
    private String g = null;
    private Boolean h = null;
    private Boolean i = null;
    private byte[] j = null;
    public zzdsq zzhsj = null;
    public String[] zzhsk = zzdry.zzhog;
    public String[] zzhsl = zzdry.zzhog;

    public zzdsj() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        String str = this.url;
        if (str != null) {
            zzdrpVar.zzf(1, str);
        }
        String str2 = this.zzhrx;
        if (str2 != null) {
            zzdrpVar.zzf(2, str2);
        }
        zzdsp[] zzdspVarArr = this.zzhsa;
        int i = 0;
        if (zzdspVarArr != null && zzdspVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzdsp[] zzdspVarArr2 = this.zzhsa;
                if (i2 >= zzdspVarArr2.length) {
                    break;
                }
                zzdsp zzdspVar = zzdspVarArr2[i2];
                if (zzdspVar != null) {
                    zzdrpVar.zza(4, zzdspVar);
                }
                i2++;
            }
        }
        String[] strArr = this.f;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i3];
                if (str3 != null) {
                    zzdrpVar.zzf(6, str3);
                }
                i3++;
            }
        }
        Integer num = this.zzhrv;
        if (num != null) {
            zzdrpVar.zzx(10, num.intValue());
        }
        zzdsk zzdskVar = this.zzhrz;
        if (zzdskVar != null) {
            zzdrpVar.zza(12, zzdskVar);
        }
        String str4 = this.zzhsb;
        if (str4 != null) {
            zzdrpVar.zzf(13, str4);
        }
        zzdso zzdsoVar = this.zzhsc;
        if (zzdsoVar != null) {
            zzdrpVar.zza(14, zzdsoVar);
        }
        zzdsq zzdsqVar = this.zzhsj;
        if (zzdsqVar != null) {
            zzdrpVar.zza(17, zzdsqVar);
        }
        String[] strArr3 = this.zzhsk;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.zzhsk;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i4];
                if (str5 != null) {
                    zzdrpVar.zzf(20, str5);
                }
                i4++;
            }
        }
        String[] strArr5 = this.zzhsl;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.zzhsl;
                if (i >= strArr6.length) {
                    break;
                }
                String str6 = strArr6[i];
                if (str6 != null) {
                    zzdrpVar.zzf(21, str6);
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
        String str = this.url;
        if (str != null) {
            a2 += zzdrp.zzg(1, str);
        }
        String str2 = this.zzhrx;
        if (str2 != null) {
            a2 += zzdrp.zzg(2, str2);
        }
        zzdsp[] zzdspVarArr = this.zzhsa;
        int i = 0;
        if (zzdspVarArr != null && zzdspVarArr.length > 0) {
            int i2 = a2;
            int i3 = 0;
            while (true) {
                zzdsp[] zzdspVarArr2 = this.zzhsa;
                if (i3 >= zzdspVarArr2.length) {
                    break;
                }
                zzdsp zzdspVar = zzdspVarArr2[i3];
                if (zzdspVar != null) {
                    i2 += zzdrp.zzb(4, zzdspVar);
                }
                i3++;
            }
            a2 = i2;
        }
        String[] strArr = this.f;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.f;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i4];
                if (str3 != null) {
                    i6++;
                    i5 += zzdrp.zzgx(str3);
                }
                i4++;
            }
            a2 = a2 + i5 + (i6 * 1);
        }
        Integer num = this.zzhrv;
        if (num != null) {
            a2 += zzdrp.zzab(10, num.intValue());
        }
        zzdsk zzdskVar = this.zzhrz;
        if (zzdskVar != null) {
            a2 += zzdrp.zzb(12, zzdskVar);
        }
        String str4 = this.zzhsb;
        if (str4 != null) {
            a2 += zzdrp.zzg(13, str4);
        }
        zzdso zzdsoVar = this.zzhsc;
        if (zzdsoVar != null) {
            a2 += zzdrp.zzb(14, zzdsoVar);
        }
        zzdsq zzdsqVar = this.zzhsj;
        if (zzdsqVar != null) {
            a2 += zzdrp.zzb(17, zzdsqVar);
        }
        String[] strArr3 = this.zzhsk;
        if (strArr3 != null && strArr3.length > 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.zzhsk;
                if (i7 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i7];
                if (str5 != null) {
                    i9++;
                    i8 += zzdrp.zzgx(str5);
                }
                i7++;
            }
            a2 = a2 + i8 + (i9 * 2);
        }
        String[] strArr5 = this.zzhsl;
        if (strArr5 == null || strArr5.length <= 0) {
            return a2;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr6 = this.zzhsl;
            if (i >= strArr6.length) {
                return a2 + i10 + (i11 * 2);
            }
            String str6 = strArr6[i];
            if (str6 != null) {
                i11++;
                i10 += zzdrp.zzgx(str6);
            }
            i++;
        }
    }
}
