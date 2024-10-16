package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfz extends zzdob<zzdfz, zza> implements zzdpm {
    private static volatile zzdpv<zzdfz> zzdv;
    private static final zzdfz zzgtc = new zzdfz();
    private int zzgqy;
    private int zzgta;
    private zzdmr zzgtb = zzdmr.zzhcr;

    private zzdfz() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfz, zza> implements zzdpm {
        private zza() {
            super(zzdfz.zzgtc);
        }

        /* synthetic */ zza(acz aczVar) {
            this();
        }
    }

    public final zzdgf zzara() {
        zzdgf zzek = zzdgf.zzek(this.zzgta);
        return zzek == null ? zzdgf.UNRECOGNIZED : zzek;
    }

    public final zzdgj zzaoo() {
        zzdgj zzel = zzdgj.zzel(this.zzgqy);
        return zzel == null ? zzdgj.UNRECOGNIZED : zzel;
    }

    public final zzdmr zzarb() {
        return this.zzgtb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acz aczVar = null;
        switch (acz.f1805a[i - 1]) {
            case 1:
                return new zzdfz();
            case 2:
                return new zza(aczVar);
            case 3:
                return a(zzgtc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzgta", "zzgqy", "zzgtb"});
            case 4:
                return zzgtc;
            case 5:
                zzdpv<zzdfz> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfz.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgtc);
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

    public static zzdfz zzarc() {
        return zzgtc;
    }

    static {
        zzdob.a((Class<zzdfz>) zzdfz.class, zzgtc);
    }
}
