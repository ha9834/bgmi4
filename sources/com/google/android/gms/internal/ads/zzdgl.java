package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdgl extends zzdob<zzdgl, zza> implements zzdpm {
    private static volatile zzdpv<zzdgl> zzdv;
    private static final zzdgl zzgtu = new zzdgl();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;
    private zzdgp zzgtt;

    private zzdgl() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdgl, zza> implements zzdpm {
        private zza() {
            super(zzdgl.zzgtu);
        }

        public final zza zzem(int i) {
            a();
            ((zzdgl) this.f3590a).b(0);
            return this;
        }

        public final zza zzc(zzdgp zzdgpVar) {
            a();
            ((zzdgl) this.f3590a).a(zzdgpVar);
            return this;
        }

        public final zza zzbl(zzdmr zzdmrVar) {
            a();
            ((zzdgl) this.f3590a).a(zzdmrVar);
            return this;
        }

        /* synthetic */ zza(add addVar) {
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

    public final zzdgp zzarj() {
        zzdgp zzdgpVar = this.zzgtt;
        return zzdgpVar == null ? zzdgp.zzarr() : zzdgpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdgp zzdgpVar) {
        if (zzdgpVar == null) {
            throw new NullPointerException();
        }
        this.zzgtt = zzdgpVar;
    }

    public final zzdmr zzaoi() {
        return this.zzgqs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdmr zzdmrVar) {
        if (zzdmrVar == null) {
            throw new NullPointerException();
        }
        this.zzgqs = zzdmrVar;
    }

    public static zzdgl zzbk(zzdmr zzdmrVar) throws zzdok {
        return (zzdgl) zzdob.a(zzgtu, zzdmrVar);
    }

    public static zza zzark() {
        return (zza) ((zzdob.zza) zzgtu.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        add addVar = null;
        switch (add.f1808a[i - 1]) {
            case 1:
                return new zzdgl();
            case 2:
                return new zza(addVar);
            case 3:
                return a(zzgtu, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgtt", "zzgqs"});
            case 4:
                return zzgtu;
            case 5:
                zzdpv<zzdgl> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdgl.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgtu);
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

    public static zzdgl zzarl() {
        return zzgtu;
    }

    static {
        zzdob.a((Class<zzdgl>) zzdgl.class, zzgtu);
    }
}
