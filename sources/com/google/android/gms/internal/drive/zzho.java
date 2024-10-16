package com.google.android.gms.internal.drive;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzho extends zzir<zzho> {
    public long zzac = -1;
    public long zzf = -1;

    public zzho() {
        this.f3996a = null;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.drive.zzir, com.google.android.gms.internal.drive.zzix
    public final int a() {
        return super.a() + zzip.zzb(1, this.zzac) + zzip.zzb(2, this.zzf);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzho)) {
            return false;
        }
        zzho zzhoVar = (zzho) obj;
        if (this.zzac == zzhoVar.zzac && this.zzf == zzhoVar.zzf) {
            return (this.f3996a == null || this.f3996a.isEmpty()) ? zzhoVar.f3996a == null || zzhoVar.f3996a.isEmpty() : this.f3996a.equals(zzhoVar.f3996a);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        long j = this.zzac;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.zzf;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((this.f3996a == null || this.f3996a.isEmpty()) ? 0 : this.f3996a.hashCode());
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public final /* synthetic */ zzix zza(zzio zzioVar) throws IOException {
        while (true) {
            int zzbd = zzioVar.zzbd();
            if (zzbd == 0) {
                return this;
            }
            if (zzbd == 8) {
                long zzbf = zzioVar.zzbf();
                this.zzac = (-(zzbf & 1)) ^ (zzbf >>> 1);
            } else if (zzbd == 16) {
                long zzbf2 = zzioVar.zzbf();
                this.zzf = (-(zzbf2 & 1)) ^ (zzbf2 >>> 1);
            } else if (!super.a(zzioVar, zzbd)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.drive.zzir, com.google.android.gms.internal.drive.zzix
    public final void zza(zzip zzipVar) throws IOException {
        zzipVar.zza(1, this.zzac);
        zzipVar.zza(2, this.zzf);
        super.zza(zzipVar);
    }
}
