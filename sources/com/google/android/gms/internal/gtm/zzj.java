package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzj extends zzuq<zzj> {
    private static volatile zzj[] c;
    public String name = "";
    private zzl d = null;
    public zzh zzqi = null;

    public static zzj[] zzz() {
        if (c == null) {
            synchronized (zzuu.zzbhk) {
                if (c == null) {
                    c = new zzj[0];
                }
            }
        }
        return c;
    }

    public zzj() {
        this.f4457a = null;
        this.b = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        String str = this.name;
        if (str == null) {
            if (zzjVar.name != null) {
                return false;
            }
        } else if (!str.equals(zzjVar.name)) {
            return false;
        }
        zzl zzlVar = this.d;
        if (zzlVar == null) {
            if (zzjVar.d != null) {
                return false;
            }
        } else if (!zzlVar.equals(zzjVar.d)) {
            return false;
        }
        zzh zzhVar = this.zzqi;
        if (zzhVar == null) {
            if (zzjVar.zzqi != null) {
                return false;
            }
        } else if (!zzhVar.equals(zzjVar.zzqi)) {
            return false;
        }
        if (this.f4457a == null || this.f4457a.isEmpty()) {
            return zzjVar.f4457a == null || zzjVar.f4457a.isEmpty();
        }
        return this.f4457a.equals(zzjVar.f4457a);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = hashCode + (str == null ? 0 : str.hashCode());
        zzl zzlVar = this.d;
        int hashCode3 = (hashCode2 * 31) + (zzlVar == null ? 0 : zzlVar.hashCode());
        zzh zzhVar = this.zzqi;
        int hashCode4 = ((hashCode3 * 31) + (zzhVar == null ? 0 : zzhVar.hashCode())) * 31;
        if (this.f4457a != null && !this.f4457a.isEmpty()) {
            i = this.f4457a.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) throws IOException {
        String str = this.name;
        if (str != null && !str.equals("")) {
            zzuoVar.zza(1, this.name);
        }
        zzl zzlVar = this.d;
        if (zzlVar != null) {
            zzuoVar.zza(2, zzlVar);
        }
        zzh zzhVar = this.zzqi;
        if (zzhVar != null) {
            zzuoVar.zza(3, zzhVar);
        }
        super.zza(zzuoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int a() {
        int a2 = super.a();
        String str = this.name;
        if (str != null && !str.equals("")) {
            a2 += zzuo.zzb(1, this.name);
        }
        zzl zzlVar = this.d;
        if (zzlVar != null) {
            a2 += zzuo.zzb(2, zzlVar);
        }
        zzh zzhVar = this.zzqi;
        return zzhVar != null ? a2 + zzuo.zzb(3, zzhVar) : a2;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) throws IOException {
        while (true) {
            int zzni = zzunVar.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 10) {
                this.name = zzunVar.readString();
            } else if (zzni == 18) {
                if (this.d == null) {
                    this.d = new zzl();
                }
                zzunVar.zza(this.d);
            } else if (zzni != 26) {
                if (!super.a(zzunVar, zzni)) {
                    return this;
                }
            } else {
                if (this.zzqi == null) {
                    this.zzqi = new zzh();
                }
                zzunVar.zza(this.zzqi);
            }
        }
    }
}
