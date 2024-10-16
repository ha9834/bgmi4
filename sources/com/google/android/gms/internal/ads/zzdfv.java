package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfv extends zzdob<zzdfv, zza> implements zzdpm {
    private static volatile zzdpv<zzdfv> zzdv;
    private static final zzdfv zzgsy = new zzdfv();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;
    private zzdfx zzgsx;

    private zzdfv() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfv, zza> implements zzdpm {
        private zza() {
            super(zzdfv.zzgsy);
        }

        public final zza zzeg(int i) {
            a();
            ((zzdfv) this.f3590a).b(0);
            return this;
        }

        public final zza zzb(zzdfx zzdfxVar) {
            a();
            ((zzdfv) this.f3590a).a(zzdfxVar);
            return this;
        }

        public final zza zzbb(zzdmr zzdmrVar) {
            a();
            ((zzdfv) this.f3590a).a(zzdmrVar);
            return this;
        }

        /* synthetic */ zza(acx acxVar) {
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

    public final zzdfx zzaqu() {
        zzdfx zzdfxVar = this.zzgsx;
        return zzdfxVar == null ? zzdfx.zzaqy() : zzdfxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdfx zzdfxVar) {
        if (zzdfxVar == null) {
            throw new NullPointerException();
        }
        this.zzgsx = zzdfxVar;
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

    public static zzdfv zzba(zzdmr zzdmrVar) throws zzdok {
        return (zzdfv) zzdob.a(zzgsy, zzdmrVar);
    }

    public static zza zzaqv() {
        return (zza) ((zzdob.zza) zzgsy.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acx acxVar = null;
        switch (acx.f1803a[i - 1]) {
            case 1:
                return new zzdfv();
            case 2:
                return new zza(acxVar);
            case 3:
                return a(zzgsy, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgsx", "zzgqs"});
            case 4:
                return zzgsy;
            case 5:
                zzdpv<zzdfv> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfv.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgsy);
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
        zzdob.a((Class<zzdfv>) zzdfv.class, zzgsy);
    }
}
