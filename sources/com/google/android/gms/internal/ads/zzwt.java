package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class zzwt {

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob<zza, zzb> implements zzdpm {
        private static final zza zzbzk = new zza();
        private static volatile zzdpv<zza> zzdv;
        private int zzbzi;
        private zzl zzbzj;
        private int zzdj;

        /* renamed from: com.google.android.gms.internal.ads.zzwt$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public enum EnumC0103zza implements zzdoe {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);

            private static final zzdof<EnumC0103zza> g = new apr();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static EnumC0103zza zzbz(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return aps.f2038a;
            }

            EnumC0103zza(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* loaded from: classes2.dex */
        public static final class zzb extends zzdob.zza<zza, zzb> implements zzdpm {
            private zzb() {
                super(zza.zzbzk);
            }

            /* synthetic */ zzb(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(apqVar);
                case 3:
                    return a(zzbzk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzbzi", EnumC0103zza.zzad(), "zzbzj"});
                case 4:
                    return zzbzk;
                case 5:
                    zzdpv<zza> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zza.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzbzk);
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
            zzdob.a((Class<zza>) zza.class, zzbzk);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static final zzb zzcaa = new zzb();
        private static volatile zzdpv<zzb> zzdv;
        private String zzbzx = "";
        private zzdoj<zza> zzbzy = d();
        private int zzbzz;
        private int zzdj;

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzcaa);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcaa, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001", new Object[]{"zzdj", "zzbzx", "zzbzy", zza.class, "zzbzz", zzwx.zzad()});
                case 4:
                    return zzcaa;
                case 5:
                    zzdpv<zzb> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzb.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcaa);
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
            zzdob.a((Class<zzb>) zzb.class, zzcaa);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
        private static final zzc zzcah = new zzc();
        private static volatile zzdpv<zzc> zzdv;
        private int zzcab;
        private zzn zzcac;
        private zzn zzcad;
        private zzn zzcae;
        private zzdoj<zzn> zzcaf = d();
        private int zzcag;
        private int zzdj;

        private zzc() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
            private zza() {
                super(zzc.zzcah);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcah, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b\u0006\u0004\u0004", new Object[]{"zzdj", "zzcab", "zzcac", "zzcad", "zzcae", "zzcaf", zzn.class, "zzcag"});
                case 4:
                    return zzcah;
                case 5:
                    zzdpv<zzc> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzc.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcah);
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
            zzdob.a((Class<zzc>) zzc.class, zzcah);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzd extends zzdob<zzd, zza> implements zzdpm {
        private static final zzd zzcaq = new zzd();
        private static volatile zzdpv<zzd> zzdv;
        private int zzcan;
        private zzn zzcap;
        private int zzdj;
        private String zzcam = "";
        private zzdoh zzcao = c();

        private zzd() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzd, zza> implements zzdpm {
            private zza() {
                super(zzd.zzcaq);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcaq, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0016\u0004\t\u0002", new Object[]{"zzdj", "zzcam", "zzcan", zzwx.zzad(), "zzcao", "zzcap"});
                case 4:
                    return zzcaq;
                case 5:
                    zzdpv<zzd> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzd.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcaq);
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
            zzdob.a((Class<zzd>) zzd.class, zzcaq);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zze extends zzdob<zze, zza> implements zzdpm {
        private static final zze zzcas = new zze();
        private static volatile zzdpv<zze> zzdv;
        private zzdoh zzcao = c();
        private int zzcar;
        private int zzdj;

        private zze() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zze, zza> implements zzdpm {
            private zza() {
                super(zze.zzcas);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcas, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcao"});
                case 4:
                    return zzcas;
                case 5:
                    zzdpv<zze> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zze.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcas);
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
            zzdob.a((Class<zze>) zze.class, zzcas);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzf extends zzdob<zzf, zza> implements zzdpm {
        private static final zzf zzcav = new zzf();
        private static volatile zzdpv<zzf> zzdv;
        private zzn zzcap;
        private int zzcar;
        private zzd zzcat;
        private zzdoj<zzm> zzcau = d();
        private int zzdj;

        private zzf() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzf, zza> implements zzdpm {
            private zza() {
                super(zzf.zzcav);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcav, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\t\u0002", new Object[]{"zzdj", "zzcat", "zzcau", zzm.class, "zzcar", zzwx.zzad(), "zzcap"});
                case 4:
                    return zzcav;
                case 5:
                    zzdpv<zzf> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzf.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcav);
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
            zzdob.a((Class<zzf>) zzf.class, zzcav);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzg extends zzdob<zzg, zza> implements zzdpm {
        private static final zzg zzcax = new zzg();
        private static volatile zzdpv<zzg> zzdv;
        private int zzbzi;
        private int zzcaw;
        private int zzdj;

        /* loaded from: classes2.dex */
        public enum zzb implements zzdoe {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);


            /* renamed from: a, reason: collision with root package name */
            private static final zzdof<zzb> f3771a = new apv();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static zzb zzcb(int i) {
                if (i != 4) {
                    switch (i) {
                        case 0:
                            return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                        case 1:
                            return TWO_G;
                        case 2:
                            return THREE_G;
                        default:
                            return null;
                    }
                }
                return LTE;
            }

            public static zzdog zzad() {
                return apw.f2040a;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        /* loaded from: classes2.dex */
        public enum zzc implements zzdoe {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);


            /* renamed from: a, reason: collision with root package name */
            private static final zzdof<zzc> f3772a = new apx();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static zzc zzcc(int i) {
                switch (i) {
                    case 0:
                        return NETWORKTYPE_UNSPECIFIED;
                    case 1:
                        return CELL;
                    case 2:
                        return WIFI;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return apy.f2041a;
            }

            zzc(int i) {
                this.value = i;
            }
        }

        private zzg() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzg, zza> implements zzdpm {
            private zza() {
                super(zzg.zzcax);
            }

            public final zza zzb(zzc zzcVar) {
                a();
                ((zzg) this.f3590a).a(zzcVar);
                return this;
            }

            public final zza zzb(zzb zzbVar) {
                a();
                ((zzg) this.f3590a).a(zzbVar);
                return this;
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzc zzcVar) {
            if (zzcVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 1;
            this.zzbzi = zzcVar.zzac();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzb zzbVar) {
            if (zzbVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 2;
            this.zzcaw = zzbVar.zzac();
        }

        public static zza zznv() {
            return (zza) ((zzdob.zza) zzcax.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcax, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzdj", "zzbzi", zzc.zzad(), "zzcaw", zzb.zzad()});
                case 4:
                    return zzcax;
                case 5:
                    zzdpv<zzg> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzg.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcax);
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
            zzdob.a((Class<zzg>) zzg.class, zzcax);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzh extends zzdob<zzh, zza> implements zzdpm {
        private static final zzh zzcbj = new zzh();
        private static volatile zzdpv<zzh> zzdv;
        private int zzcbh;
        private zzn zzcbi;
        private int zzdj;

        private zzh() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzh, zza> implements zzdpm {
            private zza() {
                super(zzh.zzcbj);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcbj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzcbh", zzwx.zzad(), "zzcbi"});
                case 4:
                    return zzcbj;
                case 5:
                    zzdpv<zzh> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzh.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcbj);
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
            zzdob.a((Class<zzh>) zzh.class, zzcbj);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzi extends zzdob<zzi, zzb> implements zzdpm {
        private static final zzi zzcbq = new zzi();
        private static volatile zzdpv<zzi> zzdv;
        private int zzcbl;
        private int zzcbm;
        private long zzcbn;
        private long zzcbp;
        private int zzdj;
        private zzdoj<zza> zzcbk = d();
        private String zzdk = "";
        private String zzcbo = "";

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob<zza, C0104zza> implements zzdpm {
            private static final zzdoi<Integer, zza.EnumC0103zza> zzcbw = new apz();
            private static final zza zzcce = new zza();
            private static volatile zzdpv<zza> zzdv;
            private long zzcbr;
            private int zzcbs;
            private long zzcbt;
            private long zzcbu;
            private zzdoh zzcbv = c();
            private zzg zzcbx;
            private int zzcby;
            private int zzcbz;
            private int zzcca;
            private int zzccb;
            private int zzccc;
            private int zzccd;
            private int zzdj;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzwt$zzi$zza$zza, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0104zza extends zzdob.zza<zza, C0104zza> implements zzdpm {
                private C0104zza() {
                    super(zza.zzcce);
                }

                public final C0104zza zzew(long j) {
                    a();
                    ((zza) this.f3590a).a(j);
                    return this;
                }

                public final C0104zza zzf(zzwx zzwxVar) {
                    a();
                    ((zza) this.f3590a).a(zzwxVar);
                    return this;
                }

                public final C0104zza zzex(long j) {
                    a();
                    ((zza) this.f3590a).b(j);
                    return this;
                }

                public final C0104zza zzey(long j) {
                    a();
                    ((zza) this.f3590a).c(j);
                    return this;
                }

                public final C0104zza zzc(Iterable<? extends zza.EnumC0103zza> iterable) {
                    a();
                    ((zza) this.f3590a).a(iterable);
                    return this;
                }

                public final C0104zza zzb(zzg zzgVar) {
                    a();
                    ((zza) this.f3590a).a(zzgVar);
                    return this;
                }

                public final C0104zza zzg(zzwx zzwxVar) {
                    a();
                    ((zza) this.f3590a).b(zzwxVar);
                    return this;
                }

                public final C0104zza zzh(zzwx zzwxVar) {
                    a();
                    ((zza) this.f3590a).c(zzwxVar);
                    return this;
                }

                public final C0104zza zzi(zzwx zzwxVar) {
                    a();
                    ((zza) this.f3590a).d(zzwxVar);
                    return this;
                }

                public final C0104zza zzcg(int i) {
                    a();
                    ((zza) this.f3590a).b(i);
                    return this;
                }

                public final C0104zza zzj(zzwx zzwxVar) {
                    a();
                    ((zza) this.f3590a).e(zzwxVar);
                    return this;
                }

                public final C0104zza zzb(zzc zzcVar) {
                    a();
                    ((zza) this.f3590a).a(zzcVar);
                    return this;
                }

                /* synthetic */ C0104zza(apq apqVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void a(long j) {
                this.zzdj |= 1;
                this.zzcbr = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void a(zzwx zzwxVar) {
                if (zzwxVar == null) {
                    throw new NullPointerException();
                }
                this.zzdj |= 2;
                this.zzcbs = zzwxVar.zzac();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void b(long j) {
                this.zzdj |= 4;
                this.zzcbt = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void c(long j) {
                this.zzdj |= 8;
                this.zzcbu = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void a(Iterable<? extends zza.EnumC0103zza> iterable) {
                if (!this.zzcbv.zzavi()) {
                    zzdoh zzdohVar = this.zzcbv;
                    int size = zzdohVar.size();
                    this.zzcbv = zzdohVar.zzfl(size == 0 ? 10 : size << 1);
                }
                Iterator<? extends zza.EnumC0103zza> it = iterable.iterator();
                while (it.hasNext()) {
                    this.zzcbv.zzgp(it.next().zzac());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void a(zzg zzgVar) {
                if (zzgVar == null) {
                    throw new NullPointerException();
                }
                this.zzcbx = zzgVar;
                this.zzdj |= 16;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void b(zzwx zzwxVar) {
                if (zzwxVar == null) {
                    throw new NullPointerException();
                }
                this.zzdj |= 32;
                this.zzcby = zzwxVar.zzac();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void c(zzwx zzwxVar) {
                if (zzwxVar == null) {
                    throw new NullPointerException();
                }
                this.zzdj |= 64;
                this.zzcbz = zzwxVar.zzac();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void d(zzwx zzwxVar) {
                if (zzwxVar == null) {
                    throw new NullPointerException();
                }
                this.zzdj |= 128;
                this.zzcca = zzwxVar.zzac();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void b(int i) {
                this.zzdj |= 256;
                this.zzccb = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void e(zzwx zzwxVar) {
                if (zzwxVar == null) {
                    throw new NullPointerException();
                }
                this.zzdj |= 512;
                this.zzccc = zzwxVar.zzac();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void a(zzc zzcVar) {
                if (zzcVar == null) {
                    throw new NullPointerException();
                }
                this.zzdj |= 1024;
                this.zzccd = zzcVar.zzac();
            }

            public static zza zzh(byte[] bArr) throws zzdok {
                return (zza) zzdob.a(zzcce, bArr);
            }

            public static C0104zza zzoa() {
                return (C0104zza) ((zzdob.zza) zzcce.a(zzdob.zze.zzhho, (Object) null, (Object) null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                apq apqVar = null;
                switch (apq.f2037a[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0104zza(apqVar);
                    case 3:
                        return a(zzcce, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\u0002\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u001e\u0006\t\u0004\u0007\f\u0005\b\f\u0006\t\f\u0007\n\u0004\b\u000b\f\t\f\f\n", new Object[]{"zzdj", "zzcbr", "zzcbs", zzwx.zzad(), "zzcbt", "zzcbu", "zzcbv", zza.EnumC0103zza.zzad(), "zzcbx", "zzcby", zzwx.zzad(), "zzcbz", zzwx.zzad(), "zzcca", zzwx.zzad(), "zzccb", "zzccc", zzwx.zzad(), "zzccd", zzc.zzad()});
                    case 4:
                        return zzcce;
                    case 5:
                        zzdpv<zza> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zza.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzcce);
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
                zzdob.a((Class<zza>) zza.class, zzcce);
            }
        }

        /* loaded from: classes2.dex */
        public enum zzc implements zzdoe {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);


            /* renamed from: a, reason: collision with root package name */
            private static final zzdof<zzc> f3773a = new aqa();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static zzc zzcj(int i) {
                switch (i) {
                    case 0:
                        return UNSPECIFIED;
                    case 1:
                        return CONNECTING;
                    case 2:
                        return CONNECTED;
                    case 3:
                        return DISCONNECTING;
                    case 4:
                        return DISCONNECTED;
                    case 5:
                        return SUSPENDED;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return aqb.f2043a;
            }

            zzc(int i) {
                this.value = i;
            }
        }

        private zzi() {
        }

        /* loaded from: classes2.dex */
        public static final class zzb extends zzdob.zza<zzi, zzb> implements zzdpm {
            private zzb() {
                super(zzi.zzcbq);
            }

            public final zzb zzd(Iterable<? extends zza> iterable) {
                a();
                ((zzi) this.f3590a).a(iterable);
                return this;
            }

            public final zzb zzch(int i) {
                a();
                ((zzi) this.f3590a).b(i);
                return this;
            }

            public final zzb zzci(int i) {
                a();
                ((zzi) this.f3590a).c(i);
                return this;
            }

            public final zzb zzez(long j) {
                a();
                ((zzi) this.f3590a).a(j);
                return this;
            }

            public final zzb zzbq(String str) {
                a();
                ((zzi) this.f3590a).a(str);
                return this;
            }

            public final zzb zzbr(String str) {
                a();
                ((zzi) this.f3590a).b(str);
                return this;
            }

            /* synthetic */ zzb(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(Iterable<? extends zza> iterable) {
            if (!this.zzcbk.zzavi()) {
                zzdoj<zza> zzdojVar = this.zzcbk;
                int size = zzdojVar.size();
                this.zzcbk = zzdojVar.zzfl(size == 0 ? 10 : size << 1);
            }
            zzdmi.a(iterable, this.zzcbk);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzdj |= 1;
            this.zzcbl = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(int i) {
            this.zzdj |= 2;
            this.zzcbm = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzdj |= 4;
            this.zzcbn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 8;
            this.zzdk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 16;
            this.zzcbo = str;
        }

        public static zzb zzny() {
            return (zzb) ((zzdob.zza) zzcbq.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzb(apqVar);
                case 3:
                    return a(zzcbq, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0000\u0003\u0004\u0001\u0004\u0002\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005", new Object[]{"zzdj", "zzcbk", zza.class, "zzcbl", "zzcbm", "zzcbn", "zzdk", "zzcbo", "zzcbp"});
                case 4:
                    return zzcbq;
                case 5:
                    zzdpv<zzi> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzi.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcbq);
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
            zzdob.a((Class<zzi>) zzi.class, zzcbq);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzj extends zzdob<zzj, zza> implements zzdpm {
        private static final zzj zzccx = new zzj();
        private static volatile zzdpv<zzj> zzdv;
        private int zzccm = 1000;
        private int zzccn = 1000;
        private int zzcco;
        private int zzccp;
        private int zzccq;
        private int zzccr;
        private int zzccs;
        private int zzcct;
        private int zzccu;
        private int zzccv;
        private zzk zzccw;
        private int zzdj;

        private zzj() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzj, zza> implements zzdpm {
            private zza() {
                super(zzj.zzccx);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzccx, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u0004\b\n\u0004\t\u000b\t\n", new Object[]{"zzdj", "zzccm", zzwx.zzad(), "zzccn", zzwx.zzad(), "zzcco", "zzccp", "zzccq", "zzccr", "zzccs", "zzcct", "zzccu", "zzccv", "zzccw"});
                case 4:
                    return zzccx;
                case 5:
                    zzdpv<zzj> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzj.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzccx);
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
            zzdob.a((Class<zzj>) zzj.class, zzccx);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzk extends zzdob<zzk, zza> implements zzdpm {
        private static final zzk zzcda = new zzk();
        private static volatile zzdpv<zzk> zzdv;
        private int zzccy;
        private int zzccz;
        private int zzdj;

        private zzk() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzk, zza> implements zzdpm {
            private zza() {
                super(zzk.zzcda);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcda, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzccy", "zzccz"});
                case 4:
                    return zzcda;
                case 5:
                    zzdpv<zzk> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzk.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcda);
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
            zzdob.a((Class<zzk>) zzk.class, zzcda);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzl extends zzdob<zzl, zza> implements zzdpm {
        private static final zzl zzcdd = new zzl();
        private static volatile zzdpv<zzl> zzdv;
        private int zzcdb;
        private int zzcdc;
        private int zzdj;

        private zzl() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzl, zza> implements zzdpm {
            private zza() {
                super(zzl.zzcdd);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcdd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzcdb", "zzcdc"});
                case 4:
                    return zzcdd;
                case 5:
                    zzdpv<zzl> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzl.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcdd);
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
            zzdob.a((Class<zzl>) zzl.class, zzcdd);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzm extends zzdob<zzm, zza> implements zzdpm {
        private static final zzm zzcde = new zzm();
        private static volatile zzdpv<zzm> zzdv;
        private String zzcam = "";
        private int zzcan;
        private zzn zzcap;
        private int zzdj;

        private zzm() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzm, zza> implements zzdpm {
            private zza() {
                super(zzm.zzcde);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcde, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcam", "zzcan", zzwx.zzad(), "zzcap"});
                case 4:
                    return zzcde;
                case 5:
                    zzdpv<zzm> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzm.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcde);
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
            zzdob.a((Class<zzm>) zzm.class, zzcde);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzn extends zzdob<zzn, zza> implements zzdpm {
        private static final zzn zzcdh = new zzn();
        private static volatile zzdpv<zzn> zzdv;
        private int zzcdf;
        private int zzcdg;
        private int zzdj;

        private zzn() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzn, zza> implements zzdpm {
            private zza() {
                super(zzn.zzcdh);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcdh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzcdf", "zzcdg"});
                case 4:
                    return zzcdh;
                case 5:
                    zzdpv<zzn> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzn.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcdh);
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
            zzdob.a((Class<zzn>) zzn.class, zzcdh);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzo extends zzdob<zzo, zza> implements zzdpm {
        private static final zzo zzcdk = new zzo();
        private static volatile zzdpv<zzo> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        private zzo() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzo, zza> implements zzdpm {
            private zza() {
                super(zzo.zzcdk);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcdk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdk;
                case 5:
                    zzdpv<zzo> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzo.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcdk);
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
            zzdob.a((Class<zzo>) zzo.class, zzcdk);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzp extends zzdob<zzp, zza> implements zzdpm {
        private static final zzp zzcdm = new zzp();
        private static volatile zzdpv<zzp> zzdv;
        private int zzcdl;
        private int zzdj;

        /* loaded from: classes2.dex */
        public enum zzb implements zzdoe {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);

            private static final zzdof<zzb> e = new aqc();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static zzb zzck(int i) {
                switch (i) {
                    case 0:
                        return VIDEO_ERROR_CODE_UNSPECIFIED;
                    case 1:
                        return OPENGL_RENDERING_FAILED;
                    case 2:
                        return CACHE_LOAD_FAILED;
                    case 3:
                        return ANDROID_TARGET_API_TOO_LOW;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return aqd.f2044a;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        private zzp() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzp, zza> implements zzdpm {
            private zza() {
                super(zzp.zzcdm);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcdm, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzdj", "zzcdl", zzb.zzad()});
                case 4:
                    return zzcdm;
                case 5:
                    zzdpv<zzp> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzp.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcdm);
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
            zzdob.a((Class<zzp>) zzp.class, zzcdm);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzq extends zzdob<zzq, zza> implements zzdpm {
        private static final zzq zzcdv = new zzq();
        private static volatile zzdpv<zzq> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzcds;
        private int zzcdt;
        private int zzcdu;
        private int zzdj;

        private zzq() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzq, zza> implements zzdpm {
            private zza() {
                super(zzq.zzcdv);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcdv, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcds", "zzcdt", "zzcdu"});
                case 4:
                    return zzcdv;
                case 5:
                    zzdpv<zzq> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzq.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcdv);
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
            zzdob.a((Class<zzq>) zzq.class, zzcdv);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzr extends zzdob<zzr, zza> implements zzdpm {
        private static final zzr zzcdw = new zzr();
        private static volatile zzdpv<zzr> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        private zzr() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzr, zza> implements zzdpm {
            private zza() {
                super(zzr.zzcdw);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcdw, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdw;
                case 5:
                    zzdpv<zzr> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzr.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcdw);
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
            zzdob.a((Class<zzr>) zzr.class, zzcdw);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzs extends zzdob<zzs, zza> implements zzdpm {
        private static final zzs zzcdy = new zzs();
        private static volatile zzdpv<zzs> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzcds;
        private int zzcdt;
        private int zzcdu;
        private long zzcdx;
        private int zzdj;

        private zzs() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzs, zza> implements zzdpm {
            private zza() {
                super(zzs.zzcdy);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcdy, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0003\u0005", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcds", "zzcdt", "zzcdu", "zzcdx"});
                case 4:
                    return zzcdy;
                case 5:
                    zzdpv<zzs> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzs.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcdy);
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
            zzdob.a((Class<zzs>) zzs.class, zzcdy);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzt extends zzdob<zzt, zza> implements zzdpm {
        private static final zzt zzcdz = new zzt();
        private static volatile zzdpv<zzt> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        private zzt() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzt, zza> implements zzdpm {
            private zza() {
                super(zzt.zzcdz);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcdz, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdz;
                case 5:
                    zzdpv<zzt> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzt.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcdz);
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
            zzdob.a((Class<zzt>) zzt.class, zzcdz);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzu extends zzdob<zzu, zza> implements zzdpm {
        private static final zzu zzcea = new zzu();
        private static volatile zzdpv<zzu> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzdj;

        private zzu() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzu, zza> implements zzdpm {
            private zza() {
                super(zzu.zzcea);
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzcea, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi"});
                case 4:
                    return zzcea;
                case 5:
                    zzdpv<zzu> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzu.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzcea);
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
            zzdob.a((Class<zzu>) zzu.class, zzcea);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzv extends zzdob<zzv, zza> implements zzdpm {
        private static final zzv zzced = new zzv();
        private static volatile zzdpv<zzv> zzdv;
        private boolean zzceb;
        private int zzcec;
        private int zzdj;

        private zzv() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzv, zza> implements zzdpm {
            private zza() {
                super(zzv.zzced);
            }

            public final boolean zzoo() {
                return ((zzv) this.f3590a).zzoo();
            }

            public final zza zzr(boolean z) {
                a();
                ((zzv) this.f3590a).a(z);
                return this;
            }

            public final zza zzcm(int i) {
                a();
                ((zzv) this.f3590a).b(i);
                return this;
            }

            /* synthetic */ zza(apq apqVar) {
                this();
            }
        }

        public final boolean zzoo() {
            return this.zzceb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(boolean z) {
            this.zzdj |= 1;
            this.zzceb = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzdj |= 2;
            this.zzcec = i;
        }

        public static zza zzop() {
            return (zza) ((zzdob.zza) zzced.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apq apqVar = null;
            switch (apq.f2037a[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(apqVar);
                case 3:
                    return a(zzced, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzceb", "zzcec"});
                case 4:
                    return zzced;
                case 5:
                    zzdpv<zzv> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzv.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzced);
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
            zzdob.a((Class<zzv>) zzv.class, zzced);
        }
    }
}
