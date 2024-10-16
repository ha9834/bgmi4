package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsp extends zzdrr<zzdsp> {
    private static volatile zzdsp[] c;
    public Integer zzhsw = null;
    public String url = null;
    public zzdsm zzhsx = null;
    private zzdsn d = null;
    private Integer e = null;
    private int[] f = zzdry.zzhjo;
    private String g = null;
    public Integer zzhtc = null;
    public String[] zzhtd = zzdry.zzhog;

    public static zzdsp[] zzbba() {
        if (c == null) {
            synchronized (zzdrv.zzhnw) {
                if (c == null) {
                    c = new zzdsp[0];
                }
            }
        }
        return c;
    }

    public zzdsp() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        zzdrpVar.zzx(1, this.zzhsw.intValue());
        String str = this.url;
        if (str != null) {
            zzdrpVar.zzf(2, str);
        }
        zzdsm zzdsmVar = this.zzhsx;
        if (zzdsmVar != null) {
            zzdrpVar.zza(3, zzdsmVar);
        }
        int[] iArr = this.f;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.f;
                if (i2 >= iArr2.length) {
                    break;
                }
                zzdrpVar.zzx(6, iArr2[i2]);
                i2++;
            }
        }
        Integer num = this.zzhtc;
        if (num != null) {
            zzdrpVar.zzx(8, num.intValue());
        }
        String[] strArr = this.zzhtd;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.zzhtd;
                if (i >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    zzdrpVar.zzf(9, str2);
                }
                i++;
            }
        }
        super.zza(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int a() {
        int[] iArr;
        int a2 = super.a() + zzdrp.zzab(1, this.zzhsw.intValue());
        String str = this.url;
        if (str != null) {
            a2 += zzdrp.zzg(2, str);
        }
        zzdsm zzdsmVar = this.zzhsx;
        if (zzdsmVar != null) {
            a2 += zzdrp.zzb(3, zzdsmVar);
        }
        int[] iArr2 = this.f;
        int i = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                iArr = this.f;
                if (i2 >= iArr.length) {
                    break;
                }
                i3 += zzdrp.zzge(iArr[i2]);
                i2++;
            }
            a2 = a2 + i3 + (iArr.length * 1);
        }
        Integer num = this.zzhtc;
        if (num != null) {
            a2 += zzdrp.zzab(8, num.intValue());
        }
        String[] strArr = this.zzhtd;
        if (strArr == null || strArr.length <= 0) {
            return a2;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.zzhtd;
            if (i >= strArr2.length) {
                return a2 + i4 + (i5 * 1);
            }
            String str2 = strArr2[i];
            if (str2 != null) {
                i5++;
                i4 += zzdrp.zzgx(str2);
            }
            i++;
        }
    }
}
