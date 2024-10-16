package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzh extends zzuq<zzh> {
    public zzl[] zzpe = zzl.zzaa();
    public zzl[] zzpf = zzl.zzaa();
    public zzc.C0108zzc[] zzpg = new zzc.C0108zzc[0];

    public zzh() {
        this.f4457a = null;
        this.b = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzhVar = (zzh) obj;
        if (!zzuu.equals(this.zzpe, zzhVar.zzpe) || !zzuu.equals(this.zzpf, zzhVar.zzpf) || !zzuu.equals(this.zzpg, zzhVar.zzpg)) {
            return false;
        }
        if (this.f4457a == null || this.f4457a.isEmpty()) {
            return zzhVar.f4457a == null || zzhVar.f4457a.isEmpty();
        }
        return this.f4457a.equals(zzhVar.f4457a);
    }

    public final int hashCode() {
        return ((((((((getClass().getName().hashCode() + 527) * 31) + zzuu.hashCode(this.zzpe)) * 31) + zzuu.hashCode(this.zzpf)) * 31) + zzuu.hashCode(this.zzpg)) * 31) + ((this.f4457a == null || this.f4457a.isEmpty()) ? 0 : this.f4457a.hashCode());
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) throws IOException {
        zzl[] zzlVarArr = this.zzpe;
        int i = 0;
        if (zzlVarArr != null && zzlVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzl[] zzlVarArr2 = this.zzpe;
                if (i2 >= zzlVarArr2.length) {
                    break;
                }
                zzl zzlVar = zzlVarArr2[i2];
                if (zzlVar != null) {
                    zzuoVar.zza(1, zzlVar);
                }
                i2++;
            }
        }
        zzl[] zzlVarArr3 = this.zzpf;
        if (zzlVarArr3 != null && zzlVarArr3.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlVarArr4 = this.zzpf;
                if (i3 >= zzlVarArr4.length) {
                    break;
                }
                zzl zzlVar2 = zzlVarArr4[i3];
                if (zzlVar2 != null) {
                    zzuoVar.zza(2, zzlVar2);
                }
                i3++;
            }
        }
        zzc.C0108zzc[] c0108zzcArr = this.zzpg;
        if (c0108zzcArr != null && c0108zzcArr.length > 0) {
            while (true) {
                zzc.C0108zzc[] c0108zzcArr2 = this.zzpg;
                if (i >= c0108zzcArr2.length) {
                    break;
                }
                zzc.C0108zzc c0108zzc = c0108zzcArr2[i];
                if (c0108zzc != null) {
                    zzuoVar.zze(3, c0108zzc);
                }
                i++;
            }
        }
        super.zza(zzuoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int a() {
        int a2 = super.a();
        zzl[] zzlVarArr = this.zzpe;
        int i = 0;
        if (zzlVarArr != null && zzlVarArr.length > 0) {
            int i2 = a2;
            int i3 = 0;
            while (true) {
                zzl[] zzlVarArr2 = this.zzpe;
                if (i3 >= zzlVarArr2.length) {
                    break;
                }
                zzl zzlVar = zzlVarArr2[i3];
                if (zzlVar != null) {
                    i2 += zzuo.zzb(1, zzlVar);
                }
                i3++;
            }
            a2 = i2;
        }
        zzl[] zzlVarArr3 = this.zzpf;
        if (zzlVarArr3 != null && zzlVarArr3.length > 0) {
            int i4 = a2;
            int i5 = 0;
            while (true) {
                zzl[] zzlVarArr4 = this.zzpf;
                if (i5 >= zzlVarArr4.length) {
                    break;
                }
                zzl zzlVar2 = zzlVarArr4[i5];
                if (zzlVar2 != null) {
                    i4 += zzuo.zzb(2, zzlVar2);
                }
                i5++;
            }
            a2 = i4;
        }
        zzc.C0108zzc[] c0108zzcArr = this.zzpg;
        if (c0108zzcArr != null && c0108zzcArr.length > 0) {
            while (true) {
                zzc.C0108zzc[] c0108zzcArr2 = this.zzpg;
                if (i >= c0108zzcArr2.length) {
                    break;
                }
                zzc.C0108zzc c0108zzc = c0108zzcArr2[i];
                if (c0108zzc != null) {
                    a2 += zzqj.zzc(3, c0108zzc);
                }
                i++;
            }
        }
        return a2;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) throws IOException {
        while (true) {
            int zzni = zzunVar.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 10) {
                int zzb = zzuz.zzb(zzunVar, 10);
                zzl[] zzlVarArr = this.zzpe;
                int length = zzlVarArr == null ? 0 : zzlVarArr.length;
                zzl[] zzlVarArr2 = new zzl[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzpe, 0, zzlVarArr2, 0, length);
                }
                while (length < zzlVarArr2.length - 1) {
                    zzlVarArr2[length] = new zzl();
                    zzunVar.zza(zzlVarArr2[length]);
                    zzunVar.zzni();
                    length++;
                }
                zzlVarArr2[length] = new zzl();
                zzunVar.zza(zzlVarArr2[length]);
                this.zzpe = zzlVarArr2;
            } else if (zzni == 18) {
                int zzb2 = zzuz.zzb(zzunVar, 18);
                zzl[] zzlVarArr3 = this.zzpf;
                int length2 = zzlVarArr3 == null ? 0 : zzlVarArr3.length;
                zzl[] zzlVarArr4 = new zzl[zzb2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzpf, 0, zzlVarArr4, 0, length2);
                }
                while (length2 < zzlVarArr4.length - 1) {
                    zzlVarArr4[length2] = new zzl();
                    zzunVar.zza(zzlVarArr4[length2]);
                    zzunVar.zzni();
                    length2++;
                }
                zzlVarArr4[length2] = new zzl();
                zzunVar.zza(zzlVarArr4[length2]);
                this.zzpf = zzlVarArr4;
            } else if (zzni != 26) {
                if (!super.a(zzunVar, zzni)) {
                    return this;
                }
            } else {
                int zzb3 = zzuz.zzb(zzunVar, 26);
                zzc.C0108zzc[] c0108zzcArr = this.zzpg;
                int length3 = c0108zzcArr == null ? 0 : c0108zzcArr.length;
                zzc.C0108zzc[] c0108zzcArr2 = new zzc.C0108zzc[zzb3 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.zzpg, 0, c0108zzcArr2, 0, length3);
                }
                while (length3 < c0108zzcArr2.length - 1) {
                    c0108zzcArr2[length3] = (zzc.C0108zzc) zzunVar.zza(zzc.C0108zzc.zza());
                    zzunVar.zzni();
                    length3++;
                }
                c0108zzcArr2[length3] = (zzc.C0108zzc) zzunVar.zza(zzc.C0108zzc.zza());
                this.zzpg = c0108zzcArr2;
            }
        }
    }
}
