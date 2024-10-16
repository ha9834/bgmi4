package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdgw extends zzdob<zzdgw, zza> implements zzdpm {
    private static volatile zzdpv<zzdgw> zzdv;
    private static final zzdgw zzgur = new zzdgw();
    private String zzgtz = "";
    private zzdmr zzgua = zzdmr.zzhcr;
    private int zzguq;

    private zzdgw() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdgw, zza> implements zzdpm {
        private zza() {
            super(zzdgw.zzgur);
        }

        /* synthetic */ zza(adj adjVar) {
            this();
        }
    }

    public final String zzart() {
        return this.zzgtz;
    }

    public final zzdmr zzaru() {
        return this.zzgua;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adj adjVar = null;
        switch (adj.f1812a[i - 1]) {
            case 1:
                return new zzdgw();
            case 2:
                return new zza(adjVar);
            case 3:
                return a(zzgur, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgtz", "zzgua", "zzguq"});
            case 4:
                return zzgur;
            case 5:
                zzdpv<zzdgw> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdgw.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgur);
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

    public static zzdgw zzarz() {
        return zzgur;
    }

    static {
        zzdob.a((Class<zzdgw>) zzdgw.class, zzgur);
    }
}
