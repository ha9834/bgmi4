package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbq;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbw extends zziq<zzbw> {
    public Long zzzk = null;
    public String zzcg = null;
    private Integer c = null;
    public zzbq.zza[] zzzm = new zzbq.zza[0];
    public zzbx[] zzzn = zzbx.zzrc();
    public zzbv[] zzzo = zzbv.zzqx();
    private String d = null;
    public Boolean zzzq = null;

    public zzbw() {
        this.f4576a = null;
        this.b = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbw)) {
            return false;
        }
        zzbw zzbwVar = (zzbw) obj;
        Long l = this.zzzk;
        if (l == null) {
            if (zzbwVar.zzzk != null) {
                return false;
            }
        } else if (!l.equals(zzbwVar.zzzk)) {
            return false;
        }
        String str = this.zzcg;
        if (str == null) {
            if (zzbwVar.zzcg != null) {
                return false;
            }
        } else if (!str.equals(zzbwVar.zzcg)) {
            return false;
        }
        Integer num = this.c;
        if (num == null) {
            if (zzbwVar.c != null) {
                return false;
            }
        } else if (!num.equals(zzbwVar.c)) {
            return false;
        }
        if (!zziu.equals(this.zzzm, zzbwVar.zzzm) || !zziu.equals(this.zzzn, zzbwVar.zzzn) || !zziu.equals(this.zzzo, zzbwVar.zzzo)) {
            return false;
        }
        String str2 = this.d;
        if (str2 == null) {
            if (zzbwVar.d != null) {
                return false;
            }
        } else if (!str2.equals(zzbwVar.d)) {
            return false;
        }
        Boolean bool = this.zzzq;
        if (bool == null) {
            if (zzbwVar.zzzq != null) {
                return false;
            }
        } else if (!bool.equals(zzbwVar.zzzq)) {
            return false;
        }
        if (this.f4576a == null || this.f4576a.isEmpty()) {
            return zzbwVar.f4576a == null || zzbwVar.f4576a.isEmpty();
        }
        return this.f4576a.equals(zzbwVar.f4576a);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Long l = this.zzzk;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.zzcg;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.c;
        int hashCode4 = (((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + zziu.hashCode(this.zzzm)) * 31) + zziu.hashCode(this.zzzn)) * 31) + zziu.hashCode(this.zzzo)) * 31;
        String str2 = this.d;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.zzzq;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        if (this.f4576a != null && !this.f4576a.isEmpty()) {
            i = this.f4576a.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zziq, com.google.android.gms.internal.measurement.zziw
    public final void zza(zzio zzioVar) throws IOException {
        Long l = this.zzzk;
        int i = 0;
        if (l != null) {
            long longValue = l.longValue();
            zzioVar.zzb(1, 0);
            zzioVar.zzbz(longValue);
        }
        String str = this.zzcg;
        if (str != null) {
            zzioVar.zzb(2, str);
        }
        Integer num = this.c;
        if (num != null) {
            zzioVar.zzc(3, num.intValue());
        }
        zzbq.zza[] zzaVarArr = this.zzzm;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzbq.zza[] zzaVarArr2 = this.zzzm;
                if (i2 >= zzaVarArr2.length) {
                    break;
                }
                zzbq.zza zzaVar = zzaVarArr2[i2];
                if (zzaVar != null) {
                    zzioVar.zze(4, zzaVar);
                }
                i2++;
            }
        }
        zzbx[] zzbxVarArr = this.zzzn;
        if (zzbxVarArr != null && zzbxVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzbx[] zzbxVarArr2 = this.zzzn;
                if (i3 >= zzbxVarArr2.length) {
                    break;
                }
                zzbx zzbxVar = zzbxVarArr2[i3];
                if (zzbxVar != null) {
                    zzioVar.zza(5, zzbxVar);
                }
                i3++;
            }
        }
        zzbv[] zzbvVarArr = this.zzzo;
        if (zzbvVarArr != null && zzbvVarArr.length > 0) {
            while (true) {
                zzbv[] zzbvVarArr2 = this.zzzo;
                if (i >= zzbvVarArr2.length) {
                    break;
                }
                zzbv zzbvVar = zzbvVarArr2[i];
                if (zzbvVar != null) {
                    zzioVar.zza(6, zzbvVar);
                }
                i++;
            }
        }
        String str2 = this.d;
        if (str2 != null) {
            zzioVar.zzb(7, str2);
        }
        Boolean bool = this.zzzq;
        if (bool != null) {
            zzioVar.zzb(8, bool.booleanValue());
        }
        super.zza(zzioVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zziq, com.google.android.gms.internal.measurement.zziw
    public final int a() {
        int a2 = super.a();
        Long l = this.zzzk;
        if (l != null) {
            long longValue = l.longValue();
            a2 += zzio.zzbi(1) + (((-128) & longValue) == 0 ? 1 : ((-16384) & longValue) == 0 ? 2 : ((-2097152) & longValue) == 0 ? 3 : ((-268435456) & longValue) == 0 ? 4 : ((-34359738368L) & longValue) == 0 ? 5 : ((-4398046511104L) & longValue) == 0 ? 6 : ((-562949953421312L) & longValue) == 0 ? 7 : ((-72057594037927936L) & longValue) == 0 ? 8 : (longValue & Long.MIN_VALUE) == 0 ? 9 : 10);
        }
        String str = this.zzcg;
        if (str != null) {
            a2 += zzio.zzc(2, str);
        }
        Integer num = this.c;
        if (num != null) {
            a2 += zzio.zzg(3, num.intValue());
        }
        zzbq.zza[] zzaVarArr = this.zzzm;
        int i = 0;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i2 = a2;
            int i3 = 0;
            while (true) {
                zzbq.zza[] zzaVarArr2 = this.zzzm;
                if (i3 >= zzaVarArr2.length) {
                    break;
                }
                zzbq.zza zzaVar = zzaVarArr2[i3];
                if (zzaVar != null) {
                    i2 += zzee.zzc(4, zzaVar);
                }
                i3++;
            }
            a2 = i2;
        }
        zzbx[] zzbxVarArr = this.zzzn;
        if (zzbxVarArr != null && zzbxVarArr.length > 0) {
            int i4 = a2;
            int i5 = 0;
            while (true) {
                zzbx[] zzbxVarArr2 = this.zzzn;
                if (i5 >= zzbxVarArr2.length) {
                    break;
                }
                zzbx zzbxVar = zzbxVarArr2[i5];
                if (zzbxVar != null) {
                    i4 += zzio.zzb(5, zzbxVar);
                }
                i5++;
            }
            a2 = i4;
        }
        zzbv[] zzbvVarArr = this.zzzo;
        if (zzbvVarArr != null && zzbvVarArr.length > 0) {
            while (true) {
                zzbv[] zzbvVarArr2 = this.zzzo;
                if (i >= zzbvVarArr2.length) {
                    break;
                }
                zzbv zzbvVar = zzbvVarArr2[i];
                if (zzbvVar != null) {
                    a2 += zzio.zzb(6, zzbvVar);
                }
                i++;
            }
        }
        String str2 = this.d;
        if (str2 != null) {
            a2 += zzio.zzc(7, str2);
        }
        Boolean bool = this.zzzq;
        if (bool == null) {
            return a2;
        }
        bool.booleanValue();
        return a2 + zzio.zzbi(8) + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final /* synthetic */ zziw zza(zzil zzilVar) throws IOException {
        while (true) {
            int zzsg = zzilVar.zzsg();
            if (zzsg == 0) {
                return this;
            }
            if (zzsg == 8) {
                this.zzzk = Long.valueOf(zzilVar.zztb());
            } else if (zzsg == 18) {
                this.zzcg = zzilVar.readString();
            } else if (zzsg == 24) {
                this.c = Integer.valueOf(zzilVar.zzta());
            } else if (zzsg == 34) {
                int zzb = zzix.zzb(zzilVar, 34);
                zzbq.zza[] zzaVarArr = this.zzzm;
                int length = zzaVarArr == null ? 0 : zzaVarArr.length;
                zzbq.zza[] zzaVarArr2 = new zzbq.zza[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzzm, 0, zzaVarArr2, 0, length);
                }
                while (length < zzaVarArr2.length - 1) {
                    zzaVarArr2[length] = (zzbq.zza) zzilVar.zza(zzbq.zza.zzkj());
                    zzilVar.zzsg();
                    length++;
                }
                zzaVarArr2[length] = (zzbq.zza) zzilVar.zza(zzbq.zza.zzkj());
                this.zzzm = zzaVarArr2;
            } else if (zzsg == 42) {
                int zzb2 = zzix.zzb(zzilVar, 42);
                zzbx[] zzbxVarArr = this.zzzn;
                int length2 = zzbxVarArr == null ? 0 : zzbxVarArr.length;
                zzbx[] zzbxVarArr2 = new zzbx[zzb2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzzn, 0, zzbxVarArr2, 0, length2);
                }
                while (length2 < zzbxVarArr2.length - 1) {
                    zzbxVarArr2[length2] = new zzbx();
                    zzilVar.zza(zzbxVarArr2[length2]);
                    zzilVar.zzsg();
                    length2++;
                }
                zzbxVarArr2[length2] = new zzbx();
                zzilVar.zza(zzbxVarArr2[length2]);
                this.zzzn = zzbxVarArr2;
            } else if (zzsg == 50) {
                int zzb3 = zzix.zzb(zzilVar, 50);
                zzbv[] zzbvVarArr = this.zzzo;
                int length3 = zzbvVarArr == null ? 0 : zzbvVarArr.length;
                zzbv[] zzbvVarArr2 = new zzbv[zzb3 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.zzzo, 0, zzbvVarArr2, 0, length3);
                }
                while (length3 < zzbvVarArr2.length - 1) {
                    zzbvVarArr2[length3] = new zzbv();
                    zzilVar.zza(zzbvVarArr2[length3]);
                    zzilVar.zzsg();
                    length3++;
                }
                zzbvVarArr2[length3] = new zzbv();
                zzilVar.zza(zzbvVarArr2[length3]);
                this.zzzo = zzbvVarArr2;
            } else if (zzsg == 58) {
                this.d = zzilVar.readString();
            } else if (zzsg != 64) {
                if (!super.a(zzilVar, zzsg)) {
                    return this;
                }
            } else {
                this.zzzq = Boolean.valueOf(zzilVar.zzsm());
            }
        }
    }
}
