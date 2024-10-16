package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbx extends zziq<zzbx> {
    private static volatile zzbx[] c;
    public String name = null;
    public Boolean zzzs = null;
    public Boolean zzzt = null;
    public Integer zzzu = null;

    public static zzbx[] zzrc() {
        if (c == null) {
            synchronized (zziu.zzaov) {
                if (c == null) {
                    c = new zzbx[0];
                }
            }
        }
        return c;
    }

    public zzbx() {
        this.f4576a = null;
        this.b = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbx)) {
            return false;
        }
        zzbx zzbxVar = (zzbx) obj;
        String str = this.name;
        if (str == null) {
            if (zzbxVar.name != null) {
                return false;
            }
        } else if (!str.equals(zzbxVar.name)) {
            return false;
        }
        Boolean bool = this.zzzs;
        if (bool == null) {
            if (zzbxVar.zzzs != null) {
                return false;
            }
        } else if (!bool.equals(zzbxVar.zzzs)) {
            return false;
        }
        Boolean bool2 = this.zzzt;
        if (bool2 == null) {
            if (zzbxVar.zzzt != null) {
                return false;
            }
        } else if (!bool2.equals(zzbxVar.zzzt)) {
            return false;
        }
        Integer num = this.zzzu;
        if (num == null) {
            if (zzbxVar.zzzu != null) {
                return false;
            }
        } else if (!num.equals(zzbxVar.zzzu)) {
            return false;
        }
        if (this.f4576a == null || this.f4576a.isEmpty()) {
            return zzbxVar.f4576a == null || zzbxVar.f4576a.isEmpty();
        }
        return this.f4576a.equals(zzbxVar.f4576a);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzzs;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzzt;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.zzzu;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        if (this.f4576a != null && !this.f4576a.isEmpty()) {
            i = this.f4576a.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zziq, com.google.android.gms.internal.measurement.zziw
    public final void zza(zzio zzioVar) throws IOException {
        String str = this.name;
        if (str != null) {
            zzioVar.zzb(1, str);
        }
        Boolean bool = this.zzzs;
        if (bool != null) {
            zzioVar.zzb(2, bool.booleanValue());
        }
        Boolean bool2 = this.zzzt;
        if (bool2 != null) {
            zzioVar.zzb(3, bool2.booleanValue());
        }
        Integer num = this.zzzu;
        if (num != null) {
            zzioVar.zzc(4, num.intValue());
        }
        super.zza(zzioVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zziq, com.google.android.gms.internal.measurement.zziw
    public final int a() {
        int a2 = super.a();
        String str = this.name;
        if (str != null) {
            a2 += zzio.zzc(1, str);
        }
        Boolean bool = this.zzzs;
        if (bool != null) {
            bool.booleanValue();
            a2 += zzio.zzbi(2) + 1;
        }
        Boolean bool2 = this.zzzt;
        if (bool2 != null) {
            bool2.booleanValue();
            a2 += zzio.zzbi(3) + 1;
        }
        Integer num = this.zzzu;
        return num != null ? a2 + zzio.zzg(4, num.intValue()) : a2;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final /* synthetic */ zziw zza(zzil zzilVar) throws IOException {
        while (true) {
            int zzsg = zzilVar.zzsg();
            if (zzsg == 0) {
                return this;
            }
            if (zzsg == 10) {
                this.name = zzilVar.readString();
            } else if (zzsg == 16) {
                this.zzzs = Boolean.valueOf(zzilVar.zzsm());
            } else if (zzsg == 24) {
                this.zzzt = Boolean.valueOf(zzilVar.zzsm());
            } else if (zzsg != 32) {
                if (!super.a(zzilVar, zzsg)) {
                    return this;
                }
            } else {
                this.zzzu = Integer.valueOf(zzilVar.zzta());
            }
        }
    }
}
