package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzop extends zzuq<zzop> {
    public long zzaux = 0;
    public zzi zzqk = null;
    public zzk zzauy = null;

    public zzop() {
        this.f4457a = null;
        this.b = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzop)) {
            return false;
        }
        zzop zzopVar = (zzop) obj;
        if (this.zzaux != zzopVar.zzaux) {
            return false;
        }
        zzi zziVar = this.zzqk;
        if (zziVar == null) {
            if (zzopVar.zzqk != null) {
                return false;
            }
        } else if (!zziVar.equals(zzopVar.zzqk)) {
            return false;
        }
        zzk zzkVar = this.zzauy;
        if (zzkVar == null) {
            if (zzopVar.zzauy != null) {
                return false;
            }
        } else if (!zzkVar.equals(zzopVar.zzauy)) {
            return false;
        }
        if (this.f4457a == null || this.f4457a.isEmpty()) {
            return zzopVar.f4457a == null || zzopVar.f4457a.isEmpty();
        }
        return this.f4457a.equals(zzopVar.f4457a);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        long j = this.zzaux;
        int i = hashCode + ((int) (j ^ (j >>> 32)));
        zzi zziVar = this.zzqk;
        int i2 = 0;
        int hashCode2 = (i * 31) + (zziVar == null ? 0 : zziVar.hashCode());
        zzk zzkVar = this.zzauy;
        int hashCode3 = ((hashCode2 * 31) + (zzkVar == null ? 0 : zzkVar.hashCode())) * 31;
        if (this.f4457a != null && !this.f4457a.isEmpty()) {
            i2 = this.f4457a.hashCode();
        }
        return hashCode3 + i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) throws IOException {
        zzuoVar.zzi(1, this.zzaux);
        zzi zziVar = this.zzqk;
        if (zziVar != null) {
            zzuoVar.zza(2, zziVar);
        }
        zzk zzkVar = this.zzauy;
        if (zzkVar != null) {
            zzuoVar.zza(3, zzkVar);
        }
        super.zza(zzuoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int a() {
        int a2 = super.a() + zzuo.zzd(1, this.zzaux);
        zzi zziVar = this.zzqk;
        if (zziVar != null) {
            a2 += zzuo.zzb(2, zziVar);
        }
        zzk zzkVar = this.zzauy;
        return zzkVar != null ? a2 + zzuo.zzb(3, zzkVar) : a2;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) throws IOException {
        while (true) {
            int zzni = zzunVar.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 8) {
                this.zzaux = zzunVar.zzob();
            } else if (zzni == 18) {
                if (this.zzqk == null) {
                    this.zzqk = new zzi();
                }
                zzunVar.zza(this.zzqk);
            } else if (zzni != 26) {
                if (!super.a(zzunVar, zzni)) {
                    return this;
                }
            } else {
                if (this.zzauy == null) {
                    this.zzauy = new zzk();
                }
                zzunVar.zza(this.zzauy);
            }
        }
    }
}
