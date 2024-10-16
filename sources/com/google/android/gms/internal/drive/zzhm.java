package com.google.android.gms.internal.drive;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzhm extends zzir<zzhm> {
    public int versionCode = 1;
    public long zze = -1;
    public long zzf = -1;
    public long zzg = -1;

    public zzhm() {
        this.f3996a = null;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.drive.zzir, com.google.android.gms.internal.drive.zzix
    public final int a() {
        return super.a() + zzip.zzc(1, this.versionCode) + zzip.zzb(2, this.zze) + zzip.zzb(3, this.zzf) + zzip.zzb(4, this.zzg);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhm)) {
            return false;
        }
        zzhm zzhmVar = (zzhm) obj;
        if (this.versionCode == zzhmVar.versionCode && this.zze == zzhmVar.zze && this.zzf == zzhmVar.zzf && this.zzg == zzhmVar.zzg) {
            return (this.f3996a == null || this.f3996a.isEmpty()) ? zzhmVar.f3996a == null || zzhmVar.f3996a.isEmpty() : this.f3996a.equals(zzhmVar.f3996a);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31;
        long j = this.zze;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.zzf;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.zzg;
        return ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((this.f3996a == null || this.f3996a.isEmpty()) ? 0 : this.f3996a.hashCode());
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public final /* synthetic */ zzix zza(zzio zzioVar) throws IOException {
        while (true) {
            int zzbd = zzioVar.zzbd();
            if (zzbd == 0) {
                return this;
            }
            if (zzbd == 8) {
                this.versionCode = zzioVar.zzbe();
            } else if (zzbd == 16) {
                long zzbf = zzioVar.zzbf();
                this.zze = (-(zzbf & 1)) ^ (zzbf >>> 1);
            } else if (zzbd == 24) {
                long zzbf2 = zzioVar.zzbf();
                this.zzf = (-(zzbf2 & 1)) ^ (zzbf2 >>> 1);
            } else if (zzbd == 32) {
                long zzbf3 = zzioVar.zzbf();
                this.zzg = (-(zzbf3 & 1)) ^ (zzbf3 >>> 1);
            } else if (!super.a(zzioVar, zzbd)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.drive.zzir, com.google.android.gms.internal.drive.zzix
    public final void zza(zzip zzipVar) throws IOException {
        zzipVar.zzb(1, this.versionCode);
        zzipVar.zza(2, this.zze);
        zzipVar.zza(3, this.zzf);
        zzipVar.zza(4, this.zzg);
        super.zza(zzipVar);
    }
}
