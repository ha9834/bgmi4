package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdft extends zzdob<zzdft, zza> implements zzdpm {
    private static volatile zzdpv<zzdft> zzdv;
    private static final zzdft zzgsw = new zzdft();
    private zzdfz zzgst;
    private zzdfp zzgsu;
    private int zzgsv;

    private zzdft() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdft, zza> implements zzdpm {
        private zza() {
            super(zzdft.zzgsw);
        }

        /* synthetic */ zza(acw acwVar) {
            this();
        }
    }

    public final zzdfz zzaqp() {
        zzdfz zzdfzVar = this.zzgst;
        return zzdfzVar == null ? zzdfz.zzarc() : zzdfzVar;
    }

    public final zzdfp zzaqq() {
        zzdfp zzdfpVar = this.zzgsu;
        return zzdfpVar == null ? zzdfp.zzaql() : zzdfpVar;
    }

    public final zzdfd zzaqr() {
        zzdfd zzec = zzdfd.zzec(this.zzgsv);
        return zzec == null ? zzdfd.UNRECOGNIZED : zzec;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acw acwVar = null;
        switch (acw.f1802a[i - 1]) {
            case 1:
                return new zzdft();
            case 2:
                return new zza(acwVar);
            case 3:
                return a(zzgsw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzgst", "zzgsu", "zzgsv"});
            case 4:
                return zzgsw;
            case 5:
                zzdpv<zzdft> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdft.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgsw);
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

    public static zzdft zzaqs() {
        return zzgsw;
    }

    static {
        zzdob.a((Class<zzdft>) zzdft.class, zzgsw);
    }
}
