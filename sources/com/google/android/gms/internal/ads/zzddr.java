package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzddr extends zzdob<zzddr, zza> implements zzdpm {
    private static volatile zzdpv<zzddr> zzdv;
    private static final zzddr zzgqn = new zzddr();
    private int zzgqk;
    private zzdeb zzgql;
    private zzdgl zzgqm;

    private zzddr() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzddr, zza> implements zzdpm {
        private zza() {
            super(zzddr.zzgqn);
        }

        public final zza zzdu(int i) {
            a();
            ((zzddr) this.f3590a).b(i);
            return this;
        }

        public final zza zzb(zzdeb zzdebVar) {
            a();
            ((zzddr) this.f3590a).a(zzdebVar);
            return this;
        }

        public final zza zzb(zzdgl zzdglVar) {
            a();
            ((zzddr) this.f3590a).a(zzdglVar);
            return this;
        }

        /* synthetic */ zza(aci aciVar) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzgqk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        this.zzgqk = i;
    }

    public final zzdeb zzaoa() {
        zzdeb zzdebVar = this.zzgql;
        return zzdebVar == null ? zzdeb.zzaou() : zzdebVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdeb zzdebVar) {
        if (zzdebVar == null) {
            throw new NullPointerException();
        }
        this.zzgql = zzdebVar;
    }

    public final zzdgl zzaob() {
        zzdgl zzdglVar = this.zzgqm;
        return zzdglVar == null ? zzdgl.zzarl() : zzdglVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdgl zzdglVar) {
        if (zzdglVar == null) {
            throw new NullPointerException();
        }
        this.zzgqm = zzdglVar;
    }

    public static zzddr zzu(zzdmr zzdmrVar) throws zzdok {
        return (zzddr) zzdob.a(zzgqn, zzdmrVar);
    }

    public static zza zzaoc() {
        return (zza) ((zzdob.zza) zzgqn.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        aci aciVar = null;
        switch (aci.f1789a[i - 1]) {
            case 1:
                return new zzddr();
            case 2:
                return new zza(aciVar);
            case 3:
                return a(zzgqn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzgqk", "zzgql", "zzgqm"});
            case 4:
                return zzgqn;
            case 5:
                zzdpv<zzddr> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzddr.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgqn);
                            zzdv = zzdpvVar;
                        }
                    }
                }
                return zzdpvVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzdob.a((Class<zzddr>) zzddr.class, zzgqn);
    }
}
