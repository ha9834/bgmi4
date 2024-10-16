package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdhk extends zzdob<zzdhk, zza> implements zzdpm {
    private static volatile zzdpv<zzdhk> zzdv;
    private static final zzdhk zzgvp = new zzdhk();
    private String zzgvn = "";
    private zzdgw zzgvo;

    private zzdhk() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdhk, zza> implements zzdpm {
        private zza() {
            super(zzdhk.zzgvp);
        }

        /* synthetic */ zza(adq adqVar) {
            this();
        }
    }

    public final String zzatf() {
        return this.zzgvn;
    }

    public final zzdgw zzatg() {
        zzdgw zzdgwVar = this.zzgvo;
        return zzdgwVar == null ? zzdgw.zzarz() : zzdgwVar;
    }

    public static zzdhk zzbs(zzdmr zzdmrVar) throws zzdok {
        return (zzdhk) zzdob.a(zzgvp, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adq adqVar = null;
        switch (adq.f1819a[i - 1]) {
            case 1:
                return new zzdhk();
            case 2:
                return new zza(adqVar);
            case 3:
                return a(zzgvp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzgvn", "zzgvo"});
            case 4:
                return zzgvp;
            case 5:
                zzdpv<zzdhk> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdhk.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgvp);
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

    public static zzdhk zzath() {
        return zzgvp;
    }

    static {
        zzdob.a((Class<zzdhk>) zzdhk.class, zzgvp);
    }
}
