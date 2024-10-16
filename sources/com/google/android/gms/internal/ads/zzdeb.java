package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdeb extends zzdob<zzdeb, zza> implements zzdpm {
    private static volatile zzdpv<zzdeb> zzdv;
    private static final zzdeb zzgrc = new zzdeb();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;
    private zzdef zzgrb;

    private zzdeb() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdeb, zza> implements zzdpm {
        private zza() {
            super(zzdeb.zzgrc);
        }

        public final zza zzdw(int i) {
            a();
            ((zzdeb) this.f3590a).b(0);
            return this;
        }

        public final zza zzc(zzdef zzdefVar) {
            a();
            ((zzdeb) this.f3590a).a(zzdefVar);
            return this;
        }

        public final zza zzab(zzdmr zzdmrVar) {
            a();
            ((zzdeb) this.f3590a).a(zzdmrVar);
            return this;
        }

        /* synthetic */ zza(ack ackVar) {
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

    public final zzdef zzaos() {
        zzdef zzdefVar = this.zzgrb;
        return zzdefVar == null ? zzdef.zzaoz() : zzdefVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdef zzdefVar) {
        if (zzdefVar == null) {
            throw new NullPointerException();
        }
        this.zzgrb = zzdefVar;
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

    public static zzdeb zzaa(zzdmr zzdmrVar) throws zzdok {
        return (zzdeb) zzdob.a(zzgrc, zzdmrVar);
    }

    public static zza zzaot() {
        return (zza) ((zzdob.zza) zzgrc.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        ack ackVar = null;
        switch (ack.f1791a[i - 1]) {
            case 1:
                return new zzdeb();
            case 2:
                return new zza(ackVar);
            case 3:
                return a(zzgrc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgrb", "zzgqs"});
            case 4:
                return zzgrc;
            case 5:
                zzdpv<zzdeb> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdeb.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgrc);
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

    public static zzdeb zzaou() {
        return zzgrc;
    }

    static {
        zzdob.a((Class<zzdeb>) zzdeb.class, zzgrc);
    }
}
