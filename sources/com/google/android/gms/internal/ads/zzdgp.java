package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdgp extends zzdob<zzdgp, zza> implements zzdpm {
    private static volatile zzdpv<zzdgp> zzdv;
    private static final zzdgp zzgty = new zzdgp();
    private int zzgtw;
    private int zzgtx;

    private zzdgp() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdgp, zza> implements zzdpm {
        private zza() {
            super(zzdgp.zzgty);
        }

        /* synthetic */ zza(adf adfVar) {
            this();
        }
    }

    public final zzdgj zzarp() {
        zzdgj zzel = zzdgj.zzel(this.zzgtw);
        return zzel == null ? zzdgj.UNRECOGNIZED : zzel;
    }

    public final int zzarq() {
        return this.zzgtx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adf adfVar = null;
        switch (adf.f1810a[i - 1]) {
            case 1:
                return new zzdgp();
            case 2:
                return new zza(adfVar);
            case 3:
                return a(zzgty, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzgtw", "zzgtx"});
            case 4:
                return zzgty;
            case 5:
                zzdpv<zzdgp> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdgp.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgty);
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

    public static zzdgp zzarr() {
        return zzgty;
    }

    static {
        zzdob.a((Class<zzdgp>) zzdgp.class, zzgty);
    }
}
