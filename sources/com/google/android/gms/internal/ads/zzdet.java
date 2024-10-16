package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdet extends zzdob<zzdet, zza> implements zzdpm {
    private static volatile zzdpv<zzdet> zzdv;
    private static final zzdet zzgro = new zzdet();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;

    private zzdet() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdet, zza> implements zzdpm {
        private zza() {
            super(zzdet.zzgro);
        }

        public final zza zzdz(int i) {
            a();
            ((zzdet) this.f3590a).b(0);
            return this;
        }

        public final zza zzak(zzdmr zzdmrVar) {
            a();
            ((zzdet) this.f3590a).a(zzdmrVar);
            return this;
        }

        /* synthetic */ zza(acq acqVar) {
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

    public static zzdet zzaj(zzdmr zzdmrVar) throws zzdok {
        return (zzdet) zzdob.a(zzgro, zzdmrVar);
    }

    public static zza zzapn() {
        return (zza) ((zzdob.zza) zzgro.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acq acqVar = null;
        switch (acq.f1797a[i - 1]) {
            case 1:
                return new zzdet();
            case 2:
                return new zza(acqVar);
            case 3:
                return a(zzgro, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgro;
            case 5:
                zzdpv<zzdet> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdet.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgro);
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
        zzdob.a((Class<zzdet>) zzdet.class, zzgro);
    }
}
