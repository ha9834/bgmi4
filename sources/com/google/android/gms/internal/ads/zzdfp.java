package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfp extends zzdob<zzdfp, zza> implements zzdpm {
    private static volatile zzdpv<zzdfp> zzdv;
    private static final zzdfp zzgsq = new zzdfp();
    private zzdgw zzgsp;

    private zzdfp() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfp, zza> implements zzdpm {
        private zza() {
            super(zzdfp.zzgsq);
        }

        /* synthetic */ zza(acu acuVar) {
            this();
        }
    }

    public final zzdgw zzaqk() {
        zzdgw zzdgwVar = this.zzgsp;
        return zzdgwVar == null ? zzdgw.zzarz() : zzdgwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acu acuVar = null;
        switch (acu.f1800a[i - 1]) {
            case 1:
                return new zzdfp();
            case 2:
                return new zza(acuVar);
            case 3:
                return a(zzgsq, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzgsp"});
            case 4:
                return zzgsq;
            case 5:
                zzdpv<zzdfp> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfp.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgsq);
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

    public static zzdfp zzaql() {
        return zzgsq;
    }

    static {
        zzdob.a((Class<zzdfp>) zzdfp.class, zzgsq);
    }
}
