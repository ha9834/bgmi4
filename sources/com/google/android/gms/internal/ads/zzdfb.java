package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfb extends zzdob<zzdfb, zza> implements zzdpm {
    private static volatile zzdpv<zzdfb> zzdv;
    private static final zzdfb zzgrs = new zzdfb();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;

    private zzdfb() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfb, zza> implements zzdpm {
        private zza() {
            super(zzdfb.zzgrs);
        }

        public final zza zzeb(int i) {
            a();
            ((zzdfb) this.f3590a).b(0);
            return this;
        }

        public final zza zzaq(zzdmr zzdmrVar) {
            a();
            ((zzdfb) this.f3590a).a(zzdmrVar);
            return this;
        }

        /* synthetic */ zza(acs acsVar) {
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

    public static zzdfb zzap(zzdmr zzdmrVar) throws zzdok {
        return (zzdfb) zzdob.a(zzgrs, zzdmrVar);
    }

    public static zza zzapt() {
        return (zza) ((zzdob.zza) zzgrs.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acs acsVar = null;
        switch (acs.f1799a[i - 1]) {
            case 1:
                return new zzdfb();
            case 2:
                return new zza(acsVar);
            case 3:
                return a(zzgrs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgrs;
            case 5:
                zzdpv<zzdfb> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfb.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgrs);
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
        zzdob.a((Class<zzdfb>) zzdfb.class, zzgrs);
    }
}
