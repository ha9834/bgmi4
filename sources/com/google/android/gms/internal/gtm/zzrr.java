package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
public class zzrr {

    /* renamed from: a, reason: collision with root package name */
    private static final zzqp f4445a = zzqp.zzoq();
    private zzps b;
    private volatile zzsk c;
    private volatile zzps d;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzrr)) {
            return false;
        }
        zzrr zzrrVar = (zzrr) obj;
        zzsk zzskVar = this.c;
        zzsk zzskVar2 = zzrrVar.c;
        if (zzskVar == null && zzskVar2 == null) {
            return zzmv().equals(zzrrVar.zzmv());
        }
        if (zzskVar != null && zzskVar2 != null) {
            return zzskVar.equals(zzskVar2);
        }
        if (zzskVar != null) {
            return zzskVar.equals(zzrrVar.a(zzskVar.zzpi()));
        }
        return a(zzskVar2.zzpi()).equals(zzskVar2);
    }

    private final zzsk a(zzsk zzskVar) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        this.c = zzskVar;
                        this.d = zzps.zzavx;
                    } catch (zzrk unused) {
                        this.c = zzskVar;
                        this.d = zzps.zzavx;
                    }
                }
            }
        }
        return this.c;
    }

    public final zzsk zzi(zzsk zzskVar) {
        zzsk zzskVar2 = this.c;
        this.b = null;
        this.d = null;
        this.c = zzskVar;
        return zzskVar2;
    }

    public final int zzpe() {
        if (this.d != null) {
            return this.d.size();
        }
        if (this.c != null) {
            return this.c.zzpe();
        }
        return 0;
    }

    public final zzps zzmv() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = zzps.zzavx;
            } else {
                this.d = this.c.zzmv();
            }
            return this.d;
        }
    }
}
