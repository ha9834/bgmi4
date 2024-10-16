package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdhc extends zzdob<zzdhc, zza> implements zzdpm {
    private static volatile zzdpv<zzdhc> zzdv;
    private static final zzdhc zzgvf = new zzdhc();
    private int zzdj;
    private int zzgux;
    private zzdoj<zzb> zzgve = d();

    /* loaded from: classes2.dex */
    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzgvg = new zzb();
        private String zzgtz = "";
        private int zzguq;
        private int zzgvb;
        private int zzgvc;

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzgvg);
            }

            public final zza zzgq(String str) {
                a();
                ((zzb) this.f3590a).a(str);
                return this;
            }

            public final zza zzc(zzdgu zzdguVar) {
                a();
                ((zzb) this.f3590a).a(zzdguVar);
                return this;
            }

            public final zza zzew(int i) {
                a();
                ((zzb) this.f3590a).b(i);
                return this;
            }

            public final zza zzc(zzdhm zzdhmVar) {
                a();
                ((zzb) this.f3590a).a(zzdhmVar);
                return this;
            }

            /* synthetic */ zza(adm admVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzgtz = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzdgu zzdguVar) {
            if (zzdguVar == null) {
                throw new NullPointerException();
            }
            this.zzgvb = zzdguVar.zzac();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzgvc = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzdhm zzdhmVar) {
            if (zzdhmVar == null) {
                throw new NullPointerException();
            }
            this.zzguq = zzdhmVar.zzac();
        }

        public static zza zzasu() {
            return (zza) ((zzdob.zza) zzgvg.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            adm admVar = null;
            switch (adm.f1815a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(admVar);
                case 3:
                    return a(zzgvg, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgtz", "zzgvb", "zzgvc", "zzguq"});
                case 4:
                    return zzgvg;
                case 5:
                    zzdpv<zzb> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzb.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzgvg);
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
            zzdob.a((Class<zzb>) zzb.class, zzgvg);
        }
    }

    private zzdhc() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdhc, zza> implements zzdpm {
        private zza() {
            super(zzdhc.zzgvf);
        }

        public final zza zzev(int i) {
            a();
            ((zzdhc) this.f3590a).b(i);
            return this;
        }

        public final zza zzb(zzb zzbVar) {
            a();
            ((zzdhc) this.f3590a).a(zzbVar);
            return this;
        }

        /* synthetic */ zza(adm admVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        this.zzgux = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzb zzbVar) {
        if (zzbVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzgve.zzavi()) {
            zzdoj<zzb> zzdojVar = this.zzgve;
            int size = zzdojVar.size();
            this.zzgve = zzdojVar.zzfl(size == 0 ? 10 : size << 1);
        }
        this.zzgve.add(zzbVar);
    }

    public static zza zzass() {
        return (zza) ((zzdob.zza) zzgvf.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adm admVar = null;
        switch (adm.f1815a[i - 1]) {
            case 1:
                return new zzdhc();
            case 2:
                return new zza(admVar);
            case 3:
                return a(zzgvf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdj", "zzgux", "zzgve", zzb.class});
            case 4:
                return zzgvf;
            case 5:
                zzdpv<zzdhc> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdhc.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgvf);
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
        zzdob.a((Class<zzdhc>) zzdhc.class, zzgvf);
    }
}
