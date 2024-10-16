package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
public class zzhv {

    /* renamed from: a, reason: collision with root package name */
    private static final zzgu f4187a = zzgu.zzgf();
    private zzfx b;
    private volatile zzim c;
    private volatile zzfx d;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhv)) {
            return false;
        }
        zzhv zzhvVar = (zzhv) obj;
        zzim zzimVar = this.c;
        zzim zzimVar2 = zzhvVar.c;
        if (zzimVar == null && zzimVar2 == null) {
            return zzeo().equals(zzhvVar.zzeo());
        }
        if (zzimVar != null && zzimVar2 != null) {
            return zzimVar.equals(zzimVar2);
        }
        if (zzimVar != null) {
            return zzimVar.equals(zzhvVar.a(zzimVar.zzgx()));
        }
        return a(zzimVar2.zzgx()).equals(zzimVar2);
    }

    private final zzim a(zzim zzimVar) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        this.c = zzimVar;
                        this.d = zzfx.zzow;
                    } catch (zzhm unused) {
                        this.c = zzimVar;
                        this.d = zzfx.zzow;
                    }
                }
            }
        }
        return this.c;
    }

    public final zzim zzi(zzim zzimVar) {
        zzim zzimVar2 = this.c;
        this.b = null;
        this.d = null;
        this.c = zzimVar;
        return zzimVar2;
    }

    public final int zzgy() {
        if (this.d != null) {
            return this.d.size();
        }
        if (this.c != null) {
            return this.c.zzgy();
        }
        return 0;
    }

    public final zzfx zzeo() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = zzfx.zzow;
            } else {
                this.d = this.c.zzeo();
            }
            return this.d;
        }
    }
}
