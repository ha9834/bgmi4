package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public class zzdor {

    /* renamed from: a, reason: collision with root package name */
    private static final zzdno f3595a = zzdno.zzaxd();
    private zzdmr b;
    private volatile zzdpk c;
    private volatile zzdmr d;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdor)) {
            return false;
        }
        zzdor zzdorVar = (zzdor) obj;
        zzdpk zzdpkVar = this.c;
        zzdpk zzdpkVar2 = zzdorVar.c;
        if (zzdpkVar == null && zzdpkVar2 == null) {
            return zzavf().equals(zzdorVar.zzavf());
        }
        if (zzdpkVar != null && zzdpkVar2 != null) {
            return zzdpkVar.equals(zzdpkVar2);
        }
        if (zzdpkVar != null) {
            return zzdpkVar.equals(zzdorVar.a(zzdpkVar.zzaxv()));
        }
        return a(zzdpkVar2.zzaxv()).equals(zzdpkVar2);
    }

    private final zzdpk a(zzdpk zzdpkVar) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        this.c = zzdpkVar;
                        this.d = zzdmr.zzhcr;
                    } catch (zzdok unused) {
                        this.c = zzdpkVar;
                        this.d = zzdmr.zzhcr;
                    }
                }
            }
        }
        return this.c;
    }

    public final zzdpk zzq(zzdpk zzdpkVar) {
        zzdpk zzdpkVar2 = this.c;
        this.b = null;
        this.d = null;
        this.c = zzdpkVar;
        return zzdpkVar2;
    }

    public final int zzaxj() {
        if (this.d != null) {
            return this.d.size();
        }
        if (this.c != null) {
            return this.c.zzaxj();
        }
        return 0;
    }

    public final zzdmr zzavf() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = zzdmr.zzhcr;
            } else {
                this.d = this.c.zzavf();
            }
            return this.d;
        }
    }
}
