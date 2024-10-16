package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdrz {

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob<zza, C0095zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        private static final zza zzhoq = new zza();
        private int zzdj;
        private int zzhoj;
        private zzb zzhok;
        private boolean zzhon;
        private boolean zzhoo;
        private byte zzhop = 2;
        private zzdmr zzhol = zzdmr.zzhcr;
        private zzdmr zzhom = zzdmr.zzhcr;

        /* loaded from: classes2.dex */
        public static final class zzb extends zzdob<zzb, C0096zza> implements zzdpm {
            private static volatile zzdpv<zzb> zzdv;
            private static final zzb zzhov = new zzb();
            private int zzdj;
            private String zzhor = "";
            private String zzhos = "";
            private String zzhot = "";
            private int zzhou;

            private zzb() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zza$zzb$zza, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0096zza extends zzdob.zza<zzb, C0096zza> implements zzdpm {
                private C0096zza() {
                    super(zzb.zzhov);
                }

                /* synthetic */ C0096zza(aie aieVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                aie aieVar = null;
                switch (aie.f1890a[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0096zza(aieVar);
                    case 3:
                        return a(zzhov, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzdj", "zzhor", "zzhos", "zzhot", "zzhou"});
                    case 4:
                        return zzhov;
                    case 5:
                        zzdpv<zzb> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zzb.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzhov);
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
                zzdob.a((Class<zzb>) zzb.class, zzhov);
            }
        }

        /* loaded from: classes2.dex */
        public enum zzc implements zzdoe {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);

            private static final zzdof<zzc> f = new aif();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static zzc zzhg(int i) {
                switch (i) {
                    case 0:
                        return SAFE;
                    case 1:
                        return DANGEROUS;
                    case 2:
                        return UNKNOWN;
                    case 3:
                        return POTENTIALLY_UNWANTED;
                    case 4:
                        return DANGEROUS_HOST;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return aig.f1891a;
            }

            zzc(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzdrz$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0095zza extends zzdob.zza<zza, C0095zza> implements zzdpm {
            private C0095zza() {
                super(zza.zzhoq);
            }

            /* synthetic */ C0095zza(aie aieVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            aie aieVar = null;
            switch (aie.f1890a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0095zza(aieVar);
                case 3:
                    return a(zzhoq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzdj", "zzhoj", zzc.zzad(), "zzhok", "zzhol", "zzhom", "zzhon", "zzhoo"});
                case 4:
                    return zzhoq;
                case 5:
                    zzdpv<zza> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zza.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzhoq);
                                zzdv = zzdpvVar;
                            }
                        }
                    }
                    return zzdpvVar;
                case 6:
                    return Byte.valueOf(this.zzhop);
                case 7:
                    this.zzhop = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdob.a((Class<zza>) zza.class, zzhoq);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzhpr = new zzb();
        private int zzbzi;
        private int zzdj;
        private int zzhpc;
        private C0097zzb zzhpf;
        private zzf zzhpi;
        private boolean zzhpj;
        private boolean zzhpm;
        private boolean zzhpn;
        private zzi zzhpo;
        private byte zzhop = 2;
        private String zzhos = "";
        private String zzhpd = "";
        private String zzhpe = "";
        private zzdoj<zzh> zzhpg = d();
        private String zzhph = "";
        private zzdoj<String> zzhpk = zzdob.d();
        private String zzhpl = "";
        private zzdmr zzhol = zzdmr.zzhcr;
        private zzdoj<String> zzhpp = zzdob.d();
        private zzdoj<String> zzhpq = zzdob.d();

        /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzb, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0097zzb extends zzdob<C0097zzb, zza> implements zzdpm {
            private static volatile zzdpv<C0097zzb> zzdv;
            private static final C0097zzb zzhpt = new C0097zzb();
            private int zzdj;
            private String zzhps = "";

            private C0097zzb() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzb$zza */
            /* loaded from: classes2.dex */
            public static final class zza extends zzdob.zza<C0097zzb, zza> implements zzdpm {
                private zza() {
                    super(C0097zzb.zzhpt);
                }

                /* synthetic */ zza(aie aieVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                aie aieVar = null;
                switch (aie.f1890a[i - 1]) {
                    case 1:
                        return new C0097zzb();
                    case 2:
                        return new zza(aieVar);
                    case 3:
                        return a(zzhpt, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdj", "zzhps"});
                    case 4:
                        return zzhpt;
                    case 5:
                        zzdpv<C0097zzb> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (C0097zzb.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzhpt);
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
                zzdob.a((Class<C0097zzb>) C0097zzb.class, zzhpt);
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
            private static volatile zzdpv<zzc> zzdv;
            private static final zzc zzhpv = new zzc();
            private int zzdj;
            private byte zzhop = 2;
            private zzdmr zzhpu = zzdmr.zzhcr;
            private zzdmr zzgua = zzdmr.zzhcr;

            private zzc() {
            }

            /* loaded from: classes2.dex */
            public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
                private zza() {
                    super(zzc.zzhpv);
                }

                /* synthetic */ zza(aie aieVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                aie aieVar = null;
                switch (aie.f1890a[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(aieVar);
                    case 3:
                        return a(zzhpv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzdj", "zzhpu", "zzgua"});
                    case 4:
                        return zzhpv;
                    case 5:
                        zzdpv<zzc> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zzc.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzhpv);
                                    zzdv = zzdpvVar;
                                }
                            }
                        }
                        return zzdpvVar;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        this.zzhop = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.a((Class<zzc>) zzc.class, zzhpv);
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzd extends zzdob<zzd, zza> implements zzdpm {
            private static volatile zzdpv<zzd> zzdv;
            private static final zzd zzhqb = new zzd();
            private int zzdj;
            private C0098zzb zzhpw;
            private int zzhqa;
            private byte zzhop = 2;
            private zzdoj<zzc> zzhpx = d();
            private zzdmr zzhpy = zzdmr.zzhcr;
            private zzdmr zzhpz = zzdmr.zzhcr;

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzd$zzb, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0098zzb extends zzdob<C0098zzb, zza> implements zzdpm {
                private static volatile zzdpv<C0098zzb> zzdv;
                private static final C0098zzb zzhqf = new C0098zzb();
                private int zzdj;
                private zzdmr zzhqc = zzdmr.zzhcr;
                private zzdmr zzhqd = zzdmr.zzhcr;
                private zzdmr zzhqe = zzdmr.zzhcr;

                private C0098zzb() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzd$zzb$zza */
                /* loaded from: classes2.dex */
                public static final class zza extends zzdob.zza<C0098zzb, zza> implements zzdpm {
                    private zza() {
                        super(C0098zzb.zzhqf);
                    }

                    /* synthetic */ zza(aie aieVar) {
                        this();
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzdob
                public final Object a(int i, Object obj, Object obj2) {
                    aie aieVar = null;
                    switch (aie.f1890a[i - 1]) {
                        case 1:
                            return new C0098zzb();
                        case 2:
                            return new zza(aieVar);
                        case 3:
                            return a(zzhqf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhqc", "zzhqd", "zzhqe"});
                        case 4:
                            return zzhqf;
                        case 5:
                            zzdpv<C0098zzb> zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                synchronized (C0098zzb.class) {
                                    zzdpvVar = zzdv;
                                    if (zzdpvVar == null) {
                                        zzdpvVar = new zzdob.zzb<>(zzhqf);
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
                    zzdob.a((Class<C0098zzb>) C0098zzb.class, zzhqf);
                }
            }

            private zzd() {
            }

            /* loaded from: classes2.dex */
            public static final class zza extends zzdob.zza<zzd, zza> implements zzdpm {
                private zza() {
                    super(zzd.zzhqb);
                }

                /* synthetic */ zza(aie aieVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                aie aieVar = null;
                switch (aie.f1890a[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(aieVar);
                    case 3:
                        return a(zzhqb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzdj", "zzhpw", "zzhpx", zzc.class, "zzhpy", "zzhpz", "zzhqa"});
                    case 4:
                        return zzhqb;
                    case 5:
                        zzdpv<zzd> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zzd.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzhqb);
                                    zzdv = zzdpvVar;
                                }
                            }
                        }
                        return zzdpvVar;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        this.zzhop = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.a((Class<zzd>) zzd.class, zzhqb);
            }
        }

        /* loaded from: classes2.dex */
        public static final class zze extends zzdob<zze, zza> implements zzdpm {
            private static volatile zzdpv<zze> zzdv;
            private static final zze zzhqi = new zze();
            private int zzdj;
            private int zzhqa;
            private C0099zzb zzhqg;
            private byte zzhop = 2;
            private zzdoj<zzc> zzhpx = d();
            private zzdmr zzhpy = zzdmr.zzhcr;
            private zzdmr zzhpz = zzdmr.zzhcr;
            private zzdmr zzhqh = zzdmr.zzhcr;

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zze$zzb, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0099zzb extends zzdob<C0099zzb, zza> implements zzdpm {
                private static volatile zzdpv<C0099zzb> zzdv;
                private static final C0099zzb zzhql = new C0099zzb();
                private int zzdj;
                private int zzhqj;
                private zzdmr zzhqk = zzdmr.zzhcr;
                private zzdmr zzhqe = zzdmr.zzhcr;

                private C0099zzb() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zze$zzb$zza */
                /* loaded from: classes2.dex */
                public static final class zza extends zzdob.zza<C0099zzb, zza> implements zzdpm {
                    private zza() {
                        super(C0099zzb.zzhql);
                    }

                    /* synthetic */ zza(aie aieVar) {
                        this();
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzdob
                public final Object a(int i, Object obj, Object obj2) {
                    aie aieVar = null;
                    switch (aie.f1890a[i - 1]) {
                        case 1:
                            return new C0099zzb();
                        case 2:
                            return new zza(aieVar);
                        case 3:
                            return a(zzhql, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhqj", "zzhqk", "zzhqe"});
                        case 4:
                            return zzhql;
                        case 5:
                            zzdpv<C0099zzb> zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                synchronized (C0099zzb.class) {
                                    zzdpvVar = zzdv;
                                    if (zzdpvVar == null) {
                                        zzdpvVar = new zzdob.zzb<>(zzhql);
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
                    zzdob.a((Class<C0099zzb>) C0099zzb.class, zzhql);
                }
            }

            private zze() {
            }

            /* loaded from: classes2.dex */
            public static final class zza extends zzdob.zza<zze, zza> implements zzdpm {
                private zza() {
                    super(zze.zzhqi);
                }

                /* synthetic */ zza(aie aieVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                aie aieVar = null;
                switch (aie.f1890a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(aieVar);
                    case 3:
                        return a(zzhqi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzdj", "zzhqg", "zzhpx", zzc.class, "zzhpy", "zzhpz", "zzhqa", "zzhqh"});
                    case 4:
                        return zzhqi;
                    case 5:
                        zzdpv<zze> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zze.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzhqi);
                                    zzdv = zzdpvVar;
                                }
                            }
                        }
                        return zzdpvVar;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        this.zzhop = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.a((Class<zze>) zze.class, zzhqi);
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzf extends zzdob<zzf, zza> implements zzdpm {
            private static volatile zzdpv<zzf> zzdv;
            private static final zzf zzhqo = new zzf();
            private int zzbzi;
            private int zzdj;
            private String zzhqm = "";
            private zzdmr zzhqn = zzdmr.zzhcr;

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzf$zzb, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public enum EnumC0100zzb implements zzdoe {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);

                private static final zzdof<EnumC0100zzb> c = new aih();
                private final int value;

                @Override // com.google.android.gms.internal.ads.zzdoe
                public final int zzac() {
                    return this.value;
                }

                public static EnumC0100zzb zzhh(int i) {
                    switch (i) {
                        case 0:
                            return TYPE_UNKNOWN;
                        case 1:
                            return TYPE_CREATIVE;
                        default:
                            return null;
                    }
                }

                public static zzdog zzad() {
                    return aii.f1892a;
                }

                EnumC0100zzb(int i) {
                    this.value = i;
                }
            }

            private zzf() {
            }

            /* loaded from: classes2.dex */
            public static final class zza extends zzdob.zza<zzf, zza> implements zzdpm {
                private zza() {
                    super(zzf.zzhqo);
                }

                /* synthetic */ zza(aie aieVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                aie aieVar = null;
                switch (aie.f1890a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(aieVar);
                    case 3:
                        return a(zzhqo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzbzi", EnumC0100zzb.zzad(), "zzhqm", "zzhqn"});
                    case 4:
                        return zzhqo;
                    case 5:
                        zzdpv<zzf> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zzf.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzhqo);
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
                zzdob.a((Class<zzf>) zzf.class, zzhqo);
            }
        }

        /* loaded from: classes2.dex */
        public enum zzg implements zzdoe {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);

            private static final zzdof<zzg> k = new aij();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static zzg zzhi(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return aik.f1893a;
            }

            zzg(int i) {
                this.value = i;
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzh extends zzdob<zzh, C0101zzb> implements zzdpm {
            private static volatile zzdpv<zzh> zzdv;
            private static final zzh zzhrl = new zzh();
            private int zzdj;
            private int zzhrd;
            private zzd zzhre;
            private zze zzhrf;
            private int zzhrg;
            private int zzhrj;
            private byte zzhop = 2;
            private String zzhos = "";
            private zzdoh zzhrh = c();
            private String zzhri = "";
            private zzdoj<String> zzhrk = zzdob.d();

            /* loaded from: classes2.dex */
            public enum zza implements zzdoe {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);

                private static final zzdof<zza> e = new ail();
                private final int value;

                @Override // com.google.android.gms.internal.ads.zzdoe
                public final int zzac() {
                    return this.value;
                }

                public static zza zzhj(int i) {
                    switch (i) {
                        case 0:
                            return AD_RESOURCE_UNKNOWN;
                        case 1:
                            return AD_RESOURCE_CREATIVE;
                        case 2:
                            return AD_RESOURCE_POST_CLICK;
                        case 3:
                            return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                        default:
                            return null;
                    }
                }

                public static zzdog zzad() {
                    return aim.f1894a;
                }

                zza(int i) {
                    this.value = i;
                }
            }

            private zzh() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzh$zzb, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0101zzb extends zzdob.zza<zzh, C0101zzb> implements zzdpm {
                private C0101zzb() {
                    super(zzh.zzhrl);
                }

                /* synthetic */ C0101zzb(aie aieVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                aie aieVar = null;
                switch (aie.f1890a[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0101zzb(aieVar);
                    case 3:
                        return a(zzhrl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzdj", "zzhrd", "zzhos", "zzhre", "zzhrf", "zzhrg", "zzhrh", "zzhri", "zzhrj", zza.zzad(), "zzhrk"});
                    case 4:
                        return zzhrl;
                    case 5:
                        zzdpv<zzh> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zzh.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzhrl);
                                    zzdv = zzdpvVar;
                                }
                            }
                        }
                        return zzdpvVar;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        this.zzhop = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.a((Class<zzh>) zzh.class, zzhrl);
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzi extends zzdob<zzi, zza> implements zzdpm {
            private static volatile zzdpv<zzi> zzdv;
            private static final zzi zzhru = new zzi();
            private int zzdj;
            private String zzhrr = "";
            private long zzhrs;
            private boolean zzhrt;

            private zzi() {
            }

            /* loaded from: classes2.dex */
            public static final class zza extends zzdob.zza<zzi, zza> implements zzdpm {
                private zza() {
                    super(zzi.zzhru);
                }

                /* synthetic */ zza(aie aieVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                aie aieVar = null;
                switch (aie.f1890a[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(aieVar);
                    case 3:
                        return a(zzhru, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzdj", "zzhrr", "zzhrs", "zzhrt"});
                    case 4:
                        return zzhru;
                    case 5:
                        zzdpv<zzi> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zzi.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzhru);
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
                zzdob.a((Class<zzi>) zzi.class, zzhru);
            }
        }

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzhpr);
            }

            /* synthetic */ zza(aie aieVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            aie aieVar = null;
            switch (aie.f1890a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(aieVar);
                case 3:
                    return a(zzhpr, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzdj", "zzhos", "zzhpd", "zzhpe", "zzhpg", zzh.class, "zzhpj", "zzhpk", "zzhpl", "zzhpm", "zzhpn", "zzbzi", zzg.zzad(), "zzhpc", zza.zzc.zzad(), "zzhpf", "zzhph", "zzhpi", "zzhol", "zzhpo", "zzhpp", "zzhpq"});
                case 4:
                    return zzhpr;
                case 5:
                    zzdpv<zzb> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzb.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzhpr);
                                zzdv = zzdpvVar;
                            }
                        }
                    }
                    return zzdpvVar;
                case 6:
                    return Byte.valueOf(this.zzhop);
                case 7:
                    this.zzhop = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdob.a((Class<zzb>) zzb.class, zzhpr);
        }
    }
}
