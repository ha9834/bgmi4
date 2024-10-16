package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbk;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbv extends zziq<zzbv> {
    private static volatile zzbv[] c;
    public Integer zzzf = null;
    public zzbk.zzd[] zzzg = new zzbk.zzd[0];
    public zzbk.zza[] zzzh = new zzbk.zza[0];
    private Boolean d = null;
    private Boolean e = null;

    public static zzbv[] zzqx() {
        if (c == null) {
            synchronized (zziu.zzaov) {
                if (c == null) {
                    c = new zzbv[0];
                }
            }
        }
        return c;
    }

    public zzbv() {
        this.f4576a = null;
        this.b = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbv)) {
            return false;
        }
        zzbv zzbvVar = (zzbv) obj;
        Integer num = this.zzzf;
        if (num == null) {
            if (zzbvVar.zzzf != null) {
                return false;
            }
        } else if (!num.equals(zzbvVar.zzzf)) {
            return false;
        }
        if (!zziu.equals(this.zzzg, zzbvVar.zzzg) || !zziu.equals(this.zzzh, zzbvVar.zzzh)) {
            return false;
        }
        Boolean bool = this.d;
        if (bool == null) {
            if (zzbvVar.d != null) {
                return false;
            }
        } else if (!bool.equals(zzbvVar.d)) {
            return false;
        }
        Boolean bool2 = this.e;
        if (bool2 == null) {
            if (zzbvVar.e != null) {
                return false;
            }
        } else if (!bool2.equals(zzbvVar.e)) {
            return false;
        }
        if (this.f4576a == null || this.f4576a.isEmpty()) {
            return zzbvVar.f4576a == null || zzbvVar.f4576a.isEmpty();
        }
        return this.f4576a.equals(zzbvVar.f4576a);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzzf;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zziu.hashCode(this.zzzg)) * 31) + zziu.hashCode(this.zzzh)) * 31;
        Boolean bool = this.d;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.e;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        if (this.f4576a != null && !this.f4576a.isEmpty()) {
            i = this.f4576a.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zziq, com.google.android.gms.internal.measurement.zziw
    public final void zza(zzio zzioVar) throws IOException {
        Integer num = this.zzzf;
        if (num != null) {
            zzioVar.zzc(1, num.intValue());
        }
        zzbk.zzd[] zzdVarArr = this.zzzg;
        int i = 0;
        if (zzdVarArr != null && zzdVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzbk.zzd[] zzdVarArr2 = this.zzzg;
                if (i2 >= zzdVarArr2.length) {
                    break;
                }
                zzbk.zzd zzdVar = zzdVarArr2[i2];
                if (zzdVar != null) {
                    zzioVar.zze(2, zzdVar);
                }
                i2++;
            }
        }
        zzbk.zza[] zzaVarArr = this.zzzh;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            while (true) {
                zzbk.zza[] zzaVarArr2 = this.zzzh;
                if (i >= zzaVarArr2.length) {
                    break;
                }
                zzbk.zza zzaVar = zzaVarArr2[i];
                if (zzaVar != null) {
                    zzioVar.zze(3, zzaVar);
                }
                i++;
            }
        }
        Boolean bool = this.d;
        if (bool != null) {
            zzioVar.zzb(4, bool.booleanValue());
        }
        Boolean bool2 = this.e;
        if (bool2 != null) {
            zzioVar.zzb(5, bool2.booleanValue());
        }
        super.zza(zzioVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zziq, com.google.android.gms.internal.measurement.zziw
    public final int a() {
        int a2 = super.a();
        Integer num = this.zzzf;
        if (num != null) {
            a2 += zzio.zzg(1, num.intValue());
        }
        zzbk.zzd[] zzdVarArr = this.zzzg;
        int i = 0;
        if (zzdVarArr != null && zzdVarArr.length > 0) {
            int i2 = a2;
            int i3 = 0;
            while (true) {
                zzbk.zzd[] zzdVarArr2 = this.zzzg;
                if (i3 >= zzdVarArr2.length) {
                    break;
                }
                zzbk.zzd zzdVar = zzdVarArr2[i3];
                if (zzdVar != null) {
                    i2 += zzee.zzc(2, zzdVar);
                }
                i3++;
            }
            a2 = i2;
        }
        zzbk.zza[] zzaVarArr = this.zzzh;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            while (true) {
                zzbk.zza[] zzaVarArr2 = this.zzzh;
                if (i >= zzaVarArr2.length) {
                    break;
                }
                zzbk.zza zzaVar = zzaVarArr2[i];
                if (zzaVar != null) {
                    a2 += zzee.zzc(3, zzaVar);
                }
                i++;
            }
        }
        Boolean bool = this.d;
        if (bool != null) {
            bool.booleanValue();
            a2 += zzio.zzbi(4) + 1;
        }
        Boolean bool2 = this.e;
        if (bool2 == null) {
            return a2;
        }
        bool2.booleanValue();
        return a2 + zzio.zzbi(5) + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final /* synthetic */ zziw zza(zzil zzilVar) throws IOException {
        while (true) {
            int zzsg = zzilVar.zzsg();
            if (zzsg == 0) {
                return this;
            }
            if (zzsg == 8) {
                this.zzzf = Integer.valueOf(zzilVar.zzta());
            } else if (zzsg == 18) {
                int zzb = zzix.zzb(zzilVar, 18);
                zzbk.zzd[] zzdVarArr = this.zzzg;
                int length = zzdVarArr == null ? 0 : zzdVarArr.length;
                zzbk.zzd[] zzdVarArr2 = new zzbk.zzd[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzzg, 0, zzdVarArr2, 0, length);
                }
                while (length < zzdVarArr2.length - 1) {
                    zzdVarArr2[length] = (zzbk.zzd) zzilVar.zza(zzbk.zzd.zzkj());
                    zzilVar.zzsg();
                    length++;
                }
                zzdVarArr2[length] = (zzbk.zzd) zzilVar.zza(zzbk.zzd.zzkj());
                this.zzzg = zzdVarArr2;
            } else if (zzsg == 26) {
                int zzb2 = zzix.zzb(zzilVar, 26);
                zzbk.zza[] zzaVarArr = this.zzzh;
                int length2 = zzaVarArr == null ? 0 : zzaVarArr.length;
                zzbk.zza[] zzaVarArr2 = new zzbk.zza[zzb2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzzh, 0, zzaVarArr2, 0, length2);
                }
                while (length2 < zzaVarArr2.length - 1) {
                    zzaVarArr2[length2] = (zzbk.zza) zzilVar.zza(zzbk.zza.zzkj());
                    zzilVar.zzsg();
                    length2++;
                }
                zzaVarArr2[length2] = (zzbk.zza) zzilVar.zza(zzbk.zza.zzkj());
                this.zzzh = zzaVarArr2;
            } else if (zzsg == 32) {
                this.d = Boolean.valueOf(zzilVar.zzsm());
            } else if (zzsg != 40) {
                if (!super.a(zzilVar, zzsg)) {
                    return this;
                }
            } else {
                this.e = Boolean.valueOf(zzilVar.zzsm());
            }
        }
    }
}
