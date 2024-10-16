package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public class zzfn {

    /* renamed from: a, reason: collision with root package name */
    private static final zzel f4564a = zzel.zztp();
    private zzdp b;
    private volatile zzgi c;
    private volatile zzdp d;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfn)) {
            return false;
        }
        zzfn zzfnVar = (zzfn) obj;
        zzgi zzgiVar = this.c;
        zzgi zzgiVar2 = zzfnVar.c;
        if (zzgiVar == null && zzgiVar2 == null) {
            return zzrs().equals(zzfnVar.zzrs());
        }
        if (zzgiVar != null && zzgiVar2 != null) {
            return zzgiVar.equals(zzgiVar2);
        }
        if (zzgiVar != null) {
            return zzgiVar.equals(zzfnVar.a(zzgiVar.zzuh()));
        }
        return a(zzgiVar2.zzuh()).equals(zzgiVar2);
    }

    private final zzgi a(zzgi zzgiVar) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        this.c = zzgiVar;
                        this.d = zzdp.zzadh;
                    } catch (zzfi unused) {
                        this.c = zzgiVar;
                        this.d = zzdp.zzadh;
                    }
                }
            }
        }
        return this.c;
    }

    public final zzgi zzi(zzgi zzgiVar) {
        zzgi zzgiVar2 = this.c;
        this.b = null;
        this.d = null;
        this.c = zzgiVar;
        return zzgiVar2;
    }

    public final int zzuk() {
        if (this.d != null) {
            return this.d.size();
        }
        if (this.c != null) {
            return this.c.zzuk();
        }
        return 0;
    }

    public final zzdp zzrs() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = zzdp.zzadh;
            } else {
                this.d = this.c.zzrs();
            }
            return this.d;
        }
    }
}
