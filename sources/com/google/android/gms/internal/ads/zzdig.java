package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdig extends zzdob<zzdig, zza> implements zzdpm {
    private static volatile zzdpv<zzdig> zzdv;
    private static final zzdig zzgwz = new zzdig();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;

    private zzdig() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdig, zza> implements zzdpm {
        private zza() {
            super(zzdig.zzgwz);
        }

        public final zza zzfe(int i) {
            a();
            ((zzdig) this.f3590a).b(0);
            return this;
        }

        public final zza zzcy(zzdmr zzdmrVar) {
            a();
            ((zzdig) this.f3590a).a(zzdmrVar);
            return this;
        }

        /* synthetic */ zza(adt adtVar) {
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

    public static zzdig zzcx(zzdmr zzdmrVar) throws zzdok {
        return (zzdig) zzdob.a(zzgwz, zzdmrVar);
    }

    public static zza zzaus() {
        return (zza) ((zzdob.zza) zzgwz.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adt adtVar = null;
        switch (adt.f1821a[i - 1]) {
            case 1:
                return new zzdig();
            case 2:
                return new zza(adtVar);
            case 3:
                return a(zzgwz, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgwz;
            case 5:
                zzdpv<zzdig> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdig.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgwz);
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
        zzdob.a((Class<zzdig>) zzdig.class, zzgwz);
    }
}
