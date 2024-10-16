package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfx extends zzdob<zzdfx, zza> implements zzdpm {
    private static volatile zzdpv<zzdfx> zzdv;
    private static final zzdfx zzgsz = new zzdfx();
    private int zzgqk;
    private zzdmr zzgsh = zzdmr.zzhcr;
    private zzdmr zzgsi = zzdmr.zzhcr;
    private zzdft zzgsr;

    private zzdfx() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfx, zza> implements zzdpm {
        private zza() {
            super(zzdfx.zzgsz);
        }

        public final zza zzeh(int i) {
            a();
            ((zzdfx) this.f3590a).b(0);
            return this;
        }

        public final zza zzc(zzdft zzdftVar) {
            a();
            ((zzdfx) this.f3590a).a(zzdftVar);
            return this;
        }

        public final zza zzbd(zzdmr zzdmrVar) {
            a();
            ((zzdfx) this.f3590a).a(zzdmrVar);
            return this;
        }

        public final zza zzbe(zzdmr zzdmrVar) {
            a();
            ((zzdfx) this.f3590a).b(zzdmrVar);
            return this;
        }

        /* synthetic */ zza(acy acyVar) {
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

    public final zzdft zzaqn() {
        zzdft zzdftVar = this.zzgsr;
        return zzdftVar == null ? zzdft.zzaqs() : zzdftVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdft zzdftVar) {
        if (zzdftVar == null) {
            throw new NullPointerException();
        }
        this.zzgsr = zzdftVar;
    }

    public final zzdmr zzaqf() {
        return this.zzgsh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdmr zzdmrVar) {
        if (zzdmrVar == null) {
            throw new NullPointerException();
        }
        this.zzgsh = zzdmrVar;
    }

    public final zzdmr zzaqg() {
        return this.zzgsi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(zzdmr zzdmrVar) {
        if (zzdmrVar == null) {
            throw new NullPointerException();
        }
        this.zzgsi = zzdmrVar;
    }

    public static zzdfx zzbc(zzdmr zzdmrVar) throws zzdok {
        return (zzdfx) zzdob.a(zzgsz, zzdmrVar);
    }

    public static zza zzaqx() {
        return (zza) ((zzdob.zza) zzgsz.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acy acyVar = null;
        switch (acy.f1804a[i - 1]) {
            case 1:
                return new zzdfx();
            case 2:
                return new zza(acyVar);
            case 3:
                return a(zzgsz, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzgqk", "zzgsr", "zzgsh", "zzgsi"});
            case 4:
                return zzgsz;
            case 5:
                zzdpv<zzdfx> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfx.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgsz);
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

    public static zzdfx zzaqy() {
        return zzgsz;
    }

    static {
        zzdob.a((Class<zzdfx>) zzdfx.class, zzgsz);
    }
}
