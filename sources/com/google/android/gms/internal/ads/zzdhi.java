package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdhi extends zzdob<zzdhi, zza> implements zzdpm {
    private static volatile zzdpv<zzdhi> zzdv;
    private static final zzdhi zzgvm = new zzdhi();
    private int zzgqk;
    private zzdhk zzgvl;

    private zzdhi() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdhi, zza> implements zzdpm {
        private zza() {
            super(zzdhi.zzgvm);
        }

        public final zza zzey(int i) {
            a();
            ((zzdhi) this.f3590a).b(0);
            return this;
        }

        public final zza zzb(zzdhk zzdhkVar) {
            a();
            ((zzdhi) this.f3590a).a(zzdhkVar);
            return this;
        }

        /* synthetic */ zza(adp adpVar) {
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

    public final zzdhk zzatc() {
        zzdhk zzdhkVar = this.zzgvl;
        return zzdhkVar == null ? zzdhk.zzath() : zzdhkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdhk zzdhkVar) {
        if (zzdhkVar == null) {
            throw new NullPointerException();
        }
        this.zzgvl = zzdhkVar;
    }

    public static zzdhi zzbr(zzdmr zzdmrVar) throws zzdok {
        return (zzdhi) zzdob.a(zzgvm, zzdmrVar);
    }

    public static zza zzatd() {
        return (zza) ((zzdob.zza) zzgvm.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adp adpVar = null;
        switch (adp.f1818a[i - 1]) {
            case 1:
                return new zzdhi();
            case 2:
                return new zza(adpVar);
            case 3:
                return a(zzgvm, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzgqk", "zzgvl"});
            case 4:
                return zzgvm;
            case 5:
                zzdpv<zzdhi> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdhi.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgvm);
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
        zzdob.a((Class<zzdhi>) zzdhi.class, zzgvm);
    }
}
