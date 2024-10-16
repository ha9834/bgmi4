package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdhg extends zzdob<zzdhg, zza> implements zzdpm {
    private static volatile zzdpv<zzdhg> zzdv;
    private static final zzdhg zzgvk = new zzdhg();
    private String zzgvj = "";

    private zzdhg() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdhg, zza> implements zzdpm {
        private zza() {
            super(zzdhg.zzgvk);
        }

        /* synthetic */ zza(ado adoVar) {
            this();
        }
    }

    public final String zzasz() {
        return this.zzgvj;
    }

    public static zzdhg zzbq(zzdmr zzdmrVar) throws zzdok {
        return (zzdhg) zzdob.a(zzgvk, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        ado adoVar = null;
        switch (ado.f1817a[i - 1]) {
            case 1:
                return new zzdhg();
            case 2:
                return new zza(adoVar);
            case 3:
                return a(zzgvk, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzgvj"});
            case 4:
                return zzgvk;
            case 5:
                zzdpv<zzdhg> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdhg.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgvk);
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

    public static zzdhg zzata() {
        return zzgvk;
    }

    static {
        zzdob.a((Class<zzdhg>) zzdhg.class, zzgvk);
    }
}
