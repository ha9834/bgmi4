package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdha extends zzdob<zzdha, zza> implements zzdpm {
    private static volatile zzdpv<zzdha> zzdv;
    private static final zzdha zzguz = new zzdha();
    private int zzdj;
    private int zzgux;
    private zzdoj<zzb> zzguy = d();

    /* loaded from: classes2.dex */
    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzgvd = new zzb();
        private int zzguq;
        private zzdgr zzgva;
        private int zzgvb;
        private int zzgvc;

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzgvd);
            }

            public final zza zzb(zzdgr zzdgrVar) {
                a();
                ((zzb) this.f3590a).a(zzdgrVar);
                return this;
            }

            public final zza zzb(zzdgu zzdguVar) {
                a();
                ((zzb) this.f3590a).a(zzdguVar);
                return this;
            }

            public final zza zzeu(int i) {
                a();
                ((zzb) this.f3590a).b(i);
                return this;
            }

            public final zza zzb(zzdhm zzdhmVar) {
                a();
                ((zzb) this.f3590a).a(zzdhmVar);
                return this;
            }

            /* synthetic */ zza(adl adlVar) {
                this();
            }
        }

        public final boolean zzasm() {
            return this.zzgva != null;
        }

        public final zzdgr zzasn() {
            zzdgr zzdgrVar = this.zzgva;
            return zzdgrVar == null ? zzdgr.zzarx() : zzdgrVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzdgr zzdgrVar) {
            if (zzdgrVar == null) {
                throw new NullPointerException();
            }
            this.zzgva = zzdgrVar;
        }

        public final zzdgu zzaso() {
            zzdgu zzeo = zzdgu.zzeo(this.zzgvb);
            return zzeo == null ? zzdgu.UNRECOGNIZED : zzeo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzdgu zzdguVar) {
            if (zzdguVar == null) {
                throw new NullPointerException();
            }
            this.zzgvb = zzdguVar.zzac();
        }

        public final int zzasp() {
            return this.zzgvc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzgvc = i;
        }

        public final zzdhm zzanw() {
            zzdhm zzez = zzdhm.zzez(this.zzguq);
            return zzez == null ? zzdhm.UNRECOGNIZED : zzez;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzdhm zzdhmVar) {
            if (zzdhmVar == null) {
                throw new NullPointerException();
            }
            this.zzguq = zzdhmVar.zzac();
        }

        public static zza zzasq() {
            return (zza) ((zzdob.zza) zzgvd.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            adl adlVar = null;
            switch (adl.f1814a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(adlVar);
                case 3:
                    return a(zzgvd, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgva", "zzgvb", "zzgvc", "zzguq"});
                case 4:
                    return zzgvd;
                case 5:
                    zzdpv<zzb> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzb.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzgvd);
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
            zzdob.a((Class<zzb>) zzb.class, zzgvd);
        }
    }

    private zzdha() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdha, zza> implements zzdpm {
        private zza() {
            super(zzdha.zzguz);
        }

        public final zza zzes(int i) {
            a();
            ((zzdha) this.f3590a).b(i);
            return this;
        }

        public final zza zzb(zzb zzbVar) {
            a();
            ((zzdha) this.f3590a).a(zzbVar);
            return this;
        }

        /* synthetic */ zza(adl adlVar) {
            this();
        }
    }

    public final int zzash() {
        return this.zzgux;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        this.zzgux = i;
    }

    public final List<zzb> zzasi() {
        return this.zzguy;
    }

    public final int zzasj() {
        return this.zzguy.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzb zzbVar) {
        if (zzbVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzguy.zzavi()) {
            zzdoj<zzb> zzdojVar = this.zzguy;
            int size = zzdojVar.size();
            this.zzguy = zzdojVar.zzfl(size == 0 ? 10 : size << 1);
        }
        this.zzguy.add(zzbVar);
    }

    public static zzdha zzn(byte[] bArr) throws zzdok {
        return (zzdha) zzdob.a(zzguz, bArr);
    }

    public static zza zzask() {
        return (zza) ((zzdob.zza) zzguz.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adl adlVar = null;
        switch (adl.f1814a[i - 1]) {
            case 1:
                return new zzdha();
            case 2:
                return new zza(adlVar);
            case 3:
                return a(zzguz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdj", "zzgux", "zzguy", zzb.class});
            case 4:
                return zzguz;
            case 5:
                zzdpv<zzdha> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdha.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzguz);
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
        zzdob.a((Class<zzdha>) zzdha.class, zzguz);
    }
}
