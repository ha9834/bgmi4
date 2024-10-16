package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfr extends zzdob<zzdfr, zza> implements zzdpm {
    private static volatile zzdpv<zzdfr> zzdv;
    private static final zzdfr zzgss = new zzdfr();
    private zzdft zzgsr;

    private zzdfr() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfr, zza> implements zzdpm {
        private zza() {
            super(zzdfr.zzgss);
        }

        /* synthetic */ zza(acv acvVar) {
            this();
        }
    }

    public final zzdft zzaqn() {
        zzdft zzdftVar = this.zzgsr;
        return zzdftVar == null ? zzdft.zzaqs() : zzdftVar;
    }

    public static zzdfr zzaz(zzdmr zzdmrVar) throws zzdok {
        return (zzdfr) zzdob.a(zzgss, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acv acvVar = null;
        switch (acv.f1801a[i - 1]) {
            case 1:
                return new zzdfr();
            case 2:
                return new zza(acvVar);
            case 3:
                return a(zzgss, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzgsr"});
            case 4:
                return zzgss;
            case 5:
                zzdpv<zzdfr> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfr.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgss);
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
        zzdob.a((Class<zzdfr>) zzdfr.class, zzgss);
    }
}
