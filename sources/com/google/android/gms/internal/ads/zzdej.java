package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdej extends zzdob<zzdej, zza> implements zzdpm {
    private static volatile zzdpv<zzdej> zzdv;
    private static final zzdej zzgri = new zzdej();
    private int zzgqu;
    private zzdel zzgrg;

    private zzdej() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdej, zza> implements zzdpm {
        private zza() {
            super(zzdej.zzgri);
        }

        /* synthetic */ zza(aco acoVar) {
            this();
        }
    }

    public final zzdel zzapb() {
        zzdel zzdelVar = this.zzgrg;
        return zzdelVar == null ? zzdel.zzapf() : zzdelVar;
    }

    public final int getKeySize() {
        return this.zzgqu;
    }

    public static zzdej zzaf(zzdmr zzdmrVar) throws zzdok {
        return (zzdej) zzdob.a(zzgri, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        aco acoVar = null;
        switch (aco.f1795a[i - 1]) {
            case 1:
                return new zzdej();
            case 2:
                return new zza(acoVar);
            case 3:
                return a(zzgri, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgrg", "zzgqu"});
            case 4:
                return zzgri;
            case 5:
                zzdpv<zzdej> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdej.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgri);
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
        zzdob.a((Class<zzdej>) zzdej.class, zzgri);
    }
}
