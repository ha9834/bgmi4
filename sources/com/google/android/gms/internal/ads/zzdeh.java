package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdeh extends zzdob<zzdeh, zza> implements zzdpm {
    private static volatile zzdpv<zzdeh> zzdv;
    private static final zzdeh zzgrh = new zzdeh();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;
    private zzdel zzgrg;

    private zzdeh() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdeh, zza> implements zzdpm {
        private zza() {
            super(zzdeh.zzgrh);
        }

        public final zza zzdx(int i) {
            a();
            ((zzdeh) this.f3590a).b(0);
            return this;
        }

        public final zza zzb(zzdel zzdelVar) {
            a();
            ((zzdeh) this.f3590a).a(zzdelVar);
            return this;
        }

        public final zza zzae(zzdmr zzdmrVar) {
            a();
            ((zzdeh) this.f3590a).a(zzdmrVar);
            return this;
        }

        /* synthetic */ zza(acn acnVar) {
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

    public final zzdel zzapb() {
        zzdel zzdelVar = this.zzgrg;
        return zzdelVar == null ? zzdel.zzapf() : zzdelVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdel zzdelVar) {
        if (zzdelVar == null) {
            throw new NullPointerException();
        }
        this.zzgrg = zzdelVar;
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

    public static zzdeh zzad(zzdmr zzdmrVar) throws zzdok {
        return (zzdeh) zzdob.a(zzgrh, zzdmrVar);
    }

    public static zza zzapc() {
        return (zza) ((zzdob.zza) zzgrh.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acn acnVar = null;
        switch (acn.f1794a[i - 1]) {
            case 1:
                return new zzdeh();
            case 2:
                return new zza(acnVar);
            case 3:
                return a(zzgrh, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgrg", "zzgqs"});
            case 4:
                return zzgrh;
            case 5:
                zzdpv<zzdeh> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdeh.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgrh);
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
        zzdob.a((Class<zzdeh>) zzdeh.class, zzgrh);
    }
}
